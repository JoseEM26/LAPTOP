package com.ExploraPeru.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ExploraPeru.model.DetalleBoleta;

/**
 * Servlet implementation class EliminarCarroServlt
 */
@WebServlet(name = "EliminarCarro", urlPatterns = { "/EliminarCarro" })
public class EliminarCarroServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EliminarCarroServlt() {
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
		int codigo = Integer.parseInt(request.getParameter("id"));

		List<DetalleBoleta> carro = (List<DetalleBoleta>) request.getSession().getAttribute("carro");
		double subTotalViaje = (double) request.getSession().getAttribute("subTotalViaje");
		int cantViaje = (int) request.getSession().getAttribute("canViajes");

		for (DetalleBoleta detalleBoleta : carro) {
			if (detalleBoleta.getIdViaje() == codigo) {
				cantViaje -= detalleBoleta.getCantidad();
				subTotalViaje -= detalleBoleta.getImporte() ;
				carro.remove(detalleBoleta);
				break;

			}

		}
		request.getSession().setAttribute("carro", carro);
		request.getSession().setAttribute("canViajes", cantViaje);
		request.getSession().setAttribute("subTotalViaje", subTotalViaje);

		response.sendRedirect("Carrito.jsp");
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
