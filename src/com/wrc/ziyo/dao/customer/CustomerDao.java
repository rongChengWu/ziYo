package com.wrc.ziyo.dao.customer;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.wrc.ziyo.dao.BaseDao;
import com.wrc.ziyo.pojo.Customer;

@Repository
@Component("customerDao")
public class CustomerDao extends BaseDao<Customer> {

}
