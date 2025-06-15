using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EJEMPLO_3
{
    internal partial class Docente
    {
        public int codigo { get; set; }
        public string nombre { get; set; }

        public Docente(int codigo, string nombre)
        {
            this.codigo = codigo;
            this.nombre = nombre;
        }
    }
}
