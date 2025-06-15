using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Diagnostics;
using System.Linq;
using System.Web;
using System.Web.UI.WebControls;

namespace Tarea2_GuiaMVC.Models
{

    public class AccesoDatos
    {
        

        
            SqlConnection con = new SqlConnection(ConfigurationManager.ConnectionStrings["db"].ConnectionString);
   
            public DataSet ProductoListar()
            {
            SqlDataAdapter da = new SqlDataAdapter("USP_PRODUCTOLISTARE",con);
            da.SelectCommand.CommandType = CommandType.StoredProcedure;

            DataSet dato = new DataSet();
            da.Fill(dato);
            return dato;
            }
        
    }
}