using Aplicacion.DTOs;
using Aplicacion.Servicios;
using Microsoft.AspNetCore.Mvc;

namespace Api.Laboratorio.Controllers
{
    [Route("Api/Alumno")]
    public class AlumnoController : ControllerBase
    {
        private readonly AlumnoServicio _servicio;
        public AlumnoController(AlumnoServicio servicio)
        {
            _servicio = servicio;
        }

        [Route("Agregar_Alumno")]
        [HttpPost]
        [ProducesResponseType(StatusCodes.Status200OK)]
        [ProducesResponseType(StatusCodes.Status400BadRequest)]

        public IActionResult Agregar_Alumno([FromBody] AlumnoDTO alumnodto) 
        {
            try {
                var respuesta = _servicio.AgregarAlumno(alumnodto);
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
