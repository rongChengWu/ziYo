package com.wrc.ziyo.service.rkd;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wrc.ziyo.dao.rkd.RkdDao;
import com.wrc.ziyo.pojo.Rkd;
import com.wrc.ziyo.service.BaseService;

@Service
@Component("rkdService")
public class RkdService extends BaseService<Rkd> {
	@Autowired
	private RkdDao rkdDao;

	@Override
	public void save(Rkd t) throws Exception {
		this.rkdDao.save(t);
	}

	@Override
	public List<Rkd> findByExample(Rkd t, int offset, int size)
			throws Exception {
		return this.rkdDao.findByExample(t, offset, size);
	}

	@Override
	public Rkd get(Serializable id) throws Exception {
		return this.rkdDao.get(id);
	}

	@Override
	public void update(Rkd t) throws Exception {
		this.rkdDao.update(t);
	}

	public RkdDao getrkdDao() {
		return rkdDao;
	}

	public void setrkdDao(RkdDao rkdDao) {
		this.rkdDao = rkdDao;
	}
}
