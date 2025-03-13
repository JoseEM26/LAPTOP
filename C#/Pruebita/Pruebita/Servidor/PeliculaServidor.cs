using Pruebita.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Pruebita.Servidor
{
    public class PeliculaServidor
    {
        public Pelicula ObtenerPelicula()
        {
            return new Pelicula()
            {
                nombre = "DeadPool",
                fecha = DateTime.Today,
                costo = 1111,
                pais = "Peru"

            };
        }



    }
}