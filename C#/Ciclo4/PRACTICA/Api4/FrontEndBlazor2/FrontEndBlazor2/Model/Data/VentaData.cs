using FrontEndBlazor2.Model.ENtity;
using Newtonsoft.Json;
using System.Net;
using System.Text.Json.Serialization;

namespace FrontEndBlazor2.Model.Data
{
    public class VentaData
    {
        public ResultadoTransaction<string> GuardarVenta(Venta venta)
        {
            ResultadoTransaction<string> resultado = new ResultadoTransaction<string>();
            string ruta = "http://localhost:5276/api/venta/RegistrarVenta";

            using(HttpClient http= new HttpClient())
            {
                var Json = JsonConvert.SerializeObject (venta);
                var contetn = new StringContent(Json, System.Text.Encoding.UTF8, "application/json");
                var result = http.PostAsync(ruta, contetn).Result;
                if (result.StatusCode ==HttpStatusCode.OK)
                {
                    var resultadossss = result.Content.ReadAsStringAsync().Result;
                    resultado = JsonConvert.DeserializeObject<ResultadoTransaction<string>>(resultadossss);
                }
                else
                {
                    resultado.IdRegistro = -1;
                    resultado.Mensaje = "ERROR";
                }
            }

            return resultado;
        }
        public ResultadoTransaction<string> ActualizarVenta(Venta venta)
        {
            ResultadoTransaction<string> resultado = new ResultadoTransaction<string>();
            string ruta = "http://localhost:5276/api/venta/ActualizarVenta";

            using (HttpClient http = new HttpClient())
            {
                var Json = JsonConvert.SerializeObject(venta);
                var contetn = new StringContent(Json, System.Text.Encoding.UTF8, "application/json");
                var result = http.PutAsync(ruta, contetn).Result;
                if (result.StatusCode == HttpStatusCode.OK)
                {
                    var resultadossss = result.Content.ReadAsStringAsync().Result;
                    resultado = JsonConvert.DeserializeObject<ResultadoTransaction<string>>(resultadossss);
                }
                else
                {
                    resultado.IdRegistro = -1;
                    resultado.Mensaje = "ERROR";
                }
            }

            return resultado;
        }

        public ResultadoTransaction<string> ActualizarVentaDetalle(VentaDet venta)
        {
            ResultadoTransaction<string> resultado = new ResultadoTransaction<string>();
            string ruta = "http://localhost:5276/api/venta/ActualizarVentaDetalle";

            using (HttpClient http = new HttpClient())
            {
                var Json = JsonConvert.SerializeObject(venta);
                var contetn = new StringContent(Json, System.Text.Encoding.UTF8, "application/json");
                var result = http.PutAsync(ruta, contetn).Result;
                if (result.StatusCode == HttpStatusCode.OK)
                {
                    var resultadossss = result.Content.ReadAsStringAsync().Result;
                    resultado = JsonConvert.DeserializeObject<ResultadoTransaction<string>>(resultadossss);
                }
                else
                {
                    resultado.IdRegistro = -1;
                    resultado.Mensaje = "ERROR";
                }
            }

            return resultado;
        }

        public ResultadoTransaction<string> EliminarVentaDetalle(int idVenta,int idVentaDet)
        {
            ResultadoTransaction<string> resultado = new ResultadoTransaction<string>();
            string ruta = "http://localhost:5276/api/venta/EliminarVentaDetalle/" + idVenta+"/"+idVentaDet;

            using (HttpClient http = new HttpClient())
            {
                var result = http.DeleteAsync(ruta).Result;
                if (result.StatusCode == HttpStatusCode.OK)
                {
                    var resultadossss = result.Content.ReadAsStringAsync().Result;
                    resultado = JsonConvert.DeserializeObject<ResultadoTransaction<string>>(resultadossss);
                }
                else
                {
                    resultado.IdRegistro = -1;
                    resultado.Mensaje = "ERROR";
                }
            }

            return resultado;
        }
        public ResultadoTransaction<string> EliminarVenta(int id)
        {
            ResultadoTransaction<string> resultado = new ResultadoTransaction<string>();
            string ruta = "http://localhost:5276/api/venta/EliminarVenta/"+id;

            using (HttpClient http = new HttpClient())
            {
                var result = http.DeleteAsync(ruta).Result;
                if (result.StatusCode == HttpStatusCode.OK)
                {
                    var resultadossss = result.Content.ReadAsStringAsync().Result;
                    resultado = JsonConvert.DeserializeObject<ResultadoTransaction<string>>(resultadossss);
                }
                else
                {
                    resultado.IdRegistro = -1;
                    resultado.Mensaje = "ERROR";
                }
            }

            return resultado;
        }
        public ResultadoTransaction<Venta> ListarVenta()
        {
            ResultadoTransaction<Venta> resultado = new ResultadoTransaction<Venta>();
            string ruta = "http://localhost:5276/api/venta/ListarVenta";

            using (HttpClient http = new HttpClient())
            {
                var result = http.GetAsync(ruta).Result;
                if (result.StatusCode == HttpStatusCode.OK)
                {
                    var resultadossss = result.Content.ReadAsStringAsync().Result;
                    resultado = JsonConvert.DeserializeObject<ResultadoTransaction<Venta>>(resultadossss);
                }
                else
                {
                    resultado.IdRegistro = -1;
                    resultado.Mensaje = "ERROR";
                }
            }

            return resultado;
        }
        public ResultadoTransaction<VentaDet> ListarVentaDetalle()
        {
            ResultadoTransaction<VentaDet> resultado = new ResultadoTransaction<VentaDet>();
            string ruta = "http://localhost:5276/api/venta/ListarVentaDetalle";

            using (HttpClient http = new HttpClient())
            {
                var result = http.GetAsync(ruta).Result;
                if (result.StatusCode == HttpStatusCode.OK)
                {
                    var resultadossss = result.Content.ReadAsStringAsync().Result;
                    resultado = JsonConvert.DeserializeObject<ResultadoTransaction<VentaDet>>(resultadossss);
                }
                else
                {
                    resultado.IdRegistro = -1;
                    resultado.Mensaje = "ERROR";
                }
            }

            return resultado;
        }
        public ResultadoTransaction<VentaDet> ListarVentaDetalleXIDVenta(int idVenta)
        {
            ResultadoTransaction<VentaDet> resultado = new ResultadoTransaction<VentaDet>();
            string ruta = "http://localhost:5276/api/venta/ListarVentaDetalleXIdVenta/"+idVenta;

            using (HttpClient http = new HttpClient())
            {
                var result = http.GetAsync(ruta).Result;
                if (result.StatusCode == HttpStatusCode.OK)
                {
                    var resultadossss = result.Content.ReadAsStringAsync().Result;
                    resultado = JsonConvert.DeserializeObject<ResultadoTransaction<VentaDet>>(resultadossss);
                }
                else
                {
                    resultado.IdRegistro = -1;
                    resultado.Mensaje = "ERROR";
                }
            }

            return resultado;
        }

    }
}
