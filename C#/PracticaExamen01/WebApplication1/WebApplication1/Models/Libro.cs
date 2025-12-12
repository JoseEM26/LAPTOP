using System.Text.Json.Serialization;

namespace WebApplication1.Models
{
    public class Libro
    {
        public string CodigoLibro { get; set; } = null!;
        public string TituloLibro { get; set; } = null!;
        public string Autor { get; set; } = null!;
        public string? Genero { get; set; }
        public string CodigoEditorial { get; set; } = null!;

        public Editorial? Editorial { get; set; } = null;
    }
}