using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Entidades
{
    public class ResultadoTransaccion<T>
    {
        public int IdRegistro { get; set; }
        public string Mensaje { get; set; }
        public bool Value { get; set; }
        public T Data { get; set; }
        public List<T> DataList { get; set; }
    }
}
