using Dominio.Entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Interzas
{
    public interface IAlumnoRepository
    {
        ResultadoTransaction<String> CreateAlumno(Alumno alumno);
        ResultadoTransaction<String> UpdateAlumno(Alumno alumno);
        ResultadoTransaction<String> DeleteAlumno(int id);
        ResultadoTransaction<Alumno> ListarAlumno();
        ResultadoTransaction<Alumno> ListarAlumnoXID(int id);
    }
}
