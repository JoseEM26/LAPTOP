using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Entidad
{
    public class ResultadoTransaction<T>
    {
        public int idResultado { get; set; }
        public string mensaje { get; set; }
        public bool value { get; set; }
        public  T data{ get; set; }
        public List<T> ListData { get; set; }
    }
}
