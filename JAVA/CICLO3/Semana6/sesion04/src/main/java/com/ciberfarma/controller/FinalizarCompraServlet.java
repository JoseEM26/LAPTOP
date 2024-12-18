package com.ciberfarma.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ciberfarma.mantenimientos.GestionBoleta;
import com.ciberfarma.model.Boleta;
import com.ciberfarma.model.DetalleBoleta;
import com.ciberfarma.model.Usuario;

/**
 * Servlet implementation class FinalizarCompraServlet
 */
@WebServlet(name = "pagar", urlPatterns = { "/pagar" })
public class FinalizarCompraServlet extends HttpServlet {
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
		// validar si el usuario está logueado (attrib)
		Usuario u = (Usuario) request.getSession().getAttribute("u");
		
		if (u == null) {
			request.setAttribute("mensaje","<script>Swal.fire({title: 'Aviso!',text: 'Ingrese a su cuenta para continuar!',icon: 'warning'});</script>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		// Crea el objeto cabecera de boleta
		Boleta b = new Boleta();
		b.setCod_cliente(u.getCodigo());
		
		// Detalle de Boleta -> usamos el carro
		List<DetalleBoleta> carro = (List<DetalleBoleta>) request.getSession().getAttribute("carro");
    	double subTotalVenta = (double) request.getSession().getAttribute("subTotalVenta");
    	int cantArticulos = (int) request.getSession().getAttribute("cantArticulos");
    	
		int ok = new GestionBoleta().realizarVenta(b, carro);
		
		if (ok == 0) {  // error
			request.setAttribute("mensaje","<script>Swal.fire({title: 'Aviso!',text: 'Error al realizar venta!',icon: 'error'});</script>");
			request.getRequestDispatcher("canasta.jsp").forward(request, response);
		} else {        // éxito
			request.setAttribute("mensaje","<script>Swal.fire({title: 'Aviso!',text: 'Venta éxitosa!',icon: 'success'});</script>");
			// limpiar las variables globales
			request.getSession().setAttribute("carro", new ArrayList<DetalleBoleta>());
	    	request.getSession().setAttribute("subTotalVenta", 0.0);
	    	request.getSession().setAttribute("cantArticulos", 0);
	    	
			request.getRequestDispatcher("canasta.jsp").forward(request, response);
		}
	}

}








