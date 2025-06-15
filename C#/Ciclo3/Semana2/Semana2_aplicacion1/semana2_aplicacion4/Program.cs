using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace semana2_aplicacion4
{
    internal class Program
    {
        static void Main(string[] args)
        {
            List<int> n = new List<int>() {100, 1, 2, 3, 4, 5,5,5,5,5,5,5,5,5,5, 6, 7, 8, 9, 10 };

            //n.Sort();
            //n.Reverse();
            //n.Remove(100);
            //n.RemoveAt(1);
            //n.RemoveAll(x => x == 5);
            //n.RemoveRange(0, 3);

            //int pos190 = n.IndexOf(180);
            //Console.WriteLine(pos190);
            n.Exists

            foreach (int x in n)
            {
                Console.WriteLine($"Numero:{x}");
            }

            Console.ReadKey();
        }

        
    }
}
