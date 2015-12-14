package com.wrc.ziyo.dao.order;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.wrc.ziyo.dao.BaseDao;
import com.wrc.ziyo.pojo.OrderDetail;

@Repository
@Component("orderDetailDao")
public class OrderDetailDao extends BaseDao<OrderDetail> {

}
