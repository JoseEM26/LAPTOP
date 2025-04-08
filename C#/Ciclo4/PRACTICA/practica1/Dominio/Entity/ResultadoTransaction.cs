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
        public Boolean valor { get; set; }
        public string mensaje { get; set; }
        public T Dato { get; set; }
        public List<T> listDatos { get; set; }
    }
}
