// Agregar 
using System.ComponentModel.DataAnnotations;
namespace ejerCore_T2_02.Models
{
    public class Propietario
    {
        [Required,Display(Name ="Codigo")] public String Cod_Propietario { get; set; }
        [Required, Display(Name = "Nombre")] public String Nom_Propietario { get; set; }
        [Required, Display(Name = "Apellido")] public String Ape_Propietario { get; set; }
        [Required, Display(Name = "Direccion")] public String Dir_Propietario { get; set; }
        [Required, Display(Name = "DNI")] public String DNI_Propietario { get; set; }
        [Required, Display(Name = "Distrito")] public String Cod_Distrito { get; set; }
    }
}
