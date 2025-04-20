using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Entidades
{
    public class Venta
    {
        public int Idventa { get; set; }
        public string cliente { get; set; }
        public string nrodocumento { get; set; }
        public DateTime fechaventa { get; set; }
        public double subtotal { get; set; }
        public double igv { get; set; }
        public double total { get; set; }

        public List<ventaDet> Listadetalle { get;set; }
    }

    public class ventaDet 
    {
        public int IdventaDet { get; set; }
        public int Idventa { get; set; }
        public string Producto { get; set; }
        public int cantidad { get; set; }
        public double precio { get; set; }
        public double subtotal { get; set; }
        public double igv { get; set; }
        public double total { get; set; }
    }
}
