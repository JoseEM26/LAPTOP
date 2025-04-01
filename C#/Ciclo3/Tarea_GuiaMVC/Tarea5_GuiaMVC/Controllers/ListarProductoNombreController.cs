using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.WebPages;
using Tarea5_GuiaMVC.Models;

namespace Tarea5_GuiaMVC.Controllers
{
    public class ListarProductoNombreController : Controller
    {
        // GET: ListarProductoNombre
        AccesoDatos d = new AccesoDatos();
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult ListarProductosNombres(string nombre)
        {
            if (nombre == null) nombre = string.Empty;
            ViewBag.nombre = nombre;


            return View(d.ProductoListar(nombre).ToList());
        }

        public ActionResult ListarCategoriaNombre(string categoria=null)
        {
            if (categoria == null) categoria = string.Empty;
            ViewBag.categoria = categoria;

            return View(d.ProductoListarCategoria(categoria).ToList());
        }
    }
}