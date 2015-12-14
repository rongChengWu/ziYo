package com.wrc.ziyo.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wrc.ziyo.dao.order.OrderDetailDao;
import com.wrc.ziyo.pojo.OrderDetail;
import com.wrc.ziyo.service.BaseService;

@Service
@Component("orderDetailService")
public class OrderDetailService extends BaseService<OrderDetail> {

	private OrderDetailDao orderDetailDao;

	public OrderDetailDao getOrderDetailDao() {
		return orderDetailDao;
	}

	@Autowired
	public void setOrderDetailDao(OrderDetailDao orderDetailDao) {
		super.setBaseDao(orderDetailDao);
		this.orderDetailDao = orderDetailDao;
	}

}
