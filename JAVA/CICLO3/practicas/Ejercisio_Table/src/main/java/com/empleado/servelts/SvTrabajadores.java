package com.empleado.servelts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SvTrabajadores
 */
@WebServlet("/SvTrabajadores")
public class SvTrabajadores extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SvTrabajadores() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	     List<Trabajador> lista= new ArrayList<Trabajador>();		
		lista.add(new Trabajador("Jose","Espinoza ",19));
		lista.add(new Trabajador("migle","morales ",25));
		lista.add(new Trabajador("ariadna","vanessa ",99));
		
		request.getSession().setAttribute("lista", lista);
		request.getRequestDispatcher("TablaTrabajadores.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		try {
			String nombre, apellido;
			int edad;

			nombre = request.getParameter("nombre");
			apellido = request.getParameter("apellido");
			edad = Integer.parseInt(request.getParameter("edad"));

			System.out.println("nombre :" + nombre);
			System.out.println("apellido :" + apellido);
			System.out.println("edad :" + edad);
			
			

			request.setAttribute("mensaje",
					"<script>Swal.fire({title: 'Good job!',text: 'You clicked the button!',icon: 'success'}) </script>");

			request.getRequestDispatcher("Principal.jsp").forward(request, response);

		} catch (Exception e) {
			request.setAttribute("mensaje",
	                "<script>Swal.fire({title: 'Ocurrió un error!', text: '" + e.getMessage() + "', icon: 'error'})</script>");
	        request.getRequestDispatcher("Principal.jsp").forward(request, response);
	   }

	}

}
