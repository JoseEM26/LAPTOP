using Aplication.DTOs;
using Aplication.Services;
using Microsoft.AspNetCore.Mvc;

namespace API.Controllers
{
    [Route("api/venta")]
    public class VentaController : Controller
    {
        private readonly VentaServices _services;

        public VentaController(VentaServices services)
        {
            _services = services;
        }

        [Route("create")]
        [HttpPost]
        [ProducesResponseType(StatusCodes.Status200OK)]
        [ProducesResponseType(StatusCodes.Status400BadRequest)]
        public IActionResult CreateVenta([FromBody] VentaDTO ventaDTO )
        {
            var resultado = _services.createVenta(ventaDTO);
            if (resultado.idRespuesta == -1)
            {
                return BadRequest(resultado);
            }
            return Ok(resultado);
        }
        [Route("listar")]
        [HttpGet]
        [ProducesResponseType(StatusCodes.Status200OK)]
        [ProducesResponseType(StatusCodes.Status400BadRequest)]
        public IActionResult ListarVenta()
        {
            var resultado = _services.ListarVenta();
            if (resultado.idRespuesta == -1)
            {
                return BadRequest(resultado);
            }
            return Ok(resultado);
        }
    }
}
