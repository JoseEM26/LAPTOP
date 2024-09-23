using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercisio_6
{
    internal class Cliente:Persona
    {
      

        public int categoria { get; set; }
        public int codigo { get; set; }

        public Cliente(string nombre, string apellido, int documento, string genero,int categoriam,int codigo) : base(nombre, apellido, documento, genero)
        {
            this.categoria = categoriam;
            this.codigo = codigo;
        }

        public string generarCodigo()
        {
            return nombre + "_" + codigo;
        }
        public override string saludo()
        {
            return "Hola estamos en la Cliente";
        }
    }
}
