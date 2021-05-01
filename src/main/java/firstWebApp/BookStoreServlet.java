package firstWebApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookStoreServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>The Get method</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("Book Search by Name:");
		out.println("<FORM METHOD=POST>");
		out.println("Book Name: <INPUT TYPE=TEXT NAME=name>");
		out.println("<INPUT TYPE=SUBMIT VALUE=submit>");
		out.println("</FORM></BODY></HTML>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException, ServletException {

		String bookName = request.getParameter("name");
		System.out.println("Request book name: " + bookName);

		if (bookName != null && getAllBooks().contains(bookName)) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/bookdetail");
			rd.forward(request, response);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<HTML>");
			out.println("<HEAD>");
			out.println("<TITLE>The Get method</TITLE>");
			out.println("</HEAD>");
			out.println("<BODY>");
			out.println("Book no found");
			out.println("</BODY></HTML>");
		}

	}

	private List<String> getAllBooks() {
		List<String> bookStore = new ArrayList<String>();
		bookStore.add("BrookLink");
		bookStore.add("Moonlight");
		bookStore.add("Hello Jack");
		bookStore.add("CAV tutorial");
		return bookStore;
	}
}
