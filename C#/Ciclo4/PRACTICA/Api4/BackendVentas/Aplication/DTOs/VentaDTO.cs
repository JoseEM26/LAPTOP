using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aplication.DTOs
{
    public class VentaDTO
    {
        public int idVenta { get; set; }
        public string cliente { get; set; }
        public string nroDocumento { get; set; }
        public DateTime fechaVenta { get; set; }
        public double subTotal { get; set; }
        public double igv { get; set; }
        public double total { get; set; }
        public List<VentaDetDTO> ListaDetalle { get; set; }
    }

    public class VentaDetDTO
    {
        public int idVentaDet { get; set; }
        public int idVenta { get; set; }
        public string producto { get; set; }
        public int cantidad { get; set; }
        public double precio { get; set; }
        public double subtotal { get; set; }
        public double igv { get; set; }
        public double total { get; set; }
    }
}
