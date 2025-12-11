// Agregar 
using System.ComponentModel.DataAnnotations;
namespace ejerCore_T2_02.Models
{
    public class Propietario
    {
        //EXPRESIONES REGULARES
        //LIMITACIONES DE CARACTERES Y QUE SEAN NUMEROS EN LOS STRINGS
        //DATOS SI O SI REQUERIDOS

        [Required,Display(Name ="Codigo")]
        [StringLength(5,MinimumLength =5,ErrorMessage ="El codigo debe tener exsactamente 5 caracteres")]
        public String Cod_Propietario { get; set; }
        [Required, Display(Name = "Nombre")] public String Nom_Propietario { get; set; }
        [Required, Display(Name = "Apellido")] public String Ape_Propietario { get; set; }
        [Required, Display(Name = "Direccion")] public String Dir_Propietario { get; set; }
        [Required, Display(Name = "DNI")]

        [StringLength(8, MinimumLength = 8, ErrorMessage = "El DNI debe tener exsactamente 8 caracteres")]
        public String DNI_Propietario { get; set; }
        [Required, Display(Name = "Distrito")]
        public String Cod_Distrito { get; set; }
    }
}
