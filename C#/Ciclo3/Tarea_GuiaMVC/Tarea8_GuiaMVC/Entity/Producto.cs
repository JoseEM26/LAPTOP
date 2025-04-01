using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Tarea8_GuiaMVC.Entity
{
    public class Producto
    {
        public int IdProducto { get; set; }
        public string NomProducto { get; set; }
        public int IdCategoria { get; set; }
        public int IdProveedor { get; set; }
        public string CantxUnidad { get; set; }
        public decimal PrecioUnidad { get; set; }
        public int UnidadesEnExistencia { get; set; }
    }
}