using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ExamenAbril.Models
{
    public class Evaluaciones
    {
        public int IdEvaluacion { get; set; }
        public string nombreCurso { get; set; }
        public int nota1 { get; set; }
        public int nota2 { get; set; }
        public int notaParcial { get; set; }
        public int notaFinal { get; set; }

        public Evaluaciones(int idEvaluacion, string nombreCurso, int nota1, int nota2, int notaParcial, int notaFinal)
        {
            IdEvaluacion = idEvaluacion;
            this.nombreCurso = nombreCurso;
            this.nota1 = nota1;
            this.nota2 = nota2;
            this.notaParcial = notaParcial;
            this.notaFinal = notaFinal;
        }
    }
}