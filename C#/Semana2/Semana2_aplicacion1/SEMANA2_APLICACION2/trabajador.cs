using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SEMANA2_APLICACION2
{
    internal class trabajador
    {

        public int codigo { get; set; }
        public string nombre { get; set; }
        public string apellido { get; set; }
        public string direccion { get; set; }
        public int numero { get; set; }

        public trabajador(int codigo, string nombre, string apellido, string direccion, int numero)
        {
            this.codigo = codigo;
            this.nombre = nombre;
            this.apellido = apellido;
            this.direccion = direccion;
            this.numero = numero;
        }


    }
}
