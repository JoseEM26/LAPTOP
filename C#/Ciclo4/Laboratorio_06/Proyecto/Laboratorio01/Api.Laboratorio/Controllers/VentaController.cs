using Aplicacion.DTOs;
using Aplicacion.Servicios;
using Microsoft.AspNetCore.Mvc;

namespace Api.Laboratorio.Controllers
{
    [Route("API/Venta")]
    public class VentaController : ControllerBase
    {
        private readonly VentaServicio _ventaServicio;

        public VentaController(VentaServicio ventaServicio)
        {
            _ventaServicio = ventaServicio;
        }
        
        [Route("Registrar_Venta")]
        [HttpPost]
        [ProducesResponseType(StatusCodes.Status200OK)]
        [ProducesResponseType(StatusCodes.Status400BadRequest)]

        public async Task<IActionResult> Agregar_Alumno([FromBody] VentaDto ventadto)
        {
            try
            {
                var respuesta = await _ventaServicio.Registrar_Venta(ventadto);
                if (respuesta.IdRegistro == -1)
                {
                    return BadRequest(respuesta.Mensaje);
                }
                return Ok(respuesta);
            }
            catch (Exception ex)
            {
                return BadRequest(ex.Message);
            }
        }

		[Route("Actualizar_Venta")]
		[HttpPost]
		[ProducesResponseType(StatusCodes.Status200OK)]
		[ProducesResponseType(StatusCodes.Status400BadRequest)]

		public async Task<IActionResult> Actualizar_Venta([FromBody] VentaDto ventadto)
		{
			try
			{
				var respuesta = await _ventaServicio.Editar_Venta(ventadto);
				if (respuesta.IdRegistro == -1)
				{
					return BadRequest(respuesta.Mensaje);
				}
				return Ok(ventadto);
			}
			catch (Exception ex)
			{
				return BadRequest(ex.Message);
			}
		}

		[Route("ListarVentas")]
		[HttpGet]
		[ProducesResponseType(StatusCodes.Status200OK)]
		[ProducesResponseType(StatusCodes.Status400BadRequest)]
		public async Task<IActionResult> ListarVenta() 
        {
            try { 
                var respuesta = await _ventaServicio.Listar_ventas();
				if (respuesta.IdRegistro == -1)
				{
					return BadRequest(respuesta.Mensaje);
				}
				return Ok(respuesta);
			}
            catch (Exception ex) 
            {
                return BadRequest(ex.Message);
            }
        }

		[Route("ListarVentasXID")]
		[HttpGet]
		[ProducesResponseType(StatusCodes.Status200OK)]
		[ProducesResponseType(StatusCodes.Status400BadRequest)]
		public async Task<IActionResult> ListarVenta_X_ID(int IdVenta)
		{
			try
			{
				var respuesta = await _ventaServicio.Listar_X_ID(IdVenta);
				if (respuesta.IdRegistro == -1)
				{
					return BadRequest(respuesta.Mensaje);
				}
				return Ok(respuesta);
			}
			catch (Exception ex)
			{
				return BadRequest(ex.Message);
			}
		}

	}
}
