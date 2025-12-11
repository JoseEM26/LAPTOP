using GrpcServicePromediar.Services;
using GrpcServiceRegistro.Services;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddGrpc();

var app = builder.Build();

// Configure the HTTP request pipeline.
app.MapGrpcService<GreeterService>();
app.MapGet("/", () => "HOLA ESTAMOS EN EL SERVICIO DE GREETER");

app.MapGrpcService<PromediarService>();
app.MapGet("/promediar", () => "HOLA ESTAMOS EN EL SERVICIO DE PROMEDIAR");


app.Run();
