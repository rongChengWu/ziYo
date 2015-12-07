package com.wrc.ziyo.action.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.wrc.ziyo.pojo.UtilDict;
import com.wrc.ziyo.pojo.UtilDictDetails;
import com.wrc.ziyo.service.util.UtilDictDetailsService;
import com.wrc.ziyo.service.util.UtilDictService;

@Namespace("/utilDictAction")
@Scope("prototype")
@Controller
@Component("utilDictAction")
public class UtilDictAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {

	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;
	private HttpServletResponse response;
	private UtilDict utilDict;
	private UtilDictDetails utilDictDetails;

	@Autowired
	private UtilDictService utilDictService;
	@Autowired
	private UtilDictDetailsService utilDictDetailsService;

	@Action(value = "add", results = {
			@org.apache.struts2.convention.annotation.Result(name = "success", location = "/error.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String add() {
		try {
			utilDictService.save(utilDict);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";

	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public UtilDict getUtilDict() {
		return utilDict;
	}

	public void setUtilDict(UtilDict utilDict) {
		this.utilDict = utilDict;
	}

	public UtilDictDetails getUtilDictDetails() {
		return utilDictDetails;
	}

	public void setUtilDictDetails(UtilDictDetails utilDictDetails) {
		this.utilDictDetails = utilDictDetails;
	}

	public UtilDictService getUtilDictService() {
		return utilDictService;
	}

	public void setUtilDictService(UtilDictService utilDictService) {
		this.utilDictService = utilDictService;
	}

	public UtilDictDetailsService getUtilDictDetailsService() {
		return utilDictDetailsService;
	}

	public void setUtilDictDetailsService(
			UtilDictDetailsService utilDictDetailsService) {
		this.utilDictDetailsService = utilDictDetailsService;
	}

}
