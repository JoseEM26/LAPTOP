using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using PracticaExamen_02.Models;
using PracticaExamen_02.Service;

namespace PracticaExamen_02.Controllers
{
    public class ClienteController : Controller
    {
        private readonly ClienteService _service;
        private readonly DropTownService _dropTownService;

        public ClienteController(ClienteService service, DropTownService dropTownService)
        {
            _service = service;
            _dropTownService = dropTownService;
        }
        private async Task CargarDropTown()
        {
            var distritos = await _dropTownService.FIND_ALL();
            ViewBag.lista = distritos.Select(d => new SelectListItem
            {
                Value = d.IdDistrito,
                Text = d.nombre_distrito
            }).ToList();
        }






        public async Task<IActionResult> Index()
        {
            var x = await _service.FIND_ALL();
            return View(x);
        }

        public async Task<IActionResult> Details(string id)
        {
            var x = await _service.GET_BY_ID(id);
            if (x == null)
                return NotFound();

            return View(x);
        }

        public async Task<IActionResult> Create()
        {
            await CargarDropTown();
            return View(new Cliente());
        }

        [HttpPost]
        public async Task<IActionResult> Create(Cliente newModel)
        {
            if (!ModelState.IsValid)
                return View(newModel);

            bool creado = await _service.SAVE(newModel);


            return RedirectToAction(nameof(Index));
        }

        public async Task<IActionResult> Edit(string id)
        {
            var x = await _service.GET_BY_ID(id);
            if (x == null)
                return NotFound();

            await CargarDropTown();

            return View(x);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(string id, Cliente newModel)
        {
            if (id != newModel.IdCliente)
                return BadRequest();

            if (!ModelState.IsValid)
                return View(newModel);

            bool actualizado = await _service.UPDATE(newModel);

            return RedirectToAction(nameof(Index));
        }

        public async Task<IActionResult> Delete(string id)
        {
            var x = await _service.GET_BY_ID(id);
            if (x == null)
                return NotFound();

            return View(x);
        }

        [HttpPost, ActionName("Delete")]
        public async Task<IActionResult> DeleteConfirmed(string id)
        {
            bool eliminado = await _service.DELETE(id);

            if (!eliminado)
            {
                TempData["ErrorMessage"] = "No se pudo eliminar el Modelo. Puede que ya no exista.";
                return RedirectToAction(nameof(Index));
            }

            TempData["SuccessMessage"] = "Modelo eliminado correctamente.";
            return RedirectToAction(nameof(Index));
        }
    }
}
