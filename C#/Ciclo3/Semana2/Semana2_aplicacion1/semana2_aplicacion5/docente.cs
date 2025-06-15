using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace semana2_aplicacion5
{
    internal class docente
    {
        public string nombre { get; set; }
        public string apellido { get; set; }
        public int edad { get; set; }

        public docente(string nombre, string apellido, int edad)
        {
            this.nombre = nombre;
            this.apellido = apellido;
            this.edad = edad;
        }
    }
}
