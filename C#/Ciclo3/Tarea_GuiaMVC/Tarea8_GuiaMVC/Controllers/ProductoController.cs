using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Tarea8_GuiaMVC.Entity;
using Tarea8_GuiaMVC.Models;

namespace Tarea8_GuiaMVC.Controllers
{
    public class ProductoController : Controller
    {
        // GET: Producto
        CategoriaDAO daoCategoria = new CategoriaDAO();
        ProductoDAO daoProducto = new ProductoDAO();
        ProveedorDao daoProveedor = new ProveedorDao();

        public ActionResult Index()
        {
            return View(daoProducto.ListarProducto());
        }

        public ActionResult Details(int id)
        {
            return View(daoProducto.BuscarProductoID(id));
        }


        public ActionResult Create()
        {
            ViewBag.categorias = new SelectList(daoCategoria.ListarCategoria()
                                 ,"IdCategoria", "nomCategoria");
            ViewBag.proovedor = new SelectList(daoProveedor.ListarProveedor()
                                 , "IdProveedor", "nomProveedor");
            
            return View(new Producto());
        }
        [HttpPost]
        public ActionResult Create(Producto p)
        {
            try
            {
                if (ModelState.IsValid)
                {
                    ViewBag.categorias = new SelectList(daoCategoria.ListarCategoria()
                                 , "IdCategoria", "NomCategoria");
                    ViewBag.proovedor = new SelectList(daoProveedor.ListarProveedor()
                                         , "IdProveedor", "NomProveedor");

                    daoProducto.InsertarProducto(p);
                    return RedirectToAction("Index");
                }

                return RedirectToAction("Index");

            }
            catch (Exception e)
            {
                return View();
            }
        }


        public ActionResult Delete(int id)
        {
            return View(daoProducto.BuscarProductoID(id));
        }
        [HttpPost,ActionName("Delete")]
        public ActionResult DeleteConfirmed(int id)
        {
            daoProducto.EliminarProducto(id);
            return RedirectToAction("Index");
        }


        public ActionResult Edit(int id) {

            Producto pro = daoProducto.BuscarProductoID(id);

            ViewBag.Categoriass = new SelectList(daoCategoria.ListarCategoria(),
                                             "idCategoria", "nomCategoria");
            ViewBag.Provedorss = new SelectList(daoProveedor.ListarProveedor(),
                                             "idProveedor", "nomProveedor");
            return View(pro);
        }
        [HttpPost]
        public ActionResult Edit(Producto pro)
        {

            //ViewBag.Categoriass = new SelectList(daoCategoria.ListarCategoria(),
            //                                   "idCategoria", "nomCategoria");
            //ViewBag.Provedorss = new SelectList(daoProveedor.ListarProveedor(),
            //                                 "idProveedor", "nomProveedor");
            daoProducto.ActualizarProducto(pro);
            return RedirectToAction("Index");
        }

    }
}