using Microsoft.AspNetCore.Mvc;
using ejerCore_T2_02.Models;
using System.Data;
using Microsoft.Data.SqlClient;
using Microsoft.AspNetCore.Mvc.Rendering;
namespace ejerCore_T2_02.Controllers
{
    public class PropietarioController : Controller
    {
        // definimos la propiedad de tipo IConfig para la conexion
        private readonly IConfiguration _config;

        public PropietarioController(IConfiguration config)
        {
            _config = config;
        }

        private readonly ILogger<PropietarioController> _logger;

       

        // Agregue aqui los metodos de acceso a datos...
        IEnumerable<Propietario> Listado()
        {
            List<Propietario> temporal = new List<Propietario>();   

            using (SqlConnection cn = new SqlConnection(_config .GetConnectionString ("Infracciones")))
            {
                cn.Open ();
                SqlCommand cmd = new SqlCommand("usp_ListarPropietario", cn);
                SqlDataReader dr = cmd.ExecuteReader ();
                while (dr.Read())
                {
                    temporal.Add(new Propietario()
                    {
                        Cod_Propietario = dr.GetString(0),
                        Nom_Propietario = dr.GetString(1),
                        Ape_Propietario = dr.GetString(2),
                        Dir_Propietario = dr.GetString(3),
                        DNI_Propietario = dr.GetString(4),
                        Cod_Distrito = dr.GetString(5)
                    });
                }
                //Cerramos el dr
                dr.Close ();
            }
            return temporal;


        }

        String MergePropietario(Propietario propietario)
        {
            String mensaje = String.Empty;

            using(SqlConnection con=new SqlConnection(_config.GetConnectionString("Infracciones")))
            {
                try
                {
                    SqlCommand cmd = new SqlCommand("usp_MergePropietario", con);
                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.Parameters.AddWithValue("@Cod_Propietario", propietario.Cod_Propietario);
                    cmd.Parameters.AddWithValue("@Nom_Propietario", propietario.Nom_Propietario);
                    cmd.Parameters.AddWithValue("@Ape_Propietario", propietario.Ape_Propietario);
                    cmd.Parameters.AddWithValue("@Dir_Propietario", propietario.Dir_Propietario);
                    cmd.Parameters.AddWithValue("@DNI_Propietario", propietario.DNI_Propietario);
                    cmd.Parameters.AddWithValue("@Cod_Distrito", propietario.Cod_Distrito);

                    con.Open();
                    int i = cmd.ExecuteNonQuery();
                    mensaje = $"SE INSERTO {i} PROPIETARIO";

                }catch(Exception e)
                {
                    mensaje = e.Message;
                }
                finally
                {
                    con.Close();
                }
            }


            return null;
        }

        IEnumerable<Distrito> Distritos()
        {
            List<Distrito> temporal = new List<Distrito>();

            using (SqlConnection cn = new SqlConnection(_config.GetConnectionString("Infracciones")))
            {
                cn.Open();
                SqlCommand cmd = new SqlCommand("usp_ListarDistrito", cn);
                SqlDataReader dr = cmd.ExecuteReader();
                while (dr.Read())
                {
                    temporal.Add(new Distrito()
                    {
                        Cod_distrito = dr.GetString(0),
                        Nom_distrito = dr.GetString(1),
                    });
                }
                dr.Close();
            }
            return temporal;


        }

        Propietario buscar(String codigo)
        {
            return Listado().Where(x => x.Cod_Propietario == codigo).FirstOrDefault();
        }


        public async Task<IActionResult> Index()
        {
            return View(await Task.Run(()=> Listado()));
        }

        public async Task<IActionResult> Create()
        {
            ViewBag.Distritos = new SelectList(Distritos(), "Cod_distrito", "Nom_distrito");
            return View(await Task.Run(()=>new Propietario()));
        }

        [HttpPost]
        public async Task<IActionResult> Create(Propietario registro)
        {
            //SI EL MODELO ES VALIDO
            if (!ModelState.IsValid)
            {
                ViewBag.Distritos = new SelectList(Distritos(), "Cod_distrito", "Nom_distrito");
                return View(await Task.Run(() =>registro));
            }

            ViewBag.mensaje = MergePropietario(registro);
            ViewBag.Distritos = new SelectList(Distritos(), "Cod_distrito", "Nom_distrito");


            return View(await Task.Run(() => registro));

        }
    }
}
