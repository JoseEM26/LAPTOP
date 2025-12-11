using Grpc.Core;
using GrpcServiceRegistro;

namespace GrpcServiceRegistro.Services
{
    public class GreeterService : Greeter.GreeterBase
    {
        private readonly ILogger<GreeterService> _logger;
        public GreeterService(ILogger<GreeterService> logger)
        {
            _logger = logger;
        }

        public override Task<HelloReply> SayHello(HelloRequest request, ServerCallContext context)
        {
            // Se arma el mensaje con la concatenacion de los 3 elementos definido en el proto
            
            string mensaje = string.Concat(request.Codigo, "-", request.Nombre, "-", request.Apellido);
            return Task.FromResult(new HelloReply
            {
                Message = "HOLA  " + mensaje
            });
        }
    }
}
