using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Diagnostics;
using System.Linq;
using System.Web;

namespace Tarea4_GuiaMVC.Models
{
    public class AccesoDatos
    {
        SqlConnection con = null;
        SqlCommand cmd = null;
        SqlDataReader reader = null;
        List<Cliente> Lista = new List<Cliente>();
        List<Pedido> ListaP = new List<Pedido>();
        public List<Cliente> ListaCliente()
        {
            try
            {
                con = new SqlConnection(ConfigurationManager.ConnectionStrings["db"].ConnectionString);
                con.Open();

                cmd = new SqlCommand("USP_CLIENTE_LISTAR", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;

                reader = cmd.ExecuteReader();

                while (reader.Read())
                {
                    Cliente c = new Cliente()
                    {
                        idCliente = reader[0].ToString(),
                        NombreCliente = reader[1].ToString(),
                        DirCliente = reader[2].ToString(),
                        Pais = reader[3].ToString(),
                        Telefono = reader[4].ToString(),
                    };
                    Lista.Add(c);
                }



            }catch(Exception e)
            {
                Debug.WriteLine(e.Message);
            }
            finally
            {
                con.Close();
                reader.Close();
            }
            return Lista;
        }

        public List<Pedido> ListaPedido()
        {
            try
            {
                con = new SqlConnection(ConfigurationManager.ConnectionStrings["db"].ConnectionString);
                con.Open();

                cmd = new SqlCommand("USP_PEDIDO_LISTAR", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;

                reader = cmd.ExecuteReader();

                while (reader.Read())
                {
                    Pedido c = new Pedido()
                    {
                        IdPedido = reader[0].ToString(),
                        FechaPedido = reader[1].ToString(),
                        NomCliente = reader[2].ToString(),
                        DirCliente = reader[3].ToString(),
                        Empleado = reader[4].ToString(),
                    };
                    ListaP.Add(c);
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
            return ListaP;
        }
    }
}