using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Aplicacion.DTOs;
using Dominio.Entidades;

namespace Aplicacion.CasosDeUso
{
    public class VentaCaseUse
    {
        public ResultadoTransaccion<string> ValidarVenta(VentaDto objventa) 
        {
            ResultadoTransaccion<string> resultado = new ResultadoTransaccion<string>();
            var detalle = objventa.Listadetalle.Count();
            if (detalle == 0) 
            {
                resultado.IdRegistro = -1;
                resultado.Mensaje = "Ingresar detalle de venta";
                return resultado;
            }

            if (objventa.subtotal != objventa.Listadetalle.Sum(s => s.subtotal)) 
            {
                resultado.IdRegistro = -1;
                resultado.Mensaje = "La suma del sub total del detalle debe igual al sub total de la cabecera";
                return resultado;
            }

            resultado.IdRegistro = 0;
            resultado.Mensaje = "ok";
            return resultado;
        }
    }
}
