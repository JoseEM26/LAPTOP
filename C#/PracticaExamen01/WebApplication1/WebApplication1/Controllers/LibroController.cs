// Controllers/LibroController.cs
using Microsoft.AspNetCore.Mvc;
using WebApplication1.Models;
using WebApplication1.Repository.Interfaces;

namespace WebApplication1.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class LibroController : ControllerBase
    {
        private readonly ILibro _libroRepository;

        public LibroController(ILibro libroRepository)
        {
            _libroRepository = libroRepository;
        }

        // GET: api/Libro
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Libro>>> GetAll()
        {
            var libros = await _libroRepository.GetAllAsync();
            return Ok(libros);
        }

        // GET: api/Libro/L001
        [HttpGet("{codigoLibro}")]
        public async Task<ActionResult<Libro>> GetById(string codigoLibro)
        {
            var libro = await _libroRepository.GetByIdAsync(codigoLibro);
            if (libro == null) return NotFound();
            return Ok(libro);
        }

        // POST: api/Libro
        [HttpPost]
        public async Task<ActionResult> Create([FromBody] Libro libro)
        {
            if (!ModelState.IsValid) return BadRequest(ModelState);

            await _libroRepository.AddAsync(libro);
            return CreatedAtAction(nameof(GetById), new { codigoLibro = libro.CodigoLibro }, libro);
        }

        // PUT: api/Libro/L001
        [HttpPut("{codigoLibro}")]
        public async Task<ActionResult> Update(string codigoLibro, [FromBody] Libro libro)
        {
            if (codigoLibro != libro.CodigoLibro) return BadRequest("Código no coincide");

            await _libroRepository.UpdateAsync(libro);
            return NoContent();
        }

        // DELETE: api/Libro/L001
        [HttpDelete("{codigoLibro}")]
        public async Task<ActionResult> Delete(string codigoLibro)
        {
            await _libroRepository.DeleteAsync(codigoLibro);
            return NoContent();
        }
    }
}