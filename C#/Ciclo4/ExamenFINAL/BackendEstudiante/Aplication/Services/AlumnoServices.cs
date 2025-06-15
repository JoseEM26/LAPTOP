using Aplication.DTOs;
using Aplication.Mappers;
using Dominio.Identidad;
using Dominio.Interfaz;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aplication.Services
{
	public class AlumnoServices
	{
		private readonly IAlumnoRepository _alumnoRepository;

		public AlumnoServices(IAlumnoRepository alumnoRepository)
		{
			_alumnoRepository = alumnoRepository;
		}

		public ResultadoTransaccion<string> RegistrarAlumno(AlumnoDTO dto)
		{
			Alumno alumno = new AlumnoMapper().Devolver_Entidad_Alumno(dto);
			return _alumnoRepository.Registrar_Alumno(alumno);
		}

		public ResultadoTransaccion<string> EditarAlumno(AlumnoDTO dto)
		{
			Alumno alumno = new AlumnoMapper().Devolver_Entidad_Alumno(dto);
			return _alumnoRepository.Editar_Alumno(alumno);
		}

		public ResultadoTransaccion<string> EliminarAlumno(int idAlumno)
		{
			return _alumnoRepository.Eliminar_Alumno(idAlumno);
		}

		public ResultadoTransaccion<Alumno> ListarAlumnos()
		{
			return _alumnoRepository.Listar_Alumno();
		}

		public ResultadoTransaccion<Alumno> ListarPorID(int idAlumno)
		{
			return _alumnoRepository.Listar_X_ID(idAlumno);
		}
	
}
}
