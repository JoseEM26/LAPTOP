// agregar 
using app_CoreApi_04.Models;
using app_CoreApi_04.Repositorio.Interfaces;
using Microsoft.Data.SqlClient;

namespace app_CoreApi_04.Repositorio.DAO
{
    public class clienteDAO : ICLiente
    {

        // Para manejar la cadena de conexion 
        private readonly string cadena;

        //Constructor:
        public clienteDAO()
        {
            cadena = new ConfigurationBuilder().AddJsonFile("appsettings.json").Build().GetConnectionString("sql");
        }
        public Cliente getCliente(string id)
        {
            return getClientes().FirstOrDefault(c => c.idcliente == id);
        }

        public IEnumerable<Cliente> getClientes()
        {
            List<Cliente> temporal = new List<Cliente>();
            using (SqlConnection cn = new SqlConnection(cadena))
            {
                SqlCommand cmd = new SqlCommand("usp_clientes", cn);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                cn.Open();
                SqlDataReader dr = cmd.ExecuteReader();
                while (dr.Read())
                {
                    temporal.Add(new Cliente()
                    {
                        idcliente = dr.GetString(0),
                        nombrecia = dr.GetString(1),
                         direccion = dr.GetString(2),
                        idpais = dr.GetString(3),
                        fono = dr.GetString(4)

                    });
                }

                dr.Close();
            }
            return temporal;
        }

        public string insertCliente(Cliente reg)
        {
            string mensaje = string.Empty;
            using (SqlConnection cn = new SqlConnection(cadena))
            {
                try
                {


                    SqlCommand cmd = new SqlCommand("usp_insertar_cliente", cn);
                    cmd.CommandType = System.Data.CommandType.StoredProcedure;
                    cmd.Parameters.AddWithValue("@idCliente", reg.idcliente);
                    cmd.Parameters.AddWithValue("@nombre", reg.nombrecia);
                    cmd.Parameters.AddWithValue("@direccion", reg.direccion);
                    cmd.Parameters.AddWithValue("@idpais", reg.idpais);
                    cmd.Parameters.AddWithValue("@fono", reg.fono);
                    cn.Open();
                    int i = cmd.ExecuteNonQuery();
                    mensaje = $"Se ha agregado {i} clientes";
                }
                catch (SqlException ex)
                {
                    mensaje = ex.Message;
                }
                finally { cn.Close(); }

                return mensaje;
            }
        }
        public string updateCliente(Cliente reg)
        {
            string mensaje = string.Empty;
            using (SqlConnection cn = new SqlConnection(cadena))
            {
                try
                {


                    SqlCommand cmd = new SqlCommand("usp_actualizar_cliente", cn);
                    cmd.CommandType = System.Data.CommandType.StoredProcedure;
                    cmd.Parameters.AddWithValue("@idCliente", reg.idcliente);
                    cmd.Parameters.AddWithValue("@nombre", reg.nombrecia);
                    cmd.Parameters.AddWithValue("@direccion", reg.direccion);
                    cmd.Parameters.AddWithValue("@idpais", reg.idpais);
                    cmd.Parameters.AddWithValue("@fono", reg.fono);
                    cn.Open();
                    int i = cmd.ExecuteNonQuery();
                    mensaje = $"Se ha actualizado {i} clientes";
                }
                catch (SqlException ex)
                {
                    mensaje = ex.Message;
                }
                finally { cn.Close(); }

                return mensaje;
            }
        }
    }
}
