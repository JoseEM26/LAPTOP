using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SegundoEjercisio2
{
    internal class Filmaciones
    {
        public int codigo { get; set; }
        public string titulo { get; set; }
        public int duracionM { get; set; }
        public double precioSoles { get; set; }

        public Filmaciones(int codigo, string titulo, int duracionM, double precioSoles)
        {
            this.codigo = codigo;
            this.titulo = titulo;
            this.duracionM = duracionM;
            this.precioSoles = precioSoles;
        }

        public double PrecioDolares()
        {
            return precioSoles * 3.59;
        }

        public string DatosCompletos()
        {
            return "CODIGO :" + codigo + "\n" +
                "TITULO :" + titulo + "\n"
                + "DURACION MINUTOS :" + duracionM + "\n" +
                "PRECIOS SOLES:" + precioSoles + "\n";
        }
    }
}
