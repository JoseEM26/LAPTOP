using Dominio.Entidades;
using Dominio.Interfaces;
using Microsoft.Data.SqlClient;
using System.Data;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Infraestructura
{
    public class AlumnoRepositorio : IAlumnoRepositorio
    {
        //INSTANCIAMOS CONEXION
        private readonly ConexionBD _conexion;

        public AlumnoRepositorio(ConexionBD conexionBD) 
        {
            _conexion = conexionBD;
        }
        //
        //REFERENCIAS A PROCESOS ALMACENADOS
        private readonly string SP_INSERTAR_ALUMNO = "usp_Alumno_Insert";
        private readonly string SP_ACTUALIZAR_ALUMNO = "";
        private readonly string SP_ELIMINAR_ALUMNO = "";
        private readonly string SP_ALUMNO_BUSCAR = "usp_Alumno_Lista";
        //


        public ResultadoTransaccion<string> AgregarAlumno(Alumno objalumno)
        {
            ResultadoTransaccion<string> resultado = new ResultadoTransaccion<string>();
            try 
            {
                using (SqlConnection cnn = _conexion.AbrirConexion()) 
                {
                    cnn.Open();
                    using (SqlTransaction transaction = cnn.BeginTransaction()) 
                    {
                        try 
                        {
                            using (SqlCommand cmd = new SqlCommand(SP_INSERTAR_ALUMNO, cnn, transaction))
                            {
                                cmd.CommandType = CommandType.StoredProcedure;
                                cmd.Parameters.AddWithValue("@Nombre", objalumno.Nombre);
                                cmd.Parameters.AddWithValue("@Apellidos", objalumno.Apellidos);
                                cmd.Parameters.AddWithValue("@NroDocumento", objalumno.NroDocumento);
                                cmd.Parameters.AddWithValue("@FechNacimiento", objalumno.FechNacimiento);
                                cmd.Parameters.Add("@Exito", SqlDbType.Int, 11).Direction = ParameterDirection.Output;
                                cmd.Parameters.Add("@Mensaje", SqlDbType.VarChar, 200).Direction = ParameterDirection.Output;
                                cmd.ExecuteNonQuery();

                                string mensaje = cmd.Parameters["@Mensaje"].Value.ToString();
                                int exito = Convert.ToInt32(cmd.Parameters["@Exito"].Value.ToString());

                                resultado.IdRegistro = 0;
                                resultado.Mensaje = mensaje;
                                resultado.Value = (exito == 1) ? true : false;
                                transaction.Commit();
                                transaction.Dispose();
                            }
                        }
                        catch (Exception ex)
                        {
                            transaction.Rollback();
                            resultado.IdRegistro = -1;
                            resultado.Mensaje = ex.Message;
                        }
                    }
                }
            }
            catch (Exception ex) 
            {
                resultado.IdRegistro = -1;
                resultado.Mensaje = ex.Message;
            }
            return resultado;
        }

        public ResultadoTransaccion<string> ActualizarAlumno(Alumno objalumno)
        {
            throw new NotImplementedException();
        }

        public ResultadoTransaccion<string> EliminarAlumno(int Id)
        {
            throw new NotImplementedException();
        }

        public ResultadoTransaccion<Alumno> ListarAlumno()
        {
            ResultadoTransaccion<Alumno> resultado = new ResultadoTransaccion<Alumno>();
            try 
            {
                using (SqlConnection cnn = _conexion.AbrirConexion()) 
                {
                    cnn.Open();
                    using (SqlCommand cmd = new SqlCommand(SP_ALUMNO_BUSCAR, cnn)) 
                    {
                        try
                        {
                            cmd.CommandType = CommandType.StoredProcedure;
                            cmd.Parameters.AddWithValue("@flgorden", 1);
                            cmd.Parameters.AddWithValue("@IdAlumno", 0);
                            using (SqlDataReader reader = cmd.ExecuteReader())
                            {
                                List<Alumno> Listado = new List<Alumno>();
                                while (reader.Read())
                                {
                                    Alumno objalumno = new Alumno();
                                    objalumno.IdAlumno = Convert.ToInt32(reader["IdAlumno"].ToString());
                                    objalumno.Nombre = reader["Nombre"].ToString();
                                    objalumno.Apellidos = reader["Apellido"].ToString();
                                    objalumno.NroDocumento = reader["NroDocumento"].ToString();
                                    objalumno.FechNacimiento = Convert.ToDateTime(reader["Fechanacimiento"].ToString());
                                    Listado.Add(objalumno);
                                }

                                resultado.IdRegistro = 0;
                                resultado.Mensaje = "OK";
                                resultado.DataList = Listado;
                            }
                        }
                        catch (Exception ex)
                        {
                            resultado.IdRegistro = -1;
                            resultado.Mensaje = ex.Message;
                        }
                        finally {
                            cnn.Close();
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                resultado.IdRegistro = -1;
                resultado.Mensaje = ex.Message;
            }
            return resultado;
        }

        public ResultadoTransaccion<Alumno> ListarAlumnoXId(int Id)
        {
            throw new NotImplementedException();
        }
    }
}
