package com.ciberfarma.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ciberfarma.mantenimientos.GestionProducto;
import com.ciberfarma.model.Producto;

/**
 * Servlet implementation class MostrarProductoServlet
 */
@WebServlet(name = "mostrar", urlPatterns = { "/mostrar" })
public class MostrarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// leer código del producto seleccionado (tabla /card)
		String codigo = request.getParameter("c");
		
		// Obtener un objeto de Producto con el código seleccionado
		Producto p = new GestionProducto().obtener(codigo);
		
		// enviarlo a la página como atributo 
		// request.setAttribute("p", p);  // normal
		request.getSession().setAttribute("p", p); // a nivel de session
		
		// redireccionar
		request.getRequestDispatcher("compra.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
