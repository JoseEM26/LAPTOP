using System.Data;
using Dominio.Entity;
using Dominio.Interzas;
using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;
using System.Diagnostics;

namespace Infraestructura
{
    public class AlumnoRepository : IAlumnoRepository
    {
        private readonly ConexionSql _conexion;

        public AlumnoRepository(ConexionSql conexion)
        {
            this._conexion = conexion;
        }

        private readonly string USP_ALUMNO_INSERT= "USP_ALUMNO_CREATE";
        private readonly string USP_ALUMNO_DELETE = "USP_ALUMNO_ELIMINAR";
        private readonly string USP_ALUMNO_UPDATE = "USP_ALUMNO_UPDATE";
        private readonly string USP_ALUMNO_LISTAR = "USP_ALUMNO_LISTAR";

        public ResultadoTransaction<Alumno> ListarAlumno()
        {
            ResultadoTransaction<Alumno> resultado = new ResultadoTransaction<Alumno>();

            try
            {
                using (SqlConnection con = _conexion.GetConnection())
                {
                    con.Open();
                    using (SqlCommand cmd = new SqlCommand(USP_ALUMNO_LISTAR, con))
                    {
                        cmd.CommandType =CommandType.StoredProcedure;
                        cmd.Parameters.AddWithValue("@idAlumno", 0);
                        cmd.Parameters.AddWithValue("@flgListar", 1);

                        using (SqlDataReader reader= cmd.ExecuteReader())
                        {
                            List<Alumno> lista = new List<Alumno>();
                            while (reader.Read())
                            {
                                Alumno a = new Alumno()
                                {
                                    idAlumno = Convert.ToInt32(reader["idAlumno"].ToString()),
                                    apellido = reader["apellido"].ToString(),
                                    fechaNacimiento = Convert.ToDateTime(reader["fechaNacimiento"].ToString()),
                                    nombre = reader["nombre"].ToString(),
                                    nroDocumento = reader["nroDocumento"].ToString()

                                };
                                lista.Add(a);
                            }
                            resultado.listData = lista;
                            resultado.value = true;
                            resultado.mensaje = "Se listo Todos los alumnos Correctamente";
                            resultado.idRegistro = 0;
                        }

                    }
                }
            }
            catch(Exception e)
            {
                resultado.idRegistro = -1;
                resultado.mensaje = "RepositorioList " + e.Message; 
            }

            return resultado;
        }

        public ResultadoTransaction<string> CreateAlumno(Alumno alumno)
        {
            ResultadoTransaction<string> resultado = new ResultadoTransaction<string>();

            try
            {
                using (SqlConnection con = _conexion.GetConnection())
                {
                    con.Open();
                    using (SqlTransaction transaction = con.BeginTransaction())
                    {
                        try
                        {
                            using(SqlCommand cmd= new SqlCommand(USP_ALUMNO_INSERT, con , transaction))
                            {
                                cmd.CommandType = CommandType.StoredProcedure;
                                cmd.Parameters.AddWithValue("@nombre", alumno.nombre);
                                cmd.Parameters.AddWithValue("@apellido", alumno.apellido);
                                cmd.Parameters.AddWithValue("@nroDocumento", alumno.nroDocumento);
                                cmd.Parameters.AddWithValue("@fechaNacimiento", alumno.fechaNacimiento);
                                cmd.Parameters.Add("@mensaje", SqlDbType.VarChar, 200).Direction = ParameterDirection.Output;
                                cmd.Parameters.Add("@value", SqlDbType.Int, 11).Direction = ParameterDirection.Output;
                                cmd.ExecuteNonQuery();

                                resultado.value = Convert.ToInt32(cmd.Parameters["@value"].Value.ToString()) == 1 ? true : false;
                                resultado.mensaje = cmd.Parameters["@mensaje"].Value.ToString();
                                resultado.idRegistro = 0;
                                transaction.Commit();
                                transaction.Dispose();

                            }
                        }
                        catch (Exception e)
                        {
                            transaction.Rollback();
                            resultado.idRegistro = -1;
                            resultado.mensaje = "RepositoryCreate " + e.Message;
                        }
                    }
                }
            }

            catch (Exception e)
            {
                resultado.idRegistro = -1;
                resultado.mensaje = "RepositoryCreate " + e.Message;
            }
            return resultado;
        }
        public ResultadoTransaction<string> DeleteAlumno(int id)
        {
            ResultadoTransaction<string> resultado = new ResultadoTransaction<string>();
            try
            {
                using(SqlConnection con= _conexion.GetConnection())
                {
                    con.Open();

                    using(SqlTransaction transaction = con.BeginTransaction())
                    {
                        try
                        {
                            using(SqlCommand cmd= new SqlCommand(USP_ALUMNO_DELETE, con, transaction))
                            {
                                cmd.CommandType = CommandType.StoredProcedure;
                                cmd.Parameters.AddWithValue("@idAlumno", id);
                                cmd.Parameters.Add("@value", SqlDbType.Int, 11).Direction = ParameterDirection.Output;
                                cmd.Parameters.Add("@mensaje",SqlDbType.VarChar , 200).Direction = ParameterDirection.Output;
                                cmd.ExecuteNonQuery();

                                int exito = Convert.ToInt32(cmd.Parameters["@value"].Value.ToString());
                                resultado.value = exito ==1 ? true : false;
                                resultado.mensaje = cmd.Parameters["@mensaje"].Value.ToString();
                                resultado.idRegistro = 0;
                                transaction.Commit();
                                transaction.Dispose();

                            }

                        }catch(Exception e)
                        {
                            transaction.Rollback();
                            resultado.idRegistro = -1;
                            resultado.mensaje = e.Message;
                        } 
                    }

                }
            }catch(Exception e)
            {
                resultado.idRegistro = -1;
                resultado.mensaje = e.Message;
            }
            return resultado;
        }
        public ResultadoTransaction<Alumno> ListarAlumnoXID(int id)
        {
            ResultadoTransaction<Alumno> resultado = new ResultadoTransaction<Alumno>();

            try
            {
                using (SqlConnection con = _conexion.GetConnection())
                {
                    con.Open();
                    using (SqlCommand cmd = new SqlCommand(USP_ALUMNO_LISTAR, con))
                    {
                        cmd.CommandType = CommandType.StoredProcedure;
                        cmd.Parameters.AddWithValue("@idAlumno", id);
                        cmd.Parameters.AddWithValue("@flgListar", 2);

                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            if (reader.Read())
                            {
                                Alumno a = new Alumno()
                                {
                                    idAlumno = Convert.ToInt32(reader["idAlumno"].ToString()),
                                    apellido = reader["apellido"].ToString(),
                                    fechaNacimiento = Convert.ToDateTime(reader["fechaNacimiento"].ToString()),
                                    nombre = reader["nombre"].ToString(),
                                    nroDocumento = reader["nroDocumento"].ToString()
                                    
                                };
                                resultado.data = a;
                                
                            }
                            resultado.value = true;
                            resultado.mensaje = "Se lito el alumno x id Correctamente";
                            resultado.idRegistro = 0;
                        }

                    }
                }
            }
            catch (Exception e)
            {
                resultado.idRegistro = -1;
                resultado.mensaje = "RepositorioList " + e.Message;
            }

            return resultado;
        }
        public ResultadoTransaction<string> UpdateAlumno(Alumno alumno)
        {
            ResultadoTransaction<string> resultado = new ResultadoTransaction<string>();

            try
            {
                using (SqlConnection con = _conexion.GetConnection())
                {
                    con.Open();
                    using(SqlTransaction transaction= con.BeginTransaction())
                    {
                        try
                        {
                            using (SqlCommand cmd= new SqlCommand(USP_ALUMNO_UPDATE , con, transaction))
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

                                int exito = Convert.ToInt32(cmd.Parameters["@value"].Value.ToString());
                                resultado.value = exito == 1 ? true : false;
                                resultado.mensaje = cmd.Parameters["@mensaje"].Value.ToString();
                                resultado.idRegistro = 0;
                                transaction.Commit();
                                transaction.Dispose();

                            }
                        }catch(Exception e)
                        {
                            transaction.Rollback();
                            resultado.idRegistro = -1;
                            resultado.mensaje = e.Message;
                        }
                    }
                }
            }
            catch(Exception e)
            {
                resultado.idRegistro = -1;
                resultado.mensaje = e.Message;
            }

                return resultado;
        }
    }
}
