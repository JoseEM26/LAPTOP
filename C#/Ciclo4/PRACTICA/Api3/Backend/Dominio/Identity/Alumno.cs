using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Identity
{
    public class Alumno
    {
        public int idAlumno { get; set; }
        public string nombre { get; set; }
        public string apellido { get; set; }
        public string nroDocumento { get; set; }
        public DateTime fechaNacimiento { get; set; }
    }
}
