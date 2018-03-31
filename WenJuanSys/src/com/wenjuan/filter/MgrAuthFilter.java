package com.wenjuan.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/mgr/*")
public class MgrAuthFilter implements Filter {

    
	public void destroy() {
	
	}

	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession();
		Object user = session.getAttribute("mgr");
		if (user == null) {
			response.sendRedirect("../mgrLogin.jsp");
			return;
		}
		chain.doFilter(req, resp);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
