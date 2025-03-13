package com.ExploraPeru.Listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.ExploraPeru.model.DetalleBoleta;

/**
 * Application Lifecycle Listener implementation class ServervarListener
 *
 */
@WebListener
public class ServervarListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public ServervarListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
 
    	List<DetalleBoleta> carro= new ArrayList<DetalleBoleta>();
    	int canViajes=0;
    	double subTotalViaje=0.0;
    	
    	se.getSession().setAttribute("carro", carro);
    	se.getSession().setAttribute("canViajes", canViajes);
    	se.getSession().setAttribute("subTotalViaje", subTotalViaje);

    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
