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

        public ActionResult Actualizar()
        {
            return View();
        }
        [HttpPost]
        public ActionResult Actualizar(string id)
        {
            
            return RedirectToAction("MostrarTodo");

        }
    }
}