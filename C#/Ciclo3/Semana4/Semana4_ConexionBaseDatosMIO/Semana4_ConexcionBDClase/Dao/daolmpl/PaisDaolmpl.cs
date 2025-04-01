using Semana4_ConexcionBDClase.Dao.paises;
using Semana4_ConexcionBDClase.Models;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Diagnostics;
using System.Linq;
using System.Web.UI.WebControls;

namespace Semana4_ConexcionBDClase.Dao.daolmpl
{
    public class PaisDaolmpl : PaisDAO
    {
        public int Actualizar(Pais p)
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
                cmd.Parameters.AddWithValue("@country_id",p.country_id);
                cmd.Parameters.AddWithValue("@country_name",p.country_name);
                cmd.Parameters.AddWithValue("@region_id", p.region_id);

                procesar = cmd.ExecuteNonQuery();
            }
            catch
            {
                Debug.WriteLine("Ocurrido un errorcito");
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
            SqlDataReader reader = null;
            SqlCommand cmd = null;
            List<Pais> lista = new List<Pais>(); // Inicializar la lista

            try
            {
                con = new SqlConnection(ConfigurationManager.ConnectionStrings["cnx_bd_hr"].ConnectionString);
                con.Open();

                cmd = new SqlCommand("usp_paises_crud", con);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@indicador", "ConsultarTodo");
                cmd.Parameters.AddWithValue("@country_id", "");
                cmd.Parameters.AddWithValue("@country_name", "");
                cmd.Parameters.AddWithValue("@region_id", 0);

                reader = cmd.ExecuteReader();

                while (reader.Read())
                {
                    var objPais = new Pais()
                    {
                        country_id = reader.GetString(0),
                        country_name = reader.GetString(1),
                        region_id = reader.GetInt32(2),
                    };

                    lista.Add(objPais);
                }
            }
            catch (Exception ex)
            {
                Debug.WriteLine("Ocurrió un error: " + ex.Message);
            }
            finally
            {
                reader.Close(); // Cerrar solo si no es null
                con.Close(); // Cerrar solo si no es null
            }

            return lista; // Retornar la lista, que puede estar vacía si no hay resultados
        }

        public int Eliminar(string codigo)
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
                cmd.Parameters.AddWithValue("@country_name","");
                cmd.Parameters.AddWithValue("@region_id",0);

                procesar = cmd.ExecuteNonQuery();
            }
            catch(Exception ex)
            {
                Debug.WriteLine("Ocurrido un errorcito"+ex.Message);
            }
            finally
            {
                con.Close();
            }

            return procesar;
        }

        public Pais ObtenerPais(string codigo)
        {
            SqlConnection con = null;
            SqlCommand cmd = null;
            SqlDataReader reader = null;
            Pais objPais = null;

            try
            {
                con = new SqlConnection(ConfigurationManager.ConnectionStrings["cnx_bd_hr"].ConnectionString);
                con.Open();
                cmd = new SqlCommand("usp_paises_crud", con);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@indicador", "ConsultarXId");
                cmd.Parameters.AddWithValue("@country_id", codigo);
                cmd.Parameters.AddWithValue("@country_name", "");
                cmd.Parameters.AddWithValue("@region_id", 0);

                reader = cmd.ExecuteReader();

                if (reader.Read()) // Solo leer si hay resultados
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
                Debug.WriteLine("ObtenerPais-Error: " + ex.Message);
            }
            finally
            {
                reader.Close(); // Cerrar solo si no es null
                con.Close(); // Cerrar solo si no es null
            }

            return objPais; // Retorna null si no se encuentra el país
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
            catch
            {
                Debug.WriteLine("Ocurrido un errorcito");
            }
            finally
            {
                con.Close();

            }

            return procesar;
        }
    }
}