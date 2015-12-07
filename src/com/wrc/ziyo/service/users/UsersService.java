package com.wrc.ziyo.service.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wrc.ziyo.dao.users.UsersDao;
import com.wrc.ziyo.pojo.Users;
import com.wrc.ziyo.service.BaseService;

@Service
@Component("usersService")
public class UsersService extends BaseService<Users> {
	private UsersDao usersDao;

	public Users findUser(Users users) throws Exception {
		/* 21 */List usersList = this.usersDao.findByExample(users);
		/* 22 */if ((usersList != null) && (!usersList.isEmpty()))
			/* 23 */users = (Users) usersList.get(0);
		else {
			/* 25 */return null;
		}
		/* 27 */return users;
	}

	public UsersDao getUsersDao() {
		/* 31 */return this.usersDao;
	}

	@Autowired
	public void setUsersDao(UsersDao usersDao) {
		/* 36 */super.setBaseDao(usersDao);
		/* 37 */this.usersDao = usersDao;
	}

}

/*
 * Location: C:\Users\asus\Desktop\sshFrame\WebContent\WEB-INF\classes\
 * Qualified Name: com.wrc.sshFrame.service.users.UsersService JD-Core Version:
 * 0.6.0
 */