using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace POOI_T2_EspinozaMoralesJoseAngel.Models
{
    public class Agencia
    {
        public int AgenciaId { get; set; }
        public string Nombre { get; set; }
        public string Direccion { get; set; }
        public string ares { get; set; }
        public string distrito { get; set; }
        public string provincia { get; set; }
        public string departamento { get; set; }
    }
}