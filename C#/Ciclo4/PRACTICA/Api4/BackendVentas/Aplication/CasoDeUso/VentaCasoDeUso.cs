using Aplication.DTOs;
using Dominio.Identity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aplication.CasoDeUso
{
    public class VentaCasoDeUso
    {
        public ResultadoTransaction<string> ValidarVenta(VentaDTO ventaDTO)
        {
            ResultadoTransaction<string> resultado = new ResultadoTransaction<string>();
            var cantidad = ventaDTO.ListaDetalle.Count();
            if(cantidad==0 || ventaDTO.subTotal != ventaDTO.ListaDetalle.Sum(x => x.subtotal))
            {
                resultado.idRegistro = -1;
                resultado.mensaje = "ERROR VALIDATE";
                return resultado;
            }
            resultado.mensaje = "OK";
            resultado.idRegistro = 0;
            resultado.value = true;
            return resultado;
        }
    }
}
