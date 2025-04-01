using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;

namespace GuiaMVC2_intento3.Models
{

    public class AccesoDatos
    {
        SqlConnection cn =new SqlConnection(ConfigurationManager.ConnectionStrings["Negocios2020"].ConnectionString);

        public DataSet ProductoListar()
        {
            SqlDataAdapter da = new SqlDataAdapter("SP_PRODUCTOLISTAR", cn);
            da.SelectCommand.CommandType = CommandType.StoredProcedure;

            DataSet ds = new DataSet();
            da.Fill(ds);
            return ds;
        }

    }
}