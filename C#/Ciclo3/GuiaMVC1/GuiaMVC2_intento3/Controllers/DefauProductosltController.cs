using GuiaMVC2_intento3.Models;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace GuiaMVC2_intento3.Controllers
{
    public class DefauProductosltController : Controller
    {
        // GET: DefauProductoslt
        AccesoDatos datos = new AccesoDatos();

        public ActionResult Index()
        {
            DataSet tabla = datos.ProductoListar();
            List<Producto> lista = new List<Producto>();

            foreach(DataRow dr in tabla.Tables[0].Rows)
            {
                lista.Add(new Producto
                {
                    IdProducto = Convert.ToInt32(dr["IdProducto"]),
                    NomProducto = Convert.ToString(dr["NomProducto"]),
                    PrecioUnidad = Convert.ToDecimal(dr["PrecioUnidad"]),
                    NomCategoria = Convert.ToString(dr["NombreCategoria"]),
                    NomProveedor = Convert.ToString(dr["NomProveedor"]),
                    STOCK = Convert.ToInt32(dr["STOCK"])
                });
            }





            return View(lista);
        }
    }
}