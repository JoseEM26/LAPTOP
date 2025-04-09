using Aplicacion.DAOs;
using Dominio.Entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aplicacion.Mappers
{
    public class AlumnoMapper
    {
        public Alumno MapperAlumno(AlumnoDAO alumnoDAO)
        {
            Alumno alumno = new Alumno()
            {
                idAlumno=alumnoDAO.idAlumno,
                apellido=alumnoDAO.apellido,
                fechaNacimiento=alumnoDAO.fechaNacimiento,
                nombre=alumnoDAO.nombre,
                nroDocumento=alumnoDAO.nroDocumento
            };
            return alumno;
        }
    }
}
