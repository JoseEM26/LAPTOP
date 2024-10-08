using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Tarea7_GuiaMVC.Models
{
    public class producto
    {
        public int IdProducto { get; set; }
        public string NomProducto { get; set; }
        public decimal PrecioUnidad { get; set; }
        public string NombreCategoria { get; set; }
        public string NomProveedor { get; set; }
        public int Stock { get; set; }
    }
}