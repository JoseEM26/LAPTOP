package com.ExploraPeru.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ExploraPeru.Mantenimiento.MantenimientoContactanos;

/**
 * Servlet implementation class EliminarContactoServlt
 */
@WebServlet(name = "eliminarContacto", urlPatterns = { "/eliminarContacto" })
public class EliminarContactoServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarContactoServlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
            int id = Integer.parseInt(request.getParameter("id"));
            int ok = new MantenimientoContactanos().eliminar(id);

            if (ok != 0) {
                request.setAttribute("mensaje",
                        "<script>Swal.fire({title: 'Aviso!',text: 'Contacto eliminado!',icon: 'success'});</script>");
    	        request.getRequestDispatcher("MenuUsuario.jsp").forward(request, response);

            } else {
                request.setAttribute("mensaje",
                        "<script>Swal.fire({title: 'Aviso!',text: 'Error al eliminar el contacto!',icon: 'error'});</script>");
    	        request.getRequestDispatcher("MenuUsuario.jsp").forward(request, response);

            }

        } catch (Exception e) {
            request.setAttribute("mensaje",
                    "<script>Swal.fire({title: 'Aviso!',text: 'Valores vacíos o erróneos!',icon: 'error'});</script>");
            System.out.println(e.getMessage());
	        request.getRequestDispatcher("MenuUsuario.jsp").forward(request, response);

        }	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
