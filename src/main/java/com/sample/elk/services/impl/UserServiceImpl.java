package com.sample.elk.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.stereotype.Service;

import com.sample.elk.model.User;
import com.sample.elk.services.UserServiceI;

@Service
public class UserServiceImpl implements UserServiceI {

	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

	private List<User> users = new ArrayList<>();

	public UserServiceImpl() {
		logger.debug("Add some default users");
		users.add(new User(1L, "john_doe", "john@example.com"));
		users.add(new User(2L, "jane_smith", "jane@example.com"));
	}

	@Override
	public List<User> getAllUsers() {
		logger.info("Fetching all users");
		return users;
	}

	@Override
	public User getUserById(Long id) {
		logger.info("Fetching user by id: {}", id);
		return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
	}

	@Override
	public User createUser(User user) {
		logger.info("Creating user: {}", user);
		users.add(user);
		return user;
	}

	@Override
	public User updateUser(Long id, User user) {
		logger.info("Updating user with id: {}, new user: {}", id, user);
		User existingUser = getUserById(id);
		if (existingUser != null) {
			existingUser.setUsername(user.getUsername());
			existingUser.setEmail(user.getEmail());
		}
		return existingUser;
	}

	@Override
	public void deleteUser(Long id) {
		logger.info("Deleting user with id: {}", id);
		users.removeIf(user -> user.getId().equals(id));
	}
}
