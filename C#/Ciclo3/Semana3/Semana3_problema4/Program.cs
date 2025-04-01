using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Semana3_problema4
{
    internal class Program
    {
        //IMPRIMIR EN CONSOLA LO QUE ES LOS NOMBRES DE LOS DIRECTORIOS O CARPETAS
        //Y TMBN LOS ARCHIVOS QUE ESTAN ADENTTRO DE LA CARPETA.
        static void Main(string[] args)
        {
            string rutaDirectory = "D:/POO/ConsoleApp1/ArchivosTXT";

            DirectoryInfo directorio = new DirectoryInfo(rutaDirectory);

            DirectoryInfo[] arreglo_directory = directorio.GetDirectories();

            Imprimir("Directorios............................................");
            foreach(var x in arreglo_directory)
            {
                Imprimir(x.Name);
            }


            FileInfo[] arreglo_archivos = directorio.GetFiles();
            Imprimir("files............................................");
            foreach (var y in arreglo_archivos)
            {
                Imprimir("Carpeta : "+y.Name);
            }

            Console.ReadKey();
        }
        public static void Imprimir(string s)
        {
            Console.WriteLine(s);
        }
    }
}
