using ExamenAbril.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Web;

namespace ExamenAbril.Service
{
    public class AlumnoService
    {
        public Alumnos ObtenerAlumno()
        {
            return new Alumnos(111, "POO", 10, 15, 19, 20, 12, "jose");
        }

        public List<Alumnos> ObtenerListaAlumno()
        {
            Alumnos a1 = new Alumnos(100, "Aritmetica", 11, 12, 11, 20, 1001, "Manuelita");
            Alumnos a2 = new Alumnos(101, "POO", 01, 10, 20, 10, 1002, "Israel");
            Alumnos a3 = new Alumnos(102, "JAVA", 15, 19, 20, 10, 1003, "Hise");
            return new List<Alumnos> { a1, a2, a3 };
        }


    }
}