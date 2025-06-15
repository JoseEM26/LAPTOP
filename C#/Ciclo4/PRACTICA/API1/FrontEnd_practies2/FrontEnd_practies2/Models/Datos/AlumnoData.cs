using FrontEnd_practies2.Models.Entity;
using FrontEnd_practies2.Models.Logica;
using Newtonsoft.Json;
using System.Diagnostics;

namespace FrontEnd_practies2.Models.Datos
{
    public class AlumnoData
    {

        public List<Alumno> listarAlumno()
        {
            List<Alumno> lista = new List<Alumno>();

            try
            {
                using(HttpClient http= new HttpClient())
                {
                    string ruta = AlumnoConst.urlAPI+ AlumnoConst.constURL + AlumnoConst.methodListar;
                    var response = http.GetAsync(ruta).Result;
                    if(response.StatusCode == System.Net.HttpStatusCode.OK)
                    {
                        var resultado = response.Content.ReadAsStringAsync().Result;
                        ResultadoTransaction<Alumno> resultadoTransaction = JsonConvert.DeserializeObject<ResultadoTransaction<Alumno>>(resultado);
                        lista = resultadoTransaction.dataList;
                    }
                }
            }
            catch
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
                    string ruta =AlumnoConst.urlAPI+ AlumnoConst.constURL + AlumnoConst.methodCreate;

                

                    // Convertimos el objeto a JSON
                    string json = JsonConvert.SerializeObject(alumno);
                    Debug.WriteLine("JSON ENVIADO: " + json);

                    var content = new StringContent(json, System.Text.Encoding.UTF8, "application/json");

                    // Hacemos el POST con el contenido JSON
                    var response = http.PostAsync(ruta, content).Result;

                    if (response.StatusCode == System.Net.HttpStatusCode.OK)
                    {
                        Debug.WriteLine("Alumno creado correctamente.");
                    }
                    else
                    {
                        Debug.WriteLine($"Error al crear alumno: {response.StatusCode}");
                    }
                }
            }
            catch (Exception e)
            {
                Debug.WriteLine("Ocurrió un problema en Create controller: " + e.Message);
            }
        }

    }
}
