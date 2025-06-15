package com.producto.Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.producto.mantenimiento.Mantenimiento;
import com.producto.model.Producto;

/**
 * Servlet implementation class ListaServlt
 */
@WebServlet("/ListaServlt")
public class ListaServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListaServlt() {
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
			List<Producto> lista = new Mantenimiento().listarProducto();
			request.setAttribute("lista", lista);

			request.getRequestDispatcher("Index.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("Error en el controllador");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("Index.jsp").forward(request, response);

	}

}
