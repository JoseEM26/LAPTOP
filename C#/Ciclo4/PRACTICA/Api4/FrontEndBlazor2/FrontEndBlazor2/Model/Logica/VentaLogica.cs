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
		public ResultadoTransaction<string> ActualizarVenta(Venta venta)
		{
           return new VentaData().ActualizarVenta(venta);
		}
		public ResultadoTransaction<string> ActualizarVentaDetalle(VentaDet venta)
		{
			return new VentaData().ActualizarVentaDetalle(venta);
		}
		public ResultadoTransaction<string> EliminarVenta(int id)
		{
			return new VentaData().EliminarVenta(id);
		}
		public ResultadoTransaction<string> EliminarVentaDetalle(int idVenta,int IdventaDetalle)
		{
			return new VentaData().EliminarVentaDetalle(idVenta,IdventaDetalle);
		}
		public ResultadoTransaction<Venta> ListarVenta()
		{
			return new VentaData().ListarVenta();
		}
		public ResultadoTransaction<VentaDet> ListarVentaDetalle()
		{
			return new VentaData().ListarVentaDetalle();
		}
		public ResultadoTransaction<VentaDet> ListarVentaDetalleXidVEnta(int idVenta)
		{
			return new VentaData().ListarVentaDetalleXIDVenta(idVenta);
		}
	}
}
