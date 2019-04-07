package pers.mw.exercise;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServletAttrListener
 *
 */
@WebListener
public class ServletAttrListener implements ServletContextAttributeListener {

    /**
     * Default constructor. 
     */
    public ServletAttrListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent scae)  { 
         System.out.println("attributeAdded");
         System.out.println(scae.getServletContext().getAttribute("contextInitialized"));
         System.out.println(scae.getServletContext().getAttribute("ServletParamInit"));
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
         // TODO Auto-generated method stub
    }
	
}
