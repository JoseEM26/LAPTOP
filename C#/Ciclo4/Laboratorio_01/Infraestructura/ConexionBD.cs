using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Infraestructura
{
    public class ConexionBD
    {
        private readonly string _cadenaConection;
        public ConexionBD(string cadenaConexion)
        {
            _cadenaConection = cadenaConexion;
        }

        public SqlConnection abrirConnection()
        {
            return new SqlConnection(_cadenaConection);
        }
    }
}
