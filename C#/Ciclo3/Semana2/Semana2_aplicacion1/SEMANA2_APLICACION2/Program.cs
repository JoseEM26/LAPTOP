using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SEMANA2_APLICACION2
{
    internal class Program
    {
        static void Main(string[] args)
        {

            Console.WriteLine("datos trbaajadores");

            List<trabajador> t = new List<trabajador>();

            t.Add(new trabajador(11, "jose", "espinoza", "Lima", 11111111));
            t.Add(new trabajador(12, "jose2", "espinoza2", "Lima2", 11111112));

            foreach(trabajador x in t)
            {
                Console.WriteLine($"- {x.codigo} - {x.nombre} - {x.apellido} - {x.direccion} - {x.numero} -");
            }
            Console.ReadKey();


        }
    }
}
