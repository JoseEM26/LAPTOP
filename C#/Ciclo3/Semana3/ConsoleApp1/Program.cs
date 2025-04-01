using System;
using System.Collections.Generic;
using System.Diagnostics.Eventing.Reader;
using System.IO;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    //DENTRO DE UN IF ELSE ,VERIFICAR SI EL ARCHIVO EXISTE , LUEGO LEER TODO SU CONTENIDO E IMPRIMIRLO,
    //Y ESCRIBIRLE DENTRO DE EL ARCHIVO UN MENSAJE VALIDADNO SU EXISTENCIA,
    //SI ELSE NO EXISTE CREA UNA CARPETA NUEVA , Y CON ESA MISMA CARPETA COPIA Y MUEVE A UNA CARPETA NUEVA.
    internal class Program
    {
        static void Main(string[] args)
        {

            string ruta = "D:/POO/ConsoleApp1/ArchivosTXT/PROBLEMA1.txt";


            if (File.Exists(ruta))
            {
                StreamReader lector = new StreamReader(ruta);
                string texto = lector.ReadToEnd();
                Console.WriteLine(texto);
                lector.Close();

                StreamWriter w = new StreamWriter(ruta);
                w.WriteLine("Estamos en el if");
                w.Close();
            }
            else
            {
                string formatoPersonal = DateTime.Now.ToString("ddMMyyyyHHmmss");


                Console.WriteLine("el archivo no existe");

                FileStream archivo = File.Create(ruta);
                archivo.Close();

                Console.WriteLine("El archibo es esta creando.....");



                //CON ESTOS DOS METODOS PODEMOS NOSOTROS COPIAR Y ELMINAR A LA VEZ PARA PODER ENVIAR
                //UN ARCHIVO A OTRO LADO
                string rutaDestinoCopia = "D:/POO/ConsoleApp1/copia/bd" + formatoPersonal + ".txt";

                File.Copy(ruta, rutaDestinoCopia);
                Console.WriteLine("el archuvo se esta copiando");

                File.Delete(ruta);
                Console.WriteLine("el archuvo se elimina");

                //CON ESTO SOLO LO MOVEMOS Y ELIMINAMOS  A LA VEZ 
                string rutaDestinoMover = "D:/POO/ConsoleApp1/mover/bd" + formatoPersonal + ".txt";

                File.Move(ruta, rutaDestinoMover);
                Console.WriteLine("el archuvo se esta moviendo");


            }

            Console.ReadKey();
           
        }
        public static void Imprimir(string s)
        {
            Console.WriteLine(s);
        }
    }
}
