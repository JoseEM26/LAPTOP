using Dominio.Identity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Interfazes
{
    public interface IAlumnoRepository
    {
        ResultadoTransaction<string> DeleteAlumno(int id);
        ResultadoTransaction<string> UpdateAlumno(Alumno alumno);
        ResultadoTransaction<string> CreateAlumno(Alumno alumno);
        ResultadoTransaction<Alumno> ListarAlumno();
        ResultadoTransaction<Alumno> ListarAlumnoXID(int id);
    }
}
