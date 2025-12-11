using Microsoft.AspNetCore.Mvc;
using WebApplication1.Models;
using WebApplication1.Repository.Interfaces;

namespace WebApplication1.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EditorialController : ControllerBase
    {
        private readonly IEditorial _editorialRepository;

        public EditorialController(IEditorial editorialRepository)
        {
            _editorialRepository = editorialRepository;
        }

        [HttpGet]
        public async Task<ActionResult<IEnumerable<Editorial>>> GetAll()
        {
            return Ok(await _editorialRepository.GetAllAsync());
        }

        [HttpGet("{codigoEditorial}")]
        public async Task<ActionResult<Editorial>> GetById(string codigoEditorial)
        {
            var editorial = await _editorialRepository.GetByIdAsync(codigoEditorial);
            return editorial == null ? NotFound() : Ok(editorial);
        }

        [HttpPost]
        public async Task<ActionResult> Create([FromBody] Editorial editorial)
        {
            await _editorialRepository.AddAsync(editorial);
            return CreatedAtAction(nameof(GetById), new { codigoEditorial = editorial.CodigoEditorial }, editorial);
        }

        [HttpPut("{codigoEditorial}")]
        public async Task<ActionResult> Update(string codigoEditorial, [FromBody] Editorial editorial)
        {
            if (codigoEditorial != editorial.CodigoEditorial) return BadRequest();
            await _editorialRepository.UpdateAsync(editorial);
            return NoContent();
        }

        [HttpDelete("{codigoEditorial}")]
        public async Task<ActionResult> Delete(string codigoEditorial)
        {
            await _editorialRepository.DeleteAsync(codigoEditorial);
            return NoContent();
        }
    }
}