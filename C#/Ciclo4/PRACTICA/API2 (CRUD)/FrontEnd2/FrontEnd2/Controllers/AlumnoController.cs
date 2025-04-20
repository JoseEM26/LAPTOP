using FrontEnd2.Models.Entity;
using FrontEnd2.Models.Logica;
using Microsoft.AspNetCore.Mvc;

namespace FrontEnd2.Controllers
{
    public class AlumnoController : Controller
    {
        AlumnoLogica logia = new AlumnoLogica();
        
        [HttpGet]
        public IActionResult Listar()
        {
            return View(logia.listarAlumno());
        }
        [HttpGet]
        //Create------------------------------------------

        public IActionResult Create()
        {
            return View(new Alumno());
        }
        [HttpPost]
        public IActionResult Create(Alumno a)
        {
            List<Alumno> lista = logia.listarAlumno();
            if (!ModelState.IsValid || a.fechaNacimiento <= DateTime.MinValue || lista.Any(x=>x.nroDocumento==a.nroDocumento))
            {
                TempData["errorCreate"] = "<script>Swal.fire({title: \"Error!\", text: \"Hubo un problema al crear el alumno.\", icon: \"error\"});</script>";
                return View(new Alumno());
            }
            
                logia.Create(a);
                TempData["notificacion"] = "<script>Swal.fire({title: \"Good job!\", text: \"Alumno creado exitosamente!\", icon: \"success\"});</script>";
                return RedirectToAction("Listar");
            
            
        }
        //ListarXID------------------------------------------
        [HttpGet]
        public IActionResult ListarXID(int id)
        {
            return View(logia.ListarXID(id));
        }
        //update---------------------------------------
        [HttpGet]
        public IActionResult GetUpdate(int id)
        {
            Alumno alumno = logia.ListarXID(id);
            return View(alumno);
        }
        [HttpPost]
        [ActionName("GetUpdate")]
        public IActionResult Update(Alumno a)
        {
            List<Alumno> lista = logia.listarAlumno();
            if (!ModelState.IsValid || a.fechaNacimiento <= DateTime.MinValue)
            {
                TempData["errorActualizar"] = "<script>Swal.fire({title: \"Error!\", text: \"Hubo un problema al Actualizar el alumno.\", icon: \"error\"});</script>";
                return View(logia.ListarXID(a.idAlumno));
            }

            logia.Update(a);
            TempData["notificacion"] = "<script>Swal.fire({title: \"Good job!\", text: \"Alumno Actualizado exitosamente!\", icon: \"success\"});</script>";
            return RedirectToAction("Listar");
        }
        //Delete-------------------------------------
        [HttpGet]
        public IActionResult getDelete(int id)
        {
            Alumno alumno = logia.ListarXID(id);
            return View(alumno);
        }
        [HttpPost]
        [ActionName("getDelete")]
        public IActionResult Delete(int id)
        {
            logia.eliminar(id);
            TempData["notificacion"] = "<script>Swal.fire({title: \"DELETE!\", text: \"Alumno ELiminado exitosamente!\", icon: \"success\"});</script>";
            return RedirectToAction("Listar");
        }
    }
}
