namespace FrontEndVenta.Model.Entity
{
    public class ResultadoTransaction<T>
    {
        public int idRespuesta { get; set; }
        public string mensaje { get; set; }
        public bool value { get; set; }
        public T data { get; set; }
        public List<T> listData { get; set; }
    }
}
