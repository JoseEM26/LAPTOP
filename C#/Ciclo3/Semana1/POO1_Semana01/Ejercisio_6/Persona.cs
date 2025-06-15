using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercisio_6
{
    internal class Persona
    {
        public string nombre { get; set; }
        public string apellido { get; set; }
        public int documento { get; set; }
        public string genero { get; set; }

        public Persona(string nombre, string apellido, int documento, string genero)
        {
            this.nombre = nombre;
            this.apellido = apellido;
            this.documento = documento;
            this.genero = genero;
        }

        public virtual string saludo()
        {
            return "Hola estamos en la Persona";
        }
    }
}
