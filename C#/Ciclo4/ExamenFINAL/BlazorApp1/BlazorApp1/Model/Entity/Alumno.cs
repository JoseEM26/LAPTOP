namespace BlazorApp1.Model.Entity
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
		public int CalcularPromedio()
		{
			if (listaCurso == null || listaCurso.Count == 0)
				return 0;

			int totalNota = listaCurso.Sum(curso => curso.nota);
			return (int)Math.Round((double)totalNota / listaCurso.Count);
		}


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
