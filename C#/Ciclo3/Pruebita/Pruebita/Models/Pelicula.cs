using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Pruebita.Models
{
    public class Pelicula
    {
        public string nombre { get; set; }
        public DateTime fecha { get; set; }
        public int costo { get; set; }
        public string pais { get; set; }

    }
}