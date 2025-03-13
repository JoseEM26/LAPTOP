using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EJEMPLO_3
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Docente d = new Docente(1001, "Pepito");
            Console.WriteLine(d.generarCodigo());
            Console.WriteLine(d.saludar());

        }
    }
}
