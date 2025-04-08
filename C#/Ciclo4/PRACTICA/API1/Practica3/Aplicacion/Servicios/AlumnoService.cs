using Aplicacion.DAOs;
using Aplicacion.Mappers;
using Dominio.Identity;
using Dominio.Interfazes;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aplicacion.Servicios
{
    public class AlumnoService
    {
        private readonly IAlumnoRepository repository;

        public AlumnoService(IAlumnoRepository repository)
        {
            this.repository = repository;
        }
        public ResultadoTransaction<string> CreateAlumno(AlumnoDao alumnoDao)
        {
            var alumno = new AlumnoMapper().MapearAllAlumno(alumnoDao);
            ResultadoTransaction<string> resultado = repository.CreateAlumno(alumno);

            return resultado;
        }
        public ResultadoTransaction<Alumno> ListarAlumno()
        {
            ResultadoTransaction<Alumno> resultado = repository.ListarAlumno();


            return resultado;
        }
    }
}
