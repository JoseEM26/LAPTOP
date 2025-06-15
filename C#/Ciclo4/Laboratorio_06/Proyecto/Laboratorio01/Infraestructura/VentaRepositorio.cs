using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Dominio.Entidades;
using Dominio.Interfaces;
using Microsoft.Data.SqlClient;
using System.Data;

namespace Infraestructura
{
    public class VentaRepositorio : IVentaRepositorio
    {
        private ConexionBD conexionBD;
        public VentaRepositorio(ConexionBD conexionBD)
        {
            this.conexionBD = conexionBD;
        }
        //Definimos  nuestros procesos almacenados.
        private readonly string SP_Venta_CAB_Insert = "usp_venta_insert";
        private readonly string SP_Venta_DET_Insert = "usp_venta_Det_insert";
        private readonly string SP_Venta_Listar = "usp_ventas_listar";
        readonly string SP_Venta_cab_Update = "usp_ventacab_update";
        readonly string SP_Venta_det_Update = "usp_venta_det_update";
        readonly string SP_Venta_det_Delete = "usp_venta_det_delete";

        public async Task<ResultadoTransaccion<string>> Registrar_Venta(Venta objventa)
        {
            ResultadoTransaccion<string> resultado = new ResultadoTransaccion<string>();
            try {               
                using (SqlConnection cnn = conexionBD.AbrirConexion()) 
                {
                    cnn.Open();
                    using (SqlTransaction transaction = cnn.BeginTransaction()) 
                    {
                        try 
                        {
                            int Idventa = 0;
                            using (SqlCommand cmd = new SqlCommand(SP_Venta_CAB_Insert, cnn, transaction)) 
                            {
                                cmd.CommandType = CommandType.StoredProcedure;
                                cmd.Parameters.AddWithValue("@Cliente", objventa.cliente);
                                cmd.Parameters.AddWithValue("@Nrodocumento", objventa.nrodocumento);
                                cmd.Parameters.AddWithValue("@Fechaventa", objventa.fechaventa);
                                cmd.Parameters.AddWithValue("@Subtotal", objventa.subtotal);
                                cmd.Parameters.AddWithValue("@Igv", objventa.igv);
                                cmd.Parameters.AddWithValue("@Total", objventa.total);
                                cmd.Parameters.Add("@IdVenta", SqlDbType.Int, 11).Direction = ParameterDirection.Output;
                                await cmd.ExecuteNonQueryAsync();

                                Idventa = Convert.ToInt32(cmd.Parameters["@IdVenta"].Value.ToString());
                                if (Idventa > 0)
                                {
                                    foreach(var item in objventa.Listadetalle)
                                    {
                                        var registrodetalle = await Registrar_Venta_Detalle(item, Idventa, cnn, transaction );
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
                            resultado.Mensaje = "Se ha registrado la venta Nro: " + Idventa.ToString();
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

        private async Task<ResultadoTransaccion<string>> Registrar_Venta_Detalle(ventaDet item, int idventa, SqlConnection cnn, SqlTransaction transaction)
        {
            ResultadoTransaccion<string> resultado = new ResultadoTransaccion<string>();
            try 
            {
                using (SqlCommand cmd = new SqlCommand(SP_Venta_DET_Insert, cnn, transaction)) 
                {
                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.Parameters.AddWithValue("@Idventa", idventa);
                    cmd.Parameters.AddWithValue("@Producto", item.Producto);
                    cmd.Parameters.AddWithValue("@Cantidad", item.cantidad);
                    cmd.Parameters.AddWithValue("@Precio", item.precio);
                    cmd.Parameters.AddWithValue("@Subtotal", item.subtotal);
                    cmd.Parameters.AddWithValue("@Igv", item.igv);
                    cmd.Parameters.AddWithValue("@Total", item.total);
                    await cmd.ExecuteNonQueryAsync();
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

        public async Task<ResultadoTransaccion<string>> Editar_Venta(Venta objventa)
        {
            ResultadoTransaccion<string> resultado = new ResultadoTransaccion<string>();
            try {
                using (SqlConnection cnn = conexionBD.AbrirConexion()) 
                {
                    cnn.Open();
                    using (SqlTransaction transaction = cnn.BeginTransaction()) 
                    {
                        /*Para actualizar cabecera*/
                        using (SqlCommand cmd = new SqlCommand(SP_Venta_cab_Update , cnn, transaction)) 
                        {
                            cmd.CommandType = CommandType.StoredProcedure;
                            cmd.Parameters.AddWithValue("@Idventa", objventa.Idventa);
                            cmd.Parameters.AddWithValue("@Subtotal",objventa.subtotal);
                            cmd.Parameters.AddWithValue("@Igv", objventa.igv);
                            cmd.Parameters.AddWithValue("@Total", objventa.total);
                            await cmd.ExecuteNonQueryAsync();
                        }

                        /*OPERACIONES*/
                        var ListaInserta = objventa.Listadetalle.Where(w=>w.IdventaDet == 0 && w.flgEliminado == false).ToList();
                        if(ListaInserta.Count > 0)
                        {
                            foreach (var item in ListaInserta) 
                            {
                                var resultaInserta = await Registrar_Venta_Detalle(item, objventa.Idventa, cnn, transaction);
                                if (resultaInserta.IdRegistro == -1) 
                                {
                                    transaction.Rollback();
                                    resultado.IdRegistro = -1;
                                    resultado.Mensaje = resultaInserta.Mensaje;
                                    return resultado;
                                }
                            }
                        }

                        var ListaActualiza = objventa.Listadetalle.Where(w=> w.flgActualiza == true && w.flgEliminado == false && w.IdventaDet > 0).ToList();
                        if (ListaActualiza.Count > 0) 
                        {
                            foreach (var item in ListaActualiza) 
                            {
                                var resultadoActualiza = await Actualizar_venta_Detalle(item, cnn, transaction);
                                if (resultadoActualiza.IdRegistro == -1) 
                                {
                                    transaction.Rollback();
                                    resultado.IdRegistro = -1;
                                    resultado.Mensaje = resultadoActualiza.Mensaje;
                                    return resultado;
                                }
                            }
                        }

                        var ListaElimina = objventa.Listadetalle.Where(w=>w.flgEliminado == true && w.IdventaDet > 0).ToList();
                        if (ListaElimina.Count > 0) 
                        {
                            foreach (var item in ListaElimina) 
                            {
                                var resultadoElimina = await Eliminar_Venta_Detalle(item, cnn, transaction);
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

		private async Task<ResultadoTransaccion<string>> Eliminar_Venta_Detalle(ventaDet item, SqlConnection cnn, SqlTransaction transaction)
		{
			ResultadoTransaccion<string> resultado = new ResultadoTransaccion<string>();
			try
			{
				using (SqlCommand cmd = new SqlCommand(SP_Venta_det_Delete, cnn, transaction))
				{
					cmd.CommandType = CommandType.StoredProcedure;
					cmd.Parameters.AddWithValue("@IdventaDet", item.IdventaDet);					 
					await cmd.ExecuteNonQueryAsync();

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

		private async Task<ResultadoTransaccion<string>> Actualizar_venta_Detalle(ventaDet item, SqlConnection cnn, SqlTransaction transaction)
		{
			ResultadoTransaccion<string> resultado = new ResultadoTransaccion<string>();
            try 
            {
                using (SqlCommand cmd = new SqlCommand(SP_Venta_det_Update, cnn, transaction)) 
                {
                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.Parameters.AddWithValue("@IdventaDet", item.IdventaDet);
                    cmd.Parameters.AddWithValue("@Cantidad", item.cantidad);
                    cmd.Parameters.AddWithValue("@Precio", item.precio);
                    cmd.Parameters.AddWithValue("@Subtotal", item.subtotal);
                    cmd.Parameters.AddWithValue("@Igv", item.igv);
                    cmd.Parameters.AddWithValue("@Total", item.total);
                    await cmd.ExecuteNonQueryAsync();

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

		public Task<ResultadoTransaccion<string>> Eliminar_Venta(Venta objventa)
        {
            throw new NotImplementedException();
        }

        public async Task<ResultadoTransaccion<Venta>> Listar_ventas()
        {
			ResultadoTransaccion<Venta> resultado = new ResultadoTransaccion<Venta>();
			try
			{
				using (SqlConnection cnn = conexionBD.AbrirConexion())
				{
					cnn.Open();
					using (SqlCommand cmd = new SqlCommand(SP_Venta_Listar, cnn))
					{
						try
						{
							cmd.CommandType = CommandType.StoredProcedure;
							cmd.Parameters.AddWithValue("@flgorden", 1);
							cmd.Parameters.AddWithValue("@buscar", "");
							cmd.Parameters.AddWithValue("@Idventa", 0);
                            List<Venta> Listadoventa = new List<Venta>();
							
 
							using (SqlDataReader reader = await cmd.ExecuteReaderAsync())
							{
								while (reader.Read())
								{
									Venta objventa = new Venta();
									objventa.Idventa = Convert.ToInt32(reader["IdVenta"].ToString());
									objventa.cliente = reader["Cliente"].ToString();
									objventa.nrodocumento = reader["Nrodocumento"].ToString();
									objventa.fechaventa = Convert.ToDateTime(reader["FechaVenta"].ToString());
                                    objventa.subtotal = Convert.ToDouble(reader["Subtotal"].ToString());
                                    objventa.igv = Convert.ToDouble(reader["Igv"].ToString());
                                    objventa.total = Convert.ToDouble(reader["Total"].ToString());
                                    objventa.Listadetalle = new List<ventaDet>();
                                    Listadoventa.Add(objventa);
								}
							}

							resultado.IdRegistro = 0;
							resultado.Mensaje = "ok";
							resultado.DataList = Listadoventa;
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

        public async Task<ResultadoTransaccion<Venta>> Listar_X_ID(int Idventa)
        {
            ResultadoTransaccion<Venta> resultado = new ResultadoTransaccion<Venta>();
            try
            {
                using (SqlConnection cnn = conexionBD.AbrirConexion()) 
                {
                    cnn.Open();
                    using (SqlCommand cmd = new SqlCommand(SP_Venta_Listar, cnn)) 
                    {
                        try 
                        {
                            cmd.CommandType = CommandType.StoredProcedure;
                            cmd.Parameters.AddWithValue("@flgorden", 2);
                            cmd.Parameters.AddWithValue("@buscar", "");
                            cmd.Parameters.AddWithValue("@Idventa", Idventa);
                            
                            Venta objventa = new Venta();
                            objventa.Listadetalle = new List<ventaDet>();

                            using (SqlDataReader reader = await cmd.ExecuteReaderAsync()) 
                            {
                                if (reader.Read()) 
                                {
                                    objventa.Idventa = Convert.ToInt32(reader["IdVenta"].ToString());
                                    objventa.cliente = reader["Cliente"].ToString();
                                    objventa.nrodocumento = reader["Nrodocumento"].ToString();
                                    objventa.fechaventa = Convert.ToDateTime(reader["FechaVenta"].ToString());
									objventa.subtotal = Convert.ToDouble(reader["Subtotal"].ToString());
									objventa.igv = Convert.ToDouble(reader["Igv"].ToString());
									objventa.total = Convert.ToDouble(reader["Total"].ToString());
								}
                                //Lee el siguiente resultado
                                if (await reader.NextResultAsync()) 
                                {
                                    while (reader.Read())
                                    {
                                        ventaDet objventadet = new ventaDet();
                                        objventadet.IdventaDet = Convert.ToInt32(reader["IdVentaDet"].ToString());
                                        objventadet.Idventa = Convert.ToInt32(reader["Idventa"].ToString());
                                        objventadet.Producto = reader["Producto"].ToString();
										objventadet.cantidad = Convert.ToInt32(reader["Cantidad"].ToString());
										objventadet.precio = Convert.ToDouble(reader["Precio"].ToString());
										objventadet.subtotal = Convert.ToDouble(reader["Subtotal"].ToString());
										objventadet.igv = Convert.ToDouble(reader["Igv"].ToString());
										objventadet.total = Convert.ToDouble(reader["Total"].ToString());
										objventa.Listadetalle.Add(objventadet);
                                    }    
                                }
                            }

                            resultado.IdRegistro = 0;
                            resultado.Mensaje = "ok";
                            resultado.Data = objventa;
                        }
                        catch (Exception ex) 
                        {
							resultado.IdRegistro = -1;
							resultado.Mensaje = ex.Message;
						}
                    }
                }
            }
            catch(Exception ex) 
            {
                resultado.IdRegistro = -1;
                resultado.Mensaje = ex.Message;
            }
            return resultado;
        }

       
    }
}
