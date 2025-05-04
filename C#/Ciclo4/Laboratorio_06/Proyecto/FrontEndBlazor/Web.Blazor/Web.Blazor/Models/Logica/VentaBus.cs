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

		public ResultadoTransaccion<string> ActualizarVenta(EVenta objventa, List<EventaDet> ProductoEliminado)
		{
			ResultadoTransaccion<string> resultado = new ResultadoTransaccion<string>();
            if (objventa.Listadetalle.Count == 0) 
            {
                resultado.IdRegistro = -1;
                resultado.Mensaje = "Agregar Detalle de la venta";
                return resultado;
            }
            
            if (ProductoEliminado.Count > 0)
            {
                foreach (var item in ProductoEliminado) 
                {
                    objventa.Listadetalle.Add(item);
                }
            }

            return new VentaDTO().ActualizarVenta(objventa);
		}

		public ResultadoTransaccion<EVenta> ListadoVenta()
        {
            return new VentaDTO().ListadoVenta();
        }

        public ResultadoTransaccion<EVenta> ListadoVenta_X_ID(int Idventa) 
        {
            return new VentaDTO().ListadoVenta_X_ID(Idventa);
        }

	}
}
