using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tarea8_GuiaMVC.Services
{
    internal interface ICrudDaoProducto<T>
    {
        List<T> ListarProducto();
        T BuscarProductoID(int id);
        void InsertarProducto(T p);
        void ActualizarProducto(T p);
        void EliminarProducto(int id);
    }
}
