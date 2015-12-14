package com.wrc.ziyo.action.order;

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
import com.wrc.ziyo.pojo.Order;
import com.wrc.ziyo.pojo.OrderDetail;
import com.wrc.ziyo.pojo.Rkdmx;
import com.wrc.ziyo.pojo.Users;
import com.wrc.ziyo.service.order.OrderDetailService;
import com.wrc.ziyo.service.order.OrderService;
import com.wrc.ziyo.service.rkd.RkdmxService;
import com.wrc.ziyo.util.WebUtils;

@Namespace("/orderAction")
@Scope("prototype")
@Controller
@Component("orderAction")
public class OrderAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;

	private Order order;
	private OrderDetail orderDetail;

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderDetailService orderDetailService;

	@Autowired
	private RkdmxService rkdmxService;

	@Action(value = "add", results = {
			@org.apache.struts2.convention.annotation.Result(name = "success", location = "/error.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String add() {
		Users user = (Users) this.request.getSession()
				.getAttribute("userLogin");
		this.order.setUser_id(user.getUserId());
		this.order.setLastTime(new Date());
		this.order.setLastUser(user.getUserId());
		try {
			String[] mxxh = WebUtils.getParamValues(request, "mxxh", null);
			if (mxxh != null) {
				for (int i = 0; i < mxxh.length; i++) {
					Rkdmx rkdmx = rkdmxService.get(WebUtils.getParam(request,
							"kc_" + mxxh[i], 0));
					if (rkdmx != null
							&& rkdmx.getSysl()
									- WebUtils.getParam(request,
											"sl" + mxxh[i], 0) >= 0) {
					} else {
						Logger.getLogger("制单失败！");
						this.request
								.setAttribute("msg", "库存不存在，或库存不足请核对后再次填写！");
						return "error";
					}
				}
			}
			this.orderService.save(this.order);

			for (int i = 0; i < mxxh.length; i++) {
				orderDetail = new OrderDetail();
				// 销售单
				orderDetail.setTo_id(order.getId());
				// 产品 ID
				orderDetail.setTp_id(WebUtils.getParam(request, "tpid_"
						+ mxxh[i], 0));
				// 库存 ID
				orderDetail.setKc_id(WebUtils.getParam(request,
						"kc_" + mxxh[i], 0));
				// 销售数量
				orderDetail.setNum(WebUtils
						.getParam(request, "sl" + mxxh[i], 0));
				// 销售单价
				orderDetail.setDj(WebUtils.getParambyFloat(request, "dj"
						+ mxxh[i], 0));
				// 本商品入库 金额
				orderDetail.setJe(WebUtils.getParambyFloat(request, "je"
						+ mxxh[i], 0));
				orderDetail.setBz(WebUtils.getParam(request, "bz" + mxxh[i],
						null));
				this.orderDetailService.save(orderDetail);
				Rkdmx rkdmx = rkdmxService.get(WebUtils.getParam(request, "kc_"
						+ mxxh[i], 0));
				rkdmx.setSysl(rkdmx.getSysl()
						- WebUtils.getParam(request, "sl" + mxxh[i], 0));
				rkdmxService.update(rkdmx);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("制单失败！");
			this.request.setAttribute("msg", "制单失败！");
			return "error";
		}
		this.request.setAttribute("msg", "制单 成功");
		return "success";
	}

	@Action(value = "list", results = {
			@org.apache.struts2.convention.annotation.Result(name = "success", location = "/jsp/order/list.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String list() {
		Users user = (Users) this.request.getSession()
				.getAttribute("userLogin");
		if (this.order == null)
			this.order = new Order();
		this.order.setZhUser(user);
		try {
			List listAss = this.orderService.findByExample(this.order, 0, 20);
			this.request.setAttribute("listAss", listAss);
			this.request.setAttribute("order", this.order);
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
		this.response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public OrderDetailService getOrderDetailService() {
		return orderDetailService;
	}

	public void setOrderDetailService(OrderDetailService orderDetailService) {
		this.orderDetailService = orderDetailService;
	}

	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
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

}
