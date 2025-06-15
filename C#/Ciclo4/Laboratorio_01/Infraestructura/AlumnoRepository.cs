using Dominio.Entity;
using Dominio.Intefazes;
using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Data;
using System.Text;
using System.Threading.Tasks;

namespace Infraestructura
{
    public class AlumnoRepository : IAlumnoRepositorio
    {
        //IniciacionDeConexion
        private readonly ConexionBD _conexion;

        public AlumnoRepository(ConexionBD connectionBD)
        {
            _conexion = connectionBD;
        }

        //ReferenciaProcesoAlmacenamiento
        private readonly string SP_INSERTAR_ALUMNO = "usp_alumno_insert";
        private readonly string SP_ACTUALIZAR_ALUMNO = "usp_alumno_actualizar";
        private readonly string SP_ELIMINAR_ALUMNO = "usp_alumno_Eliminar";
        private readonly string SP_ALUMNO_BUSCAR = "usp_alumno_lista";



        public ResultadoTransaction<string> AgregarAlumno(Alumno alumno)
        {
            ResultadoTransaction<string> resultado = new ResultadoTransaction<string>();
            try
            {
                using (SqlConnection con= _conexion.abrirConnection())
                {
                    con.Open();
                    using (SqlTransaction transaction = con.BeginTransaction())
                    {
                        try
                        {
                            using (SqlCommand cmd = new SqlCommand(SP_INSERTAR_ALUMNO ,con , transaction))
                            {
                                cmd.CommandType = CommandType.StoredProcedure;
                                cmd.Parameters.AddWithValue("@nombre", alumno.nombre);
                                cmd.Parameters.AddWithValue("@apellido", alumno.apellido);
                                cmd.Parameters.AddWithValue("@nroDocumento", alumno.nroDocumento);
                                cmd.Parameters.AddWithValue("@fechaNacimiento", alumno.fechaNacimiento);
                                cmd.Parameters.Add("@exito" , SqlDbType.Int , 11 ).Direction= ParameterDirection.Output;
                                cmd.Parameters.Add("@mensaje", SqlDbType.VarChar, 200).Direction = ParameterDirection.Output;
                                cmd.ExecuteNonQuery();

                                string mensaje = cmd.Parameters["@mensaje"].Value.ToString();
                                int exito = Convert.ToInt32(cmd.Parameters["@exito"].Value.ToString());

                                resultado.idRegistro = 0;
                                resultado.mensaje = mensaje;
                                resultado.value = (exito == 1 ) ? true :false ;

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
        public ResultadoTransaction<string> ActualizarAlumno(Alumno alumno)
        {
            ResultadoTransaction<String> resultado = new ResultadoTransaction<string>;
            try { 
               using(SqlConnection con= _conexion.abrirConnection())
                {
                    con.Open();
                    using(SqlTransaction transaction = con.BeginTransaction())
                    {
                        try
                        {
                            using (SqlCommand cmd = new SqlCommand(SP_ACTUALIZAR_ALUMNO, con, transaction))
                            {
                                cmd.CommandType = CommandType.StoredProcedure;
                                cmd.Parameters.AddWithValue("@idAlumno", alumno.idAlumno);
                                cmd.Parameters.AddWithValue("@nombre", alumno.nombre);
                                cmd.Parameters.AddWithValue("@apellido", alumno.apellido);
                                cmd.Parameters.AddWithValue("@nroDocumento", alumno.nroDocumento);
                                cmd.Parameters.AddWithValue("@fechaNacimiento", alumno.fechaNacimiento);
                                cmd.Parameters.Add("@exito", SqlDbType.Int, 11).Direction = ParameterDirection.Output;
                                cmd.Parameters.Add("@mensaje", SqlDbType.VarChar, 200).Direction = ParameterDirection.Output;

                                cmd.ExecuteNonQuery();

                                resultado.idRegistro = 0;
                                resultado.mensaje = cmd.Parameters["@mensaje"].ToString();
                                resultado.value = (Convert.ToInt32(cmd.Parameters["@value"].ToString()) == 0) ? true : false;
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

        public ResultadoTransaction<string> EliminarAlumno(int id)
        {
            ResultadoTransaction<string> resultado = new ResultadoTransaction<string>();
            try
            {
                using(SqlConnection con = _conexion.abrirConnection())
                {
                    con.Open();
                    using(SqlTransaction tran= con.BeginTransaction())
                    {
                        try
                        {
                            using(SqlCommand cmd= new SqlCommand(SP_ELIMINAR_ALUMNO , con, tran))
                            {
                                cmd.CommandType = CommandType.StoredProcedure;
                                cmd.Parameters.AddWithValue("@idAlumno", id);
                                cmd.Parameters.Add("@mensaje", SqlDbType.VarChar, 200).Direction = ParameterDirection.Output;
                                cmd.Parameters.Add("@exito", SqlDbType.Int,11).Direction = ParameterDirection.Output;
                                cmd.ExecuteNonQuery();

                                int exito = Convert.ToInt32(cmd.Parameters["@exito"].Value.ToString());
                                resultado.idRegistro = 0;
                                resultado.mensaje = cmd.Parameters["@mensaje"].Value.ToString();
                                resultado.value =exito == 0?true :false;
                                tran.Commit();
                                tran.Dispose();
                            }
                        }catch(Exception e)
                        {
                            resultado.idRegistro = -1;
                            resultado.mensaje = e.Message;
                            tran.Rollback();
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

        public ResultadoTransaction<Alumno> ListarTodo()
        {
            ResultadoTransaction<Alumno> resultado = new ResultadoTransaction<Alumno>();

            try
            {
                using(SqlConnection con= _conexion.abrirConnection())
                {
                    con.Open();
                    using(SqlCommand cmd= new SqlCommand(SP_ALUMNO_BUSCAR , con))
                    {
                        try
                        {
                            cmd.CommandType = CommandType.StoredProcedure;
                            cmd.Parameters.AddWithValue("@flgorden",1);
                            cmd.Parameters.AddWithValue("@idAlumno", 0);

                            using(SqlDataReader reader= cmd.ExecuteReader())
                            {
                                List<Alumno> lista = new List<Alumno>();
                                while (reader.Read())
                                {
                                    Alumno alumno = new Alumno();
                                    alumno.idAlumno = Convert.ToInt32(reader["idAlumno"].ToString());
                                    alumno.nombre = reader["nombre"].ToString();
                                    alumno.apellido = reader["apellido"].ToString();
                                    alumno.nroDocumento = reader["nroDocumento"].ToString();
                                    alumno.fechaNacimiento = Convert.ToDateTime(reader["fechaNacimiento"].ToString());

                                    lista.Add(alumno);
                                }

                                resultado.idRegistro = 0;
                                resultado.mensaje = "OK";
                                resultado.dataList = lista;
                            }


                        }catch(Exception e)
                        {
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

        public ResultadoTransaction<Alumno> ListarXid(int id)
        {
            ResultadoTransaction<Alumno> Alumno = new ResultadoTransaction<Alumno>;
            using (SqlConnection con= _conexion.abrirConnection())
            {
                con.Open();
                try
                {
                    using (SqlCommand cmd = new SqlCommand(SP_ALUMNO_BUSCAR, con))
                    {
                        cmd.CommandType = CommandType.StoredProcedure;
                        cmd.Parameters.AddWithValue("@flgorden", 2);
                        cmd.Parameters.AddWithValue("@idAlumno", id);
                        cmd.Parameters.Add("@exito", SqlDbType.Int, 11).Direction = ParameterDirection.Output;
                        cmd.Parameters.Add("@mensaje", SqlDbType.VarChar, 200).Direction = ParameterDirection.Output;

                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            if (reader.Read())
                            {
                                Alumno a = new Alumno();
                                a.nombre = reader["nombre"].ToString();
                                a.apellido = reader["apellido"].ToString();
                                a.nroDocumento = reader["nroDocumento"].ToString();
                                a.fechaNacimiento = Convert.ToDateTime(reader["fechaNacimiento"].ToString());
                                a.idAlumno = Convert.ToInt32(reader["idAlumno"].ToString());

                                int exito = Convert.ToInt32(cmd.Parameters["@exito"].Value.ToString());

                                Alumno.data = a;
                                Alumno.idRegistro = 0;
                                Alumno.value = exito == 0 ? true :false ;
                                Alumno.mensaje = cmd.Parameters["@mensaje"].Value.ToString();
                            }
                        }
                    }
                }
                catch(Exception e)
                {
                    Alumno.idRegistro=-1;
                    Alumno.mensaje = e.Message;
                }
            }
            return Alumno;
        }
        
    }
}
