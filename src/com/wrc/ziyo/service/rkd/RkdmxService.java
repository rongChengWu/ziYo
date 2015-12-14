package com.wrc.ziyo.service.rkd;

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

	private RkdmxDao rkdmxDao;

	public RkdmxDao getRkdmxDao() {
		return rkdmxDao;
	}

	public List findByTp_id(int tp_id) throws Exception {
		String where = " where tp_id=? and sysl>0 order by id";
		return rkdmxDao.findByHqlWher(where, tp_id);
	}

	@Autowired
	public void setRkdmxDao(RkdmxDao rkdmxDao) {
		super.setBaseDao(rkdmxDao);
		this.rkdmxDao = rkdmxDao;
	}

}
