using POOI_Semana04.dao;
using POOI_Semana04.dao.daoImpl;
using POOI_Semana04.Models;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace POOI_Semana04.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {

            PaisDao dao = new PaisDaoImpl();
            Pais objPais = dao.obtenerPais("AR");
            Debug.WriteLine("Codigo : "+ objPais.country_id);
            Debug.WriteLine("Nombre : " + objPais.country_name);
            Debug.WriteLine("Region : " + objPais.region_id);
            Debug.WriteLine("***************************");
            List<Pais> lista = dao.consultarTodo();
            foreach(Pais obj in lista)
            {
                Debug.WriteLine("Codigo : " + objPais.country_id);
                Debug.WriteLine("Nombre : " + objPais.country_name);
                Debug.WriteLine("Region : " + objPais.region_id);
            }    

            return View();
        }

        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";

            return View();
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }
    }
}