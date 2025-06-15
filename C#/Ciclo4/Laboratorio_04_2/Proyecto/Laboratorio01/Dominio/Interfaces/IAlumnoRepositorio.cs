using Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Interfaces
{
    public interface IAlumnoRepositorio
    {
        ResultadoTransaccion<string> AgregarAlumno(Alumno objalumno);
        ResultadoTransaccion<string> ActualizarAlumno(Alumno objalumno);
        ResultadoTransaccion<string> EliminarAlumno(int Id);
        ResultadoTransaccion<Alumno> ListarAlumnoXId(int Id);
        ResultadoTransaccion<Alumno> ListarAlumno();
    }
}
