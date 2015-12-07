package com.wrc.ziyo.action.product;

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
import com.wrc.ziyo.pojo.Product;
import com.wrc.ziyo.pojo.Users;
import com.wrc.ziyo.service.product.ProductService;
import com.wrc.ziyo.util.DictUtil;

@Namespace("/productAction")
@Scope("prototype")
@Controller
@Component("productAction")
public class ProductAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {

	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;
	private HttpServletResponse response;

	@Autowired
	private ProductService productService;
	private Product product;
	private List<Product> proList;

	@Action(value = "add", results = {
			@org.apache.struts2.convention.annotation.Result(name = "success", location = "/error.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String add() {
		Users user = (Users) this.request.getSession()
				.getAttribute("userLogin");
		this.product.setUserid(user.getUserId());
		this.product.setLastTime(new Date());
		try {
			this.productService.save(this.product);
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("产品录入失败！");
			this.request.setAttribute("msg", "产品录入失败！");
			return "error";
		}
		this.request.setAttribute("msg", "产品录入 成功");
		return "success";
	}

	@Action(value = "list", results = {
			@org.apache.struts2.convention.annotation.Result(name = "success", location = "/jsp/product/list.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String list() {
		Users user = (Users) this.request.getSession()
				.getAttribute("userLogin");
		if (this.product == null)
			this.product = new Product();
		this.product.setUsers(user);
		try {
			List listAss = this.productService.findByExample(this.product, 0,
					20);
			this.request.setAttribute("listAss", listAss);
			this.request.setAttribute("product", this.product);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("产品查询失败");
			this.request.setAttribute("msg", "产品查询失败");
		}
		return "error";
	}

	@Action(value = "getById", results = {
			@org.apache.struts2.convention.annotation.Result(name = "update", location = "/jsp/product/update.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "detail", location = "/jsp/product/detail.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String getById() {
		int id = Integer.parseInt(this.request.getParameter("id"));
		String returnType = this.request.getParameter("returnType");
		try {
			this.product = this.productService.get(Integer.valueOf(id));
			this.request.setAttribute("product", this.product);
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
		this.product.setUserid(user.getUserId());
		this.product.setLastTime(new Date());
		try {
			this.productService.update(this.product);
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("产品修改失败！");
			this.request.setAttribute("msg", "产品修改失败！");
			return "error";
		}
		this.request.setAttribute("msg", "产品修改成功");
		return "success";
	}

	@Action(value = "getJsonByName")
	public String getJsonByName() {
		String proName = request.getParameter("proName");
		if (null != proName) {
			String whereStr = " cpmc like '%" + proName + "%'";
			try {
				proList = this.productService.getProList(whereStr);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "json";
	}

	@Action("getSelect2Products")
	public String getSelect2Products() throws IOException {
		this.response.setCharacterEncoding("UTF-8");
		PrintWriter out = this.response.getWriter();
		try {
			List listAss = this.productService.findAll();
			StringBuffer jsonSelect2 = new StringBuffer();
			jsonSelect2.append("[");
			for (int i = 0; i < listAss.size(); i++) {
				Product pro = (Product) listAss.get(i);
				if (i != 0)
					jsonSelect2.append(",");
				jsonSelect2.append("{ id: " + pro.getId() + ", text: '"
						+ pro.getCpmc() + "※" + pro.getCpgg() + "※"
						+ pro.getSuppliers().getGysmc() + "※"
						+ DictUtil.getCplx(pro.getCplx()) + "' }");
			}
			jsonSelect2.append("]");
			out.print(jsonSelect2.toString());
			return null;
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

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProList() {
		return proList;
	}

	public void setProList(List<Product> proList) {
		this.proList = proList;
	}

}
