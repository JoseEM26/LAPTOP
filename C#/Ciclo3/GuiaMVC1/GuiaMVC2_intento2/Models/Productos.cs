using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace GuiaMVC2_intento2.Models
{
    public class Productos
    {
        public int IdProducto { get; set; }
        public string NomProducto { get; set; }
        public decimal PrecioUnidad { get; set; }
        public string NomCategoria { get; set; }
        public string NomProveedor { get; set; }
        public int STOCK { get; set; }
    }
}