package com.ExploraPeru.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ExploraPeru.Mantenimiento.MantenimientoUsuario;
import com.ExploraPeru.model.Usuario;

/**
 * Servlet implementation class LoginServlt
 */
@WebServlet(name = "Login", urlPatterns = { "/Login" })
public class LoginServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlt() {
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
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entró al Servlet Login desde el Post");
		
		String email = request.getParameter("email");
		String contrasena = request.getParameter("contrasena");
		

		Usuario u = new MantenimientoUsuario().ValidacionLogin(email, contrasena);
		
		/*
		if (u != null) {
			System.out.println("Ingreso a la sesión: " + request.getSession().getId());
			request.getSession().setAttribute("u", u);
			System.out.println(u.getContraseña() + u.getNombreUsuario() + u.getFechaCumpleaños());
			System.out.println(u);
			if (u.getIdRol() == 1) {
				System.out.println("Ingreso Correctamente al loginUsuario");
				request.getRequestDispatcher("MenuUsuario.jsp").forward(request, response);
				System.out.println(email + "-" + contrasena);
			} else {
				System.out.println("Ingreso Correctamente al loginAdministrador");
				request.getRequestDispatcher("MenuAdm.jsp").forward(request, response);
				System.out.println(email + "-" + contrasena);
			}

		} else {
			System.out.println("Ingreso Incorrectamente al login");
			request.getRequestDispatcher("Index.jsp").forward(request, response);
			System.out.println(email + contrasena);

		}
		*/
		
		if (u != null) {
			System.out.println("Ingreso a la sesión: " + request.getSession().getId());
			request.getSession().setAttribute("u", u);
			request.getRequestDispatcher("MenuUsuario.jsp").forward(request, response);
			
		} else {
			request.setAttribute("mensaje","<script>Swal.fire({title: 'Aviso!',text: 'Usuario o clave incorrecto!',icon: 'error'});</script>");
			request.getRequestDispatcher("Index.jsp").forward(request, response);
		}

	}

}
