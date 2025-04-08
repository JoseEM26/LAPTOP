using Aplicacion.DAOs;
using Dominio.Identity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aplicacion.Mappers
{
    public class AlumnoMapper
    {
        public Alumno MapearAllAlumno(AlumnoDao alumnoDao)
        {
            return new Alumno()
            {
                idAlumno=alumnoDao.idAlumno,
                apellidos=alumnoDao.apellidos,
                fechaNacimiento=alumnoDao.fechaNacimiento,
                nombre=alumnoDao.nombre,
                nroDocumento=alumnoDao.nroDocumento
            };
        }
    }
}
