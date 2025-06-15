using Dominio.Identidad;
using Dominio.Interfaz;
using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Infraestructura
{
	public class AlumnoRepository : IAlumnoRepository
	{
		private readonly Conexion _conexion;

		public AlumnoRepository(Conexion conexion)
		{
			_conexion = conexion;
		}
		private readonly string USP_CREATE_ALUMNO = "USP_ALUMNO_INSERTAR";
		private readonly string USP_CREATE_CURSO = "USP_CURSO_INSERTAR";
		private readonly string USP_LISTAR = "USP_ALUMNO_LISTAR";
		readonly string USP_UPDATE_ALUMNO = "USP_ACTUALIZAR_ALUMNO";
		readonly string USP_UPDATE_CURSO = "USP_ACTUALIZAR_CURSO";
		readonly string USP_DELETE_ALUMNO = "USP_ALUMNO_DELETE";
		readonly string USP_DELETE_CURSO = "USP_CURSO_DELETE";

		public ResultadoTransaccion<Alumno> Listar_Alumno()
		{
			ResultadoTransaccion<Alumno> resultado = new ResultadoTransaccion<Alumno>();
			try
			{
				using (SqlConnection cnn = _conexion.getConexion())
				{
					cnn.Open();
					using (SqlCommand cmd = new SqlCommand(USP_LISTAR, cnn))
					{
						try
						{
							cmd.CommandType = CommandType.StoredProcedure;
							cmd.Parameters.AddWithValue("@idAlumno", 0);
							cmd.Parameters.AddWithValue("@flgListar",1 );
							List<Alumno> ListadoAlumno = new List<Alumno>();


							using (SqlDataReader reader = cmd.ExecuteReader())
							{
								while (reader.Read())
								{
									Alumno alumno = new Alumno();
									alumno.idAlumno = Convert.ToInt32(reader["idAlumno"].ToString());
									alumno.nombre = reader["nombre"].ToString();
									alumno.promedio =Convert.ToInt32(reader["promedio"].ToString());
									alumno.nroDocumento = Convert.ToString(reader["nroDocumento"].ToString());
									alumno.fecha = Convert.ToDateTime(reader["fecha"].ToString());
									alumno.ciclo = Convert.ToString(reader["ciclo"].ToString());
									alumno.listaCurso = new List<CursoAlumno>();
									ListadoAlumno.Add(alumno);
								}
							}

							resultado.IdRegistro = 0;
							resultado.Mensaje = "ok";
							resultado.DataList = ListadoAlumno;
						}
						catch (Exception ex)
						{
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

		public ResultadoTransaccion<string> Editar_Alumno(Alumno alumno)
		{
			ResultadoTransaccion<string> resultado = new ResultadoTransaccion<string>();
			try
			{
				using (SqlConnection cnn = _conexion.getConexion())
				{
					cnn.Open();
					using (SqlTransaction transaction = cnn.BeginTransaction())
					{
						/*Para actualizar cabecera*/
						using (SqlCommand cmd = new SqlCommand(USP_UPDATE_ALUMNO, cnn, transaction))
						{
							cmd.CommandType = CommandType.StoredProcedure;
							cmd.Parameters.AddWithValue("@idAlumno", alumno.idAlumno);
							cmd.Parameters.AddWithValue("@nombre", alumno.nombre);
							cmd.Parameters.AddWithValue("@nroDocumento", alumno.nroDocumento);
							cmd.Parameters.AddWithValue("@ciclo", alumno.ciclo);
							cmd.Parameters.AddWithValue("@promedio", alumno.promedio);
							cmd.ExecuteNonQuery();
						}

						/*OPERACIONES*/
						var ListaInserta = alumno.listaCurso.Where(w => w.idCursoAlumno == 0 && w.flgEliminado == false).ToList();
						if (ListaInserta.Count > 0)
						{
							foreach (var item in ListaInserta)
							{
								var resultaInserta = Registrar_Curso(item, alumno.idAlumno, cnn, transaction);
								if (resultaInserta.IdRegistro == -1)
								{
									transaction.Rollback();
									resultado.IdRegistro = -1;
									resultado.Mensaje = resultaInserta.Mensaje;
									return resultado;
								}
							}
						}

						var ListaActualiza = alumno.listaCurso.Where(w => w.flgActualiza == true && w.flgEliminado == false && w.idCursoAlumno > 0).ToList();
						if (ListaActualiza.Count > 0)
						{
							foreach (var item in ListaActualiza)
							{
								var resultadoActualiza = ActualizarCurso(item, cnn, transaction);
								if (resultadoActualiza.IdRegistro == -1)
								{
									transaction.Rollback();
									resultado.IdRegistro = -1;
									resultado.Mensaje = resultadoActualiza.Mensaje;
									return resultado;
								}
							}
						}

						var ListaElimina = alumno.listaCurso.Where(w => w.flgEliminado == true && w.idCursoAlumno > 0).ToList();
						if (ListaElimina.Count > 0)
						{
							foreach (var item in ListaElimina)
							{
								var resultadoElimina = EliminarCurso(item, cnn, transaction);
								if (resultadoElimina.IdRegistro == -1)
								{
									transaction.Rollback();
									resultado.IdRegistro = -1;
									resultado.Mensaje = resultadoElimina.Mensaje;
									return resultado;
								}
							}
						}

						transaction.Commit();
						transaction.Dispose();
						resultado.IdRegistro = 0;
						resultado.Mensaje = "Se ha actualizado el registro";
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
		private ResultadoTransaccion<string>ActualizarCurso(CursoAlumno item, SqlConnection cnn, SqlTransaction transaction)
		{
			ResultadoTransaccion<string> resultado = new ResultadoTransaccion<string>();
			try
			{
				using (SqlCommand cmd = new SqlCommand(USP_UPDATE_CURSO, cnn, transaction))
				{
					cmd.CommandType = CommandType.StoredProcedure;
					cmd.Parameters.AddWithValue("@idCursoAlumno", item.idCursoAlumno);
					cmd.Parameters.AddWithValue("@curso", item.curso);
					cmd.Parameters.AddWithValue("@nota", item.nota);
					cmd.Parameters.AddWithValue("@fechaActualizado", item.fechaActualizado);
					cmd.ExecuteNonQuery();

					resultado.IdRegistro = 0;
					resultado.Mensaje = "ok";
				}
			}
			catch (Exception ex)
			{
				resultado.IdRegistro = -1;
				resultado.Mensaje = ex.Message;
			}
			return resultado;
		}

		private ResultadoTransaccion<string> EliminarCurso(CursoAlumno item, SqlConnection cnn, SqlTransaction transaction)
		{
			ResultadoTransaccion<string> resultado = new ResultadoTransaccion<string>();
			try
			{
				using (SqlCommand cmd = new SqlCommand(USP_DELETE_CURSO, cnn, transaction))
				{
					cmd.CommandType = CommandType.StoredProcedure;
					cmd.Parameters.AddWithValue("@idCurso", item.idCursoAlumno);
					cmd.ExecuteNonQuery();

					resultado.IdRegistro = 0;
					resultado.Mensaje = "ok";
				}
			}
			catch (Exception ex)
			{
				resultado.IdRegistro = -1;
				resultado.Mensaje = ex.Message;
			}
			return resultado;
		}
		//public Task<ResultadoTransaccion<string>> Eliminar_Venta(Venta objventa)
		//{
		//	throw new NotImplementedException();
		//}
		public ResultadoTransaccion<string> Eliminar_Alumno(int id)
		{
			ResultadoTransaccion<string> resultado = new ResultadoTransaccion<string>();
			try
			{
				using (SqlConnection con = _conexion.getConexion())
				{
					con.Open();

					using (SqlTransaction transaction = con.BeginTransaction())
					{
						try
						{
							using (SqlCommand cmd = new SqlCommand(USP_DELETE_ALUMNO, con, transaction))
							{
								cmd.CommandType = CommandType.StoredProcedure;
								cmd.Parameters.AddWithValue("@idAlumno", id);
								cmd.ExecuteNonQuery();

								resultado.Mensaje="OK";
								resultado.IdRegistro = 0;
								transaction.Commit();
								transaction.Dispose();

							}

						}
						catch (Exception e)
						{
							transaction.Rollback();
							resultado.IdRegistro = -1;
							resultado.Mensaje = e.Message;
						}
					}

				}
			}
			catch (Exception e)
			{
				resultado.IdRegistro = -1;
				resultado.Mensaje = e.Message;
			}
			return resultado;
		}


		public ResultadoTransaccion<Alumno> Listar_X_ID(int idAlumno)
		{
			ResultadoTransaccion<Alumno> resultado = new ResultadoTransaccion<Alumno>();
			try
			{
				using (SqlConnection cnn = _conexion.getConexion())
				{
					cnn.Open();
					using (SqlCommand cmd = new SqlCommand(USP_LISTAR, cnn))
					{
						try
						{
							cmd.CommandType = CommandType.StoredProcedure;
							cmd.Parameters.AddWithValue("@flgListar", 2);
							cmd.Parameters.AddWithValue("@idAlumno", idAlumno);

							Alumno alumno = new Alumno();
							alumno.listaCurso = new List<CursoAlumno>();
							List<Alumno> listaAlumno = new List<Alumno>();

							using (SqlDataReader reader = cmd.ExecuteReader())
							{
								if (reader.Read())
								{
									alumno.idAlumno = Convert.ToInt32(reader["idAlumno"].ToString());
									alumno.nombre = reader["nombre"].ToString();
									alumno.nroDocumento = reader["nroDocumento"].ToString();
									alumno.fecha = Convert.ToDateTime(reader["fecha"].ToString());
									alumno.ciclo = Convert.ToString(reader["ciclo"].ToString());
									alumno.promedio = Convert.ToInt32(reader["promedio"].ToString());
								}
								//Lee el siguiente resultado
								if (reader.NextResult())
								{
									while (reader.Read())
									{
										CursoAlumno curso = new CursoAlumno();
										curso.idCursoAlumno = Convert.ToInt32(reader["idCursoAlumno"].ToString());
										curso.idAlumno = Convert.ToInt32(reader["idAlumno"].ToString());
										curso.curso = reader["curso"].ToString();
										curso.nota = Convert.ToInt32(reader["nota"].ToString());
										curso.fechaRegistro = Convert.ToDateTime(reader["fechaRegistro"].ToString());
										curso.fechaActualizado = reader["fechaActualizado"]!=DBNull.Value? Convert.ToDateTime(reader["fechaActualizado"].ToString()):null;
										alumno.listaCurso.Add(curso);
									}
								}
							}
							listaAlumno.Add(alumno);
							resultado.IdRegistro = 0;
							resultado.Mensaje = "ok";
							resultado.DataList = listaAlumno;
						}
						catch (Exception ex)
						{
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

		public ResultadoTransaccion<string> Registrar_Alumno(Alumno alumno)
		{
			ResultadoTransaccion<string> resultado = new ResultadoTransaccion<string>();
			try
			{
				using (SqlConnection cnn = _conexion.getConexion())
				{
					cnn.Open();
					using (SqlTransaction transaction = cnn.BeginTransaction())
					{
						try
						{
							int idAlumno = 0;
							using (SqlCommand cmd = new SqlCommand(USP_CREATE_ALUMNO, cnn, transaction))
							{
								cmd.CommandType = CommandType.StoredProcedure;
								cmd.Parameters.AddWithValue("@nombre", alumno.nombre);
								cmd.Parameters.AddWithValue("@nroDocumento", alumno.nroDocumento);
								cmd.Parameters.AddWithValue("@fecha", alumno.fecha);
								cmd.Parameters.AddWithValue("@ciclo", alumno.ciclo);
								cmd.Parameters.AddWithValue("@promedio", alumno.promedio);
								cmd.Parameters.Add("@idAlumno", SqlDbType.Int, 11).Direction = ParameterDirection.Output;
								 cmd.ExecuteNonQuery();

								idAlumno = Convert.ToInt32(cmd.Parameters["@idAlumno"].Value.ToString());
								if (idAlumno > 0)
								{
									foreach (var item in alumno.listaCurso)
									{
										var registrodetalle =  Registrar_Curso(item, idAlumno, cnn, transaction);
										if (registrodetalle.IdRegistro == -1)
										{
											transaction.Rollback();
											resultado.IdRegistro = -1;
											resultado.Mensaje = registrodetalle.Mensaje;
											return resultado;
										}
									}
								}
								else
								{
									transaction.Rollback();
									resultado.IdRegistro = -1;
									resultado.Mensaje = "No registro la venta cabecera";
								}
							}

							transaction.Commit();
							transaction.Dispose();
							resultado.IdRegistro = 0;
							resultado.Mensaje = "Se ha registrado la venta Nro: " + idAlumno.ToString();
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
		private ResultadoTransaccion<string> Registrar_Curso(CursoAlumno item, int idAlumno, SqlConnection cnn, SqlTransaction transaction)
		{
			ResultadoTransaccion<string> resultado = new ResultadoTransaccion<string>();
			try
			{
				using (SqlCommand cmd = new SqlCommand(USP_CREATE_CURSO, cnn, transaction))
				{
					cmd.CommandType = CommandType.StoredProcedure;
					cmd.Parameters.AddWithValue("@idAlumno", idAlumno);
					cmd.Parameters.AddWithValue("@curso", item.curso);
					cmd.Parameters.AddWithValue("@nota", item.nota);
					cmd.Parameters.AddWithValue("@fechaRegistro", item.fechaRegistro);
					cmd.ExecuteNonQuery();
					resultado.IdRegistro = 0;
					resultado.Mensaje = "OK";
				}
			}
			catch (Exception ex)
			{
				resultado.IdRegistro = -1;
				resultado.Mensaje = ex.Message;
			}
			return resultado;
		}
	}
}
