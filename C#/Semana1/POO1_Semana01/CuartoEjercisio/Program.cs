using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CuartoEjercisio
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Coordinador c = new Coordinador(1001, "pepito", 1, 1111111111);
            Console.WriteLine(c.DatosCompletos());
            Console.WriteLine("Sueldo del cordinador es     "+c.Sueldo());
        }
    }
}
