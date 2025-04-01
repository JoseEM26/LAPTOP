using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.WebPages;
using Tarea6_GuiaMVC.Models;

namespace Tarea6_GuiaMVC.Controllers
{
    public class ConsultaNegociosController : Controller
    {
        // GET: ConsultaNegocios
        NegociosEntities1 data = new NegociosEntities1();
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult ProductoListar()
        {
            var lista =from p in data.USP_PRODUCTOlISTAR()
                       select p;
            return View(lista.ToList());
        }
        public ActionResult ProductoNombreListar(string Nombre)
        {
            if (Nombre == null) Nombre = string.Empty;
            ViewBag.Nombre = Nombre;

            var lista1 = from p in data.USP_PRODUCTOlISTAR()
                         where p.NomProducto.StartsWith(Nombre)
                         select p;

            return View(lista1.ToList());
        }
        public ActionResult PedidoCliente(string id)
        {
            if (id == null) id = string.Empty;
            ViewBag.Cliente = new SelectList(data.Clientes.ToList(),
                                        "idCliente", "NomCliente",
                                        id);


            var lista2 = from p in data.pedidoscabe
                         where p.IdCliente.Equals(id)
                         select p;

            return View(lista2.ToList());
        }
    }
}