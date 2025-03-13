using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace POO1_Semana01
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hola Mundo");

            Estudiante estudiante = new Estudiante();
            estudiante.codigo = 101;
            estudiante.nombre = "PEDRO";
            estudiante.apellido = "PENELOPES";
            estudiante.sexo = "G";
            estudiante.direccion = "LIMA CENTRO";

            Console.WriteLine("Codigo Estudiante :"+estudiante.codigo);
            Console.WriteLine("Nombre Estudiante :"+estudiante.nombre);
            Console.WriteLine("Nombre Estudiante Completo : {1} {0}",estudiante.nombre,estudiante.apellido);
            /////////////////////////////////////////////////////////////////////////////////////////////////////
            Estudiante estudiante1=new Estudiante();
            estudiante1.codigo = 102;
            estudiante1.nombre = "Jose";
            estudiante1.apellido = "MANUALITA";
            estudiante1.sexo = "M";
            estudiante1.direccion = "LIMA CENTRO";
            Console.WriteLine("--------------------------------------------------------------------");
            Console.WriteLine("Codigo Estudiante :" + estudiante1.codigo);
            Console.WriteLine("Nombre Estudiante :" + estudiante1.nombre);
            Console.WriteLine("Nombre Estudiante Completo :"+ estudiante1.getNombreCompleto());







        }

    }
}
