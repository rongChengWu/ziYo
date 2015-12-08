package com.wrc.ziyo.service.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wrc.ziyo.dao.system.UserPowerDao;
import com.wrc.ziyo.pojo.UserPower;
import com.wrc.ziyo.service.BaseService;

@Service
@Component("userPowerService")
public class UserPowerService extends BaseService<UserPower> {

	private UserPowerDao userPowerDao;

	public UserPowerDao getUserPowerDao() {
		return this.userPowerDao;
	}

	@Autowired
	public void setUserPowerDao(UserPowerDao userPowerDao) {
		super.setBaseDao(userPowerDao);
		this.userPowerDao = userPowerDao;
	}
}
