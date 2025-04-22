using Aplication.DTOs;
using Aplication.Services;
using Dominio.Identity;
using Microsoft.AspNetCore.Mvc;

namespace API.Controllers
{
    [Route("/api/venta")]
    public class VentaController : Controller
    {
        private readonly VentaServices _service;

        public VentaController(VentaServices service)
        {
            _service = service;
        }

        [Route("/RegistrarVenta")]
        [ProducesResponseType(StatusCodes.Status200OK)]
        [ProducesResponseType(StatusCodes.Status400BadRequest)]
        [HttpPost]
        public async Task<IActionResult> Index([FromBody] VentaDTO ventaDTO)
        {
            ResultadoTransaction<string> resultado =await _service.AgregarVenta(ventaDTO);
            if(resultado.idRegistro == -1)
            {
                return BadRequest(resultado.mensaje);
            }
            return Ok(resultado);
        }
    }
}
