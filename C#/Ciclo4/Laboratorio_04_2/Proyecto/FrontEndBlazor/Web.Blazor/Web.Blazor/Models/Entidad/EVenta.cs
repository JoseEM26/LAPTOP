namespace Web.Blazor.Models.Entidad
{
    public class EVenta
    {
        public int Idventa { get; set; }
        public string cliente { get; set; }
        public string nrodocumento { get; set; }
        public DateTime fechaventa { get; set; }
        public double subtotal { get; set; }
        public double igv { get; set; }
        public double total { get; set; }

        public List<EventaDet> Listadetalle { get; set; }
    }

    public class EventaDet {
        public int IdventaDet { get; set; }
        public int Idventa { get; set; }
        public string Producto { get; set; }
        public int cantidad { get; set; }
        public double precio { get; set; }
        public double subtotal { get; set; }
        public double igv { get; set; }
        public double total { get; set; }

        public double CalcularSubtotal() 
        {
            return Math.Round((cantidad * precio), 4);
        }

        public double CalcularIGV()
        {
            return Math.Round((CalcularSubtotal() * 0.18), 4);
        }

        public double CalcularTotal()
        {
            return Math.Round((CalcularSubtotal() + CalcularIGV()), 4);
        }
    }
}
