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
 * Servlet implementation class EliminarVueloServlt
 */
@WebServlet(name = "eliminarVuelo", urlPatterns = { "/eliminarVuelo" })
public class EliminarVueloServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EliminarVueloServlt() {
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
			
			
			int id = Integer.parseInt(request.getParameter("id"));
			int ok = new MantenimientoVuelos().eliminar(id);

			if (ok != 0) {
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'Aviso!',text: 'Vuelo eliminado!',icon: 'success'});</script>");
			} else {
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'Aviso!',text: 'Error al eliminar!',icon: 'error'});</script>");
			}

			request.getRequestDispatcher("crudvuelos.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("mensaje",
					"<script>Swal.fire({title: 'Aviso!',text: 'Valores vacíos o erróneos!',icon: 'error'});</script>");

			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
