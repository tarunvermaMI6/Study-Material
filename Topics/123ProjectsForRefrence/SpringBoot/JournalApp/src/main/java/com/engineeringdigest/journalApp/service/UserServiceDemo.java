package com.engineeringdigest.journalApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.engineeringdigest.journalApp.entity.User;
import com.engineeringdigest.journalApp.entity.User.UserBuilder;

@Service
public class UserServiceDemo {

	public List<User> getUserAll() {

		List<User> users = new ArrayList<>();
		User use = User.builder().userName("tarun").password("1234").build();
		users.add(use);

		return users;
	}
}
