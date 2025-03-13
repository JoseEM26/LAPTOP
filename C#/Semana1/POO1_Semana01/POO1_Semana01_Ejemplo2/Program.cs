using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace POO1_Semana01_Ejemplo2
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Docente docente = new Docente(101,"Jose",100,1025);
            Console.WriteLine(docente.datosCompletos());
            Console.WriteLine(docente.SueldoBruto());
            Console.WriteLine(docente.SueldoNeto());
            Console.WriteLine(docente.Descuento());



        }
    }
}
