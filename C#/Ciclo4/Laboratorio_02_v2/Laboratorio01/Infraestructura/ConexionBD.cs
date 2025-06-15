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
        private readonly string _cadenaconexion;
        public ConexionBD(string cadenaconexion) 
        {
            _cadenaconexion = cadenaconexion;
        }

        public SqlConnection AbrirConexion() 
        {
            return new SqlConnection(_cadenaconexion);
        }
    }
}
