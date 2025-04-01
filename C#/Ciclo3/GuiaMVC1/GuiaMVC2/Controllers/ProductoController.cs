using GuiaMVC2.Models;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace GuiaMVC2.Controllers
{
    public class ProductoController : Controller
    {
        // GET: Producto
        AccesoDatos obj = new AccesoDatos();
        public ActionResult Index()
        {
            DataSet tabla = obj.productoListar();
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