package com.wrc.ziyo.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.wrc.ziyo.util.UtilException;

public class ExceptionInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = -3490533736557683231L;
	/* 22 */private Logger logger = Logger
			.getLogger(ExceptionInterceptor.class);
	/* 23 */private String excMessage = "";

	/* 28 */public String intercept(ActionInvocation arg0) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		/* 29 */String uri = request.getRequestURI();
		String result;
		try {
			result = arg0.invoke();
		} catch (HibernateException e) {
			/* 33 */e.printStackTrace();
			/* 34 */this.logger.error("异常拦截器拦截到异常：<br/>uri为：" + uri + "<br/>"
					+ e);
			/* 35 */this.excMessage = UtilException
					.getExcMessage(UtilException.ExcCode.DataProcessing);
			/* 36 */request.setAttribute("msg", this.excMessage);
			/* 37 */result = "error";
		} catch (NullPointerException e) {
			/* 39 */e.printStackTrace();
			/* 40 */this.logger.error("异常拦截器拦截到异常：<br/>action为：" + uri
					+ "<br/>" + e);
			/* 41 */this.excMessage = UtilException
					.getExcMessage(UtilException.ExcCode.IllegalData);
			/* 42 */request.setAttribute("msg", this.excMessage);
			/* 43 */result = "error";
		} catch (UtilException e) {
			/* 45 */e.printStackTrace();
			/* 46 */this.logger.error("异常拦截器拦截到异常：<br/>action为：" + uri
					+ "<br/>" + e);
			/* 47 */this.excMessage = e.getExcMessage();
			/* 48 */request.setAttribute("msg", this.excMessage);
			/* 49 */result = "error";
		} catch (Exception e) {
			/* 51 */e.printStackTrace();
			/* 52 */this.logger.error("异常拦截器拦截到异常：<br/>action为：" + uri
					+ "<br/>" + e);
			/* 53 */this.excMessage = UtilException
					.getExcMessage(UtilException.ExcCode.AppError);
			/* 54 */request.setAttribute("msg", this.excMessage);
			/* 55 */result = "error";
		}
		/* 57 */return result;
	}

}

/*
 * Location: C:\Users\asus\Desktop\sshFrame\WebContent\WEB-INF\classes\
 * Qualified Name: com.wrc.sshFrame.interceptor.ExceptionInterceptor JD-Core
 * Version: 0.6.0
 */