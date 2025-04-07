using Dominio.Entidad;
using Dominio.Interfaz;
using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;

namespace Infraestructura
{
    public class AlumnoRepositorio : IAlumnoRepositorio
    {
        private readonly ConecctionSQL _conexion;

        public AlumnoRepositorio(ConecctionSQL conexion)
        {
            _conexion = conexion;
        }

        public readonly string USP_ALUMNO_CREATE = "";
        public readonly string USP_ALUMNO_ELIMINAR = "";
        public readonly string USP_ALUMNO_LISTAR = "";
        public readonly string USP_ALUMNO_ACTUALIZAR = "";


        public ResultadoTransaction<string> AgregarAlumno(Alumno alumno)
        {
            ResultadoTransaction<String> resultado = new ResultadoTransaction<string>();

            try
            {
                using (SqlConnection con = _conexion.AplyConnection())
                {
                    con.Open();
                    using (SqlTransaction transaction = con.BeginTransaction())
                    {
                        try
                        {
                            using (SqlCommand cmd = new SqlCommand(USP_ALUMNO_CREATE, con, transaction))
                            {
                                cmd.CommandType = CommandType.StoredProcedure;
                                cmd.Parameters.AddWithValue("@nombre", alumno.nombre);
                                cmd.Parameters.AddWithValue("@apellido", alumno.apellido);
                                cmd.Parameters.AddWithValue("@nroDocumento", alumno.nroDocumento);
                                cmd.Parameters.AddWithValue("@fechaNacimiento", alumno.fechaNacimiento);
                                cmd.Parameters.Add("@value", SqlDbType.Int, 11).Direction = ParameterDirection.Input;
                                cmd.Parameters.Add("@mensaje", SqlDbType.VarChar, 200).Direction = ParameterDirection.Input;
                                cmd.ExecuteNonQuery();

                                resultado.mensaje = cmd.Parameters["@mensaje"].Value.ToString();
                                resultado.value = Convert.ToInt32(cmd.Parameters["@value"].Value.ToString()) == 1 ? true : false;
                            }
                        }
                        catch (Exception e)
                        {
                            transaction.Rollback();
                            resultado.mensaje = "Ocurrio un error Agregar PROC";
                            resultado.idResultado = -1;
                        }
                    }

                }
            }catch(Exception e)
            {
                resultado.mensaje = "Ocurrio un error Agregar Connexion";
                resultado.idResultado = -1;
            }

            return resultado;
        }
        public ResultadoTransaction<string> ActualizarAlumno(Alumno alumno)
        {
            throw new NotImplementedException();
        }


        public ResultadoTransaction<string> EliminarAlumno(int id)
        {
            throw new NotImplementedException();
        }

        public ResultadoTransaction<Alumno> ListarAlumnos()
        {
            ResultadoTransaction<Alumno> resultado = new ResultadoTransaction<Alumno>();

            try
            {
                using (SqlConnection con = _conexion.AplyConnection())
                {
                    con.Open();
                    
                        try
                        {
                            using (SqlCommand cmd = new SqlCommand(USP_ALUMNO_LISTAR, con))
                            {
                                cmd.CommandType = CommandType.StoredProcedure;
                                cmd.Parameters.AddWithValue("@flgListar", 1);
                                cmd.Parameters.AddWithValue("@idAlumno", 0);
                                cmd.Parameters.Add("@value", SqlDbType.Int, 11).Direction = ParameterDirection.Input;
                                cmd.Parameters.Add("@mensaje", SqlDbType.VarChar, 200).Direction = ParameterDirection.Input;

                            using (SqlDataReader reader = cmd.ExecuteReader())
                            {
                                List<Alumno> lista = new List<Alumno>();
                                while (reader.Read())
                                {
                                    Alumno alumno = new Alumno();
                                    alumno.idAlumno = Convert.ToInt32(reader["idAlumno"].ToString());
                                    alumno.nroDocumento = Convert.ToInt32(reader["nroDocumento"].ToString());
                                    alumno.fechaNacimiento = Convert.ToDateTime(reader["fechaNacimiento"].ToString());
                                    alumno.nombre = reader["nombre"].ToString();
                                    alumno.apellido = reader["apellido"].ToString();
                                    lista.Add(alumno);

                                }
                                resultado.ListData = lista;
                                resultado.mensaje = cmd.Parameters["@mensaje"].Value.ToString();
                                resultado.value = Convert.ToInt32(cmd.Parameters["@value"].Value.ToString()) == 1 ? true : false;
                            }
                               
                            }
                        }
                        catch (Exception e)
                        {
                            resultado.mensaje = "Ocurrio un error Agregar PROC";
                            resultado.idResultado = -1;
                        }
                    }

                
            }
            catch (Exception e)
            {
                resultado.mensaje = "Ocurrio un error Agregar Connexion";
                resultado.idResultado = -1;
            }

            return resultado;
        }

        public ResultadoTransaction<Alumno> Listar_x_id(int id)
        {
            throw new NotImplementedException();
        }
    }
}
