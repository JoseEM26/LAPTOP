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
    }
}
