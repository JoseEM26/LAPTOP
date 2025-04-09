using FrontEndAlumno.Models.Entity;
using FrontEndAlumno.Models.Logica;
using Microsoft.AspNetCore.Mvc;

namespace FrontEndAlumno.Controllers
{
    public class AlumnoController : Controller
    {
        AlumnoLogica logica = new AlumnoLogica();

        [HttpGet]
        public IActionResult Listar()
        {
            var lista = logica.listaAlumno();
            return View(lista);
        }

        [HttpGet]
        public IActionResult Create()
        {
            return View(new Alumno());
        }
        [HttpPost]
        public IActionResult Create(Alumno alumno)
        {
            logica.CreateAlumno(alumno);
           return RedirectToAction("Listar");
        }
    }
}
