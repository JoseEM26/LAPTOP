package com.ciberfarma.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ciberfarma.mantenimientos.GestionUsuario;
import com.ciberfarma.model.Usuario;

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

		// obtener un Usuario con los param del formulario (BD)
		Usuario u = new GestionUsuario().validar(usuario, clave);
		
		if (u != null) {
			// enviar un mensaje
			request.setAttribute("mensaje", "Bienvenido");
			// request.setAttribute("u", u); // a nivel de request
			System.out.println("Ingreso a la sesión: " + request.getSession().getId());
			request.getSession().setAttribute("u", u); // a nivel de session
			request.getRequestDispatcher("principal.jsp").forward(request, response);
			
		} else {
			request.setAttribute("mensaje","<script>Swal.fire({title: 'Aviso!',text: 'Usuario o clave incorrecto!',icon: 'error'});</script>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
	}

}
