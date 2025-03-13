package com.ExploraPeru.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ExploraPeru.Mantenimiento.MantenimientoDestinos;
import com.ExploraPeru.Mantenimiento.MantenimientoVuelos;
import com.ExploraPeru.model.Destinos;
import com.ExploraPeru.model.Vuelos;

/**
 * Servlet implementation class MostrarVueloServlt
 */
@WebServlet(name = "mostrarVuelo", urlPatterns = { "/mostrarVuelo" })
public class MostrarVueloServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MostrarVueloServlt() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<Vuelos> lstVuelos = new MantenimientoVuelos().listado();

			// Obtener la lista de destinos
			List<Destinos> lstDestinos = new MantenimientoDestinos().listado(); // Suponiendo que tienes una clase
			
			 // MantenimientoDestinos
	        
			
			// Pasar ambos atributos a la JSP
			request.setAttribute("lstVuelos", lstVuelos);
			request.setAttribute("lstDestinos", lstDestinos); // Agregar la lista de destinos

			int codigo = Integer.parseInt(request.getParameter("id"));

			Vuelos v = new MantenimientoVuelos().obtener(codigo);
			request.setAttribute("v", v);

			request.getRequestDispatcher("mostrarVuelo.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int codigo = Integer.parseInt(request.getParameter("id"));
			Vuelos v = new Vuelos();
			v.setIdVuelo(codigo);
			v.setFechaSalida(request.getParameter("fechaSalida"));
			v.setFechaLlegada(request.getParameter("fechaLlegada"));
			v.setPrecio(Double.parseDouble(request.getParameter("precio")));
			v.setPlazasDisponibles(Integer.parseInt(request.getParameter("plazasDisponibles")));
			v.setImagenUrl(request.getParameter("imagenUrl"));
			v.setLugar(request.getParameter("lugar"));
			v.setIdDestino(Integer.parseInt(request.getParameter("destino")));

			/*
			 * Vuelos v = new Vuelos();
			 * v.setIdDestino(Integer.parseInt(request.getParameter("idDestino"))); //
			 * Asignar ID de destino v.setFechaSalida(request.getParameter("fechaSalida"));
			 * v.setFechaLlegada(request.getParameter("fechaLlegada"));
			 * v.setPrecio(Double.parseDouble(request.getParameter("precio")));
			 * v.setPlazasDisponibles(Integer.parseInt(request.getParameter(
			 * "plazasDisponibles"))); v.setImagenUrl(request.getParameter("imagenUrl"));
			 * v.setLugar(request.getParameter("lugar"));
			 */

			int ok = new MantenimientoVuelos().actualizar(v);

			if (ok != 0) {
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'Aviso!',text: 'Vuelo actualizado!',icon: 'success'});</script>");
				request.getRequestDispatcher("MenuUsuario.jsp").forward(request, response);

			} else {
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'Aviso!',text: 'Error al actualizar!',icon: 'error'});</script>");
				request.getRequestDispatcher("mostrarVuelo.jsp").forward(request, response);

			}

		} catch (Exception e) {
			System.out.println("Error al actualizar en el server" + e.getMessage());
			request.setAttribute("mensaje",
					"<script>Swal.fire({title: 'Aviso!',text: 'Error al actualizar!',icon: 'error'});</script>");
			request.getRequestDispatcher("mostrarVuelo.jsp").forward(request, response);
		
		}

	}

}
