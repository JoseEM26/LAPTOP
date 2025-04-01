using GuiaMVC4_EntityWithSQL.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace GuiaMVC4_EntityWithSQL.Controllers
{
    public class ConsultaNegociosController : Controller
    {
        // GET: ConsultaNegocios
        NegociosEntities bd = new NegociosEntities();

        public ActionResult Index()
        {
            ViewBag.Title = "hola";

            //List<> lista= from x in bd.SP_PRODUCTOLISTAR.toLi

            return View();
        }
    }
}