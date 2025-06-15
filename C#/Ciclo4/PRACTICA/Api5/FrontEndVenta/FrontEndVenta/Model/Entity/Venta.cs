namespace FrontEndVenta.Model.Entity
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
        public List<VentaDet> listaVentaDet { get; set; }
    }

    public class VentaDet
    {
        public int idVentaDet { get; set; }
        public int idVenta { get; set; }
        public string producto { get; set; }
        public int cantidad { get; set; }
        public double precio { get; set; }
        public double subTotal { get; set; }
        public double igv { get; set; }
        public double total { get; set; }

        public double CalcularSubtotal() => cantidad * precio;
        public double CalcularIGV() => CalcularSubtotal()*0.18;
        public double CalculaTotal() => CalcularSubtotal()+CalcularIGV();
    }
}
