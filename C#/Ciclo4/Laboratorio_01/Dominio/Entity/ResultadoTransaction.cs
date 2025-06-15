using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Entity
{
    public class ResultadoTransaction<T>
    {
        public int idRegistro { get; set; }
        public string mensaje { get; set; }
        public Boolean value { get; set; }
        public T data { get; set; }
        public List<T> dataList { get; set; }
    }
}
