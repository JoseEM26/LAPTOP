package com.ciberfarma.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ciberfarma.mantenimientos.GestionProducto;
import com.ciberfarma.mantenimientos.GestionUsuario;
import com.ciberfarma.model.Producto;
import com.ciberfarma.model.Usuario;

/**
 * Servlet implementation class ActualizaUsuarioServlet
 */
@WebServlet(name = "actuser", urlPatterns = { "/actuser" })
public class ActualizaUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entró al Get del Actualiza Servlet");
		// capturar el atributo del Usuario (Servlet)
		Usuario u = (Usuario) request.getSession().getAttribute("u");
		System.out.println(u);
		request.getRequestDispatcher("actualiza.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// leer los datos del form, llamar al método de la gestion y 
		// enviar los mensajes de éxito o error
		try {
			// Usuario u = new Usuario();
			Usuario u = (Usuario) request.getSession().getAttribute("u");
			// u.setCodigo(Integer.parseInt(request.getParameter("codigo")));
			u.setNombre(request.getParameter("nombre"));
			u.setApellido(request.getParameter("apellido"));
			u.setClave(request.getParameter("clave"));
			
			int ok = new GestionUsuario().actualizar(u);
			
			if (ok != 0) {
				request.setAttribute("mensaje",
				"<script>Swal.fire({title: 'Aviso!',text: 'Usuario actualizado!',icon: 'success'});</script>");
			} else {
				request.setAttribute("mensaje",
				"<script>Swal.fire({title: 'Aviso!',text: 'Error al actualizar!',icon: 'error'});</script>");
			}	
		} catch (Exception e) {
			// envía un mensaje con la lib sweetalert
			request.setAttribute("mensaje",
			"<script>Swal.fire({title: 'Aviso!',text: 'Valores vacíos o Erróneos!',icon: 'error'});</script>");
		}
		request.getRequestDispatcher("actualiza.jsp").forward(request, response);
		
	}

}
