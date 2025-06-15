using Newtonsoft.Json;
using POOI_T2_EspinozaMoralesJoseAngel.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace POOI_T2_EspinozaMoralesJoseAngel.Controllers
{
    public class AgenciaController : Controller
    {
        // GET: Agencia
        public static List<Agencia> lista = new List<Agencia>()
        {
            new Agencia(){AgenciaId=1,ares="Libre",departamento="ICA",Direccion="Entrada Ica",distrito="ICA",Nombre="Enmanuel",provincia="Lima"},
            new Agencia(){AgenciaId=2,ares="Cordillera",departamento="Junin",Direccion="Candabandapio",distrito="Junin",Nombre="Miguel",provincia="Junin"},
            new Agencia(){AgenciaId=3,ares="Lima",departamento="Lima",Direccion="SJL",distrito="SJL",Nombre="Jose",provincia="Lima"}
        };
        public ActionResult Index()
        {
            return View(lista);
        }
        public ActionResult Agregar()
        {
            return View(new Agencia());
        }   
        [HttpPost]public ActionResult Agregar(Agencia a)
        {
            if (lista.Where(x=>x.AgenciaId==a.AgenciaId).FirstOrDefault()!=null)
            {
                ViewBag.validacion = "Este codigo ya existe";
                return View(a);
            }
            var newAgencia = new Agencia()
            {
                AgenciaId = a.AgenciaId,
                ares=a.ares,
                departamento=a.departamento,
                Direccion=a.Direccion,
                distrito=a.distrito,
                Nombre=a.Nombre,
                provincia=a.provincia
            };
            lista.Add(newAgencia);
            Serializar();

            return RedirectToAction("Index");
        }

        public ActionResult Eliminar(int id)
        {
            var eliminar=lista.Where(x=>x.AgenciaId==id).FirstOrDefault();
            Serializar();
            return View(eliminar);
        }
        [HttpPost ,ActionName("Eliminar")]
        public ActionResult EliminarConfirmacion(int id)
        {
            var Eliminar = lista.Where(x=>x.AgenciaId==id).FirstOrDefault();
            lista.Remove(Eliminar);
            return RedirectToAction("Index");
        }
        public ActionResult Serializar()
        {
            string ruta = "C:/Users/JOSE ANGEL/Pictures/LAPTOP/C#/POOI_T2_EspinozaMoralesJoseAngel/agencia.txt";

            try
            {
                string json = JsonConvert.SerializeObject(lista, Formatting.Indented);
                System.IO.File.WriteAllText(ruta, json);
                TempData["mensaje"] = "Los datos han sido guardados correctamente en el archivo .txt.";
            }
            catch (Exception ex)
            {
                TempData["mensaje"] = "Ocurrió un error al guardar los datos: " + ex.Message;
            }

            return RedirectToAction("Index");
        }


    }
}