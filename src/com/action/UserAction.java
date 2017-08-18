package com.action;

import com.entity.User;

public class UserAction extends BaseAction {
	private User user;

	public String login() {
		if (this.userService.check(this.user)) {
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
