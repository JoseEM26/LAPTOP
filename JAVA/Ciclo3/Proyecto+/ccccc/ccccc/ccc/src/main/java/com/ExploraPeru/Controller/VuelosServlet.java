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

@WebServlet(name = "vuelos", urlPatterns = { "/vuelos" })
public class VuelosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Listado de destinos y vuelos
		List<Destinos> lstDestinos = new MantenimientoDestinos().listado();
		List<Vuelos> lstVuelos = new MantenimientoVuelos().listado();

		// Enviar datos al JSP
		request.setAttribute("lstDestinos", lstDestinos);
		request.setAttribute("lstVuelos", lstVuelos);

		// Redirigir a la página vuelos.jsp
		request.getRequestDispatcher("Vuelos.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Leer la opción del combo (destino seleccionado)
		int destino = Integer.parseInt(request.getParameter("destino"));

		// Filtrar vuelos por destino
		List<Vuelos> lstVuelos = new MantenimientoVuelos().filtro(destino);
		List<Destinos> lstDestinos = new MantenimientoDestinos().listado();

		// Enviar datos al JSP
		request.setAttribute("lstDestinos", lstDestinos);
		request.setAttribute("lstVuelos", lstVuelos);

		// Redirigir a la página vuelos.jsp
		request.getRequestDispatcher("Vuelos.jsp").forward(request, response);
	}
}
