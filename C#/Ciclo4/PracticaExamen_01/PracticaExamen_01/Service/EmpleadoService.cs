using Microsoft.Data.SqlClient;
using PracticaExamen_01.Models;
using System.Collections.Generic;
using System.Data;
using System.Threading.Tasks;

namespace PracticaExamen_01.Service
{
    public class EmpleadoService
    {
        private readonly string _connString;

        public EmpleadoService(IConfiguration configuration)
        {
            _connString = configuration.GetConnectionString("conexionSQL")!;
        }

        private Empleado MapearEmpleado(SqlDataReader reader)
        {
            return new Empleado
            {
                IdEmpleado = reader.GetInt32("IdEmpleado"),
                ApeEmpleado = reader.GetString("ApeEmpleado"),
                NomEmpleado = reader.GetString("NomEmpleado"),
                FecNac = reader.GetDateTime("FecNac"),
                DirEmpleado = reader.GetString("DirEmpleado"),
                idDistrito = reader.GetInt32("idDistrito"),
                fonoEmpleado = reader.GetString("fonoEmpleado"),
                idCargo = reader.GetInt32("idCargo"),
                FecContrata = reader.GetDateTime("FecContrata")
            };
        }

        // 1. LISTAR
        public async Task<IEnumerable<Empleado>> ListarEmpleadosAsync()
        {
            var lista = new List<Empleado>();
            using var con = new SqlConnection(_connString);
            using var cmd = new SqlCommand("USP_CRUD_EMPLEADO", con);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue("@Accion", "Listar");

            await con.OpenAsync();
            using var reader = await cmd.ExecuteReaderAsync();
            while (await reader.ReadAsync())
            {
                lista.Add(MapearEmpleado(reader));
            }
            return lista;
        }

        // 2. BUSCAR POR ID
        public async Task<Empleado?> GetEmpleadoByIdAsync(int id)
        {
            using var con = new SqlConnection(_connString);
            using var cmd = new SqlCommand("USP_CRUD_EMPLEADO", con);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue("@Accion", "Buscar");
            cmd.Parameters.AddWithValue("@IdEmpleado", id);

            await con.OpenAsync();
            using var reader = await cmd.ExecuteReaderAsync();
            return await reader.ReadAsync() ? MapearEmpleado(reader) : null;
        }

        // 3. CREAR → devuelve bool
        public async Task<bool> CreateEmpleadoAsync(Empleado empleado)
        {
            using var con = new SqlConnection(_connString);
            using var cmd = new SqlCommand("USP_CRUD_EMPLEADO", con);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue("@Accion", "Crear");
            cmd.Parameters.AddWithValue("@IdEmpleado", empleado.IdEmpleado);
            cmd.Parameters.AddWithValue("@ApeEmpleado", empleado.ApeEmpleado );
            cmd.Parameters.AddWithValue("@NomEmpleado", empleado.NomEmpleado );
            cmd.Parameters.AddWithValue("@FecNac", empleado.FecNac);
            cmd.Parameters.AddWithValue("@DirEmpleado", empleado.DirEmpleado);
            cmd.Parameters.AddWithValue("@idDistrito", empleado.idDistrito);
            cmd.Parameters.AddWithValue("@fonoEmpleado", empleado.fonoEmpleado);
            cmd.Parameters.AddWithValue("@idCargo", empleado.idCargo);
            cmd.Parameters.AddWithValue("@FecContrata", empleado.FecContrata);

            await con.OpenAsync();
            var result = await cmd.ExecuteScalarAsync();
            return result != null && (bool)result;
        }

        // 4. ACTUALIZAR → devuelve bool
        public async Task<bool> UpdateEmpleadoAsync(Empleado empleado)
        {
            using var con = new SqlConnection(_connString);
            using var cmd = new SqlCommand("USP_CRUD_EMPLEADO", con);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue("@Accion", "Actualizar");
            cmd.Parameters.AddWithValue("@IdEmpleado", empleado.IdEmpleado);
            cmd.Parameters.AddWithValue("@ApeEmpleado", empleado.ApeEmpleado );
            cmd.Parameters.AddWithValue("@NomEmpleado", empleado.NomEmpleado );
            cmd.Parameters.AddWithValue("@FecNac", empleado.FecNac);
            cmd.Parameters.AddWithValue("@DirEmpleado", empleado.DirEmpleado);
            cmd.Parameters.AddWithValue("@idDistrito", empleado.idDistrito);
            cmd.Parameters.AddWithValue("@fonoEmpleado", empleado.fonoEmpleado);
            cmd.Parameters.AddWithValue("@idCargo", empleado.idCargo);
            cmd.Parameters.AddWithValue("@FecContrata", empleado.FecContrata);

            await con.OpenAsync();
            var result = await cmd.ExecuteScalarAsync();
            return result != null && (bool)result;
        }

        // 5. ELIMINAR → devuelve bool
        public async Task<bool> DeleteEmpleadoAsync(int id)
        {
            using var con = new SqlConnection(_connString);
            using var cmd = new SqlCommand("USP_CRUD_EMPLEADO", con);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue("@Accion", "Eliminar");
            cmd.Parameters.AddWithValue("@IdEmpleado", id);

            await con.OpenAsync();
            var result = await cmd.ExecuteScalarAsync();
            return result != null && (bool)result;
        }
    }
}