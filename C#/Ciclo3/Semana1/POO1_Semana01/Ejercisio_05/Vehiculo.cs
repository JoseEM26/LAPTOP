using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercisio_05
{
    internal class Vehiculo
    {
        public string matricula { get; set; }
        public string modelo { get; set; }
        public int potencia { get; set; }

        public Vehiculo(string matricula, string modelo, int potencia)
        {
            this.matricula = matricula;
            this.modelo = modelo;
            this.potencia = potencia;
        }

        public string Mensajito ()
        {
            return "somos el VEHICULO padre"+modelo;
        }
    }
}
