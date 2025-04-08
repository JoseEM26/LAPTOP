using Dominio.Entity;
using Dominio.Interefaz;
using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;
using System.Threading.Tasks;

namespace Infraestructura
{
    public class AlumnoRepositorio : IAlumnoRepository
    {
        private readonly ConexionBaseDatos _conexion;

        public AlumnoRepositorio(ConexionBaseDatos conexion)
        {
            _conexion = conexion;
        }
        private const string USP_INSERTAR_ALUMNO = "SP_Alumno_Create";
        private const string USP_LISTAR_ALUMNO = "USP_Alumno_listar";
        private const string USP_ELIMINAR_ALUMNO = "USP_Alumno_Eliminar";
        private const string USP_ACTUALIZAR_ALUMNO = "USP_Alumno_Update";
        public ResultadoTransaction<Alumno> BuscarAlumno(int id)
        {
            ResultadoTransaction<Alumno> resultado = new ResultadoTransaction<Alumno>();

            try
            {
                using (SqlConnection con = _conexion.AbrirConnection())
                {
                    con.Open();
                    using (SqlCommand cmd = new SqlCommand(USP_LISTAR_ALUMNO, con))
                    {
                        cmd.CommandType = CommandType.StoredProcedure;
                        cmd.Parameters.AddWithValue("@idAlumno", id);
                        cmd.Parameters.AddWithValue("@flgListar", 2);
                        cmd.Parameters.Add("@value", SqlDbType.Int, 11).Direction = ParameterDirection.Output;
                        cmd.Parameters.Add("@mensaje", SqlDbType.VarChar, 200).Direction = ParameterDirection.Output;

                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            if (reader.Read())
                            {
                                Alumno alumno = new Alumno();
                                alumno.nombre = reader["alumno"].ToString();
                                alumno.apellido = reader["apellido"].ToString();
                                alumno.nroDocumento = reader["nroDocumento"].ToString();
                                alumno.idAlumno = Convert.ToInt32(reader["idAlumno"].ToString());
                                alumno.fechaNacimiento = Convert.ToDateTime(reader["fechaNacimiento"].ToString());
                                int exito = Convert.ToInt32(cmd.Parameters["@value"].Value.ToString());

                                resultado.valor = exito == 0 ? true : false;
                                resultado.mensaje = cmd.Parameters["@mensaje"].Value.ToString();
                                resultado.Dato = alumno;
                                resultado.idRegistro = 0;
                            }

                        }
                    }
                }

            }
            catch (Exception e)
            {
                resultado.idRegistro = -1;
                resultado.mensaje = "Ocurrio un Error";

            }
            return resultado;
        }

        public ResultadoTransaction<string> CreateAlumno(Alumno alumno)
        {
            ResultadoTransaction<string> resultado = new ResultadoTransaction<string>();

            try
            {
                using (SqlConnection con = new SqlConnection(_conexion._cadenaConnection))
                {
                    con.Open();
                    using(SqlTransaction tran= con.BeginTransaction())
                    {
                        try
                        {
                            using (SqlCommand cmd = new SqlCommand(USP_INSERTAR_ALUMNO, con, tran))
                            {
                                cmd.CommandType = CommandType.StoredProcedure;
                                cmd.Parameters.AddWithValue("@nombre", alumno.nombre);
                                cmd.Parameters.AddWithValue("@apellido", alumno.apellido);
                                cmd.Parameters.AddWithValue("@nroDocumento", alumno.nroDocumento);
                                cmd.Parameters.AddWithValue("@fechaNacimiento", alumno.fechaNacimiento);
                                cmd.Parameters.Add("@value", SqlDbType.Int, 11).Direction = ParameterDirection.Output;
                                cmd.Parameters.Add("@mensaje", SqlDbType.VarChar, 200).Direction = ParameterDirection.Output;
                                cmd.ExecuteNonQuery();

                                tran.Commit();
                                tran.Dispose();
                                int exito = Convert.ToInt32(cmd.Parameters["@value"].Value.ToString());

                                resultado.valor = exito == 0 ? true : false;
                                resultado.mensaje = cmd.Parameters["@mensaje"].Value.ToString();
                                resultado.idRegistro = 0;
                            }
                        }catch(Exception e)
                        {
                            tran.Rollback();
                            resultado.idRegistro = -1;
                            resultado.mensaje = "Ocurrio un Error";
                        }
                    }
                }

            }catch(Exception e)
            {
                resultado.idRegistro = -1;
                resultado.mensaje = "Ocurrio un Error";
            }
            return resultado;
        }

        public ResultadoTransaction<string> DeleteAlumno(int id)
        {
            ResultadoTransaction<string> resultado = new ResultadoTransaction<string>();

            try
            {
                using (SqlConnection con = new SqlConnection(_conexion._cadenaConnection))
                {
                    con.Open();
                    using (SqlTransaction tran = con.BeginTransaction())
                    {
                        try
                        {
                            using (SqlCommand cmd = new SqlCommand(USP_ELIMINAR_ALUMNO, con, tran))
                            {
                                cmd.CommandType = CommandType.StoredProcedure;
                                cmd.Parameters.AddWithValue("@idAlumno", id);
                                cmd.Parameters.Add("@value", SqlDbType.Int, 11).Direction = ParameterDirection.Output;
                                cmd.Parameters.Add("@mensaje", SqlDbType.VarChar, 200).Direction = ParameterDirection.Output;
                                cmd.ExecuteNonQuery();

                                tran.Commit();
                                tran.Dispose();
                                int exito = Convert.ToInt32(cmd.Parameters["@value"].Value.ToString());

                                resultado.valor = exito == 0 ? true : false;
                                resultado.mensaje = cmd.Parameters["@mensaje"].Value.ToString();
                                resultado.idRegistro = 0;
                            }
                        }
                        catch (Exception e)
                        {
                            tran.Rollback();
                            resultado.idRegistro = -1;
                            resultado.mensaje = "Ocurrio un Error";
                        }
                    }
                }

            }
            catch (Exception e)
            {
                resultado.idRegistro = -1;
                resultado.mensaje = "Ocurrio un Error";
            }
            return resultado;
        }

        public ResultadoTransaction<Alumno> ListarAlumno()
        {
            ResultadoTransaction<Alumno> resultado = new ResultadoTransaction<Alumno>();

            try
            {
                using (SqlConnection con = _conexion.AbrirConnection())
                {
                    con.Open();
                    using (SqlCommand cmd = new SqlCommand(USP_LISTAR_ALUMNO, con))
                    {
                        cmd.CommandType = CommandType.StoredProcedure;
                        cmd.Parameters.AddWithValue("@idAlumno", 0);
                        cmd.Parameters.AddWithValue("@flgListar", 1);
                        cmd.Parameters.Add("@value", SqlDbType.Int, 11).Direction = ParameterDirection.Output;
                        cmd.Parameters.Add("@mensaje", SqlDbType.VarChar, 200).Direction = ParameterDirection.Output;

                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            List<Alumno> lista = new List<Alumno>();
                            while (reader.Read())
                            {
                                Alumno alumno = new Alumno();
                                alumno.nombre = reader["alumno"].ToString();
                                alumno.apellido = reader["apellido"].ToString();
                                alumno.nroDocumento = reader["nroDocumento"].ToString();
                                alumno.idAlumno = Convert.ToInt32(reader["idAlumno"].ToString());
                                alumno.fechaNacimiento = Convert.ToDateTime(reader["fechaNacimiento"].ToString());
                                lista.Add(alumno);

                            }
                            int exito = Convert.ToInt32(cmd.Parameters["@value"].Value.ToString());

                            resultado.valor = exito == 0 ? true : false;
                            resultado.mensaje = cmd.Parameters["@mensaje"].Value.ToString();
                            resultado.listDatos = lista;
                            resultado.idRegistro = 0;

                        }
                    }
                }

            }
            catch (Exception e)
            {
                resultado.idRegistro = -1;
                resultado.mensaje = "Ocurrio un Error";

            }
            return resultado;
        }

        public ResultadoTransaction<string> UpdateAlumno(Alumno alumno)
        {
            ResultadoTransaction<string> resultado = new ResultadoTransaction<string>();

            try
            {
                using (SqlConnection con = new SqlConnection(_conexion._cadenaConnection))
                {
                    con.Open();
                    using (SqlTransaction tran = con.BeginTransaction())
                    {
                        try
                        {
                            using (SqlCommand cmd = new SqlCommand(USP_ACTUALIZAR_ALUMNO, con, tran))
                            {
                                cmd.CommandType = CommandType.StoredProcedure;
                                cmd.Parameters.AddWithValue("@idAlumno", alumno.idAlumno);
                                cmd.Parameters.AddWithValue("@nombre", alumno.nombre);
                                cmd.Parameters.AddWithValue("@apellido", alumno.apellido);
                                cmd.Parameters.AddWithValue("@nroDocumento", alumno.nroDocumento);
                                cmd.Parameters.AddWithValue("@fechaNacimiento", alumno.fechaNacimiento);
                                cmd.Parameters.Add("@value", SqlDbType.Int, 11).Direction = ParameterDirection.Output;
                                cmd.Parameters.Add("@mensaje", SqlDbType.VarChar, 200).Direction = ParameterDirection.Output;
                                cmd.ExecuteNonQuery();

                                tran.Commit();
                                tran.Dispose();
                                int exito = Convert.ToInt32(cmd.Parameters["@value"].Value.ToString());

                                resultado.valor = exito == 0 ? true : false;
                                resultado.mensaje = cmd.Parameters["@mensaje"].Value.ToString();
                                resultado.idRegistro = 0;
                            }
                        }
                        catch (Exception e)
                        {
                            tran.Rollback();
                            resultado.idRegistro = -1;
                            resultado.mensaje = "Ocurrio un Error";
                        }
                    }
                }

            }
            catch (Exception e)
            {
                resultado.idRegistro = -1;
                resultado.mensaje = "Ocurrio un Error";
            }
            return resultado;
        }
    }
}
