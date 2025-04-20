using FrontEnd.Models.Entity;
using FrontEnd.Models.Logica;
using Newtonsoft.Json;
using System.Diagnostics;

namespace FrontEnd.Models.Data
{
    public class AlumnoData
    {
        public List<Alumno> listaAlumno()
        {
            string ruta = Ruta.localhost + Ruta.request +"/"+ Ruta.listar;
            List<Alumno> lista = new List<Alumno>();
            Debug.WriteLine(ruta);

            using(HttpClient http= new HttpClient())
            {
                var response = http.GetAsync(ruta).Result;
                if(response.StatusCode == System.Net.HttpStatusCode.OK)
                {
                    var respuesta = response.Content.ReadAsStringAsync().Result;
                    ResultadoTransactions<Alumno> resultado = JsonConvert.DeserializeObject<ResultadoTransactions<Alumno>>(respuesta);
                    lista = resultado.listData;
                }
                else
                {
                    Debug.WriteLine("Ocurrio un problema");
                }
            }

            return lista;
        }

        public void CrearAlumno(Alumno alumno)
        {
            string ruta = Ruta.localhost + Ruta.request +"/"+ Ruta.create;
            using(HttpClient http = new HttpClient())
            {
                var json = JsonConvert.SerializeObject(alumno);
                var content = new StringContent(json, System.Text.Encoding.UTF8, "application/json");
                var response = http.PostAsync(ruta, content).Result;
                if(response.StatusCode == System.Net.HttpStatusCode.OK)
                {
                    Debug.WriteLine("Se creo correctamente el Alumno");
                }
                else
                {
                    Debug.WriteLine("OCURRIO EROROROROROR");
                }
            }
        }
    }
}
