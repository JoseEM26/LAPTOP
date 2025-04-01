using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using WebEmpleadoCrud.dao;
using WebEmpleadoCrud.dao.daoImpl;
using WebEmpleadoCrud.Models;

namespace WebEmpleadoCrud.servicio
{
    public class ServicioEmpleado
    {

        public int operacionesEscritura(string indicador,
            Empleado e)
        {
            IEmpleadoDao dao = new EmpleadoDaoImpl();
            return dao.operacionesEscritura(indicador, e);
        }
        public List<Empleado> operacionesLectura(string indicador,
            Empleado e)
        {
            IEmpleadoDao dao = new EmpleadoDaoImpl();
            return dao.operacionesLectura(indicador, e);
        }
      


    }
}