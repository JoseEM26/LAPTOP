// FrontEnd_T2/Controllers/LibroController.cs
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using System.Net.Http.Json;
using WebApplication1.Models;

namespace FrontEnd_T2.Controllers
{
    public class LibroController : Controller
    {
        private readonly HttpClient _http;
        // Cambia este puerto por el de tu API (el que aparece cuando ejecutas el backend)
        private readonly string _apiBase = "https://localhost:7163";

        public LibroController(IHttpClientFactory httpClientFactory)
        {
            _http = httpClientFactory.CreateClient();
            _http.BaseAddress = new Uri(_apiBase);
        }

        private async Task CargarEditoriales()
        {
            try
            {
                var editoriales = await _http.GetFromJsonAsync<List<Editorial>>("api/Editorial") ?? new();
                ViewBag.Editoriales = editoriales.Select(e => new SelectListItem
                {
                    Value = e.CodigoEditorial,
                    Text = $"{e.NombreEditorial} - {e.Pais?.NombrePais ?? "Sin país"}"
                }).ToList();
            }
            catch
            {
                ViewBag.Editoriales = new List<SelectListItem>();
            }
        }

        public async Task<IActionResult> Index()
        {
            try
            {
                var libros = await _http.GetFromJsonAsync<List<Libro>>("api/Libro") ?? new();
                return View(libros);
            }
            catch (Exception ex)
            {
                TempData["Error"] = $"No se pudo conectar con la API: {ex.Message}";
                return View(new List<Libro>());
            }
        }

        public async Task<IActionResult> Details(string id)
        {
            var libro = await _http.GetFromJsonAsync<Libro>($"api/Libro/{id}");
            if (libro == null) return NotFound();
            return View(libro);
        }

        public async Task<IActionResult> Create()
        {
            await CargarEditoriales();
            return View(new Libro());
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create(Libro libro)
        {
            if (!ModelState.IsValid)
            {
                await CargarEditoriales();
                return View(libro);
            }

            var response = await _http.PostAsJsonAsync("api/Libro", libro);

            if (response.IsSuccessStatusCode)
            {
                TempData["Success"] = "Libro creado correctamente";
                return RedirectToAction(nameof(Index));
            }

            TempData["Error"] = "Error al crear el libro";
            await CargarEditoriales();
            return View(libro);
        }

        public async Task<IActionResult> Edit(string id)
        {
            var libro = await _http.GetFromJsonAsync<Libro>($"api/Libro/{id}");
            if (libro == null) return NotFound();
            await CargarEditoriales();
            return View(libro);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(string id, Libro libro)
        {
            if (id != libro.CodigoLibro) return BadRequest();

            if (!ModelState.IsValid)
            {
                await CargarEditoriales();
                return View(libro);
            }

            var response = await _http.PutAsJsonAsync($"api/Libro/{id}", libro);

            if (response.IsSuccessStatusCode)
            {
                TempData["Success"] = "Libro actualizado";
                return RedirectToAction(nameof(Index));
            }

            TempData["Error"] = "Error al actualizar";
            await CargarEditoriales();
            return View(libro);
        }

        public async Task<IActionResult> Delete(string id)
        {
            var libro = await _http.GetFromJsonAsync<Libro>($"api/Libro/{id}");
            if (libro == null) return NotFound();
            return View(libro);
        }

        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(string id)
        {
            var response = await _http.DeleteAsync($"api/Libro/{id}");
            if (response.IsSuccessStatusCode)
                TempData["Success"] = "Libro eliminado";
            else
                TempData["Error"] = "No se pudo eliminar";

            return RedirectToAction(nameof(Index));
        }
    }
}