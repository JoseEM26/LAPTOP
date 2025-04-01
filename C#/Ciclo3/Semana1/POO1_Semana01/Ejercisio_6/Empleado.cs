using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercisio_6
{
    internal class Empleado:Persona
    {
        

        public string tipoContrato { get; set;}
        public int sueldo { get; set;}
        public Empleado(string nombre, string apellido, int documento, string genero,string tipoContrato,int sueldo) : base(nombre, apellido, documento, genero)
        {
            this.sueldo = sueldo;
            this.tipoContrato = tipoContrato;
        }
        public double calcularSueldo()
        {
            return sueldo * 12;
        }

        public override string saludo()
        {
            return "Hola estamos en la Empleado";
        }
    }
}
