using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercisio_05
{
    internal class autobus : Vehiculo
    {
      

        public int numeroPlazas { get; set; }

        public autobus(string matricula, string modelo, int potencia, int numeroPlazas) : base(matricula, modelo, potencia)
        {
            this.numeroPlazas = numeroPlazas;
        }

        public void mensaje()
        {
            Console.WriteLine("Mensaje de la clase autobus :" + potencia);
        }

    }
}
