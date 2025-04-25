using Aplication.DTOs;
using Dominio.Identity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aplication.MAPPERs
{
    public class VentaMapper
    {
        public Venta MapearVentaDTO(VentaDTO ventaDTO)
        {
            return new Venta()
            {
                cliente = ventaDTO.cliente,
                fechaVenta = ventaDTO.fechaVenta,
                idVenta = ventaDTO.idVenta,
                igv = ventaDTO.igv,
                nroDocumento = ventaDTO.nroDocumento,
                subTotal = ventaDTO.subTotal,
                total = ventaDTO.total,
                ListaDetalle = ventaDTO.ListaDetalle.Select(x => new VentaDet
                {
                    cantidad=x.cantidad,
                    idVenta=x.idVenta,
                    idVentaDet=x.idVentaDet,
                    igv=x.igv,
                    precio=x.precio,
                    producto=x.producto,
                    subtotal=x.subtotal,
                    total=x.total
                }
                ).ToList()
            };
        }

        public VentaDet MapearVentaDetalleDTO(VentaDetDTO ventaDetDTO)
        {
            return new VentaDet()
            {
                cantidad=ventaDetDTO.cantidad,
                idVenta=ventaDetDTO.idVenta,
                idVentaDet=ventaDetDTO.idVentaDet,
                igv=ventaDetDTO.igv,
                precio=ventaDetDTO.precio,
                producto=ventaDetDTO.producto,
                subtotal=ventaDetDTO.subtotal,
                total=ventaDetDTO.total
            };
        }
    }
}
