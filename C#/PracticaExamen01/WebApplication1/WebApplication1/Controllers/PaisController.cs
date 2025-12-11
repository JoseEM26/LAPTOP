using Microsoft.AspNetCore.Mvc;
using WebApplication1.Repository.Interfaces;

namespace WebApplication1.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class PaisController : ControllerBase
    {
        private readonly IPais _paisRepository;

        public PaisController(IPais paisRepository)
        {
            _paisRepository = paisRepository;
        }

        // GET: api/Pais/combo
        [HttpGet("combo")]
        public async Task<ActionResult> GetForCombo()
        {
            var paises = await _paisRepository.GetForComboAsync();
            return Ok(paises);
        }
    }
}