package com.wrc.ziyo.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wrc.ziyo.dao.order.OrderDao;
import com.wrc.ziyo.pojo.Order;
import com.wrc.ziyo.service.BaseService;

@Service
@Component("orderService")
public class OrderService extends BaseService<Order> {

	private OrderDao orderDao;

	public OrderDao getOrderDao() {
		return orderDao;
	}

	@Autowired
	public void setOrderDao(OrderDao orderDao) {
		super.setBaseDao(orderDao);
		this.orderDao = orderDao;
	}

}
