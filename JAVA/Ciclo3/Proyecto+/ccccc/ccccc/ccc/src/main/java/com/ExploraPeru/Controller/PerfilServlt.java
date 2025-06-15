package com.ExploraPeru.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ExploraPeru.model.Usuario;

/**
 * Servlet implementation class PerfilServlt
 */
@WebServlet("/PerfilServlt")
public class PerfilServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PerfilServlt() {
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
		Usuario u= (Usuario)request.getSession().getAttribute("u");
		System.out.println(u.getNombreUsuario()+"Estamos en el get Del Perfil");
		if(u.getIdRol()==1) {
			request.setAttribute("rol","Usuario");
		}else {
			request.setAttribute("rol","Administrador");

		}
		request.getRequestDispatcher("Perfil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("").forward(request, response);
	}

}
