using FrontEnd.Models.Entity;
using FrontEnd.Models.Logica;
using Microsoft.AspNetCore.Mvc;

namespace FrontEnd.Controllers
{
    public class AlumnoController : Controller
    {
        public AlumnoLogica _logica= new AlumnoLogica();

        [HttpGet]
        public IActionResult Listar()
        {
            return View(_logica.listaAlumno());
        }
        [HttpGet]
        public IActionResult Create()
        {
            return View(new Alumno());
        }
        [HttpPost]
        public IActionResult Create(Alumno alumno)
        {
            _logica.CrearAlumno(alumno);
            return RedirectToAction("Listar");
        }
    }
}
