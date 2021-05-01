package firstWebApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CounterServlet extends HttpServlet {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		HttpSession session = request.getSession(true);
		System.out.println("session id: "+ session.getId());
		int counter = Integer.parseInt((String) context.getAttribute("counter"));
		session.setAttribute("user"+counter, "test");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>User Counter</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");

		out.println("There are " + counter + " users.");
		out.println("</BODY>");
		out.println("</HTML>");
	}
}
