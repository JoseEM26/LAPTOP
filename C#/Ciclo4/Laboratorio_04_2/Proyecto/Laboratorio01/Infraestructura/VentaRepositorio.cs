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

        public Task<ResultadoTransaccion<string>> Editar_Venta(Venta objventa)
        {
            throw new NotImplementedException();
        }

        public Task<ResultadoTransaccion<string>> Eliminar_Venta(Venta objventa)
        {
            throw new NotImplementedException();
        }

        public Task<ResultadoTransaccion<Venta>> Listar_ventas()
        {
            throw new NotImplementedException();
        }

        public Task<ResultadoTransaccion<Venta>> Listar_X_ID(int Idventa)
        {
            throw new NotImplementedException();
        }

       
    }
}
