package com.wrc.ziyo.service.util;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wrc.ziyo.dao.util.UtilDictDao;
import com.wrc.ziyo.pojo.UtilDict;
import com.wrc.ziyo.service.BaseService;

@Service
@Component("utilDictService")
public class UtilDictService extends BaseService<UtilDict> {

	@Autowired
	private UtilDictDao utilDictDao;

	@Override
	public void save(UtilDict t) throws Exception {
		utilDictDao.save(t);
	}

	@Override
	public List<UtilDict> findByExample(UtilDict t, int offset, int size)
			throws Exception {
		// TODO Auto-generated method stub
		return utilDictDao.findByExample(t, offset, size);
	}

	@Override
	public UtilDict get(Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return utilDictDao.get(id);
	}

	public UtilDictDao getUtilDictDao() {
		return utilDictDao;
	}

	public void setUtilDictDao(UtilDictDao utilDictDao) {
		this.utilDictDao = utilDictDao;
	}

}
