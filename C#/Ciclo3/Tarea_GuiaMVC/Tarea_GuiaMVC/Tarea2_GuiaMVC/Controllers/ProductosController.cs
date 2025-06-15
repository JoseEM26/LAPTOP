using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Tarea2_GuiaMVC.Models;

namespace Tarea2_GuiaMVC.Controllers
{
    public class ProductosController : Controller
    {
        // GET: Productos
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult ListarProductos()
        {
            AccesoDatos d = new AccesoDatos();
            DataSet tabla = d.ProductoListar();
            List<Productos> lista = new List<Productos>();

            foreach (DataRow x in tabla.Tables[0].Rows)
            {
                lista.Add(new Productos
                {
                    IdProducto = Convert.ToInt32(x["IdProducto"]),
                    NombreCategoria = Convert.ToString(x["NombreCategoria"]),
                    NomProducto = Convert.ToString(x["NomProducto"]),
                    NomProveedor = Convert.ToString(x["NomProveedor"]),
                    PrecioUnidad = Convert.ToInt32(x["PrecioUnidad"]),
                    Stock = Convert.ToInt32(x["Stock"]),
                    
                });
            }

            return View(lista);
        }
    }
}