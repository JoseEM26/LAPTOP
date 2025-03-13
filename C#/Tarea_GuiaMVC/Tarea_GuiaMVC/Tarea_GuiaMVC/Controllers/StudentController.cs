using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Tarea_GuiaMVC.Models;

namespace Tarea_GuiaMVC.Controllers
{
    public class StudentController : Controller
    {
        // GET: Student
        private static List<Student> lista = new List<Student>()
            {
                new Student(){studentId=101,studentName="Jose",año=19},
                new Student(){studentId=102,studentName="Pepe",año=25},
                new Student(){studentId=103,studentName="Juan",año=21},
                new Student(){studentId=104,studentName="Anuel",año=11},
                new Student(){studentId=105,studentName="Nay",año=20},
                new Student(){studentId=106,studentName="Ariadna",año=18}
            };
        int contador = 10;

        public ActionResult Index()
        {
            return View();
        }

        public ActionResult ListarStudent()
        {
            return View(lista);
        }
        public ActionResult Create()
        {
            var x = new Student();
            return View(x);
        }
        [HttpPost]
        public ActionResult Create(Student s)
        {
            try
            {
                var newS = new Student();
                newS.studentId = s.studentId;
                newS.studentName = s.studentName;
                newS.año = s.año;


                lista.Add(newS);
            }
            catch(Exception e)
            {
                Debug.WriteLine(e.Message);
            }

            return RedirectToAction("ListarStudent");
        }

        public ActionResult Edit(int id)
        {
            Student EditarStudent=lista.Where(x => x.studentId == id).FirstOrDefault();
            return View(EditarStudent);
        }
        [HttpPost]
        public ActionResult Edit(Student s)
        {
           Student EditarStudent = lista.Where(x => x.studentId == s.studentId).FirstOrDefault();

            EditarStudent.studentName = s.studentName;
            EditarStudent.año = s.año;
            EditarStudent.studentId = s.studentId;

            return RedirectToAction("ListarStudent");
        }
    }
}