using Dominio.Identity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Interfaz
{
    public interface IAlumnoTransaction
    {
        ResultadoTransaction<string> CreateAlumno(Alumno a);
        ResultadoTransaction<Alumno> ListarAlumno();
    }
}
