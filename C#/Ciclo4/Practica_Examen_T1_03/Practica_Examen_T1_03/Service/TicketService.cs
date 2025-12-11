using Microsoft.Data.SqlClient;
using Practica_Examen_T1_03.Models;
using System.Data;

namespace Practica_Examen_T1_03.Service
{
    public class TicketService
    {

        private readonly string _connString;
        private string PROCEDURE_SQL = "USP_CRUD_SISTEMA_TICKET";
        private string parameter1_ID = "@TicketId";
        private string parameter2 = "@ItemId";
        private string parameter3 = "@AgenciaId";
        private string parameter4 = "@FechaCreacion";
        private string parameter5 = "@FechaCierre";
        private string parameter6 = "@ServiceDesk";
        private string parameter7 = "@Resumen";
        private string parameter8 = "@EstadoId";

        public TicketService(IConfiguration configuration)
        {
            _connString = configuration.GetConnectionString("conexionSQL")!;
        }

        private Ticket MAPPER_MODEL(SqlDataReader reader)
        {
            return new Ticket
            {
                TicketId = reader.GetInt32(0),
                ItemId = reader.GetInt32(1),
                AgenciaId = reader.GetInt32(2),
                FechaCreacion = reader.GetDateTime(3),
                FechaCierre = reader.GetDateTime(4),
                ServiceDesk = reader.GetString(5).Trim(),
                Resumen = reader.GetString(6).Trim(),
                EstadoId = reader.GetInt32(7)
            };
        }

        // 1. LISTAR
        public async Task<IEnumerable<Ticket>> FIND_ALL()
        {
            var lista = new List<Ticket>();
            using var con = new SqlConnection(_connString);
            using var cmd = new SqlCommand(PROCEDURE_SQL, con);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue("@Accion", "Listar");

            await con.OpenAsync();
            using var reader = await cmd.ExecuteReaderAsync();
            while (await reader.ReadAsync())
            {
                lista.Add(MAPPER_MODEL(reader));
            }
            return lista;
        }

        // 2. BUSCAR POR ID
        public async Task<Ticket?> GET_BY_ID(string id)
        {
            using var con = new SqlConnection(_connString);
            using var cmd = new SqlCommand(PROCEDURE_SQL, con);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue("@Accion", "Buscar");
            cmd.Parameters.AddWithValue(parameter1_ID, id);

            await con.OpenAsync();
            using var reader = await cmd.ExecuteReaderAsync();
            return await reader.ReadAsync() ? MAPPER_MODEL(reader) : null;
        }

        // 3. CREAR → devuelve bool
        public async Task<bool> SAVE(Ticket cliente)
        {
            using var con = new SqlConnection(_connString);
            using var cmd = new SqlCommand(PROCEDURE_SQL, con);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue("@Accion", "Crear");
            cmd.Parameters.AddWithValue(parameter2, cliente.ItemId);
            cmd.Parameters.AddWithValue(parameter3, cliente.AgenciaId);
            cmd.Parameters.AddWithValue(parameter4, cliente.FechaCreacion);
            cmd.Parameters.AddWithValue(parameter5, cliente.FechaCierre);
            cmd.Parameters.AddWithValue(parameter6, cliente.ServiceDesk);
            cmd.Parameters.AddWithValue(parameter7, cliente.Resumen);
            cmd.Parameters.AddWithValue(parameter8, cliente.EstadoId);

            await con.OpenAsync();
            var result = await cmd.ExecuteScalarAsync();
            return result != null && (bool)result;
        }

        // 4. ACTUALIZAR → devuelve bool
        public async Task<bool> UPDATE(Ticket cliente)
        {
            using var con = new SqlConnection(_connString);
            using var cmd = new SqlCommand(PROCEDURE_SQL, con);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue("@Accion", "Actualizar");
            cmd.Parameters.AddWithValue(parameter1_ID, cliente.TicketId);
            cmd.Parameters.AddWithValue(parameter2, cliente.ItemId);
            cmd.Parameters.AddWithValue(parameter3, cliente.AgenciaId);
            cmd.Parameters.AddWithValue(parameter4, cliente.FechaCreacion);
            cmd.Parameters.AddWithValue(parameter5, cliente.FechaCierre);
            cmd.Parameters.AddWithValue(parameter6, cliente.ServiceDesk);
            cmd.Parameters.AddWithValue(parameter7, cliente.Resumen);
            cmd.Parameters.AddWithValue(parameter8, cliente.EstadoId);

            await con.OpenAsync();
            var result = await cmd.ExecuteScalarAsync();
            return result != null && (bool)result;
        }

        // 5. ELIMINAR → devuelve bool
        public async Task<bool> DELETE(string id)
        {
            using var con = new SqlConnection(_connString);
            using var cmd = new SqlCommand(PROCEDURE_SQL, con);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue("@Accion", "Eliminar");
            cmd.Parameters.AddWithValue(parameter1_ID, id);

            await con.OpenAsync();
            var result = await cmd.ExecuteScalarAsync();
            return result != null && (bool)result;
        }

    }
}
