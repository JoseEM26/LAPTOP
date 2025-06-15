using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Tarea3_GuiaMVC.Models;


namespace Tarea3_GuiaMVC.Controllers
{
    public class NegociosController : Controller
    {
        // GET: Negocios
         
        public ActionResult Index()
        {
            NegociosEntities data = new NegociosEntities();

            return View(data.USP_PRODUCTOLISTARE().ToList());
        }
    }
}