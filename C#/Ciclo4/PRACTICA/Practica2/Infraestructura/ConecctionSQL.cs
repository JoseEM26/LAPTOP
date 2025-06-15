using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Infraestructura
{
    public class ConecctionSQL
    {
        private readonly string _conexion;

        public ConecctionSQL(string conexion)
        {
            _conexion = conexion;
        }

        public SqlConnection AplyConnection()
        {
            return new SqlConnection(_conexion);
        }
    }
}
