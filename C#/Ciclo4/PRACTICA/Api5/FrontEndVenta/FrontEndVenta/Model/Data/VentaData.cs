using FrontEndVenta.Model.Entity;
using Newtonsoft.Json;

namespace FrontEndVenta.Model.Data
{
    public class VentaData
    {
        public ResultadoTransaction<Venta> ListarVenta()
        {
            ResultadoTransaction<Venta> resultado = new ResultadoTransaction<Venta>();

            using(HttpClient http=new HttpClient())
            {
                string ruta = "http://localhost:5155/api/venta/listar";
                var response = http.GetAsync(ruta).Result;
                if (response.StatusCode == System.Net.HttpStatusCode.OK)
                {
                    var content = response.Content.ReadAsStringAsync().Result;
                    resultado = JsonConvert.DeserializeObject<ResultadoTransaction<Venta>>(content);

                }
            }

            return resultado;
        }
        public ResultadoTransaction<string>CreateVenta(Venta venta)
        {
            ResultadoTransaction<string> resultado = new ResultadoTransaction<string>();

            try
            {
                using (HttpClient http = new HttpClient())
                {
                    string ruta = "http://localhost:5155/api/venta/create";
                    var json = JsonConvert.SerializeObject(venta);
                    var content = new StringContent(json, System.Text.Encoding.UTF8, "application/json");
                    var response = http.PostAsync(ruta,content).Result;
                    if (response.StatusCode == System.Net.HttpStatusCode.OK)
                    {
                        var respuestita = response.Content.ReadAsStringAsync().Result;
                        resultado = JsonConvert.DeserializeObject<ResultadoTransaction<string>>(respuestita);
                    }
                }
            }
            catch(Exception e)
            {
                resultado.idRespuesta = -1;
                resultado.mensaje = e.Message;
            }

            return resultado;
        }
    }
}
