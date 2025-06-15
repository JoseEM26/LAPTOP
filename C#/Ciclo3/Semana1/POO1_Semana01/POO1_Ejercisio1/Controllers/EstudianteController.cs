using POO1_Ejercisio1.Models;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace POO1_Ejercisio1.Controllers
{
    public class EstudianteController : Controller
    {
        // GET: Estudiante
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Registro(Estudiante e)
        {
            Debug.WriteLine("nombre:"+e.nombre);
            Debug.WriteLine("apellido:" + e.nombre);
            Debug.WriteLine("edad:" + e.nombre);
            return View(new Estudiante());
        }
    }
}