using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aplicacion.DAOs
{
    public class AlumnoDao
    {
        public int idAlumno { get; set; }
        public string nombre { get; set; }
        public string apellidos { get; set; }
        public string nroDocumento { get; set; }
        public DateTime fechaNacimiento { get; set; }
    }
}
