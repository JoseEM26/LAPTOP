using Aplication.DAOs;
using Aplication.Mappers;
using Dominio.Identity;
using Dominio.Interfaz;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aplication.Services
{
    public class AlumnoService
    {
        private readonly IAlumnoTransaction _transaction;

        public AlumnoService(IAlumnoTransaction transaction)
        {
            _transaction = transaction;
        }

        public ResultadoTransaction<string> CreateAlumno(AlumnoDAO alumnoDAO)
        {
            Alumno a = new AlumnoMapper().DevolverAlumno(alumnoDAO);
            return _transaction.CreateAlumno(a);
            
        }
        public ResultadoTransaction<Alumno> ListarAlumno()
        {
            return _transaction.ListarAlumno();
        }
    }
}
