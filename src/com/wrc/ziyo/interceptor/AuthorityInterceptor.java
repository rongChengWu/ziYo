package com.wrc.ziyo.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.wrc.ziyo.pojo.Users;
import com.wrc.ziyo.util.UtilException;

public class AuthorityInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 2914081148619842225L;

	public String intercept(ActionInvocation arg0) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();

		String contextPath = request.getServletContext().getContextPath();

		String uri = request.getRequestURI();

		String actionUrl = uri.replace(contextPath, "");

		System.out.println("contextPath:" + contextPath);
		System.out.println("uri:" + uri);
		System.out.println("actionUrl:" + actionUrl);

		Users user = (Users) request.getSession().getAttribute("userLogin");
		if ((user == null) || ("".equals(user.getUserAccount()))) {
			request.setAttribute("msg", UtilException
					.getExcMessage(UtilException.ExcCode.Unlogined));
			return "error";
		}
		return arg0.invoke();
	}

}

/*
 * Location: C:\Users\asus\Desktop\sshFrame\WebContent\WEB-INF\classes\
 * Qualified Name: com.wrc.sshFrame.interceptor.AuthorityInterceptor JD-Core
 * Version: 0.6.0
 */