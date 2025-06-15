package com.ExploraPeru.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ExploraPeru.Mantenimiento.MantenimientoTarjetaCredito;
import com.ExploraPeru.model.DetalleBoleta;
import com.ExploraPeru.model.TipoTarjeta;
import com.ExploraPeru.model.Vuelos;

/**
 * Servlet implementation class ServarServicioServlt
 */
@WebServlet(name = "reservar", urlPatterns = { "/reservar" })
public class AgregarCarro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Vuelos v = (Vuelos) request.getSession().getAttribute("vuelo");

			int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            System.out.println(v.getPrecio()*cantidad);
            System.out.println(v.getPrecio());
            System.out.println(cantidad);
            
			DetalleBoleta d = new DetalleBoleta();
			d.setCantidad(cantidad);
			d.setFechaSalida(v.getFechaSalida());
			d.setIdViaje(v.getIdVuelo());
			d.setImporte( cantidad * v.getPrecio() );
			d.setNombreViaje(v.getLugar());
			d.setPrecio(v.getPrecio());
			d.setUrlImg(v.getImagenUrl());

			List<DetalleBoleta> carro = (List<DetalleBoleta>) request.getSession().getAttribute("carro");
			int cantViaje = (int) request.getSession().getAttribute("canViajes");
			double subTotalViaje = (double) request.getSession().getAttribute("subTotalViaje");

			boolean existe = false;

			for (DetalleBoleta detalleBoleta : carro) {
				if (detalleBoleta.getIdViaje() == v.getIdVuelo()) {
					
					detalleBoleta.setCantidad(detalleBoleta.getCantidad() + d.getCantidad());
					detalleBoleta.setImporte(detalleBoleta.getImporte() + d.getImporte());

					subTotalViaje += d.getImporte();
					cantViaje += d.getCantidad();

					existe = true;
					break;
				}
			}
			if (!existe) {
				carro.add(d);
				subTotalViaje += d.getImporte();
				cantViaje += d.getCantidad();
			}

			
			  List<TipoTarjeta> cmb=new MantenimientoTarjetaCredito().ComboBox();
			  request.getSession().setAttribute("cmb", cmb);
			 
			
			
			
			request.getSession().setAttribute("carro", carro);
			request.getSession().setAttribute("canViajes", cantViaje);
			request.getSession().setAttribute("subTotalViaje", subTotalViaje);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		response.sendRedirect("Carrito.jsp");
	}

}
