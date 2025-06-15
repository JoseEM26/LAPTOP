using Aplication.DTOs;
using Aplication.Services;
using Microsoft.AspNetCore.Mvc;

namespace API.Controllers
{
	[Route("API/Alumno")]
	public class AlumnoController : ControllerBase
	{
		private readonly AlumnoServices _alumnoService;

		public AlumnoController(AlumnoServices alumnoService)
		{
			_alumnoService = alumnoService;
		}

		[Route("Registrar_Alumno")]
		[HttpPost]
		[ProducesResponseType(StatusCodes.Status200OK)]
		[ProducesResponseType(StatusCodes.Status400BadRequest)]
		public IActionResult RegistrarAlumno([FromBody] AlumnoDTO alumnoDto)
		{
			try
			{
				var respuesta = _alumnoService.RegistrarAlumno(alumnoDto);
				if (respuesta.IdRegistro == -1)
					return BadRequest(respuesta.Mensaje);

				return Ok(respuesta);
			}
			catch (Exception ex)
			{
				return BadRequest(ex.Message);
			}
		}

		[Route("Actualizar_Alumno")]
		[HttpPost]
		[ProducesResponseType(StatusCodes.Status200OK)]
		[ProducesResponseType(StatusCodes.Status400BadRequest)]
		public IActionResult ActualizarAlumno([FromBody] AlumnoDTO alumnoDto)
		{
			try
			{
				var respuesta = _alumnoService.EditarAlumno(alumnoDto);
				if (respuesta.IdRegistro == -1)
					return BadRequest(respuesta.Mensaje);

				return Ok(respuesta);
			}
			catch (Exception ex)
			{
				return BadRequest(ex.Message);
			}
		}

		[Route("Eliminar_Alumno/{idAlumno}")]
		[HttpDelete]
		[ProducesResponseType(StatusCodes.Status200OK)]
		[ProducesResponseType(StatusCodes.Status400BadRequest)]
		public IActionResult EliminarAlumno(int idAlumno)
		{
			try
			{
				var respuesta = _alumnoService.EliminarAlumno(idAlumno);
				if (respuesta.IdRegistro == -1)
					return BadRequest(respuesta.Mensaje);

				return Ok(respuesta);
			}
			catch (Exception ex)
			{
				return BadRequest(ex.Message);
			}
		}

		[Route("Listar_Alumnos")]
		[HttpGet]
		[ProducesResponseType(StatusCodes.Status200OK)]
		[ProducesResponseType(StatusCodes.Status400BadRequest)]
		public IActionResult ListarAlumnos()
		{
			try
			{
				var respuesta = _alumnoService.ListarAlumnos();
				if (respuesta.IdRegistro == -1)
					return BadRequest(respuesta.Mensaje);

				return Ok(respuesta);
			}
			catch (Exception ex)
			{
				return BadRequest(ex.Message);
			}
		}

		[Route("Listar_Alumno_X_ID/{idAlumno}")]
		[HttpGet]
		[ProducesResponseType(StatusCodes.Status200OK)]
		[ProducesResponseType(StatusCodes.Status400BadRequest)]
		public IActionResult ListarAlumnoPorId(int idAlumno)
		{
			try
			{
				var respuesta = _alumnoService.ListarPorID(idAlumno);
				if (respuesta.IdRegistro == -1)
					return BadRequest(respuesta.Mensaje);

				return Ok(respuesta);
			}
			catch (Exception ex)
			{
				return BadRequest(ex.Message);
			}
		}
	}
}
