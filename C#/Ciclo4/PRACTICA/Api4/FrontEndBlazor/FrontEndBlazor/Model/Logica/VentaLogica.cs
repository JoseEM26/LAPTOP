using FrontEndBlazor.Model.Data;
using FrontEndBlazor.Model.Entity;

namespace FrontEndBlazor.Model.Logica
{
    public class VentaLogica
    {
        public ResultadoTransaction<string> guardarVenta(Venta venta)
        {
            return new VentaData().GuardarVenta(venta);
        }
    }
}
