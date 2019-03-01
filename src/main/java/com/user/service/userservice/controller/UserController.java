package com.user.service.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.user.service.userservice.domain.model.User;
import com.user.service.userservice.domain.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public User getUser(@RequestBody User user) {
		return userService.getUser(user);
	}
	
	@PostMapping("/signup")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
		
	}

}
