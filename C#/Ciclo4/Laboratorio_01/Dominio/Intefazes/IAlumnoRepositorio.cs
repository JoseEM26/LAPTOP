using Dominio.Entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Intefazes
{
//Halsing Anime:;
    public interface IAlumnoRepositorio
    {
        ResultadoTransaction<string> AgregarAlumno(Alumno alumno);
        ResultadoTransaction<string> ActualizarAlumno(Alumno alumno);
        ResultadoTransaction<string> EliminarAlumno(int id);
        ResultadoTransaction<Alumno> ListarTodo();
        ResultadoTransaction<Alumno> ListarXid(int id);
  
    }
}
