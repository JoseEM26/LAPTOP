using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ejemplo_07
{
    internal class numeroPersonalizadoException:Exception
    {
        public numeroPersonalizadoException(string message) : base(message)
        {
            Console.WriteLine("error :" + message);
        }


    }
}
