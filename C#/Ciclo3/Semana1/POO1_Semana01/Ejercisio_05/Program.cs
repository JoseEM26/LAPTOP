using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercisio_05
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Vehiculo v = new Vehiculo("JJJ-SSS", "toyota", 100);
            taxi t = new taxi("sss-sss", "NISAN", 150, 32434);
            autobus a = new autobus("SAA-SAD", "W", 200, 6);
            

            t.mensaje();
            a.mensaje();
            v.Mensajito();

            Console.ReadKey();
        }

      
    }
}
