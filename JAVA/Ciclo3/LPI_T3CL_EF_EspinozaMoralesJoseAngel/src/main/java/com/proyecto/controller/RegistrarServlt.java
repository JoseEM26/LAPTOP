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
 * Servlet implementation class RegistrarServlt
 */
@WebServlet(name = "registrar", urlPatterns = { "/registrar" })
public class RegistrarServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarServlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Tipo> t=new GestionProyectos().ComboBox();
		request.setAttribute("cmb", t);
		
		request.getRequestDispatcher("listado").forward(request, response);
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Tipo> t=new GestionProyectos().ComboBox();
			request.setAttribute("cmb", t);
			Proyecto p=new Proyecto();
	        p.setNom_proyecto(request.getParameter("nombre"));
	        p.setId_tipo(Integer.parseInt(request.getParameter("tipo")));
	        p.setPresupuesto(Double.parseDouble(request.getParameter("presupuesto")));
	        p.setFecha_inicio(request.getParameter("fecha"));
	        p.setDuracion(Integer.parseInt(request.getParameter("duracion")));
	        
	        int ok=new GestionProyectos().registrar(p);
	        
	        if (ok != 0) {
				request.setAttribute("mensaje",
				"<script>Swal.fire({title: 'Aviso!',text: 'Se creo correctamente!',icon: 'success'});</script>");
		        request.getRequestDispatcher("Registrar.jsp").forward(request, response);

			} else {
				request.setAttribute("mensaje",
				"<script>Swal.fire({title: 'Aviso!',text: 'Error al Crear!',icon: 'error'});</script>");
		        request.getRequestDispatcher("Registrar.jsp").forward(request, response);

			}	
		} catch (Exception e) {
			request.setAttribute("mensaje",
					"<script>Swal.fire({title: 'Aviso!',text: 'Error al Crear!',icon: 'error'});</script>");
			        request.getRequestDispatcher("Registrar.jsp").forward(request, response);
		}
	}

}
