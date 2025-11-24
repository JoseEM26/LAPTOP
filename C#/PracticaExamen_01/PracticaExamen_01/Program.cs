using PracticaExamen_01.Service;

var builder = WebApplication.CreateBuilder(args);

builder.Services.AddControllersWithViews();
// ✅ AQUÍ ESTAN LOS SERVICIOS :->)
builder.Services.AddScoped<EmpleadoService>();


var app = builder.Build();

if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Home/Error");
    app.UseHsts();
}





app.UseHttpsRedirection();
app.UseStaticFiles();

app.UseRouting();

app.UseAuthorization();

app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Home}/{action=Index}/{id?}");

app.Run();
