using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
// Agregar
using app_CoreApi_04.Models;
using app_CoreApi_04.Repositorio.DAO;
namespace app_CoreApi_04.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class NegociosAPIController : ControllerBase
    {
        // metodo API que Obtiene lista de clientes
        [HttpGet("getClientes")] public async Task<ActionResult <List<Cliente>>> getClientes()
        {
            var lista = await  Task.Run( ()=> new clienteDAO().getClientes());
            return Ok(lista);
        }
        // metodo API que Obtiene lista de paises
        [HttpGet("getPaises")]
        public async Task<ActionResult<List<Pais>>> getPaises()
        {
            var lista = await Task.Run(() => new paisDAO().getPaises());
            return Ok(lista);
        }
        // metodo API que inserta un cliente
        [HttpPost("insertCliente")]
        public async Task<ActionResult<string>> insertCliente(Cliente reg)
        {
            var mensaje = await Task.Run(() => new clienteDAO().insertCliente (reg));
            return Ok(mensaje);
        }
        // metodo API que actualiza un cliente
        [HttpPut("updateCliente")]
        public async Task<ActionResult<string>> updateCliente(Cliente reg)
        {
            var mensaje = await Task.Run(() => new clienteDAO().updateCliente(reg));
            return Ok(mensaje);
        }
        // Metodo API que obtiene un cliente
        [HttpGet("getCliente/{id}")]
        public async Task<ActionResult<Cliente>> getCliente(string id)
        {
            var lista = await Task.Run(() => new clienteDAO().getCliente (id));
            return Ok(lista);
        }
    }
}
