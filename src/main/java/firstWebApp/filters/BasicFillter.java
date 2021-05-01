package firstWebApp.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class BasicFillter implements Filter {
	private FilterConfig filterConfig;
	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter Initialized");
		this.filterConfig = filterConfig;
		context = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("doFilter");
		System.out.println(req.getRemoteHost());
		chain.doFilter(req, resp);
	}

	@Override
	public void destroy() {

		System.out.println("Filter destroyed.");
		this.filterConfig = null;
	}

}
