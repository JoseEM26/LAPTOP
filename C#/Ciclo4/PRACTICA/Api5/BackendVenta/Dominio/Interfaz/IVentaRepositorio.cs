using Dominio.Identidad;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Interfaz
{
    public interface IVentaRepositorio
    {
        ResultadoTransaction<string> CreateVenta(Venta venta);
        ResultadoTransaction<Venta> ListarVenta();
    }
}
