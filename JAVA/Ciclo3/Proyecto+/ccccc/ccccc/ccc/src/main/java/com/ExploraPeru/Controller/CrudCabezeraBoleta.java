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
 * Servlet implementation class CrudCabezeraBoleta
 */
@WebServlet(name = "crudCabezera", urlPatterns = { "/crudCabezera" })
public class CrudCabezeraBoleta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrudCabezeraBoleta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Usuario> lstUsuario=new MantenimientoUsuario().listado();
		request.setAttribute("lstUsuarios", lstUsuario);
		
		   // Obtener la lista de boletas
        List<Boleta> lstBoletas = new MantenimientoBoleta().listado();
        // Pasar la lista de boletas como atributo a la JSP
        request.getSession().setAttribute("lstBoletas", lstBoletas);

        // Redirigir a la JSP
        request.getRequestDispatcher("crudboletas.jsp").forward(request, response);
    }	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String opcion = request.getParameter("btnOpcion");
	        
	        // Actualizar la lista de boletas
	        List<Boleta> lstBoletas = new MantenimientoBoleta().listado();
	        request.setAttribute("lstBoletas", lstBoletas);

	        switch (opcion) {
	        case "reg":
	            registrar(request, response);
	            break;
	        
	        default:
	            break;
	        }
	    }

	    private void registrar(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        try {
	            Boleta b = new Boleta();
	            b.setNum_bol(request.getParameter("numBol"));
	            b.setFch_bol(request.getParameter("fechaBol"));
	            b.setId_usuario(Integer.parseInt(request.getParameter("idUsuario")));

	            int ok = new MantenimientoBoleta().registrar(b);

	            if (ok != 0) {
	                request.setAttribute("mensaje",
	                        "<script>Swal.fire({title: 'Aviso!',text: 'Boleta registrada!',icon: 'success'});</script>");
	            } else {
	                request.setAttribute("mensaje",
	                        "<script>Swal.fire({title: 'Aviso!',text: 'Error al registrar!',icon: 'error'});</script>");
	            }
	        } catch (Exception e) {
	            request.setAttribute("mensaje",
	                    "<script>Swal.fire({title: 'Aviso!',text: 'Valores vacíos o erróneos!',icon: 'error'});</script>");
	        }
	        request.getRequestDispatcher("crudboletas.jsp").forward(request, response);
	    }	}


