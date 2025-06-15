using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace POO1_Semana01
{
    internal class Estudiante
    {
        public int codigo { get; set; }
        public string nombre { get; set; }
        public string apellido { get; set; }
        public string direccion { get; set; }
        public string sexo { get; set; }

        public Estudiante()
        {
            this.codigo = 100;
        }

        public Estudiante(int codigo, string nombre)
        {

            this.codigo = codigo;
            this.nombre = nombre;
           
        }

        public string getNombreCompleto()
        {
            return nombre +" "+ apellido;
        }

       



    }
}
