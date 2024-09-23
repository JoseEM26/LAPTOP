
using System;

namespace ConsoleApp1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            estudiante e1 = new estudiante();
            estudiante e2 = new estudiante("jose", "espinoza", 19);
            estudiante e3 = new estudiante("lira", "morales");

            Console.WriteLine(e1);
            Console.WriteLine("--------------------------------------------------");
            Console.WriteLine(e2);
            Console.WriteLine("--------------------------------------------------");
            Console.WriteLine(e3);
        }

        class estudiante
        {
            public string Nombre { get; set; }
            public string Apellido { get; set; }
            public int Edad { get; set; }

            // Constructor con todos los parámetros
            public estudiante(string nombre, string apellido, int edad)
            {
                Nombre = nombre;
                Apellido = apellido;
                Edad = edad;
            }

            // Constructor con nombre y apellido, edad predeterminada a 0
            public estudiante(string nombre, string apellido)
            {
                Nombre = nombre;
                Apellido = apellido;
                Edad = 0; // Valor por defecto
            }

            // Constructor sin parámetros
            public estudiante()
            {
                Nombre = "Desconocido";
                Apellido = "Desconocido";
                Edad = 0; // Valor por defecto
            }

            // Sobrecarga del método ToString para una mejor representación
            public override string ToString()
            {
                return $"Nombre: {Nombre}, Apellido: {Apellido}, Edad: {Edad}";
            }
        }
    }
}