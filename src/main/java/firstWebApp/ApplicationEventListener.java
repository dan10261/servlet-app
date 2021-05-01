package firstWebApp;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import firstWebApp.dao.DBConnection;
import firstWebApp.utils.AppCounter;

public class ApplicationEventListener implements ServletContextListener, ServletContextAttributeListener,
		HttpSessionListener, HttpSessionAttributeListener {
	private ServletContext context;
	@Override
	public void contextInitialized(ServletContextEvent cse) {
		System.out.println(ApplicationEventListener.class.getName() + ": context is initialized.");
		DBConnection.getConnection();
		cse.getServletContext().setAttribute("counter", "0");
		context = cse.getServletContext();
	}

	@Override
	public void contextDestroyed(ServletContextEvent cse) {
		System.out.println(ApplicationEventListener.class.getName() + ": context is Destroyed. updated");
		DBConnection.CloseConn();
		cse.getServletContext().removeAttribute("counter");
	}

	@Override
	public void attributeAdded(javax.servlet.ServletContextAttributeEvent scae) {
		System.out.println(ApplicationEventListener.class.getName() + ": context attribute is added.");

	}

	@Override
	public void attributeRemoved(javax.servlet.ServletContextAttributeEvent scae) {
		System.out.println(ApplicationEventListener.class.getName() + ": context attribute is removed.");

	}

	@Override
	public void attributeReplaced(javax.servlet.ServletContextAttributeEvent scae) {
		System.out.println(ApplicationEventListener.class.getName() + ": context attribute is replaced.");

	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println(ApplicationEventListener.class.getName() + ": session is created.");
		AppCounter.IncreamentCounter(context );
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println(ApplicationEventListener.class.getName() + ": Session is destroyed.");
		AppCounter.decreamentCounter(context );
	}

	@Override
	public void attributeAdded(javax.servlet.http.HttpSessionBindingEvent se) {
		System.out.println(ApplicationEventListener.class.getName() + ": Session is added.");

	}

	@Override
	public void attributeRemoved(javax.servlet.http.HttpSessionBindingEvent se) {
		System.out.println(ApplicationEventListener.class.getName() + ": Session is removed.");

	}

	@Override
	public void attributeReplaced(javax.servlet.http.HttpSessionBindingEvent se) {
		System.out.println(ApplicationEventListener.class.getName() + ": Session is replaced.");

	}
}
