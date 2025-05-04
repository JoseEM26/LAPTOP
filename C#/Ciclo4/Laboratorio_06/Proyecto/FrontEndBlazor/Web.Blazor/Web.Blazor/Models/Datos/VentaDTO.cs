using System.Text;
using Newtonsoft.Json;
using Web.Blazor.Models.Entidad;

namespace Web.Blazor.Models.Datos
{
    public class VentaDTO
    {
        public ResultadoTransaccion<string> GuardarVenta(EVenta objventa)
        {
            ResultadoTransaccion<string>resultado = new ResultadoTransaccion<string>();
            try {
                using (HttpClient cliente = new HttpClient()) 
                {
                    string ruta = "http://localhost:5089/API/Venta/Registrar_Venta";
                    var Json =JsonConvert.SerializeObject(objventa);
                    var content = new StringContent(Json, Encoding.UTF8, "application/json");
                    var response = cliente.PostAsync(ruta, content).Result;
                    if (response.StatusCode == System.Net.HttpStatusCode.OK)
                    {
                        var result = response.Content.ReadAsStringAsync().Result;
                        resultado = JsonConvert.DeserializeObject<ResultadoTransaccion<string>>(result);
                    }
                    else {
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

        public ResultadoTransaccion<EVenta> ListadoVenta() 
        {
            ResultadoTransaccion<EVenta> resultado = new ResultadoTransaccion<EVenta>();
            try {
                using (HttpClient cliente = new HttpClient()) 
                {
                    string ruta = "http://localhost:5089/API/Venta/ListarVentas";
                    var response = cliente.GetAsync(ruta).Result;
                    if (response.StatusCode == System.Net.HttpStatusCode.OK) 
                    {
						var result = response.Content.ReadAsStringAsync().Result;
                        var dataresult = JsonConvert.DeserializeObject<ResultadoTransaccion<EVenta>>(result);
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


		public ResultadoTransaccion<EVenta> ListadoVenta_X_ID(int Idventa)
		{
			ResultadoTransaccion<EVenta> resultado = new ResultadoTransaccion<EVenta>();
			try
			{
				using (HttpClient cliente = new HttpClient())
				{
					string ruta = "http://localhost:5089/API/Venta/ListarVentasXID?IdVenta="+ Idventa.ToString();
					var response = cliente.GetAsync(ruta).Result;
					if (response.StatusCode == System.Net.HttpStatusCode.OK)
					{
						var result = response.Content.ReadAsStringAsync().Result;
						var dataresult = JsonConvert.DeserializeObject<ResultadoTransaccion<EVenta>>(result);
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

		public ResultadoTransaccion<string> ActualizarVenta(EVenta objventa)
		{
			ResultadoTransaccion<string> resultado = new ResultadoTransaccion<string>();
			try
			{
				using (HttpClient cliente = new HttpClient())
				{
					string ruta = "http://localhost:5089/API/Venta/Actualizar_Venta";
					var Json = JsonConvert.SerializeObject(objventa);
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
