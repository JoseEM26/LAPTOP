package com.trabajador.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trabajador.mantenimiento.MantenimientoTrabajador;
import com.trabajador.model.Trabajador;

/**
 * Servlet implementation class TrabajadorServlt
 */
@WebServlet("/TrabajadorServlt")
public class TrabajadorServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TrabajadorServlt() {
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
		// TODO Auto-generated method stub
		String boton = request.getParameter("boton");

		switch (boton) {
		case "registrar": {
			insert(request, response);
			break;
		}
		case "eliminar": {
			eliminar(request, response);

			break;
		}
		default:
			actualizar(request, response);

			break;
		}
		request.getRequestDispatcher("Index.jsp").forward(request, response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) {

		try {
			Trabajador t = new Trabajador();
			t.setDni(Integer.parseInt(request.getParameter("dni")));
			t.setEdad(Integer.parseInt(request.getParameter("edad")));
			t.setNombre(request.getParameter("nombre"));
			t.setApellido(request.getParameter("apellido"));
			t.setDireccion(request.getParameter("direccion"));
			t.setFechaNacimiento(request.getParameter("fecha"));

			int ok = new MantenimientoTrabajador().actualizar(t);

			if (ok != 0) {
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'EXITO!!!!' ,text: 'actualizar Correctamente!' ,icon: 'success' })  </script>");
			} else {
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'ERROR!!!!' ,text: 'Error al ejecutar actualizar!' ,icon: 'error' })  </script>");
			}

		} catch (Exception e) {
			request.setAttribute("mensaje",
					"<script>Swal.fire({title: 'ERROR!!!!' ,text: 'Ocurrio un error al ingresar los datos actualizar!' ,icon: 'error' })  </script>");
			System.out.println("error controlador actualizar");
		}

	}

	

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {

		try {
			
			int ok = new MantenimientoTrabajador().eliminar(Integer.parseInt(request.getParameter("dni")));

			if (ok != 0) {
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'EXITO!!!!' ,text: 'eliminar Correctamente!' ,icon: 'success' })  </script>");
			} else {
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'ERROR!!!!' ,text: 'Error al ejecutar eliminar!' ,icon: 'error' })  </script>");
			}

		} catch (Exception e) {
			request.setAttribute("mensaje",
					"<script>Swal.fire({title: 'ERROR!!!!' ,text: 'Ocurrio un error al ingresar los datos eliminar!' ,icon: 'error' })  </script>");
			System.out.println("error controlador eliminar");

		}

	}

	

	private void insert(HttpServletRequest request, HttpServletResponse response) {

		try {
			Trabajador t = new Trabajador();
			t.setDni(Integer.parseInt(request.getParameter("dni")));
			t.setEdad(Integer.parseInt(request.getParameter("edad")));
			t.setNombre(request.getParameter("nombre"));
			t.setApellido(request.getParameter("apellido"));
			t.setDireccion(request.getParameter("direccion"));
			t.setFechaNacimiento(request.getParameter("fecha"));

			int ok = new MantenimientoTrabajador().Registrar(t);

			if (ok != 0) {
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'EXITO!!!!' ,text: 'Insertar Correctamente!' ,icon: 'success' })  </script>");
			} else {
				request.setAttribute("mensaje",
						"<script>Swal.fire({title: 'ERROR!!!!' ,text: 'Error al ejecutar Insertars!' ,icon: 'error' })  </script>");
			}

		} catch (Exception e) {
			request.setAttribute("mensaje",
					"<script>Swal.fire({title: 'ERROR!!!!' ,text: 'Ocurrio un error al ingresar los datos insertar!' ,icon: 'error' })  </script>");
			System.out.println("error controlador insertar");

		}

	}

}
