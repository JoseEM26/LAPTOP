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
        private readonly string USP_LISTARVENTA = "USP_VENTA_LISTAR";
        private readonly string USP_ActualizarVenta = "USP_VENTA_ACTUALIZAR";
        private readonly string USP_ActualizarVentaDetalle = "USP_VENTADETALLE_ACTUALIZAR";
        private readonly string USP_VENTA_DELETE = "USP_VENTA_DELETE";
        private readonly string USP_VENTADetalle_DELETE = "USP_VENTADetalle_DELETE";

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

        public async Task<ResultadoTransaction<Venta>> ListarVenta()
        {
            ResultadoTransaction<Venta> resultado = new ResultadoTransaction<Venta>();

            try
            {
                using (SqlConnection con = _conexion.GetConnection())
                {
                    con.Open();
                    using (SqlCommand cmd = new SqlCommand(USP_LISTARVENTA,con))
                    {
                        cmd.CommandType = CommandType.StoredProcedure;
                        cmd.Parameters.AddWithValue("@flgListar", 1);
                        cmd.Parameters.AddWithValue("@idVenta", 0);
                        cmd.Parameters.AddWithValue("@idVentaDet", 0);

                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            List<Venta> lista = new List<Venta>();
                            while (reader.Read())
                            {
                                
                                Venta venta = new Venta()
                                {
                                    cliente = reader["cliente"].ToString(),
                                    nroDocumento = reader["nroDocumento"].ToString(),
                                    fechaVenta = Convert.ToDateTime(reader["fechaVenta"].ToString()),
                                    idVenta = Convert.ToInt32(reader["idVenta"].ToString()),
                                    igv = Convert.ToDouble(reader["igv"].ToString()),
                                    subTotal = Convert.ToDouble(reader["subTotal"].ToString()),
                                    total = Convert.ToDouble(reader["total"].ToString()),
                                };
                                lista.Add(venta);
                            }

                            resultado.dataList = lista;
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
        public async Task<ResultadoTransaction<VentaDet>> ListarVentaDetalleXIDVenta(int idVenta)
        {
            ResultadoTransaction<VentaDet> resultado = new ResultadoTransaction<VentaDet>();

            try
            {
                using (SqlConnection con = _conexion.GetConnection())
                {
                    con.Open();
                    using (SqlCommand cmd = new SqlCommand(USP_LISTARVENTA, con))
                    {
                        cmd.CommandType = CommandType.StoredProcedure;
                        cmd.Parameters.AddWithValue("@flgListar", 5);
                        cmd.Parameters.AddWithValue("@idVenta", idVenta);
                        cmd.Parameters.AddWithValue("@idVentaDet", 0);

                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            List<VentaDet> lista = new List<VentaDet>();
                            while (reader.Read())
                            {

                                VentaDet venta = new VentaDet()
                                {
                                    producto = reader["producto"].ToString(),
                                    cantidad = Convert.ToInt32(reader["cantidad"].ToString()),
                                    idVenta = Convert.ToInt32(reader["idVenta"].ToString()),
                                    igv = Convert.ToDouble(reader["igv"].ToString()),
                                    subtotal = Convert.ToDouble(reader["subTotal"].ToString()),
                                    total = Convert.ToDouble(reader["total"].ToString()),
                                    idVentaDet = Convert.ToInt32(reader["idVentaDet"].ToString()),
                                    precio = Convert.ToDouble(reader["precio"].ToString()),

                                };
                                lista.Add(venta);
                            }

                            resultado.dataList = lista;
                            resultado.idRegistro = 0;
                            resultado.mensaje = "OK";
                        }
                    }
                }
            }
            catch (Exception e)
            {
                resultado.idRegistro = -1;
                resultado.mensaje = e.Message;
            }

            return resultado;
        }
        public async Task<ResultadoTransaction<VentaDet>> ListarVentaDet()
        {
            ResultadoTransaction<VentaDet> resultado = new ResultadoTransaction<VentaDet>();

            try
            {
                using (SqlConnection con = _conexion.GetConnection())
                {
                    con.Open();
                    using (SqlCommand cmd = new SqlCommand(USP_LISTARVENTA, con))
                    {
                        cmd.CommandType = CommandType.StoredProcedure;
                        cmd.Parameters.AddWithValue("@flgListar", 2);
                        cmd.Parameters.AddWithValue("@idVenta", 0);
                        cmd.Parameters.AddWithValue("@idVentaDet", 0);

                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            List<VentaDet> lista = new List<VentaDet>();
                            while (reader.Read())
                            {

                                VentaDet venta = new VentaDet()
                                {
                                    producto = reader["producto"].ToString(),
                                    cantidad = Convert.ToInt32(reader["cantidad"].ToString()),
                                    idVenta = Convert.ToInt32(reader["idVenta"].ToString()),
                                    igv = Convert.ToDouble(reader["igv"].ToString()),
                                    subtotal = Convert.ToDouble(reader["subTotal"].ToString()),
                                    total = Convert.ToDouble(reader["total"].ToString()),
                                    idVentaDet = Convert.ToInt32(reader["idVentaDet"].ToString()),
                                    precio = Convert.ToDouble(reader["precio"].ToString()),

                                };
                                lista.Add(venta);
                            }

                            resultado.dataList = lista;
                        }
                    }
                }
            }
            catch (Exception e)
            {
                resultado.idRegistro = -1;
                resultado.mensaje = e.Message;
            }

            return resultado;
        }

        public async Task<ResultadoTransaction<string>> Eliminarventa(int id)
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
                            using (SqlCommand cmd = new SqlCommand(USP_VENTA_DELETE, con, transaction))
                            {
                                cmd.CommandType = CommandType.StoredProcedure;
                                cmd.Parameters.AddWithValue("@idVenta", id);
                                await cmd.ExecuteNonQueryAsync();

                                transaction.Commit();
                                transaction.Dispose();
                                resultado.idRegistro = 0;
                                resultado.mensaje = "OK";
                                resultado.value = true;
                                return resultado;
                            }
                        }
                        catch (Exception e)
                        {
                            transaction.Rollback();
                            resultado.idRegistro = -1;
                            resultado.mensaje = e.Message;
                        }
                    }
                }
            }
            catch (Exception e)
            {
                resultado.idRegistro = -1;
                resultado.mensaje = e.Message;
            }

            return resultado;
        }
        public async Task<ResultadoTransaction<string>> EliminarventaDetalle(int idVenta,int idVentDet)
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
                            using (SqlCommand cmd = new SqlCommand(USP_VENTADetalle_DELETE, con, transaction))
                            {
                                cmd.CommandType = CommandType.StoredProcedure;
                                cmd.Parameters.AddWithValue("@idVenta", idVenta);
                                cmd.Parameters.AddWithValue("@idVentaDet", idVentDet);
                                await cmd.ExecuteNonQueryAsync();

                                transaction.Commit();
                                transaction.Dispose();
                                resultado.idRegistro = 0;
                                resultado.mensaje = "OK";
                                resultado.value = true;
                                return resultado;
                            }
                        }
                        catch (Exception e)
                        {
                            transaction.Rollback();
                            resultado.idRegistro = -1;
                            resultado.mensaje = e.Message;
                        }
                    }
                }
            }
            catch (Exception e)
            {
                resultado.idRegistro = -1;
                resultado.mensaje = e.Message;
            }

            return resultado;
        }


        public async Task<ResultadoTransaction<string>> ActualizarVenta(Venta venta)
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
                            using (SqlCommand cmd = new SqlCommand(USP_ActualizarVenta, con, transaction))
                            {
                                cmd.CommandType = CommandType.StoredProcedure;
                                cmd.Parameters.AddWithValue("@idVenta", venta.idVenta);
                                cmd.Parameters.AddWithValue("@cliente", venta.cliente);
                                cmd.Parameters.AddWithValue("@nroDocumento", venta.nroDocumento);
                                await cmd.ExecuteNonQueryAsync();

                                transaction.Commit();
                                transaction.Dispose();
                                resultado.idRegistro = 0;
                                resultado.mensaje = "OK";
                                resultado.value = true;
                                return resultado;
                            }
                        }
                        catch (Exception e)
                        {
                            transaction.Rollback();
                            resultado.idRegistro = -1;
                            resultado.mensaje = e.Message;
                        }
                    }
                }
            }
            catch (Exception e)
            {
                resultado.idRegistro = -1;
                resultado.mensaje = e.Message;
            }

            return resultado;
        }
        public async Task<ResultadoTransaction<string>> ActualizarVentaDetalle(VentaDet venta)
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
                            using (SqlCommand cmd = new SqlCommand(USP_ActualizarVentaDetalle, con, transaction))
                            {
                                cmd.CommandType = CommandType.StoredProcedure;
                                cmd.Parameters.AddWithValue("@idVenta", venta.idVenta);
                                cmd.Parameters.AddWithValue("@idVentaDet", venta.idVentaDet);
                                cmd.Parameters.AddWithValue("@producto", venta.producto);
                                cmd.Parameters.AddWithValue("@cantidad", venta.cantidad);
                                cmd.Parameters.AddWithValue("@precio", venta.precio);
                                await cmd.ExecuteNonQueryAsync();
                                 
                                transaction.Commit();
                                transaction.Dispose();
                                resultado.idRegistro = 0;
                                resultado.mensaje = "OK";
                                resultado.value = true;
                                return resultado;
                            }
                        }
                        catch (Exception e)
                        {
                            transaction.Rollback();
                            resultado.idRegistro = -1;
                            resultado.mensaje = e.Message;
                        }
                    }
                }
            }
            catch (Exception e)
            {
                resultado.idRegistro = -1;
                resultado.mensaje = e.Message;
            }

            return resultado;
        }

        
    }
}
