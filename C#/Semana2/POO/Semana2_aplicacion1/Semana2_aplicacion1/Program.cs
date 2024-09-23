using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Semana2_aplicacion1
{
    internal class Program
    {
        static void Main(string[] args)
        {

            servicioOperaciones s = new servicioOperaciones();
            Console.WriteLine("" + s.sumar(1,2));
            Console.WriteLine("" + s.restar(1, 2));
            Console.WriteLine("" + s.multiplicar(1, 2));
            Console.WriteLine("" + s.dividir(10, 2));
            Console.ReadKey();


        }
    }
}
