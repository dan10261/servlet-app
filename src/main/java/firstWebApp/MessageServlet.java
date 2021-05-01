package firstWebApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import firstWebApp.service.MessageService;

public class MessageServlet extends HttpServlet {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		MessageService service = new MessageService();
		List<HashMap<String, String>> msgs = service.getAllMsgs();

		PrintWriter out;
		try {
			out = response.getWriter();
			out.println("<HTML>");
			out.println("<HEAD>");
			out.println("<TITLE>The Get method</TITLE>");
			out.println("</HEAD>");
			out.println("<BODY>");
			out.println("List of all messages");
			out.println("<TABLE>");
			for (HashMap<String, String> msg : msgs) {
				out.println("<tr><td>" + msg.get("payload") + "</td></tr>");
				out.println("<tr><td>" + msg.get("original_message") + "</td></tr>");
			}
			out.println("<TABLE>");
			out.println("</TABLE></BODY></HTML>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
