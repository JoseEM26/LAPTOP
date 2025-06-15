using Aplicacion.DTOs;
using Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aplicacion.Mappers
{
    public class AlumnoMappers
    {
        public Alumno Devolver_Entidad_Alumno(AlumnoDTO alumnoDTO) 
        {
            return new Alumno
            {
                IdAlumno = alumnoDTO.IdAlumno,
                Nombre = alumnoDTO.Nombre,
                Apellidos = alumnoDTO.Apellidos,
                NroDocumento = alumnoDTO.NroDocumento,
                FechNacimiento = alumnoDTO.FechNacimiento
            };
        }
    }
}
