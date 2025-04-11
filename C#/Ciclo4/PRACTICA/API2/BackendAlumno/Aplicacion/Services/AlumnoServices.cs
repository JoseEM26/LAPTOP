using Aplicacion.DAOs;
using Aplicacion.Mappers;
using Dominio.Entity;
using Dominio.Interzas;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aplicacion.Services
{
    public class AlumnoServices
    {
        private readonly IAlumnoRepository _alumnoRepository;

        public AlumnoServices(IAlumnoRepository alumnoRepository)
        {
            _alumnoRepository = alumnoRepository;
        }

        public ResultadoTransaction<string> CreateAlumno(AlumnoDAO alumnoDAO)
        {
            Alumno alumno = new AlumnoMapper().MapperAlumno(alumnoDAO);

            ResultadoTransaction<string> resultado = _alumnoRepository.CreateAlumno(alumno);
            return resultado;

        }
        public ResultadoTransaction<string> UpdateAlumno(AlumnoDAO alumnoDAO)
        {
            Alumno alumno = new AlumnoMapper().MapperAlumno(alumnoDAO);

            ResultadoTransaction<string> resultado = _alumnoRepository.UpdateAlumno(alumno);
            return resultado;

        }
        public ResultadoTransaction<Alumno> ListarAlumno()
        {
            ResultadoTransaction<Alumno> respuesta = _alumnoRepository.ListarAlumno();
            return respuesta;
        }

        public ResultadoTransaction<string> EliminarAlumno(int id)
        {
            ResultadoTransaction<string> resultado = _alumnoRepository.DeleteAlumno(id);

            return resultado;
        }

        public ResultadoTransaction<Alumno> ListarXID(int id)
        {
            var alumno = _alumnoRepository.ListarAlumnoXID(id);
            return alumno;

        }
    }
}
