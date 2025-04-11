using FrontEnd2.Models.Entity;
using FrontEnd2.Models.Logica;
using Newtonsoft.Json;
using System.Diagnostics;
using System.Security.Policy;
using System.Text.Json.Serialization;

namespace FrontEnd2.Models.Data
{
    public class AlumnoData
    {
        public List<Alumno> ListaALumnos()
        {
            List<Alumno> lista = new List<Alumno>();
            string ruta = Ruta.LocalHost + Ruta.AlumnoRequest + "/" + Ruta.Listar;
            Debug.WriteLine(ruta);

            using (HttpClient http = new HttpClient())
            {
                var response = http.GetAsync(ruta).Result;

                if(response.StatusCode == System.Net.HttpStatusCode.OK)
                {
                    var respuesta = response.Content.ReadAsStringAsync().Result;
                    ResultadoTransaction<Alumno> resultadoTransaction = JsonConvert.DeserializeObject<ResultadoTransaction<Alumno>>(respuesta);
                    lista = resultadoTransaction.listData;
                }
            }

                return lista;
        }

        public void CreateAlumno(Alumno a)
        {
            string ruta = Ruta.LocalHost + Ruta.AlumnoRequest + "/" + Ruta.Create;
            Debug.WriteLine(ruta);

            using (HttpClient http = new HttpClient())
            {
                var json = JsonConvert.SerializeObject(a);
                Debug.WriteLine(json);
                Debug.WriteLine(a);
                var content = new StringContent(json ,System.Text.Encoding.UTF8 ,"application/json");
                var response = http.PostAsync(ruta, content).Result;

                if (response.StatusCode == System.Net.HttpStatusCode.OK)
                {
                    Debug.WriteLine("Se creo exitosamente");
                }
                else
                {
                    Debug.WriteLine("Se creo mall");

                }
            }

        }

        public void Eliminar(int id)
        {
            try
            {
                using (HttpClient http = new HttpClient())
                {
                    string url = $"{Ruta.LocalHost}{Ruta.AlumnoRequest}/{Ruta.Eliminar}/{id}";
                    Debug.WriteLine(url);
                    var resultado = http.DeleteAsync(url).Result;

                    if (resultado.StatusCode == System.Net.HttpStatusCode.OK)
                    {
                        Debug.WriteLine("Se eliminó correctamente");
                    }
                    else
                    {
                        Debug.WriteLine("Ocurrió un problema");
                    }
                }
            }
            catch (Exception e)
            {
                Debug.WriteLine(e.Message);
            }
        }

        public void Update (Alumno a)

        {
            try
            {

                using(HttpClient http = new HttpClient())
                {
                    string url = Ruta.LocalHost + Ruta.AlumnoRequest + "/" + Ruta.Update;
                    var json = JsonConvert.SerializeObject(a);
                    var content = new StringContent(json, System.Text.Encoding.UTF8, "application/json");
                    var resultado = http.PutAsync(url, content).Result;
                    if(resultado.StatusCode== System.Net.HttpStatusCode.OK)
                    {
                        Debug.WriteLine("Se actualizo correctamente");
                    }
                    else
                    {
                        Debug.WriteLine("Ocurrio un problema");

                    }
                }
            }catch(Exception e)
            {
                Debug.WriteLine(e.Message);
            }
        }

        public Alumno ListarXID(int id)
        {
            Alumno alumno = new Alumno();
            try
            {
                using(HttpClient http= new HttpClient())
                {
                    string ruta = Ruta.LocalHost + Ruta.AlumnoRequest+"/"+ Ruta.ListarXID+"?id="+id;
                    Debug.WriteLine(ruta);
                    var content= http.GetAsync(ruta).Result;
                    if(content.StatusCode == System.Net.HttpStatusCode.OK)
                    {
                        Debug.WriteLine("Se listo correcto el alumno");
                        var repuesta = content.Content.ReadAsStringAsync().Result;
                        ResultadoTransaction<Alumno> resultado = JsonConvert.DeserializeObject<ResultadoTransaction<Alumno>>(repuesta);
                        alumno = resultado.data;
                    }
                    else
                    {
                        Debug.WriteLine("ocurrio un problema");

                    }
                }
            }catch(Exception e)
            {
                Debug.WriteLine(e.Message);
            }

            return alumno;
        }
    }
}
