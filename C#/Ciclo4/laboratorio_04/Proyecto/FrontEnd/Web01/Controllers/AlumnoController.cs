using Microsoft.AspNetCore.Mvc;
using Web01.Models.Logica;

namespace Web01.Controllers
{
    public class AlumnoController : Controller
    {
        public IActionResult Index()
        {
            var Lista = new AlumnoL().ListarAlumnos();
            return View(Lista);
        }
    }
}
