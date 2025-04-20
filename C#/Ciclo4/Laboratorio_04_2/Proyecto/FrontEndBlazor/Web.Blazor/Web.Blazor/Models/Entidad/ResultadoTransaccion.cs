namespace Web.Blazor.Models.Entidad
{
    public class ResultadoTransaccion<T>
    {
        public int IdRegistro { get; set; }
        public string Mensaje { get; set; }
        public bool Value {  get; set; }
        public T Data { get; set; }
        public List<T> DataList { get; set; }
    }
}
