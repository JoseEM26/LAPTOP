using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercisio_04
{
    internal partial class Expositor
    {
        public int codigo { get; set; }
        public string nombre { get; set; }
        public int Horatrabajadas { get; set; }
        public double tarifaHora { get; set; }

        public Expositor(int codigo, string nombre, int horatrabajadas, double tarifaHora)
        {
            this.codigo = codigo;
            this.nombre = nombre;
            this.Horatrabajadas = horatrabajadas;
            this.tarifaHora = tarifaHora;
        }
    }
}
