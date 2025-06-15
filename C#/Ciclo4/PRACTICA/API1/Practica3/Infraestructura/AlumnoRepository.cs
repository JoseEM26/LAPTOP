using System.Data;
using Dominio.Identity;
using Dominio.Interfazes;
using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Diagnostics;

namespace Infraestructura
{
    public class AlumnoRepository : IAlumnoRepository
    {
        private readonly ConexionBD _conexion;

        public AlumnoRepository(ConexionBD conexion)
        {
            _conexion = conexion;
        }

        private readonly string USP_ALUMNO_CREATE = "usp_Alumno_Insert"; 
        private readonly string USP_ALUMNO_ELIMINAR = "";
        private readonly string USP_ALUMNO_LISTAR = "usp_Alumno_Lista";
        private readonly string USP_ALUMNO_ACTUALIZAR = "";

        public ResultadoTransaction<string> CreateAlumno(Alumno alumno)
        {
            ResultadoTransaction<string> resultado = new ResultadoTransaction<string>();

            using (SqlConnection con = _conexion.GetConnection())
            {
                con.Open();
                using(SqlTransaction transaction = con.BeginTransaction())
                {
                    try
                    {
                        using (SqlCommand cmd = new SqlCommand(USP_ALUMNO_CREATE, con,transaction))
                        {
                            cmd.CommandType = CommandType.StoredProcedure;
                            cmd.Parameters.AddWithValue("@Nombre", alumno.nombre);
                            cmd.Parameters.AddWithValue("@Apellidos", alumno.apellidos);
                            cmd.Parameters.AddWithValue("@NroDocumento", alumno.nroDocumento);
                            cmd.Parameters.AddWithValue("@FechNacimiento", alumno.fechaNacimiento);
                            cmd.Parameters.Add("@Mensaje", SqlDbType.VarChar, 200).Direction = ParameterDirection.Output;
                            cmd.Parameters.Add("@Exito", SqlDbType.Int , 11).Direction = ParameterDirection.Output;
                            cmd.ExecuteNonQuery();

                            int exito = Convert.ToInt32(cmd.Parameters["@Exito"].Value.ToString());
                            resultado.value = exito == 1 ? true : false;
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
                        resultado.mensaje = e.Message;
                        Debug.WriteLine("Ocurrio un problema en Create");
                    }
                }
            }

            return resultado;
        }

        public ResultadoTransaction<string> DeleteAlumno(int id)
        {
            throw new NotImplementedException();
        }

        public ResultadoTransaction<Alumno> ListarAlumno()
        {
            ResultadoTransaction<Alumno> resultado = new ResultadoTransaction<Alumno>();

            using (SqlConnection con= _conexion.GetConnection())
            {
                con.Open();
                using(SqlCommand cmd= new SqlCommand(USP_ALUMNO_LISTAR, con))
                {
                    cmd.CommandType =CommandType.StoredProcedure;
                    cmd.Parameters.AddWithValue("@flgOrden", 1);
                    cmd.Parameters.AddWithValue("@idAlumno", 0);

                    using(SqlDataReader reader= cmd.ExecuteReader())
                    {
                        List<Alumno> lista = new List<Alumno>();
                        while (reader.Read())
                        {
                            Alumno alumno = new Alumno()
                            {
                                idAlumno = Convert.ToInt32(reader["idAlumno"].ToString()),
                                fechaNacimiento = Convert.ToDateTime(reader["fechaNacimiento"].ToString()),
                                nroDocumento = reader["nroDocumento"].ToString(),
                                nombre = reader["nombre"].ToString(),
                                apellidos = reader["apellido"].ToString()

                            };
                            lista.Add(alumno);
                        }
                        resultado.dataList = lista;
                        resultado.value = true;
                        resultado.mensaje = "Se listo Correctament";
                        resultado.idRegistro = 0;

                    }

                }
            }

                return resultado;
        }

        public ResultadoTransaction<Alumno> ListarAlumnoXID(int id)
        {
            throw new NotImplementedException();
        }

        public ResultadoTransaction<string> UpdateAlumno(Alumno alumno)
        {
            throw new NotImplementedException();
        }
    }
}
