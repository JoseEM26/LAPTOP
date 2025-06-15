using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Dominio.Entidades;

namespace Aplicacion.DTOs
{
    public class VentaDto
    {
        public int Idventa { get; set; }
        public string cliente { get; set; }
        public string nrodocumento { get; set; }
        public DateTime fechaventa { get; set; }
        public double subtotal { get; set; }
        public double igv { get; set; }
        public double total { get; set; }
		public bool flgEliminado { get; set; }
		public List<ventaDetDTO> Listadetalle { get; set; }
    }

    public class ventaDetDTO
    {
        public int IdventaDet { get; set; }
        public int Idventa { get; set; }
        public string Producto { get; set; }
        public int cantidad { get; set; }
        public double precio { get; set; }
        public double subtotal { get; set; }
        public double igv { get; set; }
        public double total { get; set; }
		public bool flgEliminado { get; set; }
		public bool flgActualiza { get; set; } = false;
	}
}
