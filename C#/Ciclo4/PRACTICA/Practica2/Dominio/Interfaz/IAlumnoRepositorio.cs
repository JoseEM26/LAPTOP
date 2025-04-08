using Dominio.Entidad;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Interfaz
{
    public interface IAlumnoRepositorio
    {
        ResultadoTransaction<String> AgregarAlumno(Alumno alumno);
        ResultadoTransaction<String> ActualizarAlumno(Alumno alumno);
        ResultadoTransaction<String> EliminarAlumno(int id);
        ResultadoTransaction<Alumno> Listar_x_id(int id);
        ResultadoTransaction<Alumno> ListarAlumnos();
    }
}
