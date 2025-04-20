using Web.Blazor.Models.Datos;
using Web.Blazor.Models.Entidad;

namespace Web.Blazor.Models.Logica
{
    public class VentaBus
    {
        public ResultadoTransaccion<string> GuardarVenta(EVenta objventa) 
        {
            return new VentaDTO().GuardarVenta(objventa);
        }
    }
}
