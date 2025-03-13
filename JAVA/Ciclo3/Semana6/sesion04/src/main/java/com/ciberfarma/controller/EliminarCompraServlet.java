package com.ciberfarma.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ciberfarma.model.DetalleBoleta;

/**
 * Servlet implementation class EliminarCompraServlet
 */
@WebServlet(name = "eliminar", urlPatterns = { "/eliminar" })
public class EliminarCompraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// leer el param del código a eliminar
		String codigo = request.getParameter("cod");
		
		// traer las variables globales
		List<DetalleBoleta> carro = (List<DetalleBoleta>) request.getSession().getAttribute("carro");
    	double subTotalVenta = (double) request.getSession().getAttribute("subTotalVenta");
    	int cantArticulos = (int) request.getSession().getAttribute("cantArticulos");
    	
		// busca el producto a eliminar
    	for (DetalleBoleta detalleBoleta : carro) {
			if (detalleBoleta.getIdprod().equals(codigo)) {
				// descontar
				cantArticulos -= detalleBoleta.getCantidad();
				subTotalVenta -= detalleBoleta.getImporte();
				carro.remove(detalleBoleta);
				break;
			}
		}
    	request.getSession().setAttribute("carro", carro);
    	request.getSession().setAttribute("subTotalVenta", subTotalVenta);
    	request.getSession().setAttribute("cantArticulos", cantArticulos);
    	
    	response.sendRedirect("canasta.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
