package com.ciberfarma.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ciberfarma.model.DetalleBoleta;
import com.ciberfarma.model.Producto;

/**
 * Servlet implementation class AgregarCompraServlet
 */
@WebServlet(name = "agregar", urlPatterns = { "/agregar" })
public class AgregarCompraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// obtener el Producto enviado a nivel de sesión (attrib)
		Producto p = (Producto) request.getSession().getAttribute("p");
		
		// leer la cantidad a comprar (input -> param)
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		
		// crear un obj DetalleBoleta para agregar al carro
		DetalleBoleta d = new DetalleBoleta();
		d.setIdprod(p.getIdprod());
		d.setNomprod(p.getDescripcion());
		d.setCantidad(cantidad);
		d.setPreciovta(p.getPrecio());
		d.setImporte(cantidad * p.getPrecio());
		
		// traer las variables "globales" de sesión del carro (attrib)
		List<DetalleBoleta> carro = (List<DetalleBoleta>) request.getSession().getAttribute("carro");
    	double subTotalVenta = (double) request.getSession().getAttribute("subTotalVenta");
    	int cantArticulos = (int) request.getSession().getAttribute("cantArticulos");
    	
    	// validar si existe ya existe el producto
    	boolean existe = false;
    	for (DetalleBoleta detalleBoleta : carro) {
			if (detalleBoleta.getIdprod().equals(d.getIdprod())) {
				// si existe, aumenta la cant y el importe
				detalleBoleta.setCantidad(detalleBoleta.getCantidad() + d.getCantidad());
				detalleBoleta.setImporte(detalleBoleta.getImporte() + d.getImporte());
				// actualiza los contadores globales
				subTotalVenta += d.getImporte();
				cantArticulos += d.getCantidad();
				// fin de búsqueda
				existe = true;
				break;
			}
		}
    	
    	if (!existe) {  // si después de la búsqueda no lo encuentra
    		carro.add(d);
    		subTotalVenta += d.getImporte();
    		cantArticulos += d.getCantidad();
    	}
		
		// reenviar las variables globales
		request.getSession().setAttribute("carro", carro);
    	request.getSession().setAttribute("subTotalVenta", subTotalVenta);
    	request.getSession().setAttribute("cantArticulos", cantArticulos);
    	
    	response.sendRedirect("canasta.jsp");
	}

}




