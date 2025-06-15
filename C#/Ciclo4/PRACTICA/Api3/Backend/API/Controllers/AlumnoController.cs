using Aplication.DAOs;
using Aplication.Services;
using Microsoft.AspNetCore.Mvc;

namespace API.Controllers
{
    [Route("api/alumno/")]
    public class AlumnoController : Controller
    {
        private readonly AlumnoService _service;

        public AlumnoController(AlumnoService service)
        {
            _service = service;
        }

        [Route("listar")]
        [HttpGet]
        [ProducesResponseType(StatusCodes.Status200OK)]
        [ProducesResponseType(StatusCodes.Status400BadRequest)]
        public IActionResult Listar()
        {
            var resultado = _service.ListarAlumno();
            if(resultado.idRegistro== -1 || resultado.value == false)
            {
                return BadRequest(resultado.mensaje);
            }
            return Ok(resultado);
        }
        [Route("crear")]
        [HttpPost]
        [ProducesResponseType(StatusCodes.Status200OK)]
        [ProducesResponseType(StatusCodes.Status400BadRequest)]
        public IActionResult Crear([FromBody] AlumnoDAO alumno)
        {
            var resultado = _service.CreateAlumno(alumno);
            if (resultado.idRegistro == -1 || resultado.value == false)
            {
                return BadRequest(resultado.mensaje);
            }
            return Ok(resultado);
        }


    }
}
