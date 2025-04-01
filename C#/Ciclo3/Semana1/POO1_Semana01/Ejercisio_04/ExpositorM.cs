using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercisio_04
{
    internal partial class Expositor
    {
        public double sueldoBruto()
        {
            return Horatrabajadas * tarifaHora;
        }

        public double descuentAFP()
        {
            return sueldoBruto() * 0.10;
        }

        public double descuentoEPS()
        {
            return sueldoBruto() * 0.05;
        }

        public double sueldoNeto()
        {
            return sueldoBruto() - (descuentAFP() + descuentoEPS());
        }
    }
}
