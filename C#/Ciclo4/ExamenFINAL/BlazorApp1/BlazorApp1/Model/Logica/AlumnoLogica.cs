using BlazorApp1.Model.Data;
using BlazorApp1.Model.Entity;
using Microsoft.Extensions.Logging;

namespace BlazorApp1.Model.Logica
{
	public class AlumnoLogica
	{
		public ResultadoTransaccion<string> GuardarAlumno(Alumno alumno)
		{
			return new AlumnoData().GuardarAlumno(alumno);
		}

		public ResultadoTransaccion<string> ActualizarAlumno(Alumno alumno, List<CursoAlumno> CursoEliminado)
		{
			ResultadoTransaccion<string> resultado = new ResultadoTransaccion<string>();
			if (alumno.listaCurso.Count == 0)
			{
				resultado.IdRegistro = -1;
				resultado.Mensaje = "Agregar Detalle de la venta";
				return resultado;
			}

			if (CursoEliminado.Count > 0)
			{
				foreach (var item in CursoEliminado)
				{
					alumno.listaCurso.Add(item);
				}
			}

			return new AlumnoData().ActualizarAlumno(alumno);
		}

		public ResultadoTransaccion<Alumno> ListadoAlumno()
		{
			return new AlumnoData().ListadoAlumno();
		}

		public ResultadoTransaccion<Alumno> ListadoVenta_X_ID(int IdAlumno)
		{
			return new AlumnoData().ListadoAlumno_X_ID(IdAlumno);
		}

	}
}

