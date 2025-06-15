using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Infraestructura
{
    public class Conexion
    {
        private readonly string _conexion;

        public Conexion(string conexion)
        {
            _conexion = conexion;
        }
        public SqlConnection getConexion()
        {
            return new SqlConnection(_conexion);
        }
    }
}
