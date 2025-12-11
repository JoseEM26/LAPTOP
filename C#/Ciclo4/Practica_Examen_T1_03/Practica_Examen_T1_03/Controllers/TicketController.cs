using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Practica_Examen_T1_03.Models;
using Practica_Examen_T1_03.Service;

namespace Practica_Examen_T1_03.Controllers
{
    public class TicketController : Controller
    {
        private readonly TicketService _service;
        private readonly ItemService _dropTownServiceItem;
        private readonly AgenciaService _dropTownServiceAgencia;

        public TicketController(TicketService service, ItemService dropTownServiceItem, AgenciaService dropTownServiceAgencia)
        {
            _service = service;
            _dropTownServiceItem = dropTownServiceItem;
            _dropTownServiceAgencia = dropTownServiceAgencia;
        }

        private async Task CargarDropTown()
        {
            var items = await _dropTownServiceItem.FIND_ALL();
            var agencias = await _dropTownServiceAgencia.FIND_ALL();

            ViewBag.lista = items.Select(d => new SelectListItem
            {
                Value = d.ItemId.ToString(),
                Text = d.Descripcion
            }).ToList();

            ViewBag.lista2 = agencias.Select(c => new SelectListItem
            {
                Value = c.AgenciaId.ToString(),
                Text = c.nombre
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
            return View(new Ticket());
        }

        [HttpPost]
        public async Task<IActionResult> Create(Ticket newModel)
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
        public async Task<IActionResult> Edit(string id, Ticket newModel)
        {
            if (id != newModel.TicketId.ToString())
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
