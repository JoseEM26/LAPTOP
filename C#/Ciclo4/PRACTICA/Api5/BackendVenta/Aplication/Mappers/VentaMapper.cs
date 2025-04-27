using Aplication.DTOs;
using Dominio.Identidad;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aplication.Mappers
{
    public class VentaMapper
    {
        public Venta ExecuteVentaMapper(VentaDTO ventaDTO)
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
                listaVentaDet = ventaDTO.listaVentaDet.Select(x => new VentaDet
                {
                    total=x.total,
                    subTotal=x.subTotal  ,
                    idVenta= x.idVenta  ,
                    cantidad= x.cantidad  ,
                    idVentaDet= x.idVenta  ,
                    igv= x.igv  ,
                    precio= x.precio  ,
                    producto= x.producto  
                }).ToList()
            };
        }
    }
}
