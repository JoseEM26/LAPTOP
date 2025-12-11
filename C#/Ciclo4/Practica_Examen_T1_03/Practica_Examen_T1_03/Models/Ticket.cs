namespace Practica_Examen_T1_03.Models
{
    public class Ticket
    {
        public int TicketId { get; set; }
        public int ItemId { get; set; }
        public int AgenciaId { get; set; }
        public DateTime FechaCreacion { get; set; }
        public DateTime FechaCierre { get; set; }
        public string ServiceDesk { get; set; }
        public string Resumen { get; set; }
        public int EstadoId { get; set; }
    }
}
