package com.sample.elk.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sample.elk.model.User;
import com.sample.elk.services.UserServiceI;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private static final Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	private UserServiceI userService;

	@GetMapping
	public List<User> getAllUsers() {
		logger.info("Requesting to fetch all users");
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		logger.info("Requesting to fetch user by id: {}", id);
		return userService.getUserById(id);
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		logger.info("Requesting to create user: {}", user);
		return userService.createUser(user);
	}

	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		logger.info("Requesting to update user with id {}: {}", id, user);
		return userService.updateUser(id, user);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		logger.info("Requesting to delete user with id: {}", id);
		userService.deleteUser(id);
	}

}
