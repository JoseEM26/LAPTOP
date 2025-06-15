using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tercer_Ejercisio
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Persona p = new Persona("Jose","Espinoza",19,1.69,65);
            Console.WriteLine(p.DatosCompletos());
            Console.WriteLine("Indice de masa corporal   :"+p.MasaCorporal());
            Console.WriteLine("Estado de edad:       "+p.EstadoEdad());

        }
    }
}
