using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Diagnostics;
using System.Linq;
using System.Web;
using Tarea8_GuiaMVC.DataBase;
using Tarea8_GuiaMVC.Entity;
using Tarea8_GuiaMVC.Services;

namespace Tarea8_GuiaMVC.Models
{
    public class CategoriaDAO : IDatoCategoria<Categorias>
    {
        public List<Categorias> ListarCategoria()
        {
            SqlCommand cmd = null;
            SqlDataReader reader = null;
            List<Categorias> lista = new List<Categorias>();
            SqlConnection con = null;

            try
            {
                con= new SqlConnection(ConfigurationManager.ConnectionStrings["db"].ConnectionString);
                con.Open();

                cmd = new SqlCommand("USP_CATEGORIA_LISTAR", con);
                cmd.CommandType =System.Data.CommandType.StoredProcedure;

                reader = cmd.ExecuteReader();

                while (reader.Read())
                {
                    Categorias c = new Categorias()
                    {
                        idCategoria = Convert.ToInt32(reader[0]),
                        nomCategoria = reader[1].ToString()
                    };
                    lista.Add(c);
                }

            }
            catch(Exception e)
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