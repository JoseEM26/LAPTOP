using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercisio_05
{
    internal class taxi : Vehiculo 
    {
        public int numeroLicencia { get; set; }

        public taxi(string matricula, string modelo, int potencia,int numeroLicencia) : base(matricula, modelo, potencia)
        {
            this.numeroLicencia = numeroLicencia;
        }


        

        public void mensaje()
        {
            Console.WriteLine("Mensaje de la clase taxi :" + potencia);
        }
    }
}
