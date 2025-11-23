using System;
using System.Diagnostics;
using System.Net;
using System.Net.Http;
using System.Windows.Forms;
using ConsultaDNI.CodigoUsuario;
using ConsultaDNI.EntidadNegocio;

namespace ConsultaDNI
{
    public partial class FrmConsultaDNI : Form
    {
        public FrmConsultaDNI()
        {
            InitializeComponent();
        }      
        
        private async void btnConsultarDNIMediantePaginaExterna_Click(object sender, EventArgs e)
        {
            int tipoRespuesta = 2;
            string mensajeRespuesta = "";

            txtApellidoPaterno.Text = "";
            txtApellidoMaterno.Text = "";
            txtNombres.Text = "";
            lblMensaje.Text = "";

            string numeroDNI = txtNumeroDNI.Text;
            if (string.IsNullOrWhiteSpace(numeroDNI))
                return;

            Stopwatch oCronometro = new Stopwatch();
            oCronometro.Start();

            CuTexto oCuTexto = new CuTexto();
            btnConsultarDNIMediantePaginaExterna.Enabled = false;

            CookieContainer cookies = new CookieContainer();
            HttpClientHandler controladorMensaje = new HttpClientHandler();
            controladorMensaje.CookieContainer = cookies;
            controladorMensaje.UseCookies = true;
            using (HttpClient cliente = new HttpClient(controladorMensaje))
            {
                cliente.DefaultRequestHeaders.Add("Host", "eldni.com");
                cliente.DefaultRequestHeaders.Add("sec-ch-ua", "\" Not A;Brand\";v=\"99\", \"Chromium\";v=\"90\", \"Google Chrome\";v=\"90\"");
                cliente.DefaultRequestHeaders.Add("sec-ch-ua-mobile", "?0");
                cliente.DefaultRequestHeaders.Add("Sec-Fetch-Dest", "document");
                cliente.DefaultRequestHeaders.Add("Sec-Fetch-Mode", "navigate");
                cliente.DefaultRequestHeaders.Add("Sec-Fetch-Site", "none");
                cliente.DefaultRequestHeaders.Add("Sec-Fetch-User", "?1");
                cliente.DefaultRequestHeaders.Add("Upgrade-Insecure-Requests", "1");
                cliente.DefaultRequestHeaders.Add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36");

                ServicePointManager.SecurityProtocol = SecurityProtocolType.Tls | SecurityProtocolType.Tls11 |
                                                       SecurityProtocolType.Tls12;

                string url = "https://eldni.com/pe/buscar-por-dni";
                using (HttpResponseMessage resultadoConsultaToken = await cliente.GetAsync(new Uri(url)))
                {
                    if (resultadoConsultaToken.IsSuccessStatusCode)
                    {
                        mensajeRespuesta = await resultadoConsultaToken.Content.ReadAsStringAsync();
                        
                        string token = oCuTexto.ExtraerContenidoEntreTagString(mensajeRespuesta, 0, "name=\"_token\" value=\"", "\">");
                        
                        cliente.DefaultRequestHeaders.Remove("Sec-Fetch-Site");

                        cliente.DefaultRequestHeaders.Add("Origin", "https://eldni.com"); 
                        cliente.DefaultRequestHeaders.Add("Referer", "https://eldni.com/pe/buscar-por-dni"); 
                        cliente.DefaultRequestHeaders.Add("Sec-Fetch-Site", "same-origin");

                        EnDNI.DatoExterno1Solicitud oDatoExterno1Solicitud = new EnDNI.DatoExterno1Solicitud();
                        oDatoExterno1Solicitud._token = token;
                        oDatoExterno1Solicitud.dni = numeroDNI;
                        using (HttpResponseMessage resultadoConsultaDatos = await cliente.PostAsJsonAsync(url, oDatoExterno1Solicitud))
                        {
                            if (resultadoConsultaDatos.IsSuccessStatusCode)
                            {
                                string contenidoHTML = await resultadoConsultaDatos.Content.ReadAsStringAsync();
                                string nombreInicio = "<table class=\"table table-striped table-scroll\">";
                                string nombreFin = "</table>";
                                string contenidoDNI = oCuTexto.ExtraerContenidoEntreTagString(contenidoHTML, 0, nombreInicio, nombreFin);
                                if (contenidoDNI == "")
                                {
                                    nombreInicio = "<h3 class=\"text-error\">";
                                    nombreFin = "</h3>";
                                    mensajeRespuesta = oCuTexto.ExtraerContenidoEntreTagString(contenidoHTML, 0, nombreInicio, nombreFin);
                                    mensajeRespuesta = mensajeRespuesta == ""
                                        ? string.Format(
                                            "No se pudo realizar la consulta del número de DNI {0}.", numeroDNI)
                                        : string.Format(
                                            "No se pudo realizar la consulta del número de DNI {0}.\r\nDetalle: {1}",
                                            numeroDNI,
                                            mensajeRespuesta);
                                }
                                else
                                {
                                    nombreInicio = "<td>";
                                    nombreFin = "</td>";
                                    string[] arrResultado = oCuTexto.ExtraerContenidoEntreTag(contenidoDNI, 0,
                                        nombreInicio,
                                        nombreFin);
                                    if (arrResultado != null)
                                    {
                                        // Nombres
                                        arrResultado = oCuTexto.ExtraerContenidoEntreTag(contenidoDNI,
                                            Convert.ToInt32(arrResultado[0]),
                                            nombreInicio, nombreFin);
                                        if (arrResultado != null)
                                        {
                                            txtNombres.Text = arrResultado[1];

                                            // Apellido Paterno
                                            arrResultado = oCuTexto.ExtraerContenidoEntreTag(contenidoDNI,
                                                Convert.ToInt32(arrResultado[0]),
                                                nombreInicio, nombreFin);

                                            if (arrResultado != null)
                                            {
                                                txtApellidoPaterno.Text = arrResultado[1];

                                                // Apellido Materno
                                                arrResultado = oCuTexto.ExtraerContenidoEntreTag(contenidoDNI,
                                                    Convert.ToInt32(arrResultado[0]),
                                                    nombreInicio, nombreFin);

                                                if (arrResultado != null)
                                                {
                                                    txtApellidoMaterno.Text = arrResultado[1];
                                                    tipoRespuesta = 1;
                                                    mensajeRespuesta = string.Format("Se realizó exitosamente la consulta del número de DNI {0}",
                                                                numeroDNI);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            else
                            {
                                mensajeRespuesta = await resultadoConsultaDatos.Content.ReadAsStringAsync();
                                mensajeRespuesta =
                                    string.Format(
                                        "Ocurrió un inconveniente al consultar los datos del DNI {0}.\r\nDetalle:{1}",
                                        numeroDNI, mensajeRespuesta);
                            }
                        }
                    }
                    else
                    {
                        mensajeRespuesta = await resultadoConsultaToken.Content.ReadAsStringAsync();
                        mensajeRespuesta =
                            string.Format(
                                "Ocurrió un inconveniente al consultar el número de DNI {0}.\r\nDetalle:{1}",
                                numeroDNI, mensajeRespuesta);
                    }
                }
            }

            oCronometro.Stop();

            
            if (tipoRespuesta > 1)
                MessageBox.Show(mensajeRespuesta, "Consultar DNI"
                    , MessageBoxButtons.OK
                    , tipoRespuesta == 2 ? MessageBoxIcon.Warning : MessageBoxIcon.Error);

            lblMensaje.Text = string.Format("Procesado en {0} seg.", oCronometro.Elapsed.TotalSeconds);

            btnConsultarDNIMediantePaginaExterna.Enabled = true;
            txtNumeroDNI.Focus();
            txtNumeroDNI.SelectAll();
        }
        
        private async void btnConsultarDNIMedianteJNE_Click(object sender, EventArgs e)
        {
            int tipoRespuesta = 2;
            string mensajeRespuesta = "";

            txtApellidoPaterno.Text = "";
            txtApellidoMaterno.Text = "";
            txtNombres.Text = "";
            lblMensaje.Text = "";

            string numeroDNI = txtNumeroDNI.Text;
            if (string.IsNullOrWhiteSpace(numeroDNI))
                return;
            
            Stopwatch oCronometro = new Stopwatch();
            oCronometro.Start();

            btnConsultarDNIMedianteJNE.Enabled = false;
            
            CuTexto oCuTexto = new CuTexto();
            
            CookieContainer cookies = new CookieContainer();
            HttpClientHandler controladorMensaje = new HttpClientHandler();
            controladorMensaje.CookieContainer = cookies;
            controladorMensaje.UseCookies = true;
            using (HttpClient cliente = new HttpClient(controladorMensaje))
            {
                cliente.DefaultRequestHeaders.Add("Host", "aplicaciones007.jne.gob.pe");
                cliente.DefaultRequestHeaders.Add("Referer", "https://www.google.com/");
                cliente.DefaultRequestHeaders.Add("sec-ch-ua", "\" Not A;Brand\";v=\"99\", \"Chromium\";v=\"91\", \"Google Chrome\";v=\"91\"");
                cliente.DefaultRequestHeaders.Add("sec-ch-ua-mobile", "?0");
                cliente.DefaultRequestHeaders.Add("Sec-Fetch-Dest", "document");
                cliente.DefaultRequestHeaders.Add("Sec-Fetch-Mode", "navigate");
                cliente.DefaultRequestHeaders.Add("Sec-Fetch-Site", "cross-site");
                cliente.DefaultRequestHeaders.Add("Sec-Fetch-User", "?1");
                cliente.DefaultRequestHeaders.Add("Upgrade-Insecure-Requests", "1");
                cliente.DefaultRequestHeaders.Add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.106 Safari/537.36");
                
                ServicePointManager.SecurityProtocol = SecurityProtocolType.Tls | SecurityProtocolType.Tls11 |
                                                       SecurityProtocolType.Tls12;

                string urlCodigo = "https://aplicaciones007.jne.gob.pe/srop_publico/Consulta/Afiliado";
                string urlDato =
                    "https://aplicaciones007.jne.gob.pe/srop_publico/Consulta/api/AfiliadoApi/GetNombresCiudadano";
                using (HttpResponseMessage resultadoConsultaToken = await cliente.GetAsync(urlCodigo))
                {
                    if (resultadoConsultaToken.IsSuccessStatusCode)
                    {
                        string contenidoHTML = await resultadoConsultaToken.Content.ReadAsStringAsync();
                        string nombreInicio = "pTokenCookie('";
                        string nombreFin = "'";
                        string pTokenCookie = oCuTexto.ExtraerContenidoEntreTagString(contenidoHTML, 0, nombreInicio, nombreFin);
                        nombreInicio = "pTokenForm('";
                        nombreFin = "'";
                        string pTokenForm = oCuTexto.ExtraerContenidoEntreTagString(contenidoHTML, 0, nombreInicio, nombreFin);

                        cliente.DefaultRequestHeaders.Remove("Referer");
                        cliente.DefaultRequestHeaders.Remove("Sec-Fetch-Dest");
                        cliente.DefaultRequestHeaders.Remove("Sec-Fetch-Mode");
                        cliente.DefaultRequestHeaders.Remove("Sec-Fetch-Site");
                        
                        cliente.DefaultRequestHeaders.Add("Origin", "https://aplicaciones007.jne.gob.pe");
                        cliente.DefaultRequestHeaders.Add("Referer", "https://aplicaciones007.jne.gob.pe/srop_publico/Consulta/Afiliado");
                        cliente.DefaultRequestHeaders.Add("RequestVerificationToken", string.Format("{0}:{1}", pTokenCookie, pTokenForm));
                        cliente.DefaultRequestHeaders.Add("Sec-Fetch-Dest", "empty");
                        cliente.DefaultRequestHeaders.Add("Sec-Fetch-Mode", "cors");
                        cliente.DefaultRequestHeaders.Add("Sec-Fetch-Site", "same-origin");
                        cliente.DefaultRequestHeaders.Add("X-Requested-With", "XMLHttpRequest");

                        EnDNI.DatoJNESolictud oEnDatoJNESolictud = new EnDNI.DatoJNESolictud();
                        oEnDatoJNESolictud.CODDNI = numeroDNI;
                        using (HttpResponseMessage resultadoConsultaDatos = await cliente.PostAsJsonAsync(urlDato, oEnDatoJNESolictud))
                        {
                            if (resultadoConsultaDatos.IsSuccessStatusCode)
                            {
                                EnDNI.DatoJNERespuesta oDatoJNERespuesta = await resultadoConsultaDatos.Content.ReadAsAsync<EnDNI.DatoJNERespuesta>();
                                string contenido = oDatoJNERespuesta.data;
                                mensajeRespuesta = oDatoJNERespuesta.mensaje;
                                string[] arrContenido = contenido.Split('|');
                                if (arrContenido[0] == "")
                                {
                                    mensajeRespuesta = mensajeRespuesta == ""
                                        ? string.Format("No existe el número DNI {0}", numeroDNI)
                                        : string.Format("No existe el número DNI {0}\r\nDetalle: {1}", numeroDNI,
                                            mensajeRespuesta);
                                }
                                else
                                {
                                    txtApellidoPaterno.Text = arrContenido[0];
                                    txtApellidoMaterno.Text = arrContenido[1];
                                    txtNombres.Text = arrContenido[2];

                                    tipoRespuesta = oDatoJNERespuesta.success ? 1 : 2;
                                }
                            }
                            else
                            {
                                mensajeRespuesta = await resultadoConsultaDatos.Content.ReadAsStringAsync();
                                mensajeRespuesta =
                                    string.Format(
                                        "Ocurrió un inconveniente al consultar los datos del DNI {0}.\r\nDetalle:{1}",
                                        numeroDNI, mensajeRespuesta);
                            }
                        }
                    }
                    else
                    {
                        mensajeRespuesta = await resultadoConsultaToken.Content.ReadAsStringAsync();
                        mensajeRespuesta =
                            string.Format(
                                "Ocurrió un inconveniente al consultar el número de DNI {0}.\r\nDetalle:{1}",
                                numeroDNI, mensajeRespuesta);
                    }
                }
            }


            oCronometro.Stop();


            if (tipoRespuesta > 1)
                MessageBox.Show(mensajeRespuesta, "Consultar DNI"
                    , MessageBoxButtons.OK
                    , tipoRespuesta == 2 ? MessageBoxIcon.Warning : MessageBoxIcon.Error);

            lblMensaje.Text = string.Format("Procesado en {0} seg.", oCronometro.Elapsed.TotalSeconds);

            btnConsultarDNIMedianteJNE.Enabled = true;
            txtNumeroDNI.Focus();
            txtNumeroDNI.SelectAll();
        }
    }
}
