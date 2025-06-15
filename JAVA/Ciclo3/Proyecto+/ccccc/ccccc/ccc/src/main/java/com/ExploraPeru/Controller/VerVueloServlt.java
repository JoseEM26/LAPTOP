package com.ExploraPeru.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ExploraPeru.Mantenimiento.MantenimientoVuelos;
import com.ExploraPeru.model.Vuelos;

/**
 * Servlet implementation class VerVueloServlt
 */
@WebServlet(name = "VerVuelo", urlPatterns = { "/VerVuelo" })
public class VerVueloServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idVuelo=Integer.parseInt(request.getParameter("id"));
		Vuelos vuelo= new MantenimientoVuelos().obtener(idVuelo);
		request.getSession().setAttribute("vuelo", vuelo);
		request.getRequestDispatcher("VerVuelo.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
