package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;

@SuppressWarnings("serial")
public class BaseAction extends ActionSupport {
	// BaseAction中定义service接口，所有Action继承该父类 ，不用每个Action中都得引入了
	protected UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
