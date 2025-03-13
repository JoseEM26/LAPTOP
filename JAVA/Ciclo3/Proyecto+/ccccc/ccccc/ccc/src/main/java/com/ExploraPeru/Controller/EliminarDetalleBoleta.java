package com.ExploraPeru.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ExploraPeru.Mantenimiento.MantenimientoDetalleBoleta;

/**
 * Servlet implementation class EliminarDetalleBoleta
 */
@WebServlet("/EliminarDetalleBoleta")
public class EliminarDetalleBoleta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EliminarDetalleBoleta() {
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
			String numBol = request.getParameter("numBol"); // Parámetro numBol
			int idDestino = Integer.parseInt(request.getParameter("idDestino")); // Parámetro idDestino

			// Llamada al mantenimiento para eliminar el detalle de la boleta
			int ok = new MantenimientoDetalleBoleta().eliminar(numBol, idDestino);

			// Si la eliminación fue exitosa
			if (ok != 0) {
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'Aviso!',text: 'Detalle de boleta eliminado!',icon: 'success'});</script>");
				request.getRequestDispatcher("MenuUsuario.jsp").forward(request, response);;
			} else {
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'Aviso!',text: 'Error al eliminar detalle!',icon: 'error'});</script>");
				request.getRequestDispatcher("crudDetalleBoleta.jsp").forward(request, response);;

			}

		} catch (Exception e) {
			// Si ocurre algún error
			request.setAttribute("mensaje",
					"<script>Swal.fire({title: 'Aviso!',text: 'Valores vacíos o erróneos!',icon: 'error'});</script>");
			System.out.println(e.getMessage());
			request.getRequestDispatcher("crudDetalleBoleta.jsp").forward(request, response);;

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
