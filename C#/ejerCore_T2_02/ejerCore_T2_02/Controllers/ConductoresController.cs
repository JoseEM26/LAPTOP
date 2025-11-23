using Microsoft.AspNetCore.Mvc;

namespace ejerCore_T2_02.Controllers
{
    public class ConductoresController : Controller
    {
        // definimos la propiedad de tipo IConfig para la conexion
        private readonly IConfiguration _config;

        public ConductoresController(IConfiguration config)
        {
            // Se asigna a la propiead la cadena de conexion
            _config = config;
        }
        public IActionResult Index()
        {
            return View();
        }
    }
}
