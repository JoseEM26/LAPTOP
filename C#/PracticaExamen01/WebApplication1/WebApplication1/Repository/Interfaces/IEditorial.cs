using WebApplication1.Models;

namespace WebApplication1.Repository.Interfaces
{
    public interface IEditorial
    {
        Task<IEnumerable<Editorial>> GetAllAsync();
        Task<Editorial?> GetByIdAsync(string codigoEditorial);
        Task AddAsync(Editorial editorial);
        Task UpdateAsync(Editorial editorial);
        Task DeleteAsync(string codigoEditorial);
    }
}
