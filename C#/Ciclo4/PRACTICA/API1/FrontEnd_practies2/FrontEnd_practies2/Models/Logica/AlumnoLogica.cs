using FrontEnd_practies2.Models.Datos;
using FrontEnd_practies2.Models.Entity;

namespace FrontEnd_practies2.Models.Logica
{
    public class AlumnoLogica
    {
        public List<Alumno> listarAlumno()
        {
            return new AlumnoData().listarAlumno();

        }
    }
}
