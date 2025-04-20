using Newtonsoft.Json;
using Web01.Models.Entidad;
using Web01.Models.Logica;

namespace Web01.Models.Datos
{
    public class AlumnoD
    {
        public List<AlumnoE> ListaAlumnos() 
        {
            List<AlumnoE> Listado = new List<AlumnoE>();
            try { 
            
                using(HttpClient client = new HttpClient())
                {
                    var ruta = CadenaApi.UrlApi + CadenaApi.UrlApiAlumno + CadenaApi.UrlAlumnoLista;
                    var response = client.GetAsync(ruta).Result;
                    if (response.StatusCode == System.Net.HttpStatusCode.OK)
                    {
                        var resultado = response.Content.ReadAsStringAsync().Result;

                        var resultadotransaccion = JsonConvert.DeserializeObject<ResultadoTransaccion<AlumnoE>>(resultado);
                        Listado = resultadotransaccion.DataList;
                    }
                }
            }
            catch (Exception ex)
            {
                Listado = new List<AlumnoE>();
            }
            return Listado;
        }
    }
}
