﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Entidades
{
    public class Alumno
    {
        public int IdAlumno { get; set; }
        public string Nombre { get; set; }
        public string Apellidos { get; set; }
        public string NroDocumento { get; set; }
        public DateTime FechNacimiento { get; set; }
    }
}
