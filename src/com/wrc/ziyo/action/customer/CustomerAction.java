package com.wrc.ziyo.action.customer;

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
import com.wrc.ziyo.pojo.Customer;
import com.wrc.ziyo.pojo.Users;
import com.wrc.ziyo.service.customer.CustomerService;

@Namespace("/customerAction")
@Scope("prototype")
@Controller
@Component("customerAction")
public class CustomerAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {
	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;
	private HttpServletResponse response;

	private Customer customer;

	@Autowired
	private CustomerService customerService;

	@Action(value = "add", results = {
			@org.apache.struts2.convention.annotation.Result(name = "success", location = "/error.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String add() {
		Users user = (Users) this.request.getSession()
				.getAttribute("userLogin");
		this.customer.setLastTime(new Date());
		this.customer.setUserid(user.getUserId());

		try {
			customerService.save(customer);
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("客户资料录入失败！");
			this.request.setAttribute("msg", "客户资料录入失败！");
			return "error";
		}
		this.request.setAttribute("msg", "客户资料录入 成功");
		return "success";
	}

	@Action(value = "list", results = {
			@org.apache.struts2.convention.annotation.Result(name = "success", location = "/jsp/customer/list.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String list() {
		Users user = (Users) this.request.getSession()
				.getAttribute("userLogin");
		if (this.customer == null)
			this.customer = new Customer();
		this.customer.setUsers(user);
		try {
			List listAss = this.customerService.findByExample(this.customer, 0,
					20);
			this.request.setAttribute("listAss", listAss);
			this.request.setAttribute("customer", this.customer);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("产品查询失败");
			this.request.setAttribute("msg", "产品查询失败");
		}
		return "error";
	}

	@Action("getCustomerBySelect2")
	public void getCustomerBySelect2() {
		this.response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter out = this.response.getWriter();
			List listAss = this.customerService.findAll();
			StringBuffer jsonSelect2 = new StringBuffer();
			jsonSelect2.append("[");
			for (int i = 0; i < listAss.size(); i++) {
				Customer customer = (Customer) listAss.get(i);
				if (i != 0)
					jsonSelect2.append(",");
				jsonSelect2.append("{ id: " + customer.getId() + ", text: '"
						+ customer.getKhmc() + "※" + customer.getQy() + "※"
						+ customer.getJc() + "※" + customer.getYwy() + "' }");
			}
			jsonSelect2.append("]");
			out.print(jsonSelect2.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
}
