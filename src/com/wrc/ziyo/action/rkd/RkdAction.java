package com.wrc.ziyo.action.rkd;

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
import com.wrc.ziyo.pojo.Rkd;
import com.wrc.ziyo.pojo.Rkdmx;
import com.wrc.ziyo.pojo.Users;
import com.wrc.ziyo.service.rkd.RkdService;
import com.wrc.ziyo.service.rkd.RkdmxService;
import com.wrc.ziyo.util.WebUtils;

@Namespace("/rkdAction")
@Scope("prototype")
@Controller
@Component("rkdAction")
public class RkdAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {

	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;
	private HttpServletResponse response;

	@Autowired
	private RkdService rkdService;
	private Rkd rkd;
	@Autowired
	private RkdmxService rkdmxService;
	private Rkdmx rkdmx;

	@Action(value = "add", results = {
			@org.apache.struts2.convention.annotation.Result(name = "success", location = "/error.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String add() {
		Users user = (Users) this.request.getSession()
				.getAttribute("userLogin");
		this.rkd.setUserid(user.getUserId());
		this.rkd.setLastTime(new Date());
		try {
			this.rkdService.save(this.rkd);
			String[] mxxh = WebUtils.getParamValues(request, "mxxh", null);
			if (mxxh != null) {
				for (int i = 0; i < mxxh.length; i++) {
					rkdmx = new Rkdmx();
					// 入库单
					rkdmx.setRkdid(rkd.getId());
					// 产品 ID
					rkdmx.setTpid(WebUtils.getParam(request, "tpid_" + mxxh[i],
							0));
					// 生产批号
					rkdmx.setScph(WebUtils.getParam(request, "scph" + mxxh[i],
							null));
					// 入库数量
					rkdmx.setRksl(WebUtils.getParam(request, "sl" + mxxh[i], 0));
					// 入库单价
					rkdmx.setRkdj(WebUtils.getParambyFloat(request, "dj"
							+ mxxh[i], 0));
					// 本商品入库 金额
					rkdmx.setJe(WebUtils.getParambyFloat(request, "je"
							+ mxxh[i], 0));
					// 生产日期
					rkdmx.setScrq(WebUtils.getParambyDate(request, "scrp"
							+ mxxh[i], new Date(), "yyyy-MM-dd"));
					// 有效期
					rkdmx.setYxq(WebUtils.getParambyDate(request, "yxq"
							+ mxxh[i], new Date(), "yyyy-MM-dd"));
					rkdmx.setBz(WebUtils
							.getParam(request, "bz" + mxxh[i], null));
					this.rkdmxService.save(rkdmx);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("入库失败！");
			this.request.setAttribute("msg", "入库失败！");
			return "error";
		}
		this.request.setAttribute("msg", "入库 成功");
		return "success";
	}

	@Action(value = "list", results = {
			@org.apache.struts2.convention.annotation.Result(name = "success", location = "/jsp/rkd/list.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String list() {
		Users user = (Users) this.request.getSession()
				.getAttribute("userLogin");
		if (this.rkd == null)
			this.rkd = new Rkd();
		this.rkd.setUser(user);
		try {
			List listAss = this.rkdService.findByExample(this.rkd, 0, 20);
			this.request.setAttribute("listAss", listAss);
			this.request.setAttribute("rkd", this.rkd);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("产品查询失败");
			this.request.setAttribute("msg", "产品查询失败");
		}
		return "error";
	}

	@Action(value = "getById", results = {
			@org.apache.struts2.convention.annotation.Result(name = "update", location = "/jsp/rkd/update.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "detail", location = "/jsp/rkd/detail.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String getById() {
		int id = Integer.parseInt(this.request.getParameter("id"));
		String returnType = this.request.getParameter("returnType");
		try {
			this.rkd = this.rkdService.get(Integer.valueOf(id));
			this.request.setAttribute("rkd", this.rkd);
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
		this.rkd.setUserid(user.getUserId());
		this.rkd.setLastTime(new Date());
		try {
			this.rkdService.update(this.rkd);
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("产品修改失败！");
			this.request.setAttribute("msg", "产品修改失败！");
			return "error";
		}
		this.request.setAttribute("msg", "产品修改成功");
		return "success";
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

	public RkdService getRkdService() {
		return rkdService;
	}

	public void setRkdService(RkdService rkdService) {
		this.rkdService = rkdService;
	}

	public Rkd getRkd() {
		return rkd;
	}

	public void setRkd(Rkd rkd) {
		this.rkd = rkd;
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

}
