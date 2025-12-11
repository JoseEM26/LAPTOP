using Microsoft.Data.SqlClient;
using PracticaExamen_02.Models;
using System.Data;
using static System.Net.Mime.MediaTypeNames;

namespace PracticaExamen_02.Service
{
    public class ClienteService
    {

        private readonly string _connString;
        private string PROCEDURE_SQL = "USP_CRUD_CLIENTE";
        private string parameter1_ID = "@IdCliente";
        private string parameter2 = "@Nombres";
        private string parameter3 = "@Apellidos";
        private string parameter4 = "@Direccion";
        private string parameter5 = "@Fono";
        private string parameter6 = "@IdDistrito";
        private string parameter7 = "@Email";

        public ClienteService(IConfiguration configuration)
        {
            _connString = configuration.GetConnectionString("conexionSQL")!;
        }
            
        private Cliente MAPPER_MODEL(SqlDataReader reader)
        {
            return new Cliente
            {
                IdCliente = reader.GetString(0).Trim(),
                Nombres = reader.GetString(1).Trim(),
                Apellidos = reader.GetString(2).Trim(),
                Direccion = reader.GetString(3).Trim(),
                Fono = reader.IsDBNull(4) ? "000000000" : reader.GetString(4).Trim(),
                IdDistrito = reader.GetString(5).Trim(),
                Email =  reader.GetString(6).Trim()
            };
        }

        // 1. LISTAR
        public async Task<IEnumerable<Cliente>> FIND_ALL()
        {
            var lista = new List<Cliente>();
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
        public async Task<Cliente?> GET_BY_ID(string id)
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
        public async Task<bool> SAVE(Cliente cliente)
        {
            using var con = new SqlConnection(_connString);
            using var cmd = new SqlCommand(PROCEDURE_SQL, con);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue("@Accion", "Crear");
            cmd.Parameters.AddWithValue(parameter1_ID, cliente.IdCliente);
            cmd.Parameters.AddWithValue(parameter2, cliente.Nombres);
            cmd.Parameters.AddWithValue(parameter3, cliente.Apellidos);
            cmd.Parameters.AddWithValue(parameter4, cliente.Direccion);
            cmd.Parameters.AddWithValue(parameter5, cliente.Fono);
            cmd.Parameters.AddWithValue(parameter6, cliente.IdDistrito);
            cmd.Parameters.AddWithValue(parameter7, cliente.Email);

            await con.OpenAsync();
            var result = await cmd.ExecuteScalarAsync();
            return result != null && (bool)result;
        }

        // 4. ACTUALIZAR → devuelve bool
        public async Task<bool> UPDATE(Cliente cliente)
        {
            using var con = new SqlConnection(_connString);
            using var cmd = new SqlCommand(PROCEDURE_SQL, con);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue("@Accion", "Actualizar");
            cmd.Parameters.AddWithValue(parameter1_ID, cliente.IdCliente);
            cmd.Parameters.AddWithValue(parameter2, cliente.Nombres);
            cmd.Parameters.AddWithValue(parameter3, cliente.Apellidos);
            cmd.Parameters.AddWithValue(parameter4, cliente.Direccion);
            cmd.Parameters.AddWithValue(parameter5, cliente.Fono);
            cmd.Parameters.AddWithValue(parameter6, cliente.IdDistrito);
            cmd.Parameters.AddWithValue(parameter7, cliente.Email);

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
