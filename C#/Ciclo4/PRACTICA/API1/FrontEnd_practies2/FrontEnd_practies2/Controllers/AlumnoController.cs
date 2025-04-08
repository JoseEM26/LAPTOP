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
    }
}
