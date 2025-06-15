using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Diagnostics;
using System.Linq;
using System.Web;
using Tarea8_GuiaMVC.Entity;
using Tarea8_GuiaMVC.Services;

namespace Tarea8_GuiaMVC.Models
{
    public class ProveedorDao : IDaoProveedor<Proveedor>
    {
        public List<Proveedor> ListarProveedor()
        {
            SqlCommand cmd = null;
            SqlDataReader reader = null;
            List<Proveedor> lista = new List<Proveedor>();
            SqlConnection con = null;

            try
            {
                con = new SqlConnection(ConfigurationManager.ConnectionStrings["db"].ConnectionString);
                con.Open();

                cmd = new SqlCommand("USP_PROVEDOR_LISTAR", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;

                reader = cmd.ExecuteReader();

                while (reader.Read())
                {
                    Proveedor c = new Proveedor()
                    {
                        idProveedor = Convert.ToInt32(reader[0]),
                        nomProveedor = reader[1].ToString()
                    };
                    lista.Add(c);
                }

            }
            catch (Exception e)
            {
                Debug.WriteLine(e.Message);
            }
            finally
            {
                reader.Close();
                con.Close();
            }
            return lista;
        }
    }
}