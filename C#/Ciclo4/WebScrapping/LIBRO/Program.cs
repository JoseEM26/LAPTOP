using System;
using System.Net.Http;
using System.Threading.Tasks;
using HtmlAgilityPack;

namespace WebScrapingProductos
{
	class Program
	{
		static async Task Main(string[] args)
		{
			string url = "http://books.toscrape.com/";

			HttpClient client = new HttpClient();
			var response = await client.GetStringAsync(url);

			HtmlDocument document = new HtmlDocument();
			document.LoadHtml(response);

			// Cada libro está dentro de un <article class="product_pod">
			var libros = document.DocumentNode.SelectNodes("//article[@class='product_pod']");

			if (libros != null) 
			{
				Console.WriteLine("Libros encontrados:");
				foreach (var libro in libros)
				{
					// Nombre del libro (está en el atributo 'title' del enlace <a>)
					var tituloNode = libro.SelectSingleNode(".//h3/a");
					string titulo = tituloNode.GetAttributeValue("title", "Título no encontrado");

					// Precio del libro (dentro de <p class="price_color">)
					var precioNode = libro.SelectSingleNode(".//p[@class='price_color']");
					string precio = precioNode?.InnerText ?? "Precio no encontrado";

					Console.WriteLine($"Título: {titulo}");
					Console.WriteLine($"Precio: {precio}");
					Console.WriteLine(new string('-', 40));
				}
			}
			else
			{
				Console.WriteLine("No se encontraron libros.");
			}

			Console.ReadLine();
		}
	}
}
