using Microsoft.Data.SqlClient;
using System.Data;
using WebApplication1.Models;
using WebApplication1.Repository.Interfaces;

namespace WebApplication1.Repository.DAO
{
    public class EditorialDAO : IEditorial
    {
        private readonly string _connString;
        private const string PROCEDURE_SQL = "USP_CRUD_EDITORIAL";

        private const string P_ACCION = "@Accion";
        private const string P_CODIGO = "@CodigoEditorial";
        private const string P_NOMBRE = "@NombreEditorial";
        private const string P_DIRECCION = "@Direccion";
        private const string P_EMAIL = "@Email";
        private const string P_PAIS = "@CodigoPais";

        public EditorialDAO(IConfiguration configuration)
        {
            _connString = configuration.GetConnectionString("conexionSQL")!;
        }

        // UN SOLO MAPPER – usado en Listar y Buscar (siempre 6 columnas)
        private static Editorial MAPPER_MODEL(SqlDataReader reader)
        {
            return new Editorial
            {
                CodigoEditorial = reader.GetString(0).Trim(),
                NombreEditorial = reader.GetString(1).Trim(),
                Direccion = reader.IsDBNull(2) ? null : reader.GetString(2).Trim(),
                Email = reader.IsDBNull(3) ? null : reader.GetString(3).Trim(),
                CodigoPais = reader.GetString(4).Trim(),
                Pais = new Pais
                {
                    CodigoPais = reader.GetString(4).Trim(),
                    NombrePais = reader.GetString(5).Trim()
                }
            };
        }

        public async Task<IEnumerable<Editorial>> GetAllAsync()
        {
            var lista = new List<Editorial>();
            using var con = new SqlConnection(_connString);
            using var cmd = new SqlCommand(PROCEDURE_SQL, con);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue(P_ACCION, "Listar");

            await con.OpenAsync();
            using var reader = await cmd.ExecuteReaderAsync();
            while (await reader.ReadAsync())
            {
                lista.Add(MAPPER_MODEL(reader));
            }
            return lista;
        }

        public async Task<Editorial?> GetByIdAsync(string codigoEditorial)
        {
            using var con = new SqlConnection(_connString);
            using var cmd = new SqlCommand(PROCEDURE_SQL, con);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue(P_ACCION, "Buscar");
            cmd.Parameters.AddWithValue(P_CODIGO, codigoEditorial);

            await con.OpenAsync();
            using var reader = await cmd.ExecuteReaderAsync();
            return await reader.ReadAsync() ? MAPPER_MODEL(reader) : null;
        }

        public async Task AddAsync(Editorial editorial)
        {
            using var con = new SqlConnection(_connString);
            using var cmd = new SqlCommand(PROCEDURE_SQL, con);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue(P_ACCION, "Crear");
            cmd.Parameters.AddWithValue(P_CODIGO, editorial.CodigoEditorial);
            cmd.Parameters.AddWithValue(P_NOMBRE, editorial.NombreEditorial);
            cmd.Parameters.AddWithValue(P_DIRECCION, editorial.Direccion ?? (object)DBNull.Value);
            cmd.Parameters.AddWithValue(P_EMAIL, editorial.Email ?? (object)DBNull.Value);
            cmd.Parameters.AddWithValue(P_PAIS, editorial.CodigoPais);

            await con.OpenAsync();
            await cmd.ExecuteScalarAsync();
        }

        public async Task UpdateAsync(Editorial editorial)
        {
            using var con = new SqlConnection(_connString);
            using var cmd = new SqlCommand(PROCEDURE_SQL, con);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue(P_ACCION, "Actualizar");
            cmd.Parameters.AddWithValue(P_CODIGO, editorial.CodigoEditorial);
            cmd.Parameters.AddWithValue(P_NOMBRE, editorial.NombreEditorial);
            cmd.Parameters.AddWithValue(P_DIRECCION, editorial.Direccion ?? (object)DBNull.Value);
            cmd.Parameters.AddWithValue(P_EMAIL, editorial.Email ?? (object)DBNull.Value);
            cmd.Parameters.AddWithValue(P_PAIS, editorial.CodigoPais);

            await con.OpenAsync();
            await cmd.ExecuteScalarAsync();
        }

        public async Task DeleteAsync(string codigoEditorial)
        {
            using var con = new SqlConnection(_connString);
            using var cmd = new SqlCommand(PROCEDURE_SQL, con);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue(P_ACCION, "Eliminar");
            cmd.Parameters.AddWithValue(P_CODIGO, codigoEditorial);

            await con.OpenAsync();
            await cmd.ExecuteScalarAsync();
        }
    }
}