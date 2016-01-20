package com.wrc.ziyo.action.rkd;

import java.io.PrintWriter;
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
import com.wrc.ziyo.pojo.Rkdmx;
import com.wrc.ziyo.pojo.Users;
import com.wrc.ziyo.service.rkd.RkdmxService;
import com.wrc.ziyo.util.PageBean;
import com.wrc.ziyo.util.WebUtils;

@Namespace("/rkdmxAction")
@Scope("prototype")
@Controller
@Component("rkdmxAction")
public class RkdMxAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {

	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;
	private HttpServletResponse response;

	@Autowired
	private RkdmxService rkdmxService;
	private Rkdmx rkdmx;
	private PageBean pageBean;

	@Action("getKcBySelect2")
	public void getKcBySelect2() {
		this.response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter out = this.response.getWriter();
			int tp_id = WebUtils.getParam(request, "tp_id", 0);
			List listAss = this.rkdmxService.findByTp_id(tp_id);
			StringBuffer jsonSelect2 = new StringBuffer();
			jsonSelect2.append("[");
			for (int i = 0; i < listAss.size(); i++) {
				Rkdmx rkdmx = (Rkdmx) listAss.get(i);
				if (i != 0)
					jsonSelect2.append(",");
				jsonSelect2.append("{ id: " + rkdmx.getId() + ", text: '"
						+ rkdmx.getProduct().getCpmc() + "※" + rkdmx.getSysl()
						+ "' }");
			}
			jsonSelect2.append("]");
			out.print(jsonSelect2.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Action(value = "list", results = {
			@org.apache.struts2.convention.annotation.Result(name = "success", location = "/jsp/stock/list.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String list() {
		Users user = (Users) this.request.getSession()
				.getAttribute("userLogin");
		if (this.rkdmx == null)
			this.rkdmx = new Rkdmx();

		if (this.pageBean == null)
			pageBean = new PageBean();
		try {
			List listAss = this.rkdmxService.findByCriteria(this.rkdmx,
					pageBean.getStartContent(), pageBean.getContentSize());
			// 获取总数
			pageBean.setContentCount(this.rkdmxService
					.getCountByCriteria(this.rkdmx));
			this.request.setAttribute("listAss", listAss);
			this.request.setAttribute("rkdmx", this.rkdmx);
			this.request.setAttribute("pageBean", this.pageBean);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("产品查询失败");
			this.request.setAttribute("msg", "产品查询失败");
		}
		return "error";
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public RkdmxService getRkdmxService() {
		return rkdmxService;
	}

	public void setRkdmxService(RkdmxService rkdmxService) {
		this.rkdmxService = rkdmxService;
	}

	public Rkdmx getRkdmx() {
		return rkdmx;
	}

	public void setRkdmx(Rkdmx rkdmx) {
		this.rkdmx = rkdmx;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

}
