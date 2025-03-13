using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SEMANA2_APLICACION2
{
    internal interface Inter_trabajador
    {
        int create(trabajador t);

        int delete(int codigo);

        int update(trabajador t);

        List<trabajador> consultarTodo();
        
        trabajador consultarXid(string codigo);
    }
}
