package com.ExploraPeru.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ExploraPeru.Mantenimiento.MantenimientoDetalleBoleta;
import com.ExploraPeru.model.DetBoleta;
import com.ExploraPeru.model.DetalleBoleta;

/**
 * Servlet implementation class CrudDetalleBoleta
 */
@WebServlet(name = "DetalleBoleta", urlPatterns = { "/DetalleBoleta" })
public class CrudDetalleBoleta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrudDetalleBoleta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   List<DetBoleta> lstDetBoletas = new MantenimientoDetalleBoleta().listadoCompleto();

	        // Pasar la lista como atributo a la JSP
	        request.getSession().setAttribute("lstDetBoletas", lstDetBoletas);

	        // Redirigir a la JSP para mostrar los detalles de la boleta
	        request.getRequestDispatcher("crudDetalleBoleta.jsp").forward(request, response);
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
