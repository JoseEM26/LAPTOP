using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Dominio.Entidades;

namespace Dominio.Interfaces
{
    public interface IVentaRepositorio
    {
        Task<ResultadoTransaccion<string>> Registrar_Venta(Venta objventa);
        Task<ResultadoTransaccion<string>> Editar_Venta(Venta objventa);
        Task<ResultadoTransaccion<string>> Eliminar_Venta(Venta objventa);
        Task<ResultadoTransaccion<Venta>> Listar_ventas();
        Task<ResultadoTransaccion<Venta>> Listar_X_ID(int Idventa);
    }
}
