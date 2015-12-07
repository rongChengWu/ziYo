package com.wrc.ziyo.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wrc.ziyo.dao.customer.CustomerDao;
import com.wrc.ziyo.pojo.Customer;
import com.wrc.ziyo.service.BaseService;

@Service
@Component("customerService")
public class CustomerService extends BaseService<Customer> {

	private CustomerDao customerDao;

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	@Autowired
	public void setCustomerDao(CustomerDao customerDao) {
		super.setBaseDao(customerDao);
		this.customerDao = customerDao;
	}

}
