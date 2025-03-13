package com.ExploraPeru.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ExploraPeru.Mantenimiento.MantenimientoBoleta;
import com.ExploraPeru.Mantenimiento.MantenimientoTarjetaCredito;
import com.ExploraPeru.model.Boleta;
import com.ExploraPeru.model.DetalleBoleta;
import com.ExploraPeru.model.Tarjeta;
import com.ExploraPeru.model.Usuario;

/**
 * Servlet implementation class VerificarTarjetaServlt
 */
@WebServlet(name = "verificarTar", urlPatterns = { "/verificarTar" })
public class VerificarTarjetaServlt extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerificarTarjetaServlt() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Carrito.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Validación de entrada
            String numeroTarjeta = request.getParameter("numero");
            String cvvString = request.getParameter("cvv");
            String fechaValidacion = request.getParameter("fecha");
            String tipoTarjetaString = request.getParameter("cmb");

            if (numeroTarjeta == null || numeroTarjeta.isEmpty() ||
                cvvString == null || cvvString.isEmpty() ||
                fechaValidacion == null || fechaValidacion.isEmpty() ||
                tipoTarjetaString == null || tipoTarjetaString.isEmpty()) {

                request.setAttribute("mensaje",
                        "<script>Swal.fire({title: 'Aviso!',text: 'Todos los campos son obligatorios!',icon: 'error'});</script>");
                request.getRequestDispatcher("Carrito.jsp").forward(request, response);
                return;
            }

            // Parseo de datos
            int cvv = Integer.parseInt(cvvString);
            int tipoTarjeta = Integer.parseInt(tipoTarjetaString);

            // Crear objeto tarjeta
            Tarjeta t = new Tarjeta();
            t.setIdTipo(tipoTarjeta);
            t.setCVV(cvv);
            t.setNumeroTarjeta(numeroTarjeta);
            t.setFechaValidacion(fechaValidacion);

            // Comprobar tarjeta
            Tarjeta ok = new MantenimientoTarjetaCredito().obtener(t);

            if (ok == null) {
                request.setAttribute("mensaje",
                        "<script>Swal.fire({title: 'Aviso!',text: 'Tarjeta inválida!',icon: 'error'});</script>");
                request.getRequestDispatcher("Carrito.jsp").forward(request, response);
                return;
            }

            // Realizar venta
            Usuario u = (Usuario) request.getSession().getAttribute("u");

            if (u == null) {
                request.setAttribute("mensaje",
                        "<script>Swal.fire({title: 'Aviso!',text: 'Debe iniciar sesión primero!',icon: 'warning'});</script>");
                response.sendRedirect("Login.jsp");
                return;
            }

            Boleta b = new Boleta();
            b.setId_usuario(u.getIdUsuario());

            List<DetalleBoleta> carro = (List<DetalleBoleta>) request.getSession().getAttribute("carro");
            if (carro == null || carro.isEmpty()) {
                request.setAttribute("mensaje",
                        "<script>Swal.fire({title: 'Aviso!',text: 'El carrito está vacío!',icon: 'error'});</script>");
                request.getRequestDispatcher("Carrito.jsp").forward(request, response);
                return;
            }

            int okVenta = new MantenimientoBoleta().RealizarVenta(b, carro);

            if (okVenta == 0) {
                request.setAttribute("mensaje",
                        "<script>Swal.fire({title: 'Aviso!',text: 'Error al realizar la venta!',icon: 'error'});</script>");
                request.getRequestDispatcher("Carrito.jsp").forward(request, response);
            } else {
                request.setAttribute("mensaje",
                        "<script>Swal.fire({title: 'Aviso!',text: 'Venta exitosa!',icon: 'success'});</script>");
                request.getSession().setAttribute("carro", new ArrayList<DetalleBoleta>());
                request.getSession().setAttribute("subTotalViaje", 0.0);
                request.getSession().setAttribute("canViajes", 0);
                // Hacer forward en lugar de redirección
                request.getRequestDispatcher("Carrito.jsp").forward(request, response);
            }

        } catch (NumberFormatException e) {
            request.setAttribute("mensaje",
                    "<script>Swal.fire({title: 'Aviso!',text: 'Error en los datos ingresados!',icon: 'error'});</script>");
            request.getRequestDispatcher("Carrito.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("Error en la venta: " + e.getMessage());
            request.setAttribute("mensaje",
                    "<script>Swal.fire({title: 'Aviso!',text: 'Error al procesar los datos!',icon: 'error'});</script>");
            request.getRequestDispatcher("Carrito.jsp").forward(request, response);
        }
    }
}
