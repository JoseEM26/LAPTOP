using System.ComponentModel.DataAnnotations;
namespace app_Core04.Models
{
    public class Cliente
    {
        [Required]
        [Display(Name ="Id. Cliente")] public string  idcliente {  get; set; }
        [Required]
        [Display (Name ="Nombre clilente")] public string nombrecia { get; set; }
        [Required]
        [Display(Name = "Direccion cliente ")] public string direccion { get; set; }
        [Required]
        [Display (Name ="Id. Pais")] public string idpais { get; set; } 
        [Required]
        [Display(Name ="Fono cliente")] public string fono {  get; set; }   
    }
}
