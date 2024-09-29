using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Semana3_Semana3
{
    //CREACION DE UNA CARPTERA O DIRECTORIO EN UNA UBICACION,
    //Y CREAR DOS SUBCARPETAS DENTRO DE ELLA U IMPRIMIR EL NOMBRE DE LA CARPETA MADRE.
    internal class Program
    {
        static void Main(string[] args)
        {
            string ruta = "D:/POO/ConsoleApp1/ArchivosTXT/Nueva Carpeta";
            if (Directory.Exists(ruta))
            {
                Console.WriteLine("ya existe la carpeta");
            }
            else
            {
                Console.WriteLine("se esta creando la carpeta");
                Directory.CreateDirectory(ruta);


                Console.WriteLine("se esta creando 2 subCarpetas");
                DirectoryInfo info = new DirectoryInfo(ruta);
                info.CreateSubdirectory("Carpeta1");
                info.CreateSubdirectory("Carpeta2");
                Console.WriteLine("info:  " + info.Name);
            }

        }
    }
}
