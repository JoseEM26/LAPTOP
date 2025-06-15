using Aplicacion.DTOs;
using Aplicacion.Mappers;
using Dominio.Entidades;
using Dominio.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aplicacion.Servicios
{
    public class AlumnoServicio
    {
        private readonly IAlumnoRepositorio repositorio;
        public AlumnoServicio(IAlumnoRepositorio _repositorio)
        {
            this.repositorio = _repositorio;
        }

        public ResultadoTransaccion<string> AgregarAlumno(AlumnoDTO objalumno) 
        {
            var _alumno = new AlumnoMappers().Devolver_Entidad_Alumno(objalumno);
            return repositorio.AgregarAlumno(_alumno);
        }

    }
}
