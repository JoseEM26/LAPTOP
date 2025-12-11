using Microsoft.AspNetCore.Mvc;
using PracticaExamen_01.Models;
using PracticaExamen_01.Service;

namespace PracticaExamen_01.Controllers
{
    public class EmpleadoController : Controller
    {
        private readonly EmpleadoService _service;

        public EmpleadoController(EmpleadoService service)
        {
            _service = service;
        }

        // GET: /Empleado/
        public async Task<IActionResult> Index()
        {
            var empleados = await _service.ListarEmpleadosAsync();
            return View(empleados);
        }

        // GET: /Empleado/Details/5
        public async Task<IActionResult> Details(int id)
        {
            var empleado = await _service.GetEmpleadoByIdAsync(id);
            if (empleado == null)
                return NotFound();

            return View(empleado);
        }

        // GET: /Empleado/Create
        public IActionResult Create()
        {
            return View(new Empleado());
        }

        // POST: /Empleado/Create
        [HttpPost]
        public async Task<IActionResult> Create(Empleado empleado)
        {
            if (!ModelState.IsValid)
                return View(empleado);

            bool creado = await _service.CreateEmpleadoAsync(empleado);

         
            return RedirectToAction(nameof(Index));
        }

        // GET: /Empleado/Edit/5
        public async Task<IActionResult> Edit(int id)
        {
            var empleado = await _service.GetEmpleadoByIdAsync(id);
            if (empleado == null)
                return NotFound();

            return View(empleado);
        }

        // POST: /Empleado/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, Empleado empleado)
        {
            if (id != empleado.IdEmpleado)
                return BadRequest();

            if (!ModelState.IsValid)
                return View(empleado);

            bool actualizado = await _service.UpdateEmpleadoAsync(empleado);

            return RedirectToAction(nameof(Index));
        }

        // GET: /Empleado/Delete/5
        public async Task<IActionResult> Delete(int id)
        {
            var empleado = await _service.GetEmpleadoByIdAsync(id);
            if (empleado == null)
                return NotFound();

            return View(empleado);
        }

        // POST: /Empleado/Delete/5
        [HttpPost, ActionName("Delete")]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            bool eliminado = await _service.DeleteEmpleadoAsync(id);

            if (!eliminado)
            {
                TempData["ErrorMessage"] = "No se pudo eliminar el empleado. Puede que ya no exista.";
                return RedirectToAction(nameof(Index));
            }

            TempData["SuccessMessage"] = "Empleado eliminado correctamente.";
            return RedirectToAction(nameof(Index));
        }
    }
}