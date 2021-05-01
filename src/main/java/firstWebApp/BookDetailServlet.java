package firstWebApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookDetailServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("BookDetailServlet GET: " + request.getServletPath());
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>The Get method</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println(request.getParameter("name"));
		out.println("</BODY></HTML>");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("BookDetailServlet POST: " + request.getServletPath());
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>The Get method</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("Book Name: " + request.getParameter("name"));
		out.println("</BODY></HTML>");
	}
}
