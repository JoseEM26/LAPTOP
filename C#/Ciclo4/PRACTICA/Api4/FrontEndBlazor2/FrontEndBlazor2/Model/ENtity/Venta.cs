namespace FrontEndBlazor2.Model.ENtity
{
    public class Venta
    {
        public int idVenta { get; set; }
        public string cliente { get; set; }
        public string nroDocumento { get; set; }
        public DateTime fechaVenta { get; set; }
        public double subTotal { get; set; }
        public double igv { get; set; }
        public double total { get; set; }
        public List<VentaDet> ListaDetalle { get; set; }
    }

    public class VentaDet
    {
        public int idVentaDet { get; set; }
        public int idVenta { get; set; }
        public string producto { get; set; }
        public int cantidad { get; set; }
        public double precio { get; set; }
        public double subtotal { get; set; }
        public double igv { get; set; }
        public double total { get; set; }

        public double CalcularSubTotal() => Math.Round(cantidad * precio);
        public double CalcularIGV() => Math.Round(CalcularSubTotal() * 0.18);
        public double CalcularTotal() => Math.Round(CalcularSubTotal()+CalcularIGV()) ;
    }
}
