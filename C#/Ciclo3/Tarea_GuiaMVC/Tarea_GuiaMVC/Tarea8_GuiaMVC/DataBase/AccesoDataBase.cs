using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Web;

namespace Tarea8_GuiaMVC.DataBase
{
    public class AccesoDataBase
    {
        public SqlConnection DatosConection()
        {
            SqlConnection con = new SqlConnection(ConfigurationManager.ConnectionStrings["db"].ConnectionString);
            return con;
        }
    }
}