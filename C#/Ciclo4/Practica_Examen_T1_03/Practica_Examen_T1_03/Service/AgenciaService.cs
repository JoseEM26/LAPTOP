using Microsoft.Data.SqlClient;
using Practica_Examen_T1_03.Models;
using System.Data;

namespace Practica_Examen_T1_03.Service
{
    public class AgenciaService
    {
        private readonly string _connString;
        private string PROCEDURE_SQL = "USP_DROPTOWNLIST_AGENCIA";

        public AgenciaService(IConfiguration configuration)
        {
            _connString = configuration.GetConnectionString("conexionSQL")!;
        }

        private Agencia MAPPER_MODEL(SqlDataReader reader)
        {
            return new Agencia
            {
                AgenciaId = reader.GetInt32(0),
                nombre = reader.GetString(1).Trim(),
            };
        }

        // 1. LISTAR
        public async Task<IEnumerable<Agencia>> FIND_ALL()
        {
            var lista = new List<Agencia>();
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
