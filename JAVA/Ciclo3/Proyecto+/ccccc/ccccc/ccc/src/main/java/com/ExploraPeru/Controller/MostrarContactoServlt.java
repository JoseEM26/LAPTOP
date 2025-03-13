package com.ExploraPeru.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ExploraPeru.Mantenimiento.MantenimientoContactanos;
import com.ExploraPeru.model.Contacto;

/**
 * Servlet implementation class MostrarContactoServlt
 */
@WebServlet(name = "mostrarContacto", urlPatterns = { "/mostrarContacto" })
public class MostrarContactoServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarContactoServlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  try {
	            // Obtener la lista de contactos
	            List<Contacto> lstContactos = new MantenimientoContactanos().listado();
	            request.setAttribute("lstContactos", lstContactos);

	            // Obtener el contacto por ID
	            int codigo = Integer.parseInt(request.getParameter("id"));
	            Contacto contacto = new MantenimientoContactanos().obtener(codigo);
	            request.setAttribute("contacto", contacto);

	            // Redirigir a la JSP para mostrar el contacto
	            request.getRequestDispatcher("mostrarContacto.jsp").forward(request, response);
	        } catch (Exception e) {
	            System.out.println("Error al obtener contacto: " + e.getMessage());
	        }	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
            // Actualizar contacto
            int codigo = Integer.parseInt(request.getParameter("id"));
            Contacto contacto = new Contacto();
            contacto.setIdContacto(codigo);
            contacto.setNombreContacto(request.getParameter("nombre"));
            contacto.setEmailContacto(request.getParameter("email"));
            contacto.setNumeroContacto(request.getParameter("telefono"));
            contacto.setMensajeContacto(request.getParameter("mensaje"));

            int ok = new MantenimientoContactanos().actualizar(contacto);

            if (ok != 0) {
                request.setAttribute("mensaje",
                        "<script>Swal.fire({title: 'Aviso!',text: 'Contacto actualizado!',icon: 'success'});</script>");
                request.getRequestDispatcher("MenuUsuario.jsp").forward(request, response);
            } else {
                request.setAttribute("mensaje",
                        "<script>Swal.fire({title: 'Aviso!',text: 'Error al actualizar!',icon: 'error'});</script>");
                request.getRequestDispatcher("MenuUsuario.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar contacto: " + e.getMessage());
            request.setAttribute("mensaje",
                    "<script>Swal.fire({title: 'Aviso!',text: 'Error al actualizar!',icon: 'error'});</script>");
            request.getRequestDispatcher("MenuUsuario.jsp").forward(request, response);
        }	}

}
