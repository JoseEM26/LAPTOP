using System;
using System.Collections.Generic;
using System.Configuration;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace semana2_aplicacion3
{
    internal class Program
    {
        static void Main(string[] args)
        {

            string ruta = ConfigurationManager.AppSettings["ruta"].ToString();
            //string ruta = @"D:\Imágenes\POO\archivo.txt";
            string correo = ConfigurationManager.AppSettings["correo"].ToString();
            string password = ConfigurationManager.AppSettings["password"].ToString();
            //StreamWriter s = null;
            StreamWriter s = new StreamWriter(ruta, true);


            try
            {
                s.WriteLine("esto es un mensaje nuevitossssssssssssssss");
                s.WriteLine(correo);
                s.WriteLine(password);
            }
            catch (Exception ex)
            {
                Console.WriteLine("ocurrio un error");
                Console.WriteLine(ex.Message);
            }
            finally
            {
                Console.WriteLine("estamos en el finally");
                s.Close();
            }
            Console.ReadKey();







        }
    }
}
