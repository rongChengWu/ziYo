package com.wrc.ziyo.service.rkd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wrc.ziyo.dao.rkd.RkdDao;
import com.wrc.ziyo.pojo.Rkd;
import com.wrc.ziyo.service.BaseService;

@Service
@Component("rkdService")
public class RkdService extends BaseService<Rkd> {

	private RkdDao rkdDao;

	public RkdDao getrkdDao() {
		return rkdDao;
	}

	@Autowired
	public void setrkdDao(RkdDao rkdDao) {
		super.setBaseDao(rkdDao);
		this.rkdDao = rkdDao;
	}
}
