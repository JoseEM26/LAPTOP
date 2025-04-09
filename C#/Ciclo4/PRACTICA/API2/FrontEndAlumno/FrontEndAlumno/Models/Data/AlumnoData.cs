using FrontEndAlumno.Models.Entity;
using FrontEndAlumno.Models.Logica;
using Newtonsoft.Json;
using System.Diagnostics;
using System.Net;

namespace FrontEndAlumno.Models.Data
{
    public class AlumnoData
    {
        public List<Alumno> listaAlumno()
        {
            List<Alumno> lista = new List<Alumno>();

            try
            {
                using (HttpClient http = new HttpClient())
                {
                    string URI = AlumnoConstantes.localhost + AlumnoConstantes.HTTPRequest +"/"+ AlumnoConstantes.HTTPList;
                    Debug.WriteLine(URI);
                    var response = http.GetAsync(URI).Result;
                    Debug.WriteLine(response);
                    Debug.WriteLine(response.StatusCode);
                    if (response.StatusCode == HttpStatusCode.OK)
                    {
                        var resultado = response.Content.ReadAsStringAsync().Result;
                        ResultadoTransaction<Alumno> resultadoTransaction = JsonConvert.DeserializeObject<ResultadoTransaction<Alumno>>(resultado);
                        lista = resultadoTransaction.listData;
                        Debug.WriteLine(lista);
                    }
                    else
                    {
                        Debug.Write("Problema en Data ALumno");
                    }
                   
                }
            }
            catch(Exception e)
            {
                lista = null;
                Debug.WriteLine("Ocurrio un problema en listar controller");
            }


            return lista;
        }

        public void CreateAlumno(Alumno alumno)
        {
            try
            {
                using (HttpClient http = new HttpClient())
                {
                    string url = AlumnoConstantes.localhost + AlumnoConstantes.HTTPRequest + "/" + AlumnoConstantes.HTTPCreate;

                    var json = JsonConvert.SerializeObject(alumno);
                    Debug.WriteLine(json);
                    Debug.Write(url);

                    var content = new StringContent(json, System.Text.Encoding.UTF8, "application/json");
                    var resultado = http.PostAsync(url, content).Result;
                    Debug.WriteLine(resultado);
                    Debug.WriteLine(resultado.StatusCode);
                    Debug.WriteLine("------------------------------------------------------------------");

                   
                    if(resultado.StatusCode == HttpStatusCode.OK)
                    {
                        Debug.Write("Se creo correctamente el ALumno");

                    }
                    else
                    {
                        Debug.Write("NOOOOO Se creo correctamente el ALumno");

                    }
                }
            }catch(Exception e)
            {
                Debug.Write(e.Message);
            }
        }
    }
}
