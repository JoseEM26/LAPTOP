using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using System.Net.Http.Json;
using WebApplication1.Models;

namespace FrontEnd_T2.Controllers
{
    public class EditorialController : Controller
    {
        private readonly HttpClient _httpClient;

        private readonly string _apiBase = "https://localhost:7163";   

        public EditorialController(IHttpClientFactory clientFactory)
        {
            _httpClient = clientFactory.CreateClient();
            _httpClient.BaseAddress = new Uri(_apiBase);
        }

        private async Task CargarPaises()
        {
            try
            {
                var paises = await _httpClient.GetFromJsonAsync<List<Pais>>("api/Pais/combo") ?? new();
                ViewBag.Paises = paises.Select(p => new SelectListItem
                {
                    Value = p.CodigoPais,
                    Text = p.NombrePais
                }).ToList();
            }
            catch
            {
                ViewBag.Paises = new List<SelectListItem>();
            }
        }

        public async Task<IActionResult> Index()
        {
            try
            {
                var editoriales = await _httpClient.GetFromJsonAsync<List<Editorial>>("api/Editorial") ?? new();
                return View(editoriales);
            }
            catch (Exception ex)
            {
                TempData["Error"] = $"No se pudo conectar con la API: {ex.Message}";
                return View(new List<Editorial>());
            }
        }

        public async Task<IActionResult> Details(string id)
        {
            if (string.IsNullOrWhiteSpace(id))
                return NotFound();

            try
            {
                var editorial = await _httpClient.GetFromJsonAsync<Editorial>($"api/Editorial/{id}");

                if (editorial == null)
                    return NotFound();

                return View(editorial);
            }
            catch (HttpRequestException)
            {
                TempData["Error"] = "No se pudo contactar con la API o la editorial no existe.";
                return RedirectToAction(nameof(Index));
            }
        }

        public async Task<IActionResult> Create()
        {
            await CargarPaises();
            return View(new Editorial());
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create(Editorial editorial)
        {
            if (!ModelState.IsValid)
            {
                await CargarPaises();
                return View(editorial);
            }

            var response = await _httpClient.PostAsJsonAsync("api/Editorial", editorial);

            if (response.IsSuccessStatusCode)
            {
                TempData["Success"] = "Editorial creada correctamente.";
                return RedirectToAction(nameof(Index));
            }

            TempData["Error"] = "Error al crear la editorial (código duplicado u otro problema).";
            await CargarPaises();
            return View(editorial);
        }

        public async Task<IActionResult> Edit(string id)
        {
            if (string.IsNullOrWhiteSpace(id))
                return NotFound();

            var editorial = await _httpClient.GetFromJsonAsync<Editorial>($"api/Editorial/{id}");
            if (editorial == null)
                return NotFound();

            await CargarPaises();
            return View(editorial);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(string id, Editorial editorial)
        {
            if (id != editorial.CodigoEditorial)
                return BadRequest();

            

            var response = await _httpClient.PutAsJsonAsync($"api/Editorial/{id}", editorial);

            if (response.IsSuccessStatusCode)
            {
                TempData["Success"] = "Editorial actualizada correctamente.";
                return RedirectToAction(nameof(Index));
            }

            TempData["Error"] = "Error al actualizar la editorial.";
            await CargarPaises();
            return View(editorial);
        }

        public async Task<IActionResult> Delete(string id)
        {
            if (string.IsNullOrWhiteSpace(id))
                return NotFound();

            var editorial = await _httpClient.GetFromJsonAsync<Editorial>($"api/Editorial/{id}");
            if (editorial == null)
                return NotFound();

            return View(editorial);
        }

        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(string id)
        {
            var response = await _httpClient.DeleteAsync($"api/Editorial/{id}");

            if (response.IsSuccessStatusCode)
                TempData["Success"] = "Editorial eliminada correctamente.";
            else
                TempData["Error"] = "No se pudo eliminar la editorial (puede tener libros asociados).";

            return RedirectToAction(nameof(Index));
        }
    }
}