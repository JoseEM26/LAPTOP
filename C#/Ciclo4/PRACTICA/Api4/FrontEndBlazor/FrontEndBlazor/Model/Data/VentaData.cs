using FrontEndBlazor.Model.Entity;
using Newtonsoft.Json;
using System.Net;

namespace FrontEndBlazor.Model.Data
{
    public class VentaData
    {
        public ResultadoTransaction<string> GuardarVenta(Venta venta)
        {
            ResultadoTransaction<string> resultado = new ResultadoTransaction<string>();

            string ruta = "http://localhost:5276/api/venta/RegistrarVenta";
            using (HttpClient http = new HttpClient())
            {
                var json = JsonConvert.SerializeObject(venta);
                var content = new StringContent(json,System.Text.Encoding.UTF8, "application/json");
                var response = http.PostAsync(ruta,content).Result;
                if (response.StatusCode == HttpStatusCode.OK)
                {
                    var result = response.Content.ReadAsStringAsync().Result;
                    resultado = JsonConvert.DeserializeObject<ResultadoTransaction<string>>(result);
                }
                else
                {
                    resultado.idRegistro = -1;
                    resultado.mensaje = response.Content.ToString();
                }
            }

                return resultado;
        }
    }
}
