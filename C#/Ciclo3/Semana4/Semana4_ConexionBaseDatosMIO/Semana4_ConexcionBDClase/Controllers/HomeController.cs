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
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            //ObtenerPais//
            PaisDAO dao = new PaisDaolmpl();
            Pais objPais = dao.ObtenerPais("AR");
            Debug.WriteLine("Codigo :" + objPais.country_id);
            Debug.WriteLine("Nombre :" + objPais.country_name);
            Debug.WriteLine("Region :" + objPais.region_id);

            return View();
        }

        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";

            return View();
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }
    }
}