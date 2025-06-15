using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercisio_6
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Cliente c = new Cliente("pepito", "Carguas", 7777777, "M", 12155, 324324);
            Empleado e = new Empleado("Juanita", "chiquihnsdjsa", 466514, "F", "DNI", 1200);
            Persona p = new Persona("Jose", "espinoza", 515414614, "M");
            Ivehiculo m = new Mototaxi();

            Console.WriteLine("generar codigo: "+c.generarCodigo());
            Console.WriteLine("calcular sueldo :"+e.calcularSueldo());
            Console.WriteLine(c.saludo());
            Console.WriteLine(e.saludo());
            Console.WriteLine(p.saludo());
            Console.WriteLine(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            m.Detener();
            m.Mover();
            Console.ReadKey();
        }
    }
}
