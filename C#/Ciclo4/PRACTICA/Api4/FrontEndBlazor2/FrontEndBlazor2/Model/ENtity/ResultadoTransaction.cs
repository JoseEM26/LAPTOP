namespace FrontEndBlazor2.Model.ENtity
{
    public class ResultadoTransaction<T>
    {
        public int IdRegistro { get; set; }
        public string Mensaje { get; set; }
        public bool Value { get; set; }
        public T Data { get; set; }
        public List<T> DataList { get; set; }
    }
}
