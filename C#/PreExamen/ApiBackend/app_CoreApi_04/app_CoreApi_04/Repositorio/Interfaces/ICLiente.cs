// Agregar
using app_CoreApi_04.Models;
namespace app_CoreApi_04.Repositorio.Interfaces
{
    public interface ICLiente
    {
        // Solo van los metodos, lo que se conoce como "la firma"
        IEnumerable<Cliente> getClientes();
        Cliente getCliente(string id);
        string insertCliente (Cliente reg);
        string updateCliente (Cliente reg);
    }
}
