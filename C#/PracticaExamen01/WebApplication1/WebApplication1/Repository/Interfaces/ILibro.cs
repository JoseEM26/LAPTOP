using WebApplication1.Models;

namespace WebApplication1.Repository.Interfaces
{
    public interface ILibro
    {
        Task<IEnumerable<Libro>> GetAllAsync();
        Task<Libro?> GetByIdAsync(string codigoLibro);
        Task AddAsync(Libro libro);
        Task UpdateAsync(Libro libro);
        Task DeleteAsync(string codigoLibro);
    }
}
