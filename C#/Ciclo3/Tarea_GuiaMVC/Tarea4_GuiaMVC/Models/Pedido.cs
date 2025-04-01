using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Tarea4_GuiaMVC.Models
{
    public class Pedido
    {
        public string IdPedido { get; set; }
        public string FechaPedido { get; set; }
        public string NomCliente { get; set; }
        public string DirCliente { get; set; }
        public string Empleado { get; set; }

    }
}