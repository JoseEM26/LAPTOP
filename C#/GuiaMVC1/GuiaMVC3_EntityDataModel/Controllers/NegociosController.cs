using GuiaMVC3_EntityDataModel.Models;

using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace GuiaMVC3_EntityDataModel.Controllers
{
    public class NegociosController : Controller
    {
        // GET: Negocios
        NegociosEntities db = new NegociosEntities();

        public ActionResult Index()
        {


            return View(db.SP_PRODUCTOLISTAR().ToList());
        }
    }
}