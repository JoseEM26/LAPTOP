package com.ExploraPeru.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ExploraPeru.Mantenimiento.MantenimientoContactanos;
import com.ExploraPeru.model.Contacto;

/**
 * Servlet implementation class CrudContactanos
 */
@WebServlet(name = "crudcontacto", urlPatterns = { "/crudcontacto" })
public class CrudContactanos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrudContactanos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Obtener la lista de contactos
        List<Contacto> lstContactos = new MantenimientoContactanos().listado();

        // Pasar la lista como atributo a la JSP
        request.getSession().setAttribute("lstContactos", lstContactos);

        // Redirigir a la JSP
        request.getRequestDispatcher("crudContactanos.jsp").forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    }

	  

	  

	   
	}


