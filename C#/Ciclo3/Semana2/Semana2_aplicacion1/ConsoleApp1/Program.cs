using System;
using System.Collections.Generic;
using System.Configuration;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string ruta = ConfigurationManager.AppSettings["ruta"].ToString();
            string nombre = ConfigurationManager.AppSettings["nombre"].ToString();
            string apellido = ConfigurationManager.AppSettings["apellido"].ToString();

            try {
                int denominador = 10;
                int numero = 0;

                Console.WriteLine(denominador / numero);
            }
            catch(Exception ex){
                Console.WriteLine(ex.Message);
                Console.WriteLine("ocurrio un error");
                StreamWriter w = new StreamWriter(ruta,true);
                w.WriteLine(ex.Message);
                w.WriteLine(ex.TargetSite);
                w.Close();  
            }

            Console.ReadKey();
        }
    }
}
