package firstWebApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetPostDemoServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>The Get method</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("The servlet has received a GET. Now, click the button below.");
		out.println("<FORM METHOD=POST>");
		out.println("<INPUT TYPE=SUBMIT VALUE=submit>");
		out.println("</FORM></BODY></HTML>");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>"); 
	    out.println("<TITLE>The POST method</TITLE>"); 
	    out.println("</HEAD>"); 
	    out.println("<BODY>"); 
	    out.println("The servlet has received a POST. Thank you."); 
	    out.println("</BODY>"); 
	    out.println("</HTML>"); 
	}
	
}
