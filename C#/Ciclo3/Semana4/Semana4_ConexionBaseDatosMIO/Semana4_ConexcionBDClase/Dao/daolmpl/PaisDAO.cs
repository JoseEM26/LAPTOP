using Semana4_ConexcionBDClase.Models;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Semana4_ConexcionBDClase.Dao.paises
{
    
    internal interface PaisDAO
    {
        //SqlConnection db = new SqlConnection(ConfigurationManager.ConnectionStrings["bd"].ToString);
        int registrar(Pais p);
        int Eliminar(string codigo);
        int Actualizar(Pais p);
        Pais ObtenerPais(string codigo);
        List<Pais> consultarTodo();
    }
}
