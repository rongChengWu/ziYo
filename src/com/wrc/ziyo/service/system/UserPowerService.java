package com.wrc.ziyo.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wrc.ziyo.dao.system.UserPowerDao;
import com.wrc.ziyo.pojo.UserPower;
import com.wrc.ziyo.service.BaseService;

@Service
@Component("userPowerService")
public class UserPowerService extends BaseService<UserPower> {

	@Autowired
	private UserPowerDao userPowerDao;

	public List<UserPower> findAll() throws Exception {
		return this.userPowerDao.findAll();
	}

	public List<UserPower> findByExample(UserPower t) throws Exception {
		return this.userPowerDao.findByExample(t);
	}

	public UserPowerDao getUserPowerDao() {
		return this.userPowerDao;
	}

	public void setUserPowerDao(UserPowerDao userPowerDao) {
		this.userPowerDao = userPowerDao;
	}
}
