namespace FrontEndBlazor.Model.Entity
{
    public class ResultadoTransaction<T>
    {
        public int idRegistro { get; set; }
        public string mensaje { get; set; }
        public bool value { get; set; }
        public T data { get; set; }
        public List<T> dataList { get; set; }
    }
}
