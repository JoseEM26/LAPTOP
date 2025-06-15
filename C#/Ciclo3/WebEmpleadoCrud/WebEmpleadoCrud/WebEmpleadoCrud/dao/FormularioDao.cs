using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WebEmpleadoCrud.Models;

namespace WebEmpleadoCrud.dao
{
    internal interface FormularioDao
    {

        List<Combo> listadoCombo(string indicador);


    }
}
