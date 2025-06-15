package com.Trabajador.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Trabajador.mantenimiento.Mantenimiento;
import com.Trabajador.modelo.Trabajador;

/**
 * Servlet implementation class TrabajadorServelt
 */
@WebServlet(name = "trabajador", urlPatterns = { "/trabajador" })
public class TrabajadorServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TrabajadorServelt() {
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
		String boton = request.getParameter("boton");

		try {
			switch (boton) {
			case "registrar": {
				insertar(request, response);
				break;
			}
			case "eliminar": {
				eliminar(request, response);

				break;
			}
			default:
				update(request, response);

				break;
			}
		} catch (Exception e) {
			System.out.println("Error en el switch");
		}

		request.getRequestDispatcher("Index.jsp").forward(request, response);
	}

	private void insertar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			int dni = Integer.parseInt(request.getParameter("dni"));
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			int edad = Integer.parseInt(request.getParameter("edad"));
			String direccion = request.getParameter("direccion");
			String fecha = request.getParameter("fecha");
			Trabajador t = new Trabajador(dni, nombre, apellido, edad, direccion, fecha);

			try {
				int ok=new Mantenimiento().Insertar(t);
				if(ok!=0) {
				}else {
					request.setAttribute("mensaje",
							"<script>Swal.fire({title: 'EXITO!!!!' ,text: 'Inserccion correcta!' ,icon: 'success' })  </script>");

				}
			} catch (Exception e) {
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'ERROR!!!!' ,text: 'Ocurrio un Error valor error 0!' ,icon: 'error' })  </script>");
			}
		} catch (Exception e) {
			System.out.println("Error al leer datos");
			request.setAttribute("mensaje",
					"<script>Swal.fire({title: 'ERROR!!!!' ,text: 'Ocurrio un error al ingresar los datos!' ,icon: 'error' })  </script>");

		}

	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
