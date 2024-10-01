using GuiaMVC2_intento2.Models;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace GuiaMVC2_intento2.Controllers
{
    public class ProductosController : Controller
    {
        // GET: Productos
        AccesoDatos ad = new AccesoDatos();
        public ActionResult Index()
        {
            DataSet tabla = ad.ProductoListar();
            List<Productos> lista = new List<Productos>();

            foreach (DataRow dr in tabla.Tables[0].Rows)
            {
                lista.Add(new Productos
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