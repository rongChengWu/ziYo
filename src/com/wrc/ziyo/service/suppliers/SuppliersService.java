package com.wrc.ziyo.service.suppliers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wrc.ziyo.dao.suppliers.SuppliersDao;
import com.wrc.ziyo.pojo.Suppliers;
import com.wrc.ziyo.service.BaseService;

@Service
@Component("suppliersService")
public class SuppliersService extends BaseService<Suppliers> {

	private SuppliersDao suppliersDao;

	public SuppliersDao getSuppliersDao() {
		return suppliersDao;
	}

	@Autowired
	public void setSuppliersDao(SuppliersDao suppliersDao) {
		super.setBaseDao(suppliersDao);
		this.suppliersDao = suppliersDao;
	}

}
