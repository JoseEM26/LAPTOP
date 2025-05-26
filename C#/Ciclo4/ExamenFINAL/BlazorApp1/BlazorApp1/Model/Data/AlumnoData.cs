using BlazorApp1.Model.Entity;
using Microsoft.Extensions.Logging;
using Newtonsoft.Json;
using System.Text;

namespace BlazorApp1.Model.Data
{
	public class AlumnoData
	{
		public ResultadoTransaccion<Alumno> ListadoAlumno()
		{
			ResultadoTransaccion<Alumno> resultado = new ResultadoTransaccion<Alumno>();
			try
			{
				using (HttpClient cliente = new HttpClient())
				{
					string ruta = "http://localhost:5155/API/Alumno/Listar_Alumnos";
					var response = cliente.GetAsync(ruta).Result;
					if (response.StatusCode == System.Net.HttpStatusCode.OK)
					{
						var result = response.Content.ReadAsStringAsync().Result;
						var dataresult = JsonConvert.DeserializeObject<ResultadoTransaccion<Alumno>>(result);
						resultado.IdRegistro = 0;
						resultado.Mensaje = dataresult.Mensaje;
						resultado.DataList = dataresult.DataList;
					}
					else
					{
						resultado.IdRegistro = -1;
						resultado.Mensaje = response.Content.ToString();
					}
				}

			}
			catch (Exception ex)
			{
				resultado.IdRegistro = -1;
				resultado.Mensaje = ex.Message;
			}
			return resultado;

		}
		public ResultadoTransaccion<Alumno> ListadoAlumno_X_ID(int idAlumno)
		{
			ResultadoTransaccion<Alumno> resultado = new ResultadoTransaccion<Alumno>();
			try
			{
				using (HttpClient cliente = new HttpClient())
				{
					string ruta = "http://localhost:5155/API/Alumno/Listar_Alumno_X_ID/" + idAlumno;
					var response = cliente.GetAsync(ruta).Result;
					if (response.StatusCode == System.Net.HttpStatusCode.OK)
					{
						var result = response.Content.ReadAsStringAsync().Result;
						var dataresult = JsonConvert.DeserializeObject<ResultadoTransaccion<Alumno>>(result);
						resultado.IdRegistro = 0;
						resultado.Mensaje = dataresult.Mensaje;
						resultado.Data = dataresult.Data;
					}
					else
					{
						resultado.IdRegistro = -1;
						resultado.Mensaje = response.Content.ToString();
					}
				}

			}
			catch (Exception ex)
			{
				resultado.IdRegistro = -1;
				resultado.Mensaje = ex.Message;
			}
			return resultado;

		}
		public ResultadoTransaccion<string> GuardarAlumno(Alumno alumno)
		{
			ResultadoTransaccion<string> resultado = new ResultadoTransaccion<string>();
			try
			{
				using (HttpClient cliente = new HttpClient())
				{
					string ruta = "http://localhost:5155/API/Alumno/Registrar_Alumno";
					var Json = JsonConvert.SerializeObject(alumno);
					var content = new StringContent(Json, Encoding.UTF8, "application/json");
					var response = cliente.PostAsync(ruta, content).Result;
					if (response.StatusCode == System.Net.HttpStatusCode.OK)
					{
						var result = response.Content.ReadAsStringAsync().Result;
						resultado = JsonConvert.DeserializeObject<ResultadoTransaccion<string>>(result);
					}
					else
					{
						resultado.IdRegistro = -1;
						resultado.Mensaje = response.Content.ToString();
					}
				}
			}
			catch (Exception ex)
			{
				resultado.IdRegistro = -1;
				resultado.Mensaje = ex.Message;
			}
			return resultado;
		}
		public ResultadoTransaccion<string> EliminarAlumno(int idVenta)
		{
			ResultadoTransaccion<string> resultado = new ResultadoTransaccion<string>();
			try
			{
				using (HttpClient cliente = new HttpClient())
				{
					string ruta = "http://localhost:5155/API/Alumno/Eliminar_Alumno/"+idVenta;
					var response = cliente.DeleteAsync(ruta).Result;
					if (response.StatusCode == System.Net.HttpStatusCode.OK)
					{
						var result = response.Content.ReadAsStringAsync().Result;
						resultado = JsonConvert.DeserializeObject<ResultadoTransaccion<string>>(result);
					}
					else
					{
						resultado.IdRegistro = -1;
						resultado.Mensaje = response.Content.ToString();
					}
				}
			}
			catch (Exception ex)
			{
				resultado.IdRegistro = -1;
				resultado.Mensaje = ex.Message;
			}
			return resultado;
		}
		public ResultadoTransaccion<string> ActualizarAlumno(Alumno alumno)
		{
			ResultadoTransaccion<string> resultado = new ResultadoTransaccion<string>();
			try
			{
				using (HttpClient cliente = new HttpClient())
				{
					string ruta = "http://localhost:5089/API/Alumno/Actualizar_Alumno";
					var Json = JsonConvert.SerializeObject(alumno);
					var content = new StringContent(Json, Encoding.UTF8, "application/json");
					var response = cliente.PostAsync(ruta, content).Result;
					if (response.StatusCode == System.Net.HttpStatusCode.OK)
					{
						var result = response.Content.ReadAsStringAsync().Result;
						resultado = JsonConvert.DeserializeObject<ResultadoTransaccion<string>>(result);
					}
					else
					{
						resultado.IdRegistro = -1;
						resultado.Mensaje = response.Content.ToString();
					}
				}
			}
			catch (Exception ex)
			{
				resultado.IdRegistro = -1;
				resultado.Mensaje = ex.Message;
			}
			return resultado;
		}
	}
}
