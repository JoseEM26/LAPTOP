package com.ExploraPeru.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ExploraPeru.Mantenimiento.MantenimientoBoleta;
import com.ExploraPeru.Mantenimiento.MantenimientoUsuario;
import com.ExploraPeru.model.Boleta;
import com.ExploraPeru.model.Usuario;

/**
 * Servlet implementation class MostrarCabezera
 */
@WebServlet(name = "mostrarCabezeraBoleta", urlPatterns = { "/mostrarCabezeraBoleta" })
public class MostrarCabezera extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarCabezera() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 try {	
	           
	            // Obtener una cabezera boleta específica si se pasa un ID
	                String codigo = request.getParameter("numBol");
	                System.out.println(codigo);
	                Boleta cabezera = new MantenimientoBoleta().obtener(codigo);
	                System.out.println(cabezera.getNum_bol());
	                request.setAttribute("cabezera", cabezera);
	                
	                List<Usuario> lstCl=new MantenimientoUsuario().listado();

	                request.setAttribute("ssss", lstCl);
	            

	            // Redirigir a la JSP correspondiente
	            request.getRequestDispatcher("mostrarCabezeraBoleta.jsp").forward(request, response);
	        } catch (Exception e) {
	            System.out.println("Error en doGet: " + e.getMessage());
	            request.setAttribute("mensaje", "<script>Swal.fire({title: 'Error!', text: 'Error al cargar los datos.', icon: 'error'});</script>");
	            request.getRequestDispatcher("error.jsp").forward(request, response);
	        }	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 try {
	            // Obtener datos del formulario
             String codigo = request.getParameter("id");
	            Boleta cabezera = new Boleta();
	            cabezera.setNum_bol(codigo);
	            cabezera.setFch_bol(request.getParameter("fechaEmision"));
	            cabezera.setId_usuario(Integer.parseInt(request.getParameter("idUsuario")));

	            // Actualizar la cabezera de boleta
	            int ok = new MantenimientoBoleta().actualizar(cabezera);

	            if (ok != 0) {
	                request.setAttribute("mensaje", "<script>Swal.fire({title: 'Éxito!', text: 'Cabezera de boleta actualizada!', icon: 'success'});</script>");
	                request.getRequestDispatcher("MenuUsuario.jsp").forward(request, response);
	            } else {
	                request.setAttribute("mensaje", "<script>Swal.fire({title: 'Error!', text: 'No se pudo actualizar la cabezera.', icon: 'error'});</script>");
	                request.getRequestDispatcher("mostrarCabezeraBoleta.jsp").forward(request, response);
	            }

	        } catch (Exception e) {
	            System.out.println("Error en doPost: " + e.getMessage());
	            request.setAttribute("mensaje", "<script>Swal.fire({title: 'Error!', text: 'Error al procesar los datos.', icon: 'error'});</script>");
	            request.getRequestDispatcher("mostrarCabezeraBoleta.jsp").forward(request, response);
	        }	}

}
