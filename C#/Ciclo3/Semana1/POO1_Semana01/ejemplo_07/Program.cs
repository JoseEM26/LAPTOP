using log4net;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ejemplo_07
{
    internal class Program
    {
        private static readonly ILog LOG = log4net.LogManager.GetLogger(System.Reflection.MethodBase.GetCurrentMethod().DeclaringType);

        static void Main(string[] args)
        {

            LOG.Info("iniciando aplicacion");
            int numerador = 10;
            int denominador = 0;

            try
            {
                //int resultado = numerador / denominador;
                //Console.WriteLine(resultado);
                if (numerador == 10)
                {
                    throw new numeroPersonalizadoException("error exception");
                }
            }catch(Exception e)
            {
                LOG.Error(e);
                LOG.Error(e.Message);
                Console.WriteLine(e.ToString());
                Console.WriteLine(e.Message);
                Console.WriteLine(e.GetType().Name);
                Console.WriteLine(e.TargetSite);


            }

            Console.ReadKey();

        }
    }
}
