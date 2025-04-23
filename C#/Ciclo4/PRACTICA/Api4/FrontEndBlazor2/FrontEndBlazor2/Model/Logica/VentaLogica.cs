using FrontEndBlazor2.Model.Data;
using FrontEndBlazor2.Model.ENtity;

namespace FrontEndBlazor2.Model.Logica
{
    public class VentaLogica
    {
        public ResultadoTransaction<string> GuardarVenta(Venta venta)
        {
            return new VentaData().GuardarVenta(venta);
        }
    }
}
