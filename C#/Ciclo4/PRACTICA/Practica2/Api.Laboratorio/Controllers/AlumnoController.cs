using Aplicacion.DTOs;
using Aplicacion.Services;
using Dominio.Entidad;
using Microsoft.AspNetCore.Mvc;

namespace Api.Laboratorio.Controllers
{
    [Route("api/alumno")]
    public class AlumnoController : Controller
    {
        private readonly AlumnoService _service;

        public AlumnoController(AlumnoService service)
        {
            _service = service;
        }

        [HttpPost]
        [Route("AgregarAlumno")]
        [ProducesResponseType(StatusCodes.Status200OK)]
        [ProducesResponseType(StatusCodes.Status400BadRequest)]
        public IActionResult AgregarAlumno([FromBody]AlumnoDTO alumnoDTO)
        {
            try
            {
                ResultadoTransaction<String> resultado = _service.CreateAlumno(alumnoDTO);
                if(resultado.idResultado == -1)
                {
                    return BadRequest(resultado.mensaje);
                }
                return Ok(resultado);
            }catch(Exception ex)
            {
                return BadRequest(ex.Message);
            }
        }
    }
}
