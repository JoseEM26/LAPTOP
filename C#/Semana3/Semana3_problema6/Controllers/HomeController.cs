using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Semana3_problema6.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";

            return View();
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "my biografy";
            ViewBag.Nombre = "Jose";
            ViewBag.apellido = "Espinoza";
            ViewBag.correo = "joseangelespinoza@gmail.com";
            ViewBag.celulat = "484168546";
            ViewBag.Title = "Contact";
            ViewBag.instituto = "CIBERTEC";

            return View();
        }
    }
}