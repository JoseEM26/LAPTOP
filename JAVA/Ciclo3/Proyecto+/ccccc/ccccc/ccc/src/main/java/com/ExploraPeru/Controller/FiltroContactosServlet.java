package com.ExploraPeru.Controller;

import com.ExploraPeru.Mantenimiento.MantenimientoContactanos;
import com.ExploraPeru.model.Contacto;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FiltroContactosServlet extends HttpServlet {

    // Método que maneja la solicitud GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 // Obtener el parámetro del contacto si está presente
        String idContactoFiltro = request.getParameter("idContacto");
        
        // Obtener todos los contactos para el combo box
        MantenimientoContactanos mantenimiento = new MantenimientoContactanos();
        List<Contacto> contactos = mantenimiento.listado();

        // Si hay un filtro, obtener los contactos filtrados por id
        List<Contacto> listaContactos = new ArrayList<Contacto>();
        if (idContactoFiltro != null && !idContactoFiltro.isEmpty()) {
            Contacto contactoFiltro = mantenimiento.obtener(Integer.parseInt(idContactoFiltro));
            listaContactos.add(contactoFiltro);
        } else {
            listaContactos = contactos;  // Si no hay filtro, mostrar todos
        }

        // Pasar todos los contactos al JSP
        request.setAttribute("lstContactos", listaContactos);
        request.setAttribute("contactosCombo", contactos); // Para el combo box
        request.getRequestDispatcher("mantenimientoContactos.jsp").forward(request, response);
   
    }
}
