package pers.mw.exercise.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class HttpFilterEx
 */
@SuppressWarnings("serial")
@WebFilter("/filterEx")
public class HttpFilterEx extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long begin = current();

		chain.doFilter(request, response);

		getServletContext().log(String.format("Request process in %d milliseconds", current() - begin));
	}

	private long current() {
		return System.currentTimeMillis();
	}
}
