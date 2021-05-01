package firstWebApp.utils;

import javax.servlet.ServletContext;

public class AppCounter{
	
	synchronized static public void IncreamentCounter(ServletContext se) {
		int counter = Integer.parseInt((String)se.getAttribute("counter"));
		counter++;
		se.setAttribute("counter", Integer.toString(counter));
		System.out.println("Counter is: " + counter);
	}

	synchronized static public void decreamentCounter( ServletContext se) {
		int counter = Integer.parseInt((String) se.getAttribute("counter"));
		counter--;
		se.setAttribute("counter", Integer.toString(counter));
		System.out.println("Counter is: " + counter);
	}
}
