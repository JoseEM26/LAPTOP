using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace GuiaMVC1.Models
{
    public class Studient
    {
        public int idStudent { get; set; }
        public string nombre { get; set; }
        public string apellido { get; set; }

        public Studient()
        {

        }
        public Studient(int idStudent, string nombre, string apellido)
        {
            this.idStudent = idStudent;
            this.nombre = nombre;
            this.apellido = apellido;
        }
    }
}