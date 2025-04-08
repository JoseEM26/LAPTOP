using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aplicacion.DTOs
{
    public class AlumnoDTO
    {
        public int idAlumno { get; set; }
        public string nombre { get; set; }
        public string apellido { get; set; }
        public DateTime fechaNacimiento { get; set; }
        public int nroDocumento { get; set; }
    }
}
