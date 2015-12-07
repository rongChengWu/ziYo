package com.wrc.ziyo.service.util;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wrc.ziyo.dao.util.UtilDictDetailsDao;
import com.wrc.ziyo.pojo.UtilDictDetails;
import com.wrc.ziyo.service.BaseService;

@Service
@Component("utilDictDetailsService")
public class UtilDictDetailsService extends BaseService<UtilDictDetails> {

	@Autowired
	private UtilDictDetailsDao utilDictDetailsDao;

	@Override
	public void save(UtilDictDetails t) throws Exception {
		// TODO Auto-generated method stub
		utilDictDetailsDao.save(t);
	}

	@Override
	public List<UtilDictDetails> findByExample(UtilDictDetails t, int offset,
			int size) throws Exception {
		// TODO Auto-generated method stub
		return utilDictDetailsDao.findByExample(t, offset, size);
	}

	@Override
	public UtilDictDetails get(Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return utilDictDetailsDao.get(id);
	}

	public UtilDictDetailsDao getUtilDictDetailsDao() {
		return utilDictDetailsDao;
	}

	public void setUtilDictDetailsDao(UtilDictDetailsDao utilDictDetailsDao) {
		this.utilDictDetailsDao = utilDictDetailsDao;
	}

}
