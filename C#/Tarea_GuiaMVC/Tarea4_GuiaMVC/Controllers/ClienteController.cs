using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Tarea4_GuiaMVC.Models;

namespace Tarea4_GuiaMVC.Controllers
{
    public class ClienteController : Controller
    {
        // GET: Cliente
        AccesoDatos data = new AccesoDatos();
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Cliente()
        {
            List<Cliente> lista = data.ListaCliente();
            return View(lista);
        }

        public ActionResult Pedido()
        {
            List<Pedido> lista = data.ListaPedido();
            return View(lista);
        }


    }
}