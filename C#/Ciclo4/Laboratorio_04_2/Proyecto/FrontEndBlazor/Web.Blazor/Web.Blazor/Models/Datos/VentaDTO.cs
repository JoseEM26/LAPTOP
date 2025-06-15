using System.Text;
using Newtonsoft.Json;
using Web.Blazor.Models.Entidad;

namespace Web.Blazor.Models.Datos
{
    public class VentaDTO
    {
        public ResultadoTransaccion<string> GuardarVenta(EVenta objventa)
        {
            ResultadoTransaccion<string>resultado = new ResultadoTransaccion<string>();
            try {
                using (HttpClient cliente = new HttpClient()) 
                {
                    string ruta = "http://localhost:5089/API/Venta/Registrar_Venta";
                    var Json =JsonConvert.SerializeObject(objventa);
                    var content = new StringContent(Json, Encoding.UTF8, "application/json");
                    var response = cliente.PostAsync(ruta, content).Result;
                    if (response.StatusCode == System.Net.HttpStatusCode.OK)
                    {
                        var result = response.Content.ReadAsStringAsync().Result;
                        resultado = JsonConvert.DeserializeObject<ResultadoTransaccion<string>>(result);
                    }
                    else {
                        resultado.IdRegistro = -1;
                        resultado.Mensaje = response.Content.ToString();
                    }
                }
            }
            catch (Exception ex)
            {
                resultado.IdRegistro = -1;
                resultado.Mensaje = ex.Message;
            }
            return resultado;
        }
    }
}
