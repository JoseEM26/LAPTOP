using Aplicacion.Servicios;
using Dominio.Interfaces;
using Infraestructura;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();
///------------------------------------------------------------------------------------------------------
string cadenaconexion = builder.Configuration.GetConnectionString("CnxSql");
builder.Services.AddSingleton(new ConexionBD(cadenaconexion));

//Referencia las interfaces
builder.Services.AddScoped<IAlumnoRepositorio, AlumnoRepositorio>();

//Registramos la aplicación
builder.Services.AddScoped<AlumnoServicio>();

var app = builder.Build();
///------------------------------------------------------------------------------------------------------

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseAuthorization();

app.MapControllers();

app.Run();
