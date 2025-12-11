//agregar
using app_CoreApi_04.Models;
using app_CoreApi_04.Repositorio.Interfaces;
//Agregar
using Microsoft.Data.SqlClient;
namespace app_CoreApi_04.Repositorio.DAO
{
    public class paisDAO : IPais
    {

        // Para manejar la cadena de conexion 
        private readonly string cadena;

        //Constructor:
        public paisDAO()
        {
            cadena = new ConfigurationBuilder().AddJsonFile("appsettings.json").Build().GetConnectionString("sql");
        }

        public IEnumerable<Pais> getPaises()
        {
            List<Pais> temporal = new List<Pais>();
            using (SqlConnection cn = new SqlConnection(cadena))
            {
                SqlCommand cmd = new SqlCommand("usp_paises", cn);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                cn.Open();
                SqlDataReader dr = cmd.ExecuteReader();
                while ( dr.Read())
                {
                    temporal.Add(new Pais()
                    {
                        idpais = dr.GetString(0),
                        nombrepais = dr.GetString(1)                     

                    } );
                }

                dr.Close ();
            }
            return temporal; 
        }
    }
}
