using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SegundoEjercisio2
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Filmaciones f = new Filmaciones(10001,"DEAD POOL % WOlveRING",2,100);

            Console.WriteLine(f.DatosCompletos());
            Console.WriteLine("Precio en DOLARES    :"+f.PrecioDolares());

        }
    }
}
