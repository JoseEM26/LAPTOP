using FrontEnd2.Models.Data;
using FrontEnd2.Models.Entity;

namespace FrontEnd2.Models.Logica
{
    public class AlumnoLogica
    {
        public List<Alumno> listarAlumno()
        {
            List<Alumno> lista = new AlumnoData().ListaALumnos();
            return lista;
        }

        public void Create(Alumno a)
        {
            new AlumnoData().CreateAlumno(a);
        }
        public void Update(Alumno a)
        {
            new AlumnoData().Update(a);
        }
        public void eliminar(int id)
        {
            new AlumnoData().Eliminar(id);
        }
        public Alumno ListarXID(int id)
        {
            return new AlumnoData().ListarXID(id);
        }
    }
}
