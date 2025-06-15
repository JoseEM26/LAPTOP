using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Aplicacion.CasosDeUso;
using Aplicacion.DTOs;
using Aplicacion.Mappers;
using Dominio.Entidades;
using Dominio.Interfaces;

namespace Aplicacion.Servicios
{
    public class VentaServicio
    {
        private readonly IVentaRepositorio _venta;
       
        public VentaServicio(IVentaRepositorio venta)
        {
            _venta = venta;
        }

        public async Task<ResultadoTransaccion<string>> Registrar_Venta(VentaDto objVenta)
        {
            var validarVenta = new VentaCaseUse().ValidarVenta(objVenta);
            if (validarVenta.IdRegistro == -1) 
            {
                return validarVenta;
            }

            var venta = new VentaMapper().Devolver_Entidad_Venta(objVenta);
            return await _venta.Registrar_Venta(venta);
        }

    }
}
