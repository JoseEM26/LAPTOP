using Aplicacion.Services;
using Dominio.Interfaz;
using Infraestructura;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();
//----------------------------------------------------------------
string conexion = builder.Configuration.GetConnectionString("db");
//conexion
builder.Services.AddSingleton(new ConecctionSQL(conexion));

builder.Services.AddScoped<IAlumnoRepositorio, AlumnoRepositorio>();
builder.Services.AddScoped <AlumnoService>();

//----------------------------------------------------------------
var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseAuthorization();

app.MapControllers();

app.Run();
