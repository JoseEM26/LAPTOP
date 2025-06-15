using Dominio.Identity;
using Dominio.Interfaz;
using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Infraestructura
{
    public class AlumnoRepository:IAlumnoTransaction
    {
        private readonly Conexion _conexion;

        public AlumnoRepository(Conexion conexion)
        {
            _conexion = conexion;
        }
        private readonly string USP_ALUMNO_CREATE = "USP_ALUMNO_CREATE";
        private readonly string USP_ALUMNO_LISTAR = "USP_ALUMNO_LISTAR";

        public ResultadoTransaction<string> CreateAlumno(Alumno a)
        {
            ResultadoTransaction<string> resultado = new ResultadoTransaction<string>();

            try
            {
                using (SqlConnection con = _conexion.GetConnextion())
                {
                    con.Open();
                    using (SqlTransaction transaction = con.BeginTransaction())
                    {
                        try
                        {
                            using(SqlCommand cmd= new SqlCommand(USP_ALUMNO_CREATE, con, transaction))
                            {
                                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                                cmd.Parameters.AddWithValue("@nombre", a.nombre);
                                cmd.Parameters.AddWithValue("@apellido", a.apellido);
                                cmd.Parameters.AddWithValue("@nroDocumento", a.nroDocumento);
                                cmd.Parameters.AddWithValue("@fechaNacimiento", a.fechaNacimiento);
                                cmd.Parameters.Add("@mensaje", System.Data.SqlDbType.VarChar, 200).Direction = System.Data.ParameterDirection.Output;
                                cmd.Parameters.Add("@value", System.Data.SqlDbType.Int, 11).Direction = System.Data.ParameterDirection.Output;
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
            }catch(Exception e)
            {
                resultado.idRegistro = -1;
                resultado.mensaje = e.Message;
            }

            return resultado;
        }

        public ResultadoTransaction<Alumno> ListarAlumno()
        {
            ResultadoTransaction<Alumno> resultado = new ResultadoTransaction<Alumno>();

            try
            {
                using(SqlConnection con= _conexion.GetConnextion())
                {
                    con.Open();
                    using(SqlCommand cmd= new SqlCommand(USP_ALUMNO_LISTAR,con))
                    {
                        cmd.CommandType = System.Data.CommandType.StoredProcedure;
                        cmd.Parameters.AddWithValue("@idAlumno", 0);
                        cmd.Parameters.AddWithValue("@flgListar", 1);
                        
                        using(SqlDataReader reader= cmd.ExecuteReader())
                        {
                            List<Alumno> lista = new List<Alumno>();

                            while (reader.Read())
                            {
                                Alumno alumno = new Alumno()
                                {
                                    apellido = reader["apellido"].ToString(),
                                    nombre = reader["nombre"].ToString(),
                                    nroDocumento = reader["nroDocumento"].ToString(),
                                    fechaNacimiento = Convert.ToDateTime(reader["fechaNacimiento"].ToString()),
                                    idAlumno = Convert.ToInt32(reader["idAlumno"].ToString())
                                };
                                lista.Add(alumno);
                            }
                            resultado.listData = lista;
                            resultado.value = true;
                            resultado.mensaje = "Se listo correctamente";
                            resultado.idRegistro = 0;
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
    }
}
