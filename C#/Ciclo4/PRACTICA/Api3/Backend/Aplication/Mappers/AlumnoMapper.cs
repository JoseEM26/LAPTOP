using Aplication.DAOs;
using Dominio.Identity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aplication.Mappers
{
    public class AlumnoMapper
    {
        public Alumno DevolverAlumno(AlumnoDAO alumnoDAO)
        {
            return new Alumno()
            {
                apellido=alumnoDAO.apellido,
                fechaNacimiento=alumnoDAO.fechaNacimiento,
                idAlumno=alumnoDAO.idAlumno,
                nombre=alumnoDAO.nombre,
                nroDocumento=alumnoDAO.nroDocumento
            };
        }
    }
}
