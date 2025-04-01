using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WebEmpleadoCrud.Models;

namespace WebEmpleadoCrud.dao
{
    internal interface IEmpleadoDao
    {

        // INSERT DELETE UPDATE
        int operacionesEscritura(string indicador, 
            Empleado e);

        // SELECT
        List<Empleado> operacionesLectura(string indicador, 
            Empleado e);


    }
}
