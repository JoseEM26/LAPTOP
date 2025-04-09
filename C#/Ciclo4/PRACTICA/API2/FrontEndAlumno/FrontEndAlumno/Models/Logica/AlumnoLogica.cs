using FrontEndAlumno.Models.Data;
using FrontEndAlumno.Models.Entity;

namespace FrontEndAlumno.Models.Logica
{
    public class AlumnoLogica
    {
        public List<Alumno> listaAlumno()
        {
            return new AlumnoData().listaAlumno();
        }

        public void CreateAlumno(Alumno alumno)
        {
            new AlumnoData().CreateAlumno(alumno);
        }
    }
}
