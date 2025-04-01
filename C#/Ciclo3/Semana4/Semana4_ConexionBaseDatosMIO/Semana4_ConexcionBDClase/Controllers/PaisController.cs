using Semana4_ConexcionBDClase.Dao.daolmpl;
using Semana4_ConexcionBDClase.Dao.paises;
using Semana4_ConexcionBDClase.Models;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Semana4_ConexcionBDClase.Controllers
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
            PaisDAO dao = new PaisDaolmpl();
            List<Pais> lista = dao.consultarTodo();

            return View(lista);
        }

        public ActionResult DetalleRegistro(string codigo)
        {
            PaisDAO dao = new PaisDaolmpl();
            Pais pais = dao.ObtenerPais(codigo);
            return View(pais);

        }

        public ActionResult Editar(string codigo)
        {
            PaisDAO dao = new PaisDaolmpl();
            Pais pais = dao.ObtenerPais(codigo);
            
            return View(pais);

        }

        [HttpPost]
        public ActionResult Editar(Pais datos)
        {
            PaisDAO dao = new PaisDaolmpl();
            int procesar =dao.Actualizar(datos);
            return RedirectToAction("Reporte");

        }

        public ActionResult Eliminar(string codigo)
        {
            PaisDAO dao = new PaisDaolmpl();
            Pais pais = dao.ObtenerPais(codigo);
            return View(pais);
        }


        [HttpPost,ActionName("Eliminar")]
        public ActionResult Eliminar_Confirmacion(string codigo)
        {
            Debug.WriteLine("Codigo a eliminar" + codigo);
            PaisDAO dao = new PaisDaolmpl();
            int procesar = dao.Eliminar(codigo);

            return RedirectToAction("Reporte");
        }

        public ActionResult Create()
        {
            return View(new Pais());
        }

        [HttpPost]
        public ActionResult Create(Pais p)
        {
            PaisDAO dao = new PaisDaolmpl();
            int procesar = dao.registrar(p);
            return RedirectToAction("Reporte");
        }

    }
}