using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace POO1_Semana01_Ejemplo2
{
    internal class Docente
    {
        public int codigo { get; set; }
        public string nombre { get; set; }
        public int HoraTrabajadas { get; set; }
        public double TarifaH { get; set; }

        public Docente(int codigo, string nombre, int horaTrabajadas, double tarifaH)
        {
            this.codigo = codigo;
            this.nombre = nombre;
            this.HoraTrabajadas = horaTrabajadas;
            this.TarifaH = tarifaH;
        }

        public double SueldoBruto()
        {
            return HoraTrabajadas * TarifaH;

        }
        public double Descuento() {
            if (SueldoBruto() > 4500)
            {
                return SueldoBruto() * 0.88;
            }
            else if (SueldoBruto() > 4500 && SueldoBruto()<6500)
            {
                return SueldoBruto() * 0.86;
            }
            else
            {
                return SueldoBruto() * 0.84;
            }

        }
        public double SueldoNeto()
        {
            return SueldoBruto() - Descuento();
        }

        public string datosCompletos()
        {
            return "Nombre :"+ nombre + "\n" +
                "Codigo :" + codigo + "\n"
                + "HorasTrabajadas :" + HoraTrabajadas+ "\n"+
                "Tarifa por horas :" + TarifaH + "\n";
        }
    }
}
