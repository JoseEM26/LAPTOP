using Grpc.Net.Client;
using GrpcServiceRegistro;
using Microsoft.AspNetCore.Mvc;

namespace app_Core5.Controllers
{
    public class PruebaController : Controller
    {
        private Greeter.GreeterClient _cliente;
        public IActionResult Index()
        {
            return View();
        }

        [HttpPost]
        public async Task<IActionResult> Index(string codigo ,string nombre , string apellido)
        {
            var canal = GrpcChannel.ForAddress("https://localhost:7176");
            _cliente = new Greeter.GreeterClient(canal);

            HelloRequest request = new HelloRequest();
            request.Codigo = codigo;
            request.Nombre = nombre;
            request.Apellido = apellido;

            HelloReply mensaje = await _cliente.SayHelloAsync(request);
            ViewBag.mensaje = codigo;
            ViewBag.nombre = nombre;
            ViewBag.apellido = apellido;


            return View();
        }

    }
}
