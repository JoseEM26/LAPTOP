using Microsoft.Data.SqlClient;
using System.Data;
using WebApplication1.Models;
using WebApplication1.Repository.Interfaces;

namespace WebApplication1.Repository.DAO
{
    public class PaisDAO : IPais
    {
        private readonly string _connString;
        private const string PROCEDURE_SQL = "USP_LISTAR_PAISES_COMBO";

        public PaisDAO(IConfiguration configuration)
        {
            _connString = configuration.GetConnectionString("conexionSQL")!;
        }

        private static Pais MAPPER_MODEL(SqlDataReader reader)
        {
            return new Pais
            {
                CodigoPais = reader.GetString(0).Trim(),
                NombrePais = reader.GetString(1).Trim()
            };
        }

        public async Task<IEnumerable<Pais>> GetForComboAsync()
        {
            var lista = new List<Pais>();
            using var con = new SqlConnection(_connString);
            using var cmd = new SqlCommand(PROCEDURE_SQL, con);
            cmd.CommandType = CommandType.StoredProcedure;

            await con.OpenAsync();
            using var reader = await cmd.ExecuteReaderAsync();
            while (await reader.ReadAsync())
            {
                lista.Add(MAPPER_MODEL(reader));
            }
            return lista;
        }
    }
}