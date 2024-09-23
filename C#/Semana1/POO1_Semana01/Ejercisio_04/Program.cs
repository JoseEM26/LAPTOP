using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercisio_04
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Expositor e = new Expositor(1001, "jose", 100, 55);
            Console.WriteLine(e.sueldoBruto());
            Console.WriteLine(e.descuentAFP());
            Console.WriteLine(e.descuentoEPS());
            Console.WriteLine(e.sueldoNeto());
        }
    }
}
