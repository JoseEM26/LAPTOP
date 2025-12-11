// Agregar
using app_CoreApi_04.Models;
namespace app_CoreApi_04.Repositorio.Interfaces
{
    public interface IPais
    {
        // Solo el metodo listar , para el dropdown de paises al momento de insertar o actualizar
        // el cliente
        IEnumerable<Pais> getPaises();
      
       
    }
}
