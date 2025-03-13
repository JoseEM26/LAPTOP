package com.proyecto.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.mantenimiento.GestionProyectos;
import com.proyecto.model.Proyecto;
import com.proyecto.model.Tipo;

/**
 * Servlet implementation class EditarProyectoServlt
 */
@WebServlet(name = "editar", urlPatterns = { "/editar" })
public class EditarProyectoServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditarProyectoServlt() {
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
		List<Tipo> t = new GestionProyectos().ComboBox();
		request.setAttribute("cmb", t);
		int id = Integer.parseInt(request.getParameter("id"));
		Proyecto p = new GestionProyectos().Buscar(id);
		request.setAttribute("p", p);
		request.getRequestDispatcher("Mostrar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));

			List<Tipo> t = new GestionProyectos().ComboBox();
			request.setAttribute("cmb", t);
			Proyecto p = new Proyecto();
			p.setCod_proyecto(id);
			p.setNom_proyecto(request.getParameter("nombre"));
			p.setId_tipo(Integer.parseInt(request.getParameter("tipo")));
			p.setPresupuesto(Double.parseDouble(request.getParameter("presupuesto")));
			p.setFecha_inicio(request.getParameter("fecha"));
			p.setDuracion(Integer.parseInt(request.getParameter("duracion")));

			int ok = new GestionProyectos().Actualizr(p);

			if (ok != 0) {
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'Aviso!',text: 'Se Actualizo correctamente!',icon: 'success'});</script>");
				request.getRequestDispatcher("listado").forward(request, response);

			} else {
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'Aviso!',text: 'Error al Actualizo!',icon: 'error'});</script>");
				request.getRequestDispatcher("Mostrar.jsp").forward(request, response);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.setAttribute("mensaje",
					"<script>Swal.fire({title: 'Aviso!',text: 'Error al Actualizo!',icon: 'error'});</script>");
			request.getRequestDispatcher("Mostrar.jsp").forward(request, response);
		}
	}

}
