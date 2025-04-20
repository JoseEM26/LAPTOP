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
    }
}
