using Aplication.DTOs;
using Aplication.Services;
using Dominio.Identity;
using Microsoft.AspNetCore.Mvc;

namespace API.Controllers
{
    [Route("api/venta")]
    public class VentaController : Controller
    {
        private readonly VentaServices _service;

        public VentaController(VentaServices service)
        {
            _service = service;
        }

        [Route("RegistrarVenta")]
        [ProducesResponseType(StatusCodes.Status200OK)]
        [ProducesResponseType(StatusCodes.Status400BadRequest)]
        [HttpPost]
        public async Task<IActionResult> CreateVenta([FromBody] VentaDTO ventaDTO)
        {
            ResultadoTransaction<string> resultado =await _service.AgregarVenta(ventaDTO);
            if(resultado.idRegistro == -1)
            {
                return BadRequest(resultado.mensaje);
            }
            return Ok(resultado);
        }
        [Route("ListarVenta")]
        [ProducesResponseType(StatusCodes.Status200OK)]
        [ProducesResponseType(StatusCodes.Status400BadRequest)]
        [HttpGet]
        public async Task<IActionResult> ListarVenta()
        {
            ResultadoTransaction<Venta> resultado = await _service.ListaVenta();
            if (resultado.idRegistro == -1)
            {
                return BadRequest(resultado.mensaje);
            }
            return Ok(resultado);
        }
        [Route("ListarVentaDetalle")]
        [ProducesResponseType(StatusCodes.Status200OK)]
        [ProducesResponseType(StatusCodes.Status400BadRequest)]
        [HttpGet]
        public async Task<IActionResult> ListarVentaDetalle()
        {
            ResultadoTransaction<VentaDet> resultado = await _service.ListaVentaDetalle();
            if (resultado.idRegistro == -1)
            {
                return BadRequest(resultado.mensaje);
            }
            return Ok(resultado);
        }
        [Route("ListarVentaDetalleXIdVenta/{id}")]
        [ProducesResponseType(StatusCodes.Status200OK)]
        [ProducesResponseType(StatusCodes.Status400BadRequest)]
        [HttpGet]
        public async Task<IActionResult> ListarVentaDetalleXIdVenta(int id)
        {
            ResultadoTransaction<VentaDet> resultado = await _service.ListaVentaDetalleXidVEnta(id);
            if (resultado.idRegistro == -1)
            {
                return BadRequest(resultado.mensaje);
            }
            return Ok(resultado);
        }
        [Route("ActualizarVenta")]
        [ProducesResponseType(StatusCodes.Status200OK)]
        [ProducesResponseType(StatusCodes.Status400BadRequest)]
        [HttpPut]
        public async Task<IActionResult> ActualizarVenta([FromBody]VentaDTO ventaDTO)
        {
            ResultadoTransaction<string> resultado = await _service.ActualizarVenta(ventaDTO);
            if (resultado.idRegistro == -1)
            {
                return BadRequest(resultado.mensaje);
            }
            return Ok(resultado);
        }
        [Route("ActualizarVentaDetalle")]
        [ProducesResponseType(StatusCodes.Status200OK)]
        [ProducesResponseType(StatusCodes.Status400BadRequest)]
        [HttpPut]
        public async Task<IActionResult> ActualizarVentaDetalle([FromBody] VentaDetDTO ventaDetDTO)
        {
            ResultadoTransaction<string> resultado = await _service.ActualizarVentaDetalle(ventaDetDTO);
            if (resultado.idRegistro == -1)
            {
                return BadRequest(resultado.mensaje);
            }
            return Ok(resultado);
        }
        [Route("EliminarVenta/{id}")]
        [ProducesResponseType(StatusCodes.Status200OK)]
        [ProducesResponseType(StatusCodes.Status400BadRequest)]
        [HttpDelete]
        public async Task<IActionResult> EliminarVenta(int id)
        {
            ResultadoTransaction<string> resultado = await _service.EliminarVenta(id);
            if (resultado.idRegistro == -1)
            {
                return BadRequest(resultado.mensaje);
            }
            return Ok(resultado);
        }
        [Route("EliminarVentaDetalle/{idVenta}/{idVentaDet}")]
        [ProducesResponseType(StatusCodes.Status200OK)]
        [ProducesResponseType(StatusCodes.Status400BadRequest)]
        [HttpDelete]
        public async Task<IActionResult> EliminarVentaDetalle(int idVenta,int idVentaDet)
        {
            ResultadoTransaction<string> resultado = await _service.EliminarVentaDetalle(idVenta,idVentaDet);
            if (resultado.idRegistro == -1)
            {
                return BadRequest(resultado.mensaje);
            }
            return Ok(resultado);
        }
    }
}
