using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Identidad
{
		public class Alumno
		{
			public int idAlumno { get; set; }
			public string nombre { get; set; }
			public string nroDocumento { get; set; }
			public DateTime fecha { get; set; }
			public string ciclo { get; set; }
			public int promedio { get; set; }
			public bool flgEliminado { get; set; }
			public List<CursoAlumno> listaCurso { get; set; }
		}
		public class CursoAlumno
		{
			public int idCursoAlumno { get; set; }
			public int idAlumno { get; set; }
			public string curso { get; set; }
			public int nota { get; set; }
			public DateTime fechaRegistro { get; set; }
			public DateTime? fechaActualizado { get; set; }
			public bool flgEliminado { get; set; }
			public bool flgActualiza { get; set; }
		}
}
