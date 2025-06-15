using FrontEnd_practies2.Models.Entity;
using FrontEnd_practies2.Models.Logica;
using Microsoft.AspNetCore.Mvc;

namespace FrontEnd_practies2.Controllers
{
    public class AlumnoController : Controller
    {
        AlumnoLogica logica = new AlumnoLogica();

        [HttpGet]
        public IActionResult Index()
        {
            return View(logica.listarAlumno());
        }
        [HttpGet]
        public IActionResult Create()
        {
            Alumno a = new Alumno();
            return View(a);
        }
        [HttpPost]
        public IActionResult Create(Alumno a)
        {
            if (ModelState.IsValid)
            {
                logica.CreateAlumno(a);
                return RedirectToAction("Index");
            }
            return View(a);
        }
    }
}
