using Aplicacion.DTOs;
using Aplicacion.Mappers;
using Dominio.Entidad;
using Dominio.Interfaz;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aplicacion.Services
{
    public class AlumnoService
    {
        public readonly IAlumnoRepositorio AlumnoRepositorio;
        AlumnoMaper alumnoMaper = new AlumnoMaper();

        public AlumnoService(IAlumnoRepositorio alumnoRepositorio)
        {
            AlumnoRepositorio = alumnoRepositorio;
        }

        public ResultadoTransaction<String> CreateAlumno(AlumnoDTO alumnoDTO)
        {
            var alumno = alumnoMaper.DevolerAlumno(alumnoDTO);
            return AlumnoRepositorio.AgregarAlumno(alumno);
            
        }
    }
}
