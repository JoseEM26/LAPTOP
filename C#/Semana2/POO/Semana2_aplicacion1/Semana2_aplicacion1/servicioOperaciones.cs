using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Semana2_aplicacion1
{
    internal class servicioOperaciones:IOperaciones
    {
        public double sumar(double valor1, double valor2)
        {
            return valor1 + valor2;
        }

        public double restar(double valor1, double valor2)
        {
            return valor1 - valor2;
        }


        public double multiplicar(double valor1, double valor2)
        {
            return valor1 * valor2;
        }

        public double dividir(double valor1, double valor2)
        {
            return valor1 / valor2;
        }


    }
}
