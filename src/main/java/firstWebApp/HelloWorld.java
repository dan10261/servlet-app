package firstWebApp;

import javax.servlet.*;
import java.util.Enumeration;
import java.io.IOException;

public class HelloWorld implements Servlet {
	ServletConfig servletConfig;

	public void init(ServletConfig config) throws ServletException {
		servletConfig = config;
	}

	public void destroy() {
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = servletConfig.getServletContext();
		servletContext.setAttribute("password", "dingdong");
		Enumeration attributes = servletContext.getAttributeNames();
		while (attributes.hasMoreElements()) {
			String attribute = (String) attributes.nextElement();
			System.out.println("Attribute name : " + attribute);
			System.out.println("Attribute value : " + servletContext.getAttribute(attribute));
		}

		System.out.println("Major version : " + servletContext.getMajorVersion());
		System.out.println("Minor version : " + servletContext.getMinorVersion());
		System.out.println("Server info : " + servletContext.getServerInfo());
		System.out.println("password : " + servletContext.getAttribute("password"));
	}

	public String getServletInfo() {
		return null;
	}

	public ServletConfig getServletConfig() {
		return null;
	}
}
