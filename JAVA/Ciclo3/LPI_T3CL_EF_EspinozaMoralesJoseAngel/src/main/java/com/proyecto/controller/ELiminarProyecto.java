package com.proyecto.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.mantenimiento.GestionProyectos;

/**
 * Servlet implementation class ELiminarProyecto
 */
@WebServlet(name = "eliminar", urlPatterns = { "/eliminar" })
public class ELiminarProyecto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ELiminarProyecto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			int ok= new GestionProyectos().Eliminar(id);
			if (ok != 0) {
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'Aviso!',text: 'Se Eliminar correctamente!',icon: 'success'});</script>");
				request.getRequestDispatcher("listado").forward(request, response);

			} else {
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'Aviso!',text: 'Error al Eliminar!',icon: 'error'});</script>");
				request.getRequestDispatcher("Mostrar.jsp").forward(request, response);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.setAttribute("mensaje",
					"<script>Swal.fire({title: 'Aviso!',text: 'Error al Eliminar!',icon: 'error'});</script>");
			request.getRequestDispatcher("Mostrar.jsp").forward(request, response);		}
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
