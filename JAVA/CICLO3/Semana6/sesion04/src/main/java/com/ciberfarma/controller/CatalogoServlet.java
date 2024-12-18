package com.ciberfarma.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ciberfarma.mantenimientos.GestionCategoria;
import com.ciberfarma.mantenimientos.GestionProducto;
import com.ciberfarma.model.Categoria;
import com.ciberfarma.model.Producto;

/**
 * Servlet implementation class CatalogoServlet
 */
@WebServlet(name = "catalogo", urlPatterns = { "/catalogo" })
public class CatalogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// al cargar la página, se debe obtener: listado de Categoría (Combo), listado 
		// de los productos (Tabla) y enviarlo a la página
		List<Categoria> lstCategorias = new GestionCategoria().listado();
		List<Producto> lstProductos = new GestionProducto().listado();
		
		request.setAttribute("lstProductos", lstProductos);
		request.setAttribute("lstCategorias", lstCategorias);
		
		request.getRequestDispatcher("catalogo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// leer la opción del combo y generar un listado según la opción y enviarlo a 
		// la página
		int categoria = Integer.parseInt(request.getParameter("categoria"));
		
		List<Producto> lstProductos = new GestionProducto().filtro(categoria);
		List<Categoria> lstCategorias = new GestionCategoria().listado();
		
		request.setAttribute("lstProductos", lstProductos);
		request.setAttribute("lstCategorias", lstCategorias);
		
		request.getRequestDispatcher("catalogo.jsp").forward(request, response);
		
	}

}




