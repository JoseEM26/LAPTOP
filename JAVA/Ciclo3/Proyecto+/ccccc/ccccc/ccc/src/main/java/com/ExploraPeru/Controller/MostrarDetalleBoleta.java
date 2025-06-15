package com.ExploraPeru.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ExploraPeru.Mantenimiento.MantenimientoDestinos;
import com.ExploraPeru.Mantenimiento.MantenimientoDetalleBoleta;
import com.ExploraPeru.model.Destinos;
import com.ExploraPeru.model.DetBoleta;

/**
 * Servlet implementation class MostrarDetBoleta
 */
@WebServlet(name = "mostrarDetBoleta", urlPatterns = { "/mostrarDetBoleta" })
public class MostrarDetalleBoleta extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarDetalleBoleta() {
        super();
        // Constructor vacío
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Destinos> COMBO = new MantenimientoDestinos().listado();
            request.setAttribute("cmb", COMBO);

        	   // Obtener el número de boleta (numBol) de la solicitud
               String numBol = request.getParameter("numBol");
               int idDestino = Integer.parseInt(request.getParameter("idDestino"));
                System.out.println(numBol+"   "+idDestino+"");
		
             
             
            DetBoleta detalle = new MantenimientoDetalleBoleta().obtener(numBol, idDestino);
            request.setAttribute("detalle", detalle);

            // Redirigir a la JSP para mostrar los detalles de la boleta
            request.getRequestDispatcher("mostrarDetalleBoleta.jsp").forward(request, response);

        } catch (Exception e) {
            System.out.println("Error al obtener detalle de boleta: " + e.getMessage());
            request.setAttribute("mensaje", 
                    "<script>Swal.fire({title: 'Aviso!', text: 'Error al obtener detalle de boleta!', icon: 'error'});</script>");
            request.getRequestDispatcher("MenuUsuario.jsp").forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Obtener los datos del formulario para actualizar el detalle de la boleta
        	   String numBol = request.getParameter("numBol");
               int idDestino = Integer.parseInt(request.getParameter("idDestino"));
            // Verificar que el número de boleta no sea nulo o vacío
            if (numBol != null && !numBol.isEmpty()) {
                DetBoleta detalle = new DetBoleta();
                detalle.setNum_bol(numBol);
                detalle.setPreciovta(Double.parseDouble(request.getParameter("precio")) );
                detalle.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
                detalle.setId_destino(idDestino);

                // Llamar al método para actualizar el detalle de la boleta
                int ok = new MantenimientoDetalleBoleta().actualizar(detalle);

                if (ok != 0) {
                    request.setAttribute("mensaje", 
                            "<script>Swal.fire({title: 'Aviso!', text: 'Detalle de boleta actualizado!', icon: 'success'});</script>");
                    request.getRequestDispatcher("MenuUsuario.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensaje", 
                            "<script>Swal.fire({title: 'Aviso!', text: 'Error al actualizar detalle de boleta!', icon: 'error'});</script>");
                    request.getRequestDispatcher("crudDetalleBoleta.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("mensaje", 
                        "<script>Swal.fire({title: 'Aviso!', text: 'Número de boleta no proporcionado!', icon: 'error'});</script>");
                request.getRequestDispatcher("crudDetalleBoleta.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar detalle de boleta: " + e.getMessage());
            request.setAttribute("mensaje", 
                    "<script>Swal.fire({title: 'Aviso!', text: 'Error al actualizar detalle de boleta!', icon: 'error'});</script>");
            request.getRequestDispatcher("crudDetalleBoleta.jsp").forward(request, response);
        }
    }
}
