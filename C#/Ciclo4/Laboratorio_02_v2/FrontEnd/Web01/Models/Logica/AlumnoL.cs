using Web01.Models.Datos;
using Web01.Models.Entidad;

namespace Web01.Models.Logica
{
    public class AlumnoL
    {
        public List<AlumnoE> ListarAlumnos() 
        {
            return new AlumnoD().ListaAlumnos();
        }

    }
}
