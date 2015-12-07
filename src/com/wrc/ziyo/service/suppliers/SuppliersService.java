package com.wrc.ziyo.service.suppliers;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wrc.ziyo.dao.suppliers.SuppliersDao;
import com.wrc.ziyo.pojo.Suppliers;
import com.wrc.ziyo.service.BaseService;

@Service
@Component("suppliersService")
public class SuppliersService extends BaseService<Suppliers> {

	@Autowired
	private SuppliersDao suppliersDao;

	@Override
	public void save(Suppliers t) throws Exception {
		this.suppliersDao.save(t);
	}

	@Override
	public List<Suppliers> findByExample(Suppliers t, int offset, int size)
			throws Exception {
		return this.suppliersDao.findByExample(t, offset, size);
	}

	@Override
	public Suppliers get(Serializable id) throws Exception {
		return this.suppliersDao.get(id);
	}

	@Override
	public void update(Suppliers t) throws Exception {
		this.suppliersDao.update(t);
	}

	@Override
	public List<Suppliers> findAll() throws Exception {
		return this.suppliersDao.findAll();
	}

	public SuppliersDao getSuppliersDao() {
		return suppliersDao;
	}

	public void setSuppliersDao(SuppliersDao suppliersDao) {
		this.suppliersDao = suppliersDao;
	}

}
