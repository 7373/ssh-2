package com.service.impl;

import com.dao.UserDao;
import com.entity.User;
import com.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean check(User user) {
		if (this.userDao.check(user)) {
			return true;
		} else {
			return false;
		}
	}
}
