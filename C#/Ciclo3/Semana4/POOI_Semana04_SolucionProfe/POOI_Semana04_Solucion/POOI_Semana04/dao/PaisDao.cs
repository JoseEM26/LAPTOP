using POOI_Semana04.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web.Configuration;

namespace POOI_Semana04.dao
{
    internal interface PaisDao
    {

        int registrar(Pais p);
        int eliminar(string codigo);
        int actualizar(Pais p);
        Pais obtenerPais(string codigo);
        List<Pais> consultarTodo();

    }
}
