using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tercer_Ejercisio
{
    internal class Persona
    {
        public string nombre { get; set; }
        public string apellido { get; set; }
        public int edad { get; set; }
        public double estatura { get; set; }
        public double peso { get; set; }

        public Persona(string nombre, string apellido, int edad, double estatura, double peso)
        {
            this.nombre = nombre;
            this.apellido = apellido;
            this.edad = edad;
            this.estatura = estatura;
            this.peso = peso;
        }

        public string EstadoEdad()
        {
            if (edad > 18)
            {
                return "Eres Mayor de Edad";
            }
            else
            {
                return "Eres Menor de Edad";
            }
        }

        public double MasaCorporal()
        {
            return peso / (estatura * estatura);
        }

        public string DatosCompletos()
        {
            return "Nombre :" + nombre + "\n" +
                "Apellido :" + apellido + "\n"
                + "Edad :" + edad + "\n" +
                "estatura:" + estatura + "\n"+
                  "peso:" + peso + "\n";
        }
    }
}
