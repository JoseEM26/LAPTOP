using Aplication.DTOs;
using Dominio.Identidad;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aplication.Mappers
{
	public class AlumnoMapper
	{
		public Alumno Devolver_Entidad_Alumno(AlumnoDTO dto)
		{
			return new Alumno
			{
				idAlumno = dto.idAlumno,
				nombre = dto.nombre,
				nroDocumento = dto.nroDocumento,
				fecha = dto.fecha,
				ciclo = dto.ciclo,
				promedio = dto.promedio,
				flgEliminado = dto.flgEliminado,
				listaCurso = dto.listaCurso.Select(c => new CursoAlumno
				{
					idCursoAlumno = c.idCursoAlumno,
					idAlumno = c.idAlumno,
					curso = c.curso,
					nota = c.nota,
					fechaRegistro = c.fechaRegistro,
					fechaActualizado = c.fechaActualizado ,
					flgEliminado = c.flgEliminado,
					flgActualiza = c.flgActualiza
				}).ToList()
			};
		}
	}
}
