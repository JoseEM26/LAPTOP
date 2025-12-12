using System.Text.Json.Serialization;
using WebApplication1.Models;

namespace WebApplication1.Models
{
    public class Editorial
    {
        public string CodigoEditorial { get; set; } = null!;
        public string NombreEditorial { get; set; } = null!;
        public string? Direccion { get; set; }
        public string? Email { get; set; }
        public string CodigoPais { get; set; } = null!;
        public Pais? Pais { get; set; } = null;
    }
}