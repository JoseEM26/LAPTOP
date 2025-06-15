using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace PaginaWeb.Models
{
    public class Pelicula
    {
        public string nombre { get; set; }
        public int duracion { get; set; }
        public DateTime fecha { get; set; }


        public Pelicula(string nombre, int duracion,DateTime fecha)
        {
            this.nombre = nombre;
            this.duracion = duracion;
            this.fecha = fecha;
        }



    }
}