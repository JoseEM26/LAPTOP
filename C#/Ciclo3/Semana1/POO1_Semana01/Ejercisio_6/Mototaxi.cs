using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercisio_6
{
    internal class Mototaxi : Ivehiculo
    {
        public void Detener()
        {
            Console.WriteLine("detener");
        }

        public void Mover()
        {
            Console.WriteLine("mover");
        }
    }
}
