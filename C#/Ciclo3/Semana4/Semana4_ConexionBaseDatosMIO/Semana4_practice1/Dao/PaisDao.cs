using Semana4_practice1.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Semana4_practice1.Dao
{
    internal interface PaisDao
    {
        int registrar(Pais p);
        int Eliminar(string codigo);
        int Actualizar(Pais p);
        Pais ObtenerPais(string codigo);
        List<Pais> consultarTodo();
    }
}
