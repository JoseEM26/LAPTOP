using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Infraestructura
{
    public class ConexionBaseDatos
    {
        public readonly string _cadenaConnection;

        public ConexionBaseDatos(string cadenaConnection)
        {
            _cadenaConnection = cadenaConnection;
        }

        public SqlConnection AbrirConnection()
        {
            return new SqlConnection(this._cadenaConnection);
        }

    }
}
