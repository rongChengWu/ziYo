package com.wrc.ziyo.service.rkd;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wrc.ziyo.dao.rkd.RkdmxDao;
import com.wrc.ziyo.pojo.Rkdmx;
import com.wrc.ziyo.service.BaseService;

@Service
@Component("rkdmxService")
public class RkdmxService extends BaseService<Rkdmx> {

	@Autowired
	private RkdmxDao rkdmxDao;

	@Override
	public void save(Rkdmx t) throws Exception {
		rkdmxDao.save(t);
	}

	@Override
	public List<Rkdmx> findByExample(Rkdmx t, int offset, int size)
			throws Exception {
		return this.rkdmxDao.findByExample(t, offset, size);
	}

	@Override
	public Rkdmx get(Serializable id) throws Exception {
		return this.rkdmxDao.get(id);
	}

	@Override
	public void update(Rkdmx t) throws Exception {
		this.rkdmxDao.update(t);
	}

	public RkdmxDao getRkdmxDao() {
		return rkdmxDao;
	}

	public void setRkdmxDao(RkdmxDao rkdmxDao) {
		this.rkdmxDao = rkdmxDao;
	}

}
