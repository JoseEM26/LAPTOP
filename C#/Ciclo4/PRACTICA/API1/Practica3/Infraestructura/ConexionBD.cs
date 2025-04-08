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
        public readonly string _conexion;

        public ConexionBD(string conexion)
        {
            _conexion = conexion;
        }

        public SqlConnection GetConnection()
        {
            return new SqlConnection(_conexion);
        }
    }
}
