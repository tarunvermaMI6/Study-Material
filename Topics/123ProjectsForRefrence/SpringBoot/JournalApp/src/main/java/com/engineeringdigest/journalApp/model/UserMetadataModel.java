package com.engineeringdigest.journalApp.model;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.engineeringdigest.journalApp.entity.User;

import lombok.Data;

@Data
public class UserMetadataModel {

	List<User> userList;

	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public UserMetadataModel() {

		User user1 = User.builder().id(1).userName("tarun").password(passwordEncoder.encode("tarun123")).roles("Admin")
				.build();
		User user2 = User.builder().id(1).userName("tarun1").password(passwordEncoder.encode("tarun123")).roles("Admin")
				.build();

		userList.add(user1);
		userList.add(user2);
	}
}
