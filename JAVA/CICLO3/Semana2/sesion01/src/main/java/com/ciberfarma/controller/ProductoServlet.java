package com.ciberfarma.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ciberfarma.mantenimientos.GestionProducto;
import com.ciberfarma.model.Producto;

/**
 * Servlet implementation class ProductoServlet
 */
@WebServlet(name = "crudprod", urlPatterns = { "/crudprod" })
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// cargar página o recurso
		request.getRequestDispatcher("crudproductos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// procesos de lectura
		String opcion = request.getParameter("btnOpcion");
		
		// según la opción seleccionada con el botón, hacer.....
		switch (opcion) {
		case "reg": 
			registrar(request, response);
			break;
		case "act": 
			actualizar(request, response);
			break;
		case "eli": 
			eliminar(request, response);
			break;
		case "lst": break;
		default:
			break;
		}
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Producto p = new Producto();
			p.setIdprod(request.getParameter("codigo"));
			p.setDescripcion(request.getParameter("descripcion"));
			p.setStock(Integer.parseInt(request.getParameter("stock")));
			p.setPrecio(Double.parseDouble(request.getParameter("precio")));
			p.setIdcategoria(Integer.parseInt(request.getParameter("categoria")));
			p.setEstado(1);  // TAREA. Hacer el combo de Estado
			
			int ok = new GestionProducto().actualizar(p);
			
			if (ok != 0) {
				request.setAttribute("mensaje",
				"<script>Swal.fire({title: 'Aviso!',text: 'Producto actualizado!',icon: 'success'});</script>");
			} else {
				request.setAttribute("mensaje",
				"<script>Swal.fire({title: 'Aviso!',text: 'Error al actualizar!',icon: 'error'});</script>");
			}	
		} catch (Exception e) {
			// envía un mensaje con la lib sweetalert
			request.setAttribute("mensaje",
			"<script>Swal.fire({title: 'Aviso!',text: 'Valores vacíos o Erróneos!',icon: 'error'});</script>");
		}
		request.getRequestDispatcher("crudproductos.jsp").forward(request, response);
		
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Producto p = new Producto();
			p.setIdprod(request.getParameter("codigo"));
			
			int ok = new GestionProducto().eliminar(p);
			
			if (ok != 0) {
				request.setAttribute("mensaje",
				"<script>Swal.fire({title: 'Aviso!',text: 'Producto eliminado!',icon: 'success'});</script>");
			} else {
				request.setAttribute("mensaje",
				"<script>Swal.fire({title: 'Aviso!',text: 'Error al eliminar!',icon: 'error'});</script>");
			}	
		} catch (Exception e) {
			// envía un mensaje con la lib sweetalert
			request.setAttribute("mensaje",
			"<script>Swal.fire({title: 'Aviso!',text: 'Valores vacíos o Erróneos!',icon: 'error'});</script>");
		}
		request.getRequestDispatcher("crudproductos.jsp").forward(request, response);
		
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Producto p = new Producto(codigo, nombre, stock, precio, categoria, 1);
			
			Producto p = new Producto();
			p.setIdprod(request.getParameter("codigo"));
			p.setDescripcion(request.getParameter("descripcion"));
			p.setStock(Integer.parseInt(request.getParameter("stock")));
			p.setPrecio(Double.parseDouble(request.getParameter("precio")));
			p.setIdcategoria(Integer.parseInt(request.getParameter("categoria")));
			p.setEstado(1);  // Estado ACTIVO
			
			int ok = new GestionProducto().registrar(p);
			
			if (ok != 0) {
				request.setAttribute("mensaje",
				"<script>Swal.fire({title: 'Aviso!',text: 'Producto registrado!',icon: 'success'});</script>");
			} else {
				request.setAttribute("mensaje",
				"<script>Swal.fire({title: 'Aviso!',text: 'Error al registrar!',icon: 'error'});</script>");
			}	
		} catch (Exception e) {
			// envía un mensaje con la lib sweetalert
			request.setAttribute("mensaje",
			"<script>Swal.fire({title: 'Aviso!',text: 'Valores vacíos o Erróneos!',icon: 'error'});</script>");
		}
		request.getRequestDispatcher("crudproductos.jsp").forward(request, response);
	}

}
