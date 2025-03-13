using Semana4_practice1.Models;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Diagnostics;
using System.Linq;
using System.Web;

namespace Semana4_practice1.Dao.DaoImpl
{
    public class PaisDaoIMPL : PaisDao
    {
        public int Actualizar(Pais p)
        {
            SqlConnection con = null;
            SqlCommand cmd = null;
            int Result = -1;

            try
            {
                con = new SqlConnection(ConfigurationManager.ConnectionStrings["bd"].ConnectionString);
                con.Open();

                cmd = new SqlCommand("usp_paises_crud", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@indicador", "Actualizar");
                cmd.Parameters.AddWithValue("@country_id", p.country_id);
                cmd.Parameters.AddWithValue("@country_name", p.country_name);
                cmd.Parameters.AddWithValue("@region_id", p.region_id);

                Result = cmd.ExecuteNonQuery();



            }
            catch(Exception e)
            {
                Debug.WriteLine(e.Message);
            }
            finally
            {
                con.Close();
            }
            return Result;


        }

        public List<Pais> consultarTodo()
        {

            SqlConnection con = null;
            SqlCommand cmd = null;
            SqlDataReader reader = null;
            List<Pais> lista = new List<Pais>();

            try
            {

                con = new SqlConnection(ConfigurationManager.ConnectionStrings["bd"].ConnectionString);
                con.Open();

                cmd = new SqlCommand("usp_paises_crud", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;

                cmd.Parameters.AddWithValue("@indicador", "ConsultarTodo");
                cmd.Parameters.AddWithValue("@country_id", "");
                cmd.Parameters.AddWithValue("@country_name", "");
                cmd.Parameters.AddWithValue("@region_id", 0);

                reader = cmd.ExecuteReader();

                while (reader.Read())
                {
                    Pais p = new Pais()
                    {
                        country_id = reader.GetString(0),
                        country_name = reader.GetString(1),
                        region_id = reader.GetInt32(2)
                    };

                    lista.Add(p);
                    
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

        public int Eliminar(string id)
        {
            SqlConnection con = null;
            SqlCommand cmd = null;
            int Result = -1;

            try
            {
                con = new SqlConnection(ConfigurationManager.ConnectionStrings["bd"].ConnectionString);
                con.Open();

                cmd = new SqlCommand("usp_paises_crud", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@indicador", "Eliminar");
                cmd.Parameters.AddWithValue("@country_id", id);
                cmd.Parameters.AddWithValue("@country_name", "");
                cmd.Parameters.AddWithValue("@region_id",0);

                Result = cmd.ExecuteNonQuery();



            }
            catch (Exception e)
            {
                Debug.WriteLine(e.Message);
            }
            finally
            {
                con.Close();
            }
            return Result;
        }

        public Pais ObtenerPais(string id)
        {
            SqlConnection con = null;
            SqlCommand cmd = null;
            SqlDataReader reader = null;
            Pais p = null;

            try
            {
                con = new SqlConnection(ConfigurationManager.ConnectionStrings["bd"].ConnectionString);
                con.Open();

                cmd = new SqlCommand("usp_paises_crud", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@indicador", "ConsultarXId");
                cmd.Parameters.AddWithValue("@country_id", id);
                cmd.Parameters.AddWithValue("@country_name", "");
                cmd.Parameters.AddWithValue("@region_id", 0);

                reader = cmd.ExecuteReader();

                if (reader.Read())
                {
                    p = new Pais()
                    {
                        country_id = reader.GetString(0),
                        country_name = reader.GetString(1),
                        region_id = reader.GetInt32(2)
                    };
                }

            }
            catch(Exception ex)
            {
                Debug.WriteLine(ex.Message);
            }
            finally
            {
                con.Close();
                reader.Close();
            }

            return p;
        }

        public int registrar(Pais p)
        {

            SqlConnection con = null;
            SqlCommand cmd = null;
            int Result = -1;

            try
            {
                con = new SqlConnection(ConfigurationManager.ConnectionStrings["bd"].ConnectionString);
                con.Open();

                cmd = new SqlCommand("usp_paises_crud", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@indicador", "Insertar");
                cmd.Parameters.AddWithValue("@country_id", p.country_id);
                cmd.Parameters.AddWithValue("@country_name", p.country_name);
                cmd.Parameters.AddWithValue("@region_id", p.region_id);

                Result = cmd.ExecuteNonQuery();



            }
            catch (Exception e)
            {
                Debug.WriteLine(e.Message);
            }
            finally
            {
                con.Close();
            }
            return Result;

        }
    }
}