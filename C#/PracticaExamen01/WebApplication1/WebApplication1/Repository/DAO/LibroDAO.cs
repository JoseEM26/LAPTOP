using Microsoft.Data.SqlClient;
using System.Data;
using WebApplication1.Models;
using WebApplication1.Repository.Interfaces;

namespace WebApplication1.Repository.DAO
{
    public class LibroDAO : ILibro
    {
        private readonly string _connString;
        private const string PROCEDURE_SQL = "USP_CRUD_LIBRO";

        private const string P_ACCION = "@Accion";
        private const string P_CODIGO = "@CodigoLibro";
        private const string P_TITULO = "@TituloLibro";
        private const string P_AUTOR = "@Autor";
        private const string P_GENERO = "@Genero";
        private const string P_EDITORIAL = "@CodigoEditorial";

        public LibroDAO(IConfiguration configuration)
        {
            _connString = configuration.GetConnectionString("conexionSQL")!;
        }

        // Modelo plano con solo lo que necesitas en el frontend
        private static Libro MAPPER_MODEL(SqlDataReader reader)
        {
            return new Libro
            {
                CodigoLibro = reader.GetString(0).Trim(),
                TituloLibro = reader.GetString(1).Trim(),
                Autor = reader.GetString(2).Trim(),
                Genero = reader.IsDBNull(3) ? null : reader.GetString(3).Trim(),
                CodigoEditorial = reader.GetString(4).Trim(),
                Editorial = new Editorial()
                {
                    CodigoEditorial = reader.GetString(4).Trim(),
                    NombreEditorial = reader.GetString(5).Trim(),
                }
            };
        }

        public async Task<IEnumerable<Libro>> GetAllAsync()
        {
            var lista = new List<Libro>();
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

        public async Task<Libro?> GetByIdAsync(string codigoLibro)
        {
            using var con = new SqlConnection(_connString);
            using var cmd = new SqlCommand(PROCEDURE_SQL, con);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue(P_ACCION, "Buscar");
            cmd.Parameters.AddWithValue(P_CODIGO, codigoLibro);

            await con.OpenAsync();
            using var reader = await cmd.ExecuteReaderAsync();
            return await reader.ReadAsync() ? MAPPER_MODEL(reader) : null;
        }

        public async Task AddAsync(Libro libro)
        {
            using var con = new SqlConnection(_connString);
            using var cmd = new SqlCommand(PROCEDURE_SQL, con);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue(P_ACCION, "Crear");
            cmd.Parameters.AddWithValue(P_CODIGO, libro.CodigoLibro);
            cmd.Parameters.AddWithValue(P_TITULO, libro.TituloLibro);
            cmd.Parameters.AddWithValue(P_AUTOR, libro.Autor);
            cmd.Parameters.AddWithValue(P_GENERO, libro.Genero ?? (object)DBNull.Value);
            cmd.Parameters.AddWithValue(P_EDITORIAL, libro.CodigoEditorial);

            await con.OpenAsync();
            await cmd.ExecuteScalarAsync();
        }

        public async Task UpdateAsync(Libro libro)
        {
            using var con = new SqlConnection(_connString);
            using var cmd = new SqlCommand(PROCEDURE_SQL, con);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue(P_ACCION, "Actualizar");
            cmd.Parameters.AddWithValue(P_CODIGO, libro.CodigoLibro);
            cmd.Parameters.AddWithValue(P_TITULO, libro.TituloLibro);
            cmd.Parameters.AddWithValue(P_AUTOR, libro.Autor);
            cmd.Parameters.AddWithValue(P_GENERO, libro.Genero ?? (object)DBNull.Value);
            cmd.Parameters.AddWithValue(P_EDITORIAL, libro.CodigoEditorial);

            await con.OpenAsync();
            await cmd.ExecuteScalarAsync();
        }

        public async Task DeleteAsync(string codigoLibro)
        {
            using var con = new SqlConnection(_connString);
            using var cmd = new SqlCommand(PROCEDURE_SQL, con);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue(P_ACCION, "Eliminar");
            cmd.Parameters.AddWithValue(P_CODIGO, codigoLibro);

            await con.OpenAsync();
            await cmd.ExecuteScalarAsync();
        }
    }
}