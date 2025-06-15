using Dominio.Identity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Interfaz
{
    public interface IVentaRepositorio
    {
        Task<ResultadoTransaction<string>> createVenta(Venta venta);
        Task<ResultadoTransaction<string>> ActualizarVenta(Venta venta);
        Task<ResultadoTransaction<string>> Eliminarventa(int id);
        Task<ResultadoTransaction<VentaDet>> ListarVentaDet();
        Task<ResultadoTransaction<Venta>> ListarVenta();
        Task<ResultadoTransaction<VentaDet>> ListarVentaDetalleXIDVenta(int idVenta);
        Task<ResultadoTransaction<string>> ActualizarVentaDetalle(VentaDet venta);
        Task<ResultadoTransaction<string>> EliminarventaDetalle(int idVenta, int idVentDet);
    }
}
