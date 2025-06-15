package com.ExploraPeru.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ExploraPeru.Mantenimiento.MantenimientoContactanos;
import com.ExploraPeru.model.Contacto;

/**
 * Servlet implementation class FormContactanos
 */
@WebServlet(name = "contactanos", urlPatterns = { "/contactanos" })
public class FormContactanosServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormContactanosServlt() {
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
		request.getRequestDispatcher("MenuUsuario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Contacto c=new Contacto();
			c.setNombreContacto(request.getParameter("name"));
			c.setEmailContacto(request.getParameter("email"));
			c.setNumeroContacto(request.getParameter("phone"));
			c.setMensajeContacto(request.getParameter("message"));
			
			System.out.println(c.getNumeroContacto());
			int ok=new MantenimientoContactanos().InsertarContactanos(c);
			
			if(ok !=0) {
				request.setAttribute("mensajeContactanos", "<script>Swal.fire({title: 'Envio Exitosamente!',text: 'Te estaremos llamando proximamente!',icon: 'success'});</script>");
			}else {
				request.setAttribute("mensajeContactanos", "<script>Swal.fire({title: 'Revisar!',text: 'Hubo un problema al enviar los datos!',icon: 'error'});</script>");
			}
			
			
		} catch (Exception e) {
			System.out.println("Error al conseguir datos en form contactanos");// TODO: handle exception
		}
		
		
		request.getRequestDispatcher("MenuUsuario.jsp").forward(request, response);
	}

}
