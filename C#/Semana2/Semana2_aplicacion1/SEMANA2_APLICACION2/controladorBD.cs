using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SEMANA2_APLICACION2
{
    internal class controladorBD : Inter_trabajador
    {
        public List<trabajador> consultarTodo()
        {
            throw new NotImplementedException();
        }

        public trabajador consultarXid(string codigo)
        {
            throw new NotImplementedException();
        }

        public int create(trabajador t)
        {
            return 1;          
        }

        public int delete(int codigo)
        {
            throw new NotImplementedException();
        }

        public int update(trabajador t)
        {
            throw new NotImplementedException();
        }
    }
}
