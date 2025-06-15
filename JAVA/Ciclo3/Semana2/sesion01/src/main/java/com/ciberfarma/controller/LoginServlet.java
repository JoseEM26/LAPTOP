package com.ciberfarma.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// para cargar páginas o recursos
		System.out.println("Entró al Servlet Login desde el Get");
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entró al Servlet Login desde el Post");
		// leer los datos enviados desde el form (parámetros)
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");

		// simulamos una validación con BD
		if (usuario.equals("admin@mail.com") && clave.equals("123456")) {
			// enviar un mensaje
			request.setAttribute("mensaje", "Bienvenido");
			request.getRequestDispatcher("principal.jsp").forward(request, response);
			
		} else {
			request.setAttribute("mensaje","<script>Swal.fire({title: 'Aviso!',text: 'Usuario o clave incorrecto!',icon: 'error'});</script>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
	}

}
