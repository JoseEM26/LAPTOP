using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using POOI_Semana04.Models;
using POOI_Semana04.dao;
using POOI_Semana04.dao.daoImpl;
using System.Diagnostics;
using System.Web.Configuration;


namespace POOI_Semana04.Controllers
{
    public class PaisController : Controller
    {
        // GET: Pais
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Reporte()
        {
            PaisDao dao = new PaisDaoImpl();
            List<Pais> lista = dao.consultarTodo();
            return View(lista);
        }

        public ActionResult DetalleRegistro(string codigo)
        {
            Debug.WriteLine("Codigo De Pais : " + codigo);
            PaisDao dao = new PaisDaoImpl();
            Pais pais = dao.obtenerPais(codigo);
            return View(pais);
        }

        [HttpGet]
        public ActionResult Editar(string codigo)
        {
            PaisDao dao = new PaisDaoImpl();
            Pais pais = dao.obtenerPais(codigo);
            return View(pais);
        }

        [HttpPost]
        public ActionResult Editar(Pais objPais)
        {

            PaisDao dao = new PaisDaoImpl();
            int procesar = dao.actualizar(objPais);
            return RedirectToAction("Reporte");
        }

        [HttpGet]
        public ActionResult Eliminar(string codigo)
        {
            PaisDao dao = new PaisDaoImpl();
            Pais pais = dao.obtenerPais(codigo);
            return View(pais);
        }

        [HttpPost, ActionName("Eliminar")]
        public ActionResult Eliminar_confirmacion(string codigo)
        {
            Debug.WriteLine("Codigo a eliminar : "+ codigo);
            PaisDao dao = new PaisDaoImpl();
            int procesar= dao.eliminar(codigo);
            return RedirectToAction("Reporte");
        }


        public ActionResult Create()
        {
            return View(new Pais());
        }

        [HttpPost]
        public ActionResult Create(Pais p)
        {
            PaisDao dao = new PaisDaoImpl();
            int procesar = dao.registrar(p);
            return RedirectToAction("Reporte");
        }







    }
}