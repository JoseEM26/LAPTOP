using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CuartoEjercisio
{
    internal class Coordinador
    {
        public int codigo { get; set; }
        public string nombre{ get; set; }
        public int categoria{ get; set; }
        public int celular{ get; set; }

        public Coordinador(int codigo, string nombre, int categoria, int celular)
        {
            this.codigo = codigo;
            this.nombre = nombre;
            this.categoria = categoria;
            this.celular = celular;
        }

        public double Sueldo()
        {
            if (categoria == 0) return 8500;
            else if (categoria == 1) return 6850;
            else return 5500;
        }

        public string DatosCompletos()
        {
            return "Codigo :" + codigo + "\n" +
                "Nombre :" + nombre + "\n"
                + "Categoria :" + categoria + "\n" +
                "Celular:" + celular;
        }


    }
}
