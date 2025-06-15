using Semana4_practice1.Dao;
using Semana4_practice1.Dao.DaoImpl;
using Semana4_practice1.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Semana4_practice1.Controllers
{
    public class PaisController : Controller
    {
        // GET: Pais
        PaisDao p = new PaisDaoIMPL();
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult MostrarPais(string id)
        {
            Pais objPais = p.ObtenerPais(id);
            return View(objPais);
        }

        public ActionResult MostrarTodo()
        {
            List<Pais> listaPais = p.consultarTodo();
            return View(listaPais);
        }
        /// //////////////////////////////////////////
        [HttpGet]
        public ActionResult Actualizar(string id)
        {
            Pais objPais = p.ObtenerPais(id);

            return View(objPais);
        }
        [HttpPost]
        public ActionResult Actualizar(Pais obj)
        {
            int procesar = p.Actualizar(obj);
            return RedirectToAction("MostrarTodo");

        }

        [HttpGet]
        public ActionResult Eliminar(string id)
        {
            Pais objPais = p.ObtenerPais(id);
            return View(objPais);
        }
        [HttpPost, ActionName("Eliminar")]
        public ActionResult Eliminar_Post(string id)
        {
            int objPais = p.Eliminar(id);

            return RedirectToAction("MostrarTodo");
        }

        public ActionResult Create()
        {
            return View(new Pais());
        }
        [HttpPost]
        public ActionResult Create(Pais obj)
        {
            int indicado = p.registrar(obj);
            return RedirectToAction("MostrarTodo");
        }
    }
}