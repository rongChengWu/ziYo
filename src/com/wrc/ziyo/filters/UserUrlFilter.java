package com.wrc.ziyo.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wrc.ziyo.pojo.Users;

public class UserUrlFilter implements Filter {
	private FilterConfig filterConfig;

	public void destroy() {
		this.filterConfig = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rep = (HttpServletResponse) response;
		req.setAttribute("toobar_url", req.getRequestURI());
		Users user = (Users) req.getSession().getAttribute("userLogin");

		if ((user == null) || ("".equals(user.getUserAccount()))) {
			if ("/,/ziYo/jsp/system/login.jsp/ziYo/systemAction/userLogin"
					.indexOf(req.getRequestURI()) != -1) {
				System.out
						.println("req.getRequestURI()=" + req.getRequestURI());
				chain.doFilter(request, response);
				return;
			}
			rep.sendRedirect("/ziYo/jsp/system/login.jsp");
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		this.filterConfig = arg0;
	}

}

/*
 * Location: C:\Users\asus\Desktop\sshFrame\WebContent\WEB-INF\classes\
 * Qualified Name: com.wrc.sshFrame.filters.UserUrlFilter JD-Core Version: 0.6.0
 */