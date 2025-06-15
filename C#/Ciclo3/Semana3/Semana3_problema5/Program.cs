using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Semana3_problema5
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string ruta = "D:/POO/ConsoleApp1/ArchivosTXT";

            DirectoryInfo directory = new DirectoryInfo(ruta);
            DirectoryInfo[] arreglo_direcctorio = directory.GetDirectories();


            foreach (var x in arreglo_direcctorio)
            {
                Imprimir("Carpeta :  " + x.Name);
                FileInfo[] arre_info = x.GetFiles();
                foreach(var y in arre_info)
                {
                    Imprimir("     -archivo : " + y.Name+"\n");
                }
            }


            Console.ReadKey();
        }
        public static void Imprimir(string s)
        {
            Console.WriteLine(s);
        }
    }
}
