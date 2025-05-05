using Dominio.Identidad;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Interfaz
{
	public interface IAlumnoRepository
	{
		ResultadoTransaccion<string> Registrar_Alumno(Alumno alumno);
		ResultadoTransaccion<string> Editar_Alumno(Alumno alumno);
		ResultadoTransaccion<string> Eliminar_Alumno(int id);
		ResultadoTransaccion<Alumno> Listar_Alumno();
		ResultadoTransaccion<Alumno> Listar_X_ID(int idAlumno);
	}
}
