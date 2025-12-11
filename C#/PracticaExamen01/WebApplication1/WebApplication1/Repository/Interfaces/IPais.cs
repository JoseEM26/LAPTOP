using WebApplication1.Models;

namespace WebApplication1.Repository.Interfaces
{
    public interface IPais
    {
        Task<IEnumerable<Pais>> GetForComboAsync();
    }
}
