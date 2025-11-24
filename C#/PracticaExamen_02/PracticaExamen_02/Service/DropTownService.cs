using Microsoft.Data.SqlClient;
using PracticaExamen_02.Models;
using System.Data;

namespace PracticaExamen_02.Service
{
    public class DropTownService
    {
        private readonly string _connString;
        private string PROCEDURE_SQL = "USP_DROPTOWNLIST_01";

        public DropTownService(IConfiguration configuration)
        {
            _connString = configuration.GetConnectionString("conexionSQL")!;
        }

        private Distritos MAPPER_MODEL(SqlDataReader reader)
        {
            return new Distritos
            {
                IdDistrito = reader.GetString(0).Trim(),
                nombre_distrito = reader.GetString(1).Trim(),
            };
        }

        // 1. LISTAR
        public async Task<IEnumerable<Distritos>> FIND_ALL()
        {
            var lista = new List<Distritos>();
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
