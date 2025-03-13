using Semana3_problema6.Models;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Semana3_problema6.Controllers
{
    public class EmpleadoController : Controller
    {
        public static int contador = 0;


        // GET: Empleado
        public ActionResult Index()
        {
            ViewBag.nombre = "Jose Angel";
            ViewBag.apellido = "Espinoza Morales";
            ViewBag.edad = "19";
            ViewBag.sexo = "Masculino";
            ViewBag.carrera = "Computacion e informatica";
            ViewBag._contador = contador;
            return View();
        }

        [HttpGet]
        public ActionResult CreateEmpleado()
        {
            return View();
        }

        [HttpPost]
        public ActionResult CreateEmpleado(Empleado e)
        {
            Debug.WriteLine("Nombre Empleado  :" + e.nombre);
            Debug.WriteLine("Apellido Empleado  :" + e.apellido);
            Debug.WriteLine("Edad Empleado  :" + e.edad);
            contador++;
            return RedirectToAction("Index");
        }
    }
}