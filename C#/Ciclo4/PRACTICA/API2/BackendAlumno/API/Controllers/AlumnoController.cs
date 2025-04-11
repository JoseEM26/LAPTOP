using Aplicacion.DAOs;
using Aplicacion.Mappers;
using Aplicacion.Services;
using Dominio.Entity;
using Microsoft.AspNetCore.Mvc;

namespace API.Controllers
{
    [Route("api/alumno")]
    public class AlumnoController : Controller
    {
        private readonly AlumnoServices _services;

        public AlumnoController(AlumnoServices services)
        {
            _services = services;
        }

        [HttpGet]
        [Route("List")]
        [ProducesResponseType(StatusCodes.Status200OK)]
        [ProducesResponseType(StatusCodes.Status400BadRequest)]
        public IActionResult ListarAlumno()
        {
            try
            {
                var resultado = _services.ListarAlumno();
                if(resultado.idRegistro == -1)
                {
                    return BadRequest(resultado.mensaje);
                }
                if(resultado.value == false)
                {
                    return BadRequest(resultado.mensaje);
                }
                return Ok(resultado);
            }
            catch (Exception e)
            {
                return BadRequest(e.Message);

            }
        }

        [HttpPost]
        [Route("Create")]
        [ProducesResponseType(StatusCodes.Status200OK)]
        [ProducesResponseType(StatusCodes.Status400BadRequest)]
        public IActionResult CreateAlumno([FromBody]AlumnoDAO alumnoDAO)
        {
            try
            {
                var resultado = _services.CreateAlumno(alumnoDAO);
                if (resultado.idRegistro == -1)
                {
                    return BadRequest(resultado.mensaje);
                }
                if (resultado.value == false)
                {
                    return BadRequest(resultado.mensaje);
                }
                return Ok(resultado);
            }
            catch (Exception e)
            {
                return BadRequest(e.Message);

            }
        }


        [Route("Eliminar/{id}")]
        [HttpDelete]
        [ProducesResponseType(StatusCodes.Status200OK)]
        [ProducesResponseType(StatusCodes.Status400BadRequest)]
        public IActionResult EliminarAlumno( int id)
        {
            var resultado = _services.EliminarAlumno(id);
            if(resultado.idRegistro == -1)
            {
                return BadRequest(resultado.mensaje);
            }
            if (resultado.value == false)
            {
                return BadRequest(resultado.mensaje);
            }
            return Ok(resultado);
        }

        [Route("Update")]
        [HttpPut]
        [ProducesResponseType(StatusCodes.Status200OK)]
        [ProducesResponseType(StatusCodes.Status400BadRequest)]
        public IActionResult UpdateAlumno([FromBody]AlumnoDAO alumno)
        {
            try
            {
                var resultado = _services.UpdateAlumno(alumno);
                if(resultado.idRegistro == -1)
                {
                    return BadRequest(resultado.mensaje);
                }if(resultado.value == false)
                {
                    return BadRequest(resultado.mensaje);

                }
                return Ok(resultado);
            }
            catch (Exception e)
            {
                return BadRequest(e.Message);
            }
        }

        [Route("listarXID")]
        [HttpGet]
        [ProducesResponseType(StatusCodes.Status200OK)]
        [ProducesResponseType(StatusCodes.Status400BadRequest)]
        public IActionResult ListarXID([FromQuery]int id)
        {
            var resultado = _services.ListarXID(id);
            if (resultado.idRegistro == -1 || resultado.value==false)
            {
                return BadRequest(resultado.mensaje);
            }
            return Ok(resultado);

        }
    }
}
