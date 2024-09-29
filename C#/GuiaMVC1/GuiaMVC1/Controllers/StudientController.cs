using GuiaMVC1.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace GuiaMVC1.Controllers
{
    public class StudientController : Controller
    {
        public static List<Studient> lista = new List<Studient>
        {
            new Studient(101,"Jose","Espinoza"),
            new Studient(102,"Luis","Morales"),
            new Studient(103,"Angel","Mendoza")
        };
        // GET: Studient
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Lista()
        {
            return View(lista);
        }

        public ActionResult Create()
        {
            return View(new Studient());
        }

        [HttpPost]
        public ActionResult Create(Studient s)
        {
            lista.Add(s);
            return RedirectToAction("Lista");
        }

        public ActionResult Edit(int id)
        {
            var student=lista.Where(x => x.idStudent == id).FirstOrDefault();
            return View(student);
        }

        [HttpPost]
        public ActionResult Edit(Studient s)
        {
            var std = lista.Where(x => x.idStudent == s.idStudent).FirstOrDefault();
            std.nombre = s.nombre;
            std.apellido = s.apellido;
            return RedirectToAction("Lista");
        }
    }
}