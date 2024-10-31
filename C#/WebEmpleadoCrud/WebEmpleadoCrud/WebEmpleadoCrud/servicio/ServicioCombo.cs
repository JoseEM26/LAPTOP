using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using WebEmpleadoCrud.dao;
using WebEmpleadoCrud.dao.daoImpl;
using WebEmpleadoCrud.Models;

namespace WebEmpleadoCrud.servicio
{
    public class ServicioCombo
    {
        public List<Combo> listadoCombo(string indicador)
        {
            FormularioDao dao = new FormularioDaoImpl();
            return dao.listadoCombo(indicador);
        }
    }
}