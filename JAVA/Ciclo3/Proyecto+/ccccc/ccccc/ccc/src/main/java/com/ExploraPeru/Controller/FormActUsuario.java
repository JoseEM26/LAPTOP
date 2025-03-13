package com.ExploraPeru.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ExploraPeru.Mantenimiento.MantenimientoUsuario;
import com.ExploraPeru.model.Usuario;

/**
 * Servlet implementation class FormActUsuario
 */
@WebServlet(name = "ActualizarUsuario", urlPatterns = { "/ActualizarUsuario" })
public class FormActUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormActUsuario() {
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
		request.getSession().getAttribute("u");

		request.getRequestDispatcher("FormActUsuario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Obtienes el usuario de la sesión
			Usuario u = (Usuario) request.getSession().getAttribute("u");
			
			// Crea un nuevo objeto Usuario con los nuevos valores
			Usuario us = new Usuario();
			us.setIdUsuario(u.getIdUsuario());  // Usamos el ID del usuario original
			us.setNombreUsuario(request.getParameter("nombre"));
			us.setEmail(request.getParameter("email"));
			us.setFechaCumpleaños(request.getParameter("fecha"));
			us.setContraseña(request.getParameter("contrasena"));
			us.setImg(request.getParameter("img"));
			us.setTelefono(request.getParameter("telefono"));

			// Actualiza los datos del objeto original 'u' con los nuevos valores
			u.setNombreUsuario(us.getNombreUsuario());
			u.setEmail(us.getEmail());
			u.setFechaCumpleaños(us.getFechaCumpleaños());
			u.setContraseña(us.getContraseña());
			u.setImg(us.getImg());
			u.setTelefono(us.getTelefono());

			// Actualiza el usuario en la sesión con los nuevos valores
			request.getSession().setAttribute("u", u);

			// Llama al método de actualización en la base de datos
			int ok = new MantenimientoUsuario().actualizar(us);
			if (ok != 0) {
				// Si la actualización es exitosa, muestra un mensaje de éxito
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'Success!',text: 'Actualización correcta!',icon: 'success'});</script>");
				// Redirige al perfil del usuario
				request.getRequestDispatcher("MenuUsuario.jsp").forward(request, response);
			} else {
				// Si hubo un error en la actualización, muestra un mensaje de error
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'Aviso!',text: 'Error al actualizar el usuario!',icon: 'error'});</script>");
				request.getRequestDispatcher("FormActUsuario.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// Captura y muestra cualquier excepción que ocurra
			System.out.println("Error al actualizar usuario: " + e.getMessage());
		}
	}


}
