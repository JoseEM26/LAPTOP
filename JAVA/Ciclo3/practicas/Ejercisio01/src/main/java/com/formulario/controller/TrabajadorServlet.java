package com.formulario.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.formulario.mantenimiento.GestionProductos;
import com.formulario.model.Trabajador;

/**
 * Servlet implementation class TrabajadorServlet
 */
@WebServlet("/TrabajadorServlet")
public class TrabajadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TrabajadorServlet() {
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
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String boton = request.getParameter("boton");
		System.out.println(boton);

		switch (boton) {
		case "insertar": {
			insertar(request, response);
		}
		case "eliminar": {
			eliminar(request, response);
		}
		case "editar": {
			Update(request, response);
		}
		default:
			break;

		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	private void insertar(HttpServletRequest request, HttpServletResponse response) {
		try {
			Trabajador t = new Trabajador();
			t.setNombre(request.getParameter("nombre"));
			t.setDni(Integer.parseInt(request.getParameter("dni")));
			t.setEdad(Integer.parseInt(request.getParameter("edad")));
			t.setApellido(request.getParameter("apellido"));
			t.setDireccion(request.getParameter("direccion"));
			t.setFecha(request.getParameter("fecha"));

			int ok = new GestionProductos().Insertar(t);

			if (ok != 0) {
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'Good job!' ,text: 'You clicked the button! ',icon: 'success'});</script>");
				request.getRequestDispatcher("index.jsp").forward(request, response);

			} else {
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'ERROR!' ,text: 'Error al Insertar! ',icon: 'error'});</script>");
			}

		} catch (Exception e) {
			request.setAttribute("mensaje",
					"<script>Swal.fire({title: 'ERROR!' ,text: 'Datos incompletos! ',icon: 'error'});</script>");
		}

	}
	
	private void Update(HttpServletRequest request, HttpServletResponse response) {
		try {
			Trabajador t = new Trabajador();
			t.setNombre(request.getParameter("nombre"));
			t.setDni(Integer.parseInt(request.getParameter("dni")));
			t.setEdad(Integer.parseInt(request.getParameter("edad")));
			t.setApellido(request.getParameter("apellido"));
			t.setDireccion(request.getParameter("direccion"));
			t.setFecha(request.getParameter("fecha"));

			int ok = new GestionProductos().update(t);

			if (ok != 0) {
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'Good job!' ,text: 'You clicked the button! ',icon: 'success'});</script>");
				request.getRequestDispatcher("index.jsp").forward(request, response);

			} else {
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'ERROR!' ,text: 'Error al Insertar! ',icon: 'error'});</script>");
			}

		} catch (Exception e) {
			request.setAttribute("mensaje",
					"<script>Swal.fire({title: 'ERROR!' ,text: 'Datos incompletos! ',icon: 'error'});</script>");
		}

	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		try {
			Trabajador t = new Trabajador();
			t.setDni(Integer.parseInt(request.getParameter("dni")));
			

			int ok = new GestionProductos().Eliminar(t);

			if (ok != 0) {
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'Good job!' ,text: 'You clicked the button! ',icon: 'success'});</script>");
				request.getRequestDispatcher("index.jsp").forward(request, response);

			} else {
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'ERROR!' ,text: 'Error al Insertar! ',icon: 'error'});</script>");
			}

		} catch (Exception e) {
			request.setAttribute("mensaje",
					"<script>Swal.fire({title: 'ERROR!' ,text: 'Datos incompletos! ',icon: 'error'});</script>");
		}

	}

}
