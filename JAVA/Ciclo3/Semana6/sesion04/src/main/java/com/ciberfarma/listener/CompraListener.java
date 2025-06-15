package com.ciberfarma.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.ciberfarma.model.DetalleBoleta;

/**
 * Application Lifecycle Listener implementation class CompraListener
 *
 */
@WebListener
public class CompraListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public CompraListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
        System.out.println("Creando variables el carro");
    	// las variables "globales" del proceso de carro de compra
    	List<DetalleBoleta> carro = new ArrayList<DetalleBoleta>(); // lista
    	double subTotalVenta = 0.0; // acumulador del total a pagar
    	int cantArticulos = 0; // contador de cantidad de artículos/prod
    	
    	// enviar las variables a nivel de sesión (attrib)
    	se.getSession().setAttribute("carro", carro);
    	se.getSession().setAttribute("subTotalVenta", subTotalVenta);
    	se.getSession().setAttribute("cantArticulos", cantArticulos);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
