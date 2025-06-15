using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tarea8_GuiaMVC.Services
{
    internal interface IDatoCategoria<T>
    {
        List<T> ListarCategoria();
    }
}
