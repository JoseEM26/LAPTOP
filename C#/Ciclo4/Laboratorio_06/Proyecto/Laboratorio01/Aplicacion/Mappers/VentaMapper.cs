using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Aplicacion.DTOs;
using Dominio.Entidades;

namespace Aplicacion.Mappers
{
    public class VentaMapper
    {
        public Venta Devolver_Entidad_Venta(VentaDto objventa)
        {
            return new Venta
            {
                Idventa = objventa.Idventa,
                cliente = objventa.cliente,
                nrodocumento = objventa.nrodocumento,
                fechaventa = objventa.fechaventa,
                subtotal = objventa.subtotal,
                igv = objventa.igv,
                total = objventa.total,
                flgEliminado = objventa.flgEliminado,
                Listadetalle = objventa.Listadetalle.Select(d => new ventaDet
                {
                    IdventaDet = d.IdventaDet,
                    Idventa = d.Idventa,
                    Producto = d.Producto,
                    cantidad = d.cantidad,
                    precio = d.precio,
                    subtotal = d.subtotal,
                    igv = d.igv,
                    total = d.total,
                    flgEliminado = d.flgEliminado,
                    flgActualiza = d.flgActualiza
                }).ToList()
            };
        }
    }
}
