using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Diagnostics;
using System.Linq;
using System.Web;

namespace Tarea5_GuiaMVC.Models
{
    public class AccesoDatos
    {
        SqlConnection con = null;
        SqlCommand cmd = null;
        SqlDataReader reader = null;
        List<Producto> lista = new List<Producto>();
        List<Producto> listaCategoria = new List<Producto>();

        public List<Producto> ProductoListar(string nombre)
        {
            try
            {
                con = new SqlConnection(ConfigurationManager.ConnectionStrings["bd"].ConnectionString);
                con.Open();

                cmd = new SqlCommand("USP_PRODUCTO_LISTAR_NOMBRE", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@NOMBRE", nombre);

                reader = cmd.ExecuteReader();

                while (reader.Read())
                {
                    Producto obj = new Producto()
                    {
                        IdProducto = Convert.ToInt32(reader[0].ToString()),
                        NomProducto = reader[1].ToString(),
                        PrecioUnidad = Convert.ToDecimal(reader[2].ToString()),
                        NombreCategoria = reader[3].ToString(),
                        NomProveedor = reader[4].ToString(),
                        Stock = Convert.ToInt32(reader[5].ToString()),
                    };

                    lista.Add(obj);
                }


            }
            catch (Exception e)
            {
                Debug.WriteLine(e.Message);
            }
            finally
            {
                con.Close();
                reader.Close();
            }
            return lista;

        }

        public List<Producto> ProductoListarCategoria(string categoria)
        {
            try
            {
                con = new SqlConnection(ConfigurationManager.ConnectionStrings["bd"].ConnectionString);
                con.Open();

                cmd = new SqlCommand("USP_PRODUCTO_CATEGORIA", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@NOMBRECategoria", categoria);

                reader = cmd.ExecuteReader();

                while (reader.Read())
                {
                    Producto obj = new Producto()
                    {
                        IdProducto = Convert.ToInt32(reader[0].ToString()),
                        NomProducto = reader[1].ToString(),
                        PrecioUnidad = Convert.ToDecimal(reader[2].ToString()),
                        NombreCategoria = reader[3].ToString(),
                        NomProveedor = reader[4].ToString(),
                        Stock = Convert.ToInt32(reader[5].ToString()),
                    };

                    listaCategoria.Add(obj);
                }


            }
            catch (Exception e)
            {
                Debug.WriteLine(e.Message);
            }
            finally
            {
                con.Close();
                reader.Close();
            }
            return listaCategoria;

        }
    }
}