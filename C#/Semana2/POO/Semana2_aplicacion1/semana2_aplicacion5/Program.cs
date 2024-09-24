using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;
using Newtonsoft.Json;

namespace semana2_aplicacion5
{
    internal class Program
    {
        static void Main(string[] args)
        {
            docente d = new docente("jose", "espinoza", 12);
            string cadenaJson=JsonConvert.SerializeObject(d);

            Console.WriteLine(cadenaJson);



            Console.WriteLine("-----------------------------------------------");

            docente x = JsonConvert.DeserializeObject<docente>(cadenaJson);
            Console.WriteLine(x.nombre);
            Console.WriteLine(x.apellido);



            Console.WriteLine("-----------------------------------------------");
            List<docente> lista = new List<docente>();
            lista.Add(d);
            lista.Add(new docente("ana","paucar",14123));

            string cadena=JsonConvert.SerializeObject(lista);
            Console.WriteLine(cadena);

            List<docente> lista1 = JsonConvert.DeserializeObject<List<docente>>(cadena);
            Console.WriteLine(lista1[0].nombre);
            Console.ReadKey();



        }
    }
}
