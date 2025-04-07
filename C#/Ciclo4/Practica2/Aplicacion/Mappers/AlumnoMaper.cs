using Aplicacion.DTOs;
using Dominio.Entidad;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aplicacion.Mappers
{
    public class AlumnoMaper
    {
        public Alumno DevolerAlumno(AlumnoDTO alumnoDTO)
        {
            return new Alumno()
            {
                apellido=alumnoDTO.apellido,
                nombre = alumnoDTO.nombre,
                idAlumno=alumnoDTO.idAlumno,
                fechaNacimiento=alumnoDTO.fechaNacimiento,
                nroDocumento=alumnoDTO.nroDocumento 
            };

        }
    }
}
