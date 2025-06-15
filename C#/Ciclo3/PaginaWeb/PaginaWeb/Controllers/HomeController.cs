using PaginaWeb.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace PaginaWeb.Controllers
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

            List<Pelicula> model = new List<Pelicula>();
            model.Add(new Pelicula("DeadPool", 111, DateTime.Today));
            model.Add(new Pelicula("Mario", 55, DateTime.Today));
            model.Add(new Pelicula("Proyecto X", 345, DateTime.Today));

            return View(model);
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }
    }
}