using System.ComponentModel.DataAnnotations;

namespace PracticaExamen_01.Models
{
    public class Empleado
    {
        public int IdEmpleado { get; set; }

        [Required(ErrorMessage = "El apellido es obligatorio")]
        [StringLength(50, MinimumLength = 2, ErrorMessage = "El apellido debe tener entre 2 y 50 caracteres")]
        public string ApeEmpleado { get; set; } = string.Empty;

        [Required(ErrorMessage = "El nombre es obligatorio")]
        [StringLength(50, MinimumLength = 2, ErrorMessage = "El nombre debe tener entre 2 y 50 caracteres")]
        public string NomEmpleado { get; set; } = string.Empty;

        [Required(ErrorMessage = "La fecha de nacimiento es obligatoria")]
        [DataType(DataType.Date)]
        public DateTime FecNac { get; set; } = DateTime.Today.AddYears(-20); // valor por defecto razonable

        [Required(ErrorMessage = "La dirección es obligatoria")]
        [StringLength(100, MinimumLength = 5, ErrorMessage = "La dirección debe tener entre 5 y 100 caracteres")]
        public string DirEmpleado { get; set; } = string.Empty;

        [Required(ErrorMessage = "El distrito es obligatorio")]
        public int idDistrito { get; set; }

        [StringLength(9, ErrorMessage = "El teléfono debe tener máximo 9 dígitos")]
        public string? fonoEmpleado { get; set; } // puede ser null

        [Required(ErrorMessage = "El cargo es obligatorio")]
        public int idCargo { get; set; }

        [Required(ErrorMessage = "La fecha de contratación es obligatoria")]
        [DataType(DataType.Date)]
        public DateTime FecContrata { get; set; } = DateTime.Today;
    }
}