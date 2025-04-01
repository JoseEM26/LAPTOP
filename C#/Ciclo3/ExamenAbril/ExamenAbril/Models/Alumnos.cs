using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ExamenAbril.Models
{
    public class Alumnos : Evaluaciones
    {
        

        public int codigoAlumno { get; set; }
        public string nombreAlumno { get; set; }

        public Alumnos(int idEvaluacion, string nombreCurso, int nota1, int nota2, int notaParcial, int notaFinal ,int codigoAlumno,string nombreAlumno) : base(idEvaluacion, nombreCurso, nota1, nota2, notaParcial, notaFinal)
        {
            this.codigoAlumno = codigoAlumno;
            this.nombreAlumno = nombreAlumno;
        }

        public double PromedioFinal()
        {
            return (nota1 * 0.15) + (nota2 * 0.15) + (notaFinal * 0.45) + (notaParcial * 0.25);
        }

        public string EstadoNota()
        {
            if (PromedioFinal() < 13)
            {
                return "REPROBADO";
            }else if(PromedioFinal()>13 && PromedioFinal() < 16)
            {
                return "APROBADO";
            }
            else
            {
                return "SOBRESALIENTE";
            }


        }

    }
}