using System.Data;
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
    public class VentaRepositorio : IVentaRepositorio
    {
        private readonly Conexion _conexion;

        public VentaRepositorio(Conexion conexion)
        {
            _conexion = conexion;
        }
        private readonly string USP_VENTA_CREATE = "USP_VENTA_INSERTAR";
        private readonly string USP_VENTADETALLE_CREATE = "USP_VENTA_INSERTARDET";

        public async Task<ResultadoTransaction<string>> createVenta(Venta venta)
        {
            ResultadoTransaction<string> resultado = new ResultadoTransaction<string>();
            try
            {
                using(SqlConnection con= _conexion.GetConnection())
                {
                    con.Open();
                    using (SqlTransaction transaction = con.BeginTransaction())
                    {
                        try
                        {
                            using(SqlCommand cmd= new SqlCommand(USP_VENTA_CREATE, con, transaction))
                            {
                                cmd.CommandType = CommandType.StoredProcedure;
                                cmd.Parameters.AddWithValue("@cliente", venta.cliente);
                                cmd.Parameters.AddWithValue("@nroDocumento", venta.nroDocumento);
                                cmd.Parameters.AddWithValue("@fechaVenta", venta.fechaVenta);
                                cmd.Parameters.AddWithValue("@subTotal", venta.subTotal);
                                cmd.Parameters.AddWithValue("@igv", venta.igv);
                                cmd.Parameters.AddWithValue("@total", venta.total);
                                cmd.Parameters.Add("@idVenta", SqlDbType.Int,11).Direction=ParameterDirection.Output;
                                await  cmd.ExecuteNonQueryAsync();

                                var idVenta = Convert.ToInt32(cmd.Parameters["@idVenta"].Value.ToString());
                                if (idVenta > 0)
                                {
                                    foreach(var item in venta.ListaDetalle)
                                    {
                                        var registroDetalle = await RegistrarVentaDetalle(idVenta,con,transaction,item);
                                        if (registroDetalle.idRegistro == -1)
                                        {
                                            transaction.Rollback();
                                            resultado.idRegistro = -1;
                                            resultado.mensaje = "ERROR";
                                            return resultado;
                                        }
                                    }
                                }
                                else
                                {
                                    transaction.Rollback();
                                    resultado.idRegistro = -1;
                                    resultado.mensaje = "ERROR";
                                }

                                transaction.Commit();
                                transaction.Dispose();
                                resultado.idRegistro = 0;
                                resultado.mensaje = "OK";
                                resultado.value = true;
                                return resultado;
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

        private async Task<ResultadoTransaction<string>> RegistrarVentaDetalle(int idVenta, SqlConnection con, SqlTransaction transaction, VentaDet item)
        {
            ResultadoTransaction<string> resultado = new ResultadoTransaction<string>();

            try
            {
                using(SqlCommand cmd= new SqlCommand(USP_VENTADETALLE_CREATE,con,transaction))
                {
                    try
                    {
                        cmd.CommandType = CommandType.StoredProcedure;
                        cmd.Parameters.AddWithValue("@idVenta", idVenta);
                        cmd.Parameters.AddWithValue("@producto", item.producto);
                        cmd.Parameters.AddWithValue("@precio", item.precio);
                        cmd.Parameters.AddWithValue("@cantidad", item.cantidad);
                        cmd.Parameters.AddWithValue("@subTotal", item.subtotal);
                        cmd.Parameters.AddWithValue("@total", item.total);
                        cmd.Parameters.AddWithValue("@igv", item.igv);
                        await cmd.ExecuteNonQueryAsync();

                        resultado.idRegistro = 0;
                        resultado.mensaje = "OK";
                        resultado.value = true;
                    }catch(Exception e)
                    {
                        await transaction.RollbackAsync();
                        resultado.idRegistro = -1;
                        resultado.mensaje = e.Message;
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
