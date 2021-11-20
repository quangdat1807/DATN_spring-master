package com.example.datn.service;

import com.example.datn.models.User;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class UserSession {
    User user;

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
