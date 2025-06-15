using Aplicacion.DAOs;
using Aplicacion.Servicios;
using Microsoft.AspNetCore.Mvc;

namespace API.Controllers
{
    [Route("/api/alumno")]
    public class AlumnoController : Controller
    {
        private readonly AlumnoService _Services;

        public AlumnoController(AlumnoService services)
        {
            _Services = services;
        }

        [Route("createAlumno")]
        [HttpPost]
        [ProducesResponseType(StatusCodes.Status200OK)]
        [ProducesResponseType(StatusCodes.Status400BadRequest)]
        public IActionResult AgregarAlumno([FromBody]AlumnoDao alumno)
        {
            try
            {
                var respuesta = _Services.CreateAlumno(alumno);
                if(respuesta.value == false)
                {
                    return BadRequest(respuesta.mensaje);
                }
                if (respuesta.idRegistro == -1) 
                {
                    return BadRequest(respuesta.mensaje);
                }
                return Ok(respuesta);

            }
            catch (Exception e)
            {
                    return BadRequest(e.Message);

            }

            
        }
        [Route("listarAlumno")]
        [HttpGet]
        [ProducesResponseType(StatusCodes.Status200OK)]
        [ProducesResponseType(StatusCodes.Status400BadRequest)]
        public IActionResult ListarAlumno()
        {
            try
            {
                var respuesta = _Services.ListarAlumno();
                if (respuesta.value == false)
                {
                    return BadRequest(respuesta.mensaje);
                }
                if (respuesta.idRegistro == -1)
                {
                    return BadRequest(respuesta.mensaje);
                }
                return Ok(respuesta);

            }
            catch (Exception e)
            {
                return BadRequest(e.Message);

            }


        }
    }
}
