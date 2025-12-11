using app_Core04.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Newtonsoft.Json;
using System.Text;

namespace app_Core04.Controllers
{
    public class NegocioController : Controller
    {
        private readonly string _apiPais = "https://localhost:7033/api/pais";
        private readonly string _apiCliente = "https://localhost:7033/api/cliente";

        private async Task<List<Pais>> CargarPaises()
        {
            using var cliente = new HttpClient();
            var response = await cliente.GetAsync(_apiPais);
            response.EnsureSuccessStatusCode();
            var json = await response.Content.ReadAsStringAsync();
            return JsonConvert.DeserializeObject<List<Pais>>(json) ?? new List<Pais>();
        }

        private async Task<List<Cliente>> CargarClientes()
        {
            using var cliente = new HttpClient();
            var response = await cliente.GetAsync(_apiCliente);
            response.EnsureSuccessStatusCode();
            var json = await response.Content.ReadAsStringAsync();
            return JsonConvert.DeserializeObject<List<Cliente>>(json) ?? new List<Cliente>();
        }

        public async Task<IActionResult> Index()
        {
            var clientes = await CargarClientes();
            return View(clientes);
        }

        public async Task<IActionResult> Create()
        {
            ViewBag.ListaPaises = new SelectList(await CargarPaises(), "idpais", "nombrepais");
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create(Cliente reg)
        {
            if (!ModelState.IsValid)
            {
                ViewBag.ListaPaises = new SelectList(await CargarPaises(), "idpais", "nombrepais");
                return View(reg);
            }

            using var cliente = new HttpClient();
            var json = JsonConvert.SerializeObject(reg);
            var content = new StringContent(json, Encoding.UTF8, "application/json");

            var response = await cliente.PostAsync(_apiCliente, content);

            if (response.IsSuccessStatusCode)
            {
                return RedirectToAction(nameof(Index)); // Éxito → redirige al Index
            }
            else
            {
                var error = await response.Content.ReadAsStringAsync();
                ModelState.AddModelError("", "Error al guardar el cliente: " + error);
                ViewBag.ListaPaises = new SelectList(await CargarPaises(), "idpais", "nombrepais");
                return View(reg);
            }
        }

        public async Task<IActionResult> Edit(string id)
        {
            if (string.IsNullOrEmpty(id))
            {
                return RedirectToAction("Index");
            }
            Cliente reg = new Cliente();
            using(var cliente=new HttpClient())
            {
                cliente.BaseAddress=new Uri(_apiCliente);
                HttpResponseMessage response = await cliente.GetAsync("/" + id);
                string apiresponse = await response.Content.ReadAsStringAsync();
                reg = JsonConvert.DeserializeObject<Cliente>(apiresponse);

                ViewBag.ListaPaises = new SelectList(await CargarPaises(), "idpais", "nombrepais");

                return View(reg);
            }
        }

        [HttpPut]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(Cliente reg)
        {
            if (!ModelState.IsValid)
            {
                ViewBag.ListaPaises = new SelectList(await CargarPaises(), "idpais", "nombrepais");
                return View(reg);
            }

            using var cliente = new HttpClient();
            var json = JsonConvert.SerializeObject(reg);
            var content = new StringContent(json, Encoding.UTF8, "application/json");

            var response = await cliente.PutAsync(_apiCliente, content);

            if (response.IsSuccessStatusCode)
            {
                return RedirectToAction(nameof(Index)); // Éxito → redirige al Index
            }
            else
            {
                var error = await response.Content.ReadAsStringAsync();
                ModelState.AddModelError("", "Error al guardar el cliente: " + error);
                ViewBag.ListaPaises = new SelectList(await CargarPaises(), "idpais", "nombrepais");
                return View(reg);
            }
        }
    }
}