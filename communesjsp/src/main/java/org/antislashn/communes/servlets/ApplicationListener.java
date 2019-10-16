package org.antislashn.communes.servlets;

import java.util.logging.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.antislashn.communes.services.CommunesServices;

/**
 * Application Lifecycle Listener implementation class ApplicationListener
 *
 */
public class ApplicationListener implements ServletContextListener {
	
	private static final Logger LOG = Logger.getLogger("communes");




	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	LOG.info(">>> appli démarrée");
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("communes");
    	LOG.info(">>> EMF " + emf);
    	ServletContext application = sce.getServletContext();
    	application.setAttribute(Constantes.EMF, emf);
    	
    	CommunesServices service = new CommunesServices(emf);
    	LOG.info(">>> Service " + service);
    	application.setAttribute(Constantes.COMMUNE_SERVICE, service);
    	
    }
    
    
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	LOG.info(">>> appli retirée");
    	EntityManagerFactory emf = (EntityManagerFactory) sce.getServletContext().getAttribute(Constantes.EMF);
    	emf.close();
    	LOG.info(">>> EMF closed");
    	LOG.info(">>> appli retirée");
    }
	
}
