package com.trabajador.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trabajador.mantenimiento.CrudTrabajador;
import com.trabajador.model.Trabajador;

/**
 * Servlet implementation class trabajadorServelt
 */
@WebServlet("/trabajadorServelt")
public class trabajadorServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public trabajadorServelt() {
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
		request.getRequestDispatcher("Index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String boton = request.getParameter("boton");

			switch (boton) {
			case "registrar": {
				registrar(request, response);
				break;
			}
			case "eliminar": {
				eliminar(request, response);
				break;

			}
			default:
				acualizar(request, response);
				break;
			}

		} catch (Exception e) {
			System.out.println("Ocurrio un error al ingresar los datos del fomrulario");
		}
		
		request.getRequestDispatcher("Index.jsp").forward(request, response);
	}

	private void acualizar(HttpServletRequest request, HttpServletResponse response) {
		try {
			int dni = Integer.parseInt(request.getParameter("dni"));
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			int edad = Integer.parseInt(request.getParameter("edad"));
			String direccion = request.getParameter("direccion");
			String fecha = request.getParameter("fecha");
			Trabajador t = new Trabajador(dni, nombre, apellido, edad, direccion, fecha);
			int ok = new CrudTrabajador().update(t);

			if (ok != 0) {
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'EXITO' ,text: 'Todo correcto al update!' ,icon: 'Success' })  </script>");

			} else {
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'ERROR!!!!' ,text: 'Ocurrio un error al update!' ,icon: 'error' })  </script>");

			}

		} catch (Exception e) {
			request.setAttribute("mensaje",
					"<script>Swal.fire({title: 'ERROR!!!!' ,text: 'Ocurrio un error al ingresar los datos!' ,icon: 'error' })  </script>");
		}
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		try {
			int dni = Integer.parseInt(request.getParameter("dni"));
			
			int ok = new CrudTrabajador().delete(dni);

			if (ok != 0) {
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'EXITO' ,text: 'Todo correcto al Eliminar!' ,icon: 'Success' })  </script>");

			} else {
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'ERROR!!!!' ,text: 'Ocurrio un error al Eliminar!' ,icon: 'error' })  </script>");

			}

		} catch (Exception e) {
			request.setAttribute("mensaje",
					"<script>Swal.fire({title: 'ERROR!!!!' ,text: 'Ocurrio un error al ingresar los datos!' ,icon: 'error' })  </script>");
		}
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) {
		try {
			int dni = Integer.parseInt(request.getParameter("dni"));
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			int edad = Integer.parseInt(request.getParameter("edad"));
			String direccion = request.getParameter("direccion");
			String fecha = request.getParameter("fecha");
			Trabajador t = new Trabajador(dni, nombre, apellido, edad, direccion, fecha);
			int ok = new CrudTrabajador().Insert(t);

			if (ok != 0) {
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'EXITO' ,text: 'Todo correcto al insertar!' ,icon: 'Success' })  </script>");

			} else {
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'ERROR!!!!' ,text: 'Ocurrio un error al isertar!' ,icon: 'error' })  </script>");

			}

		} catch (Exception e) {
			request.setAttribute("mensaje",
					"<script>Swal.fire({title: 'ERROR!!!!' ,text: 'Ocurrio un error al ingresar los datos!' ,icon: 'error' })  </script>");
		}
	}

}
