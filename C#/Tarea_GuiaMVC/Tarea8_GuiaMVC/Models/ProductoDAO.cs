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
    public class ProductoDAO : ICrudDaoProducto<Producto>
    {
        public void ActualizarProducto(Producto p)
        {
            SqlCommand cmd = null;
            SqlConnection con = null;
            int indicador = -1;

            try
            {
                con = new SqlConnection(ConfigurationManager.ConnectionStrings["db"].ConnectionString);
                con.Open();

                cmd = new SqlCommand("USP_CRUD_PRODUCTO", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@INDICADOR", "ACTUALIZAR");
                cmd.Parameters.AddWithValue("@IdProducto", p.IdProducto);
                cmd.Parameters.AddWithValue("@NomProducto", p.NomProducto);
                cmd.Parameters.AddWithValue("@IdProveedor", p.IdProveedor);
                cmd.Parameters.AddWithValue("@IdCategoria", p.IdCategoria);
                cmd.Parameters.AddWithValue("@CantxUnidad", p.CantxUnidad);
                cmd.Parameters.AddWithValue("@PrecioUnidad", p.PrecioUnidad);
                cmd.Parameters.AddWithValue("@UnidadesEnExis", p.UnidadesEnExistencia);
                cmd.Parameters.AddWithValue("@activo", 0);

                indicador = cmd.ExecuteNonQuery();
                

            }
            catch (Exception e)
            {
                Debug.WriteLine(e.Message);
            }
            finally
            {
                con.Close();
            }
        }

        public Producto BuscarProductoID(int id)
        {
            SqlCommand cmd = null;
            SqlDataReader reader = null;
            Producto objPro = null;
            SqlConnection con = null;

            try
            {
                con = new SqlConnection(ConfigurationManager.ConnectionStrings["db"].ConnectionString);
                con.Open();

                cmd = new SqlCommand("USP_CRUD_PRODUCTO", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@INDICADOR", "lISTARDATOS");
                cmd.Parameters.AddWithValue("@IdProducto", id);
                cmd.Parameters.AddWithValue("@NomProducto", "");
                cmd.Parameters.AddWithValue("@IdProveedor", 0);
                cmd.Parameters.AddWithValue("@IdCategoria", 0);
                cmd.Parameters.AddWithValue("@CantxUnidad", "");
                cmd.Parameters.AddWithValue("@PrecioUnidad", 0);
                cmd.Parameters.AddWithValue("@UnidadesEnExis", 0);
                cmd.Parameters.AddWithValue("@activo", 0);

                reader = cmd.ExecuteReader();

                if (reader.Read())
                {
                    objPro= new Producto()
                    {
                        IdProducto = Convert.ToInt32(reader[0]),
                        NomProducto = reader[1].ToString(),
                        IdProveedor = Convert.ToInt32(reader[2]),
                        IdCategoria = Convert.ToInt32(reader[3]),
                        CantxUnidad = reader[4].ToString(),
                        PrecioUnidad = Convert.ToDecimal(reader[5]),
                        UnidadesEnExistencia = Convert.ToInt32(reader[6])
                    };
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
            return objPro;
        }

        public void EliminarProducto(int id)
        {
            SqlCommand cmd = null;
            SqlConnection con = null;
            int indicador = -1;

            try
            {
                con = new SqlConnection(ConfigurationManager.ConnectionStrings["db"].ConnectionString);
                con.Open();

                cmd = new SqlCommand("USP_CRUD_PRODUCTO", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@INDICADOR", "ELIMINAR");
                cmd.Parameters.AddWithValue("@IdProducto", id);
                cmd.Parameters.AddWithValue("@NomProducto", "");
                cmd.Parameters.AddWithValue("@IdProveedor", 0);
                cmd.Parameters.AddWithValue("@IdCategoria", 0);
                cmd.Parameters.AddWithValue("@CantxUnidad", "");
                cmd.Parameters.AddWithValue("@PrecioUnidad", 0);
                cmd.Parameters.AddWithValue("@UnidadesEnExis", 0);
                cmd.Parameters.AddWithValue("@activo", 0);

                indicador = cmd.ExecuteNonQuery();


            }
            catch (Exception e)
            {
                Debug.WriteLine(e.Message);
            }
            finally
            {
                con.Close();
            }
        }

        public void InsertarProducto(Producto p)
        {
            SqlCommand cmd = null;
            SqlConnection con = null;
            int indicador = -1;

            try
            {
                con = new SqlConnection(ConfigurationManager.ConnectionStrings["db"].ConnectionString);
                con.Open();

                cmd = new SqlCommand("USP_CRUD_PRODUCTO", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@INDICADOR", "INSERTAR");
                cmd.Parameters.AddWithValue("@IdProducto", 0);
                cmd.Parameters.AddWithValue("@NomProducto", p.NomProducto);
                cmd.Parameters.AddWithValue("@IdProveedor", p.IdProveedor);
                cmd.Parameters.AddWithValue("@IdCategoria", p.IdCategoria);
                cmd.Parameters.AddWithValue("@CantxUnidad", p.CantxUnidad);
                cmd.Parameters.AddWithValue("@PrecioUnidad", p.PrecioUnidad);
                cmd.Parameters.AddWithValue("@UnidadesEnExis", p.UnidadesEnExistencia);
                cmd.Parameters.AddWithValue("@activo", 1);


                bool iresult = cmd.ExecuteNonQuery() == 1 ? true : false;


            }
            catch (Exception e)
            {
                Debug.WriteLine(e.Message);
            }
            finally
            {
                con.Close();
            }
        }

        public List<Producto> ListarProducto()
        {
            SqlCommand cmd = null;
            SqlDataReader reader = null;
            List<Producto> lista = new List<Producto>();
            SqlConnection con = null;

            try
            {
                con = new SqlConnection(ConfigurationManager.ConnectionStrings["db"].ConnectionString);
                con.Open();

                cmd = new SqlCommand("USP_CRUD_PRODUCTO", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@INDICADOR", "MOSTRARTODO");
                cmd.Parameters.AddWithValue("@IdProducto", 0);
                cmd.Parameters.AddWithValue("@NomProducto", "");
                cmd.Parameters.AddWithValue("@IdProveedor", 0);
                cmd.Parameters.AddWithValue("@IdCategoria", 0);
                cmd.Parameters.AddWithValue("@CantxUnidad", "");
                cmd.Parameters.AddWithValue("@PrecioUnidad", 0);
                cmd.Parameters.AddWithValue("@UnidadesEnExis", 0);
                cmd.Parameters.AddWithValue("@activo", 0);

                reader = cmd.ExecuteReader();

                while (reader.Read())
                {
                    Producto c = new Producto()
                    {
                        IdProducto = Convert.ToInt32(reader[0]),
                        NomProducto = reader[1].ToString(),
                        IdProveedor = Convert.ToInt32(reader[2]),
                        IdCategoria = Convert.ToInt32(reader[3]),
                        CantxUnidad = reader[4].ToString(),
                        PrecioUnidad = Convert.ToDecimal(reader[5]),
                        UnidadesEnExistencia = Convert.ToInt32(reader[6])
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