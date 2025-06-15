package com.ExploraPeru.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; // Importar para gestionar sesiones
import com.ExploraPeru.Mantenimiento.MantenimientoUsuario;
import com.ExploraPeru.model.Usuario;

/**
 * Servlet implementation class RegistrarUsuario
 */
@WebServlet(name = "registro", urlPatterns = { "/registro" })
public class RegistrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrarUsuario() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entró al Servlet RegistrarUsuario desde el Post");
		try {
			// Crear un objeto Usuario basado en los parámetros recibidos del formulario
			Usuario u = new Usuario();
			u.setNombreUsuario(request.getParameter("nombre"));
			u.setEmail(request.getParameter("correo"));
			u.setContraseña(request.getParameter("clave"));
			u.setTelefono(request.getParameter("telefono"));
			u.setFechaCumpleaños(request.getParameter("cumple"));
			u.setIdRol(1);
			u.setImg(request.getParameter("img"));

			// Llamar a la clase de gestión para registrar al usuario
			int ok = new MantenimientoUsuario().registrar(u);

			// Verificar si el registro fue exitoso
			if (ok != 0) {
				System.out.println("Ingreso a la sesión: " + request.getSession().getId());
				// Aquí creamos la sesión para el usuario registrado
				HttpSession session = request.getSession();
				session.setAttribute("u", u); // Guardamos el objeto Usuario en la sesión

				// Redirigir al menú de usuario con el usuario en sesión
				request.getRequestDispatcher("MenuUsuario.jsp").forward(request, response);
			} else {
				// Si hubo un error en el registro, mostrar el mensaje de error
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'Aviso!',text: 'Error al registrar el usuario!',icon: 'error'});</script>");
				request.getRequestDispatcher("Index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// Capturar errores y mostrar un mensaje de error
			request.setAttribute("mensaje",
					"<script>Swal.fire({title: 'Aviso!',text: 'Valores vacíos o erróneos!',icon: 'error'});</script>");
			request.getRequestDispatcher("Index.jsp").forward(request, response);
		}
	}
}
