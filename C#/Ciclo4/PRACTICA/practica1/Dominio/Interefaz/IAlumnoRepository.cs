using Dominio.Entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Interefaz
{
    public interface IAlumnoRepository
    {
        ResultadoTransaction<string> DeleteAlumno(int id);
        ResultadoTransaction<string> CreateAlumno(Alumno alumno);
        ResultadoTransaction<string> UpdateAlumno(Alumno alumno);
        ResultadoTransaction<Alumno> BuscarAlumno(int id);
        ResultadoTransaction<Alumno> ListarAlumno();
    }
}
