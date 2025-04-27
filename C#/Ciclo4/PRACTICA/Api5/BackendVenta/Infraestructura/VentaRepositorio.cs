using Dominio.Identidad;
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
        private readonly string USP_CREATE_Venta = "USP_VENTA_INSERTAR";
        private readonly string USP_CREATE_VentaDet = "USP_VENTA_INSERTARDET";
        private readonly string USP_LISTAR = "USP_VENTA_LISTAR";
        public ResultadoTransaction<string> CreateVenta(Venta venta)
        {
            ResultadoTransaction<string> resultado = new ResultadoTransaction<string>();
            using(SqlConnection con= _conexion.getConexion())
            {
                con.Open();
                using(SqlTransaction transaction = con.BeginTransaction())
                {
                    try
                    {
                        using(SqlCommand cmd= new SqlCommand(USP_CREATE_Venta, con, transaction))
                        {
                            cmd.CommandType = System.Data.CommandType.StoredProcedure;
                            cmd.Parameters.AddWithValue("@cliente", venta.cliente);
                            cmd.Parameters.AddWithValue("@nroDocumento", venta.nroDocumento);
                            cmd.Parameters.AddWithValue("@fechaVenta", venta.fechaVenta);
                            cmd.Parameters.AddWithValue("@subTotal", venta.subTotal);
                            cmd.Parameters.AddWithValue("@total", venta.total);
                            cmd.Parameters.AddWithValue("@igv", venta.igv);
                            cmd.Parameters.Add("@idVenta", System.Data.SqlDbType.Int, 11).Direction = System.Data.ParameterDirection.Output;
                            cmd.ExecuteNonQuery();

                            int idVenta = Convert.ToInt32(cmd.Parameters["@idVenta"].Value.ToString());
                            if (idVenta > 0)
                            {
                                foreach(var item in venta.listaVentaDet)
                                {
                                    var ventaDetalle = CreateVentaDetalle(idVenta, item, con, transaction);
                                    if (venta.idVenta == -1)
                                    {
                                        transaction.Rollback();
                                        resultado.idRespuesta = -1;
                                        resultado.mensaje = "ERROR";
                                        return resultado;
                                    }
                                }
                            }
                        }
                    }catch(Exception e)
                    {
                        transaction.Rollback();
                        resultado.idRespuesta = -1;
                        resultado.mensaje = "OK";
                    }
                }
            }
            return resultado;
        }

        private ResultadoTransaction<string> CreateVentaDetalle(int idVenta, VentaDet item, SqlConnection con, SqlTransaction transaction)
        {
            ResultadoTransaction<string> resultado = new ResultadoTransaction<string>();
            using(SqlCommand cmd= new SqlCommand(USP_CREATE_VentaDet, con, transaction))
            {
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@idVenta", idVenta);
                cmd.Parameters.AddWithValue("@producto", item.producto);
                cmd.Parameters.AddWithValue("@cantidad", item.cantidad);
                cmd.Parameters.AddWithValue("@precio", item.precio);
                cmd.Parameters.AddWithValue("@subTotal", item.subTotal);
                cmd.Parameters.AddWithValue("@igv", item.igv);
                cmd.Parameters.AddWithValue("@total", item.total);
                cmd.ExecuteNonQuery();

                transaction.Commit();
                transaction.Dispose();
                resultado.idRespuesta = 0;
                resultado.mensaje = "OK";
            }
            return resultado;
        }

        public ResultadoTransaction<Venta> ListarVenta()
        {
            ResultadoTransaction<Venta> resultado = new ResultadoTransaction<Venta>();

            try
            {
                using (SqlConnection con = _conexion.getConexion())
                {
                    con.Open();
                    using (SqlCommand cmd = new SqlCommand(USP_LISTAR, con))
                    {
                        cmd.CommandType = System.Data.CommandType.StoredProcedure;
                        cmd.Parameters.AddWithValue("@flgListar", 1);
                        cmd.Parameters.AddWithValue("@idVenta", 0);
                        cmd.Parameters.AddWithValue("@idVentaDet", 0);
                        
                        using(SqlDataReader reader= cmd.ExecuteReader())
                        {
                            List<Venta> lista = new List<Venta>();
                            while (reader.Read())
                            {
                                Venta venta = new Venta()
                                {
                                    cliente = reader["cliente"].ToString(),
                                    nroDocumento = reader["nroDocumento"].ToString(),
                                    subTotal = Convert.ToDouble(reader["subTotal"].ToString()),
                                    igv = Convert.ToDouble(reader["igv"].ToString()),
                                    total = Convert.ToDouble(reader["total"].ToString()),
                                    fechaVenta = Convert.ToDateTime(reader["fechaVenta"].ToString()),
                                    idVenta = Convert.ToInt32(reader["idVenta"].ToString())
                                };
                                lista.Add(venta);
                            }
                            resultado.listData = lista;
                            resultado.idRespuesta = 0;
                            resultado.mensaje = "ok";
                        }

                    }
                }
            }
            catch (Exception e)
            {
                resultado.mensaje = e.Message;
                resultado.idRespuesta = -1;

            }
            return resultado;

        }
    }
}
