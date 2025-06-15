using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EJEMPLO_3
{
    internal partial class Docente
    {
        public string generarCodigo()
        {
            return codigo + " " + nombre;
        }

        public string saludar()
        {
            return "hola " + nombre;
        }
    }
}
