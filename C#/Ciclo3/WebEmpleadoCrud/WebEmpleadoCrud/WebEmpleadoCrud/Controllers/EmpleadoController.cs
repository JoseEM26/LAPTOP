using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using WebEmpleadoCrud.Models;
using WebEmpleadoCrud.servicio;

namespace WebEmpleadoCrud.Controllers
{
    public class EmpleadoController : Controller
    {
        // GET: Empleado
        public ActionResult Inicio()
        {
            List<Empleado> lista = getListaEmpleado("ConsultarTodo", new Empleado());
            return View(lista);
        }

        public ActionResult Detalle(int id=0)
        {
            Empleado emp = getEmpleado(id);
            return View(emp);
        }

        public ActionResult Editar(int id=0)
        {
            Empleado emp = getEmpleado(id);
            return View(emp);
        }

        public ActionResult Eliminar(int id=0)
        {
            Empleado emp= getEmpleado(id);
            return View(emp);
        }

        public Empleado getEmpleado(int id)
        {
            List<Empleado> lista = getListaEmpleado("ConsultarXID", new Empleado(id) );

            if (lista.Count >0)
            {
                return lista.First();
            }
            return null;
        }

        public List<Empleado> getListaEmpleado(string indicador, Empleado e)
        {
            ServicioEmpleado servicio = new ServicioEmpleado();
            List<Empleado> lista = servicio.operacionesLectura(indicador, e);
            return lista;
        }

        public ActionResult Crear()
        {
            ServicioCombo servicioCombo = new ServicioCombo();
            List<Combo> lista = servicioCombo.listadoCombo("tabla_empleado");

            ViewBag.comboTrabajo = new SelectList(lista.Where(x=>x.indicador.Equals("TRABAJO")), "combo_id", "combo_name");
            ViewBag.comboEmpleado = new SelectList(lista.Where(x=>x.indicador.Equals("EMPLEADO")), "combo_id", "combo_name");
            ViewBag.comboDepartamento = new SelectList(lista.Where(x=>x.indicador.Equals("DEPARTAMENTO")), "combo_id", "combo_name");

            return View();
        }



    }
}
