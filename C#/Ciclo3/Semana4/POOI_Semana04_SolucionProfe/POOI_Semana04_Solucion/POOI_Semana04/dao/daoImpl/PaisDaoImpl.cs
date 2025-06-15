using POOI_Semana04.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.SqlClient;
using System.Diagnostics;
using System.Configuration;
using System.Web.Configuration;
using System.Web.UI.WebControls;

namespace POOI_Semana04.dao.daoImpl
{
    public class PaisDaoImpl : PaisDao
    {
        public int actualizar(Pais p)
        {
            SqlConnection con = null;
            SqlCommand cmd = null;
            int procesar = -1;
            try
            {
                con = new SqlConnection(ConfigurationManager.ConnectionStrings["cnx_bd_hr"].ConnectionString);
                con.Open();
                cmd = new SqlCommand("usp_paises_crud", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@indicador", "Actualizar");
                cmd.Parameters.AddWithValue("@country_id", p.country_id);
                cmd.Parameters.AddWithValue("@country_name", p.country_name);
                cmd.Parameters.AddWithValue("@region_id", p.region_id);
                procesar = cmd.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                Debug.WriteLine("Error - actualizar : " + ex.ToString());
            }
            finally
            {
                con.Close();
            }
            return procesar;
        }

        public List<Pais> consultarTodo()
        {
            SqlConnection con = null;
            SqlCommand cmd = null;
            SqlDataReader reader = null;
            List<Pais> lista= new List<Pais> ();
            try{
                con = new SqlConnection(
                    ConfigurationManager.ConnectionStrings["cnx_bd_hr"].ConnectionString);
                con.Open();
                cmd = new SqlCommand("usp_paises_crud", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@indicador", "ConsultarTodo");
                cmd.Parameters.AddWithValue("@country_id", "");
                cmd.Parameters.AddWithValue("@country_name", "");
                cmd.Parameters.AddWithValue("@region_id", 0);
                reader = cmd.ExecuteReader();
                Pais objPais;
                while (reader.Read())
                {
                    objPais = new Pais()
                    {
                        country_id= reader.GetString(0),
                        country_name= reader.GetString(1),
                        region_id= reader.GetInt32(2)
                    };
                    lista.Add(objPais);
                }

            }
            catch (Exception ex)
            {
                Debug.WriteLine(ex.Message);
            }
            finally
            {

            }
            return lista;
        }

        public int eliminar(string codigo)
        {
            SqlConnection con = null;
            SqlCommand cmd = null;
            int procesar = -1;
            try
            {
                con = new SqlConnection(ConfigurationManager.ConnectionStrings["cnx_bd_hr"].ConnectionString);
                con.Open();
                cmd = new SqlCommand("usp_paises_crud", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@indicador", "Eliminar");
                cmd.Parameters.AddWithValue("@country_id",codigo);
                cmd.Parameters.AddWithValue("@country_name", "");
                cmd.Parameters.AddWithValue("@region_id",0);
                procesar = cmd.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                Debug.WriteLine("Error - actualizar : " + ex.ToString());
            }
            finally
            {
                con.Close();
            }
            return procesar;
        }

        public Pais obtenerPais(string codigo)
        {
            SqlConnection con = null;
            SqlCommand cmd = null;
            SqlDataReader reader = null;
            Pais objPais = null; 
            try
            {
                con = new SqlConnection(
                    ConfigurationManager.ConnectionStrings["cnx_bd_hr"].ConnectionString);
                con.Open();
                cmd = new SqlCommand("usp_paises_crud", con);
                cmd.CommandType= System.Data.CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@indicador", "ConsultarXId");
                cmd.Parameters.AddWithValue("@country_id", codigo);
                cmd.Parameters.AddWithValue("@country_name", "");
                cmd.Parameters.AddWithValue("@region_id", 0);

                reader = cmd.ExecuteReader();

                while (reader.Read())
                {
                    objPais = new Pais()
                    {
                        country_id = reader.GetString(0),
                        country_name = reader.GetString(1),
                        region_id = reader.GetInt32(2)
                    };
                }
            }
            catch (Exception ex)
            {
                Debug.WriteLine("obtenerPais-Error : " + ex);
            }
            finally
            {
                reader.Close();
                con.Close();
            }
            return objPais;
        }

        public int registrar(Pais p)
        {
            SqlConnection con = null;
            SqlCommand cmd = null;
            int procesar = -1;
            try
            {
                con = new SqlConnection(ConfigurationManager.ConnectionStrings["cnx_bd_hr"].ConnectionString);
                con.Open();
                cmd = new SqlCommand("usp_paises_crud", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@indicador", "Insertar");
                cmd.Parameters.AddWithValue("@country_id", p.country_id);
                cmd.Parameters.AddWithValue("@country_name", p.country_name);
                cmd.Parameters.AddWithValue("@region_id", p.region_id);
                procesar = cmd.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                Debug.WriteLine("Error - registrar : " + ex.ToString());
            }
            finally
            {
                con.Close();
            }
            return procesar;
        }
    }
}