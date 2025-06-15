package com.bus.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bus.Mantenimiento.ComboBoxRutas;
import com.bus.Mantenimiento.MantenimientoBuses;
import com.bus.Model.Busess;
import com.bus.Model.Rutas;

/**
 * Servlet implementation class TablaServlt
 */
@WebServlet(name = "tabla", urlPatterns = { "/tabla" })
public class TablaServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TablaServlt() {
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
		List<Rutas> r=new ComboBoxRutas().ComboBoxRut();
		request.setAttribute("combo", r);
		
		
		
		request.getRequestDispatcher("Index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    try {
	        int id = Integer.parseInt(request.getParameter("id"));
	        List<Busess> lista = new MantenimientoBuses().ListaBus(id);
	        request.setAttribute("lista", lista);
	    } catch (NumberFormatException e) {
	        // En caso de que no se seleccione una ruta válida
	        request.setAttribute("error", "Por favor seleccione una ruta válida.");
	    }
	    
	    request.getRequestDispatcher("Index.jsp").forward(request, response);
	}


}















