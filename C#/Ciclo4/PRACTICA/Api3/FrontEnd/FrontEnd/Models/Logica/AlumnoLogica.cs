using FrontEnd.Models.Data;
using FrontEnd.Models.Entity;

namespace FrontEnd.Models.Logica
{
    public class AlumnoLogica
    {
        public AlumnoData _data= new AlumnoData();
        public List<Alumno> listaAlumno()
        {
            return _data.listaAlumno();
        }
        public void CrearAlumno(Alumno a)
        {
             _data.CrearAlumno(a);
        }
    }
}
