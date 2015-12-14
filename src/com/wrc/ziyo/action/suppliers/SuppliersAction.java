package com.wrc.ziyo.action.suppliers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

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
import com.wrc.ziyo.pojo.Suppliers;
import com.wrc.ziyo.pojo.Users;
import com.wrc.ziyo.service.suppliers.SuppliersService;

@Namespace("/suppliersAction")
@Scope("prototype")
@Controller
@Component("suppliersAction")
public class SuppliersAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;
	private HttpServletResponse response;

	@Autowired
	private SuppliersService suppliersService;
	private Suppliers suppliers;

	@Action(value = "add", results = {
			@org.apache.struts2.convention.annotation.Result(name = "success", location = "/error.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String add() {
		Users user = (Users) this.request.getSession()
				.getAttribute("userLogin");
		this.suppliers.setUserid(user.getUserId());
		this.suppliers.setLastTime(new Date());
		try {
			this.suppliersService.save(this.suppliers);
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("供应商录入失败！");
			this.request.setAttribute("msg", "供应商录入失败！");
			return "error";
		}
		this.request.setAttribute("msg", "供应商录入 成功");
		return "success";
	}

	@Action(value = "list", results = {
			@org.apache.struts2.convention.annotation.Result(name = "success", location = "/jsp/suppliers/list.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String list() {
		Users user = (Users) this.request.getSession()
				.getAttribute("userLogin");
		if (this.suppliers == null)
			this.suppliers = new Suppliers();
		this.suppliers.setUsers(user);
		try {
			List listAss = this.suppliersService.findByExample(this.suppliers,
					0, 20);
			this.request.setAttribute("listAss", listAss);
			this.request.setAttribute("suppliers", this.suppliers);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("供应商查询失败");
			this.request.setAttribute("msg", "供应商查询失败");
		}
		return "error";
	}

	@Action(value = "getById", results = {
			@org.apache.struts2.convention.annotation.Result(name = "update", location = "/jsp/suppliers/update.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "detail", location = "/jsp/suppliers/detail.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String getById() {
		int id = Integer.parseInt(this.request.getParameter("id"));
		String returnType = this.request.getParameter("returnType");
		try {
			this.suppliers = this.suppliersService.get(Integer.valueOf(id));
			this.request.setAttribute("suppliers", this.suppliers);
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("查询失败！");
			this.request.setAttribute("msg", "查询失败！");
			return "error";
		}
		return returnType;
	}

	@Action(value = "update", results = {
			@org.apache.struts2.convention.annotation.Result(name = "success", location = "/error.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String update() {
		Users user = (Users) this.request.getSession()
				.getAttribute("userLogin");
		this.suppliers.setUserid(user.getUserId());
		this.suppliers.setLastTime(new Date());
		try {
			this.suppliersService.update(this.suppliers);
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("供应商修改失败！");
			this.request.setAttribute("msg", "供应商修改失败！");
			return "error";
		}
		this.request.setAttribute("msg", "供应商修改成功");
		return "success";
	}

	@Action("getSelect2Suppliers")
	public String getSelect2Suppliers() throws IOException {
		this.response.setCharacterEncoding("UTF-8");
		PrintWriter out = this.response.getWriter();
		try {
			List listAss = this.suppliersService.findAll();
			StringBuffer jsonSelect2 = new StringBuffer();
			jsonSelect2.append("[");
			for (int i = 0; i < listAss.size(); i++) {
				Suppliers supp = (Suppliers) listAss.get(i);
				if (i != 0)
					jsonSelect2.append(",");
				jsonSelect2.append("{ id: " + supp.getId() + ", text: '"
						+ supp.getGysmc() + "' }");
			}
			jsonSelect2.append("]");
			out.print(jsonSelect2.toString());
		} catch (Exception e) {
			e.printStackTrace();
			out.print("1");
		}
		return null;
	}

	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public SuppliersService getSuppliersService() {
		return suppliersService;
	}

	public void setSuppliersService(SuppliersService suppliersService) {
		this.suppliersService = suppliersService;
	}

	public Suppliers getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(Suppliers suppliers) {
		this.suppliers = suppliers;
	}

}
