using Grpc.Core;
using GrpcServicePromediar;

namespace GrpcServicePromediar.Services
{
    public class PromediarService : PromediarNotas.PromediarNotasBase
    {
        private readonly ILogger<PromediarService> _logger;

        public PromediarService(ILogger<PromediarService> logger)
        {
            _logger = logger;
        }

        public override Task<NotasResponse> CalcularPromedio(NotasRequest request, ServerCallContext context)
        {
            int n1 = request.Nota1;
            int n2 = request.Nota2;
            int n3 = request.Nota3;

            int suma = n1 + n2 + n3;
            float promedio = (float)suma / 3.0f;

            _logger.LogInformation("Notas recibidas :{N1} , {N2} , {N3} . Promedio calculado :{Promedio}",n1,n2,n3,promedio);

            NotasResponse resultado = new NotasResponse();
            resultado.Promedio = promedio;

            return Task.FromResult(resultado);
        }
    }
}