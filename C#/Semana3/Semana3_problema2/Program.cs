using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Semana3_problema2
{
    // IMPRIMIR EN CONSOLA LO QUE ES LA INFORMACION DE UN ARCHIVO.TXT
    internal class Program
    {
        static void Main(string[] args)
        {
            FileInfo info = new FileInfo("D:/POO/ConsoleApp1/ArchivosTXT/archivo.txt");
            Imprimir("ruta :" + info.FullName);
            Imprimir("nombre :" + info.Name);
            Imprimir("extenciones :" + info.Extension);
            Imprimir("es lectura? :" + info.IsReadOnly);
            Imprimir("fecha Creacion :" + info.CreationTime);
            Imprimir("fecha Modificacion :" + info.LastWriteTime);
            Imprimir("Ultimo Acceso :" + info.LastWriteTime);
            Imprimir("tamanao :" + info.Length);

        }



        public static void Imprimir(string s)
        {
            Console.WriteLine(s);
        }
    }
}
