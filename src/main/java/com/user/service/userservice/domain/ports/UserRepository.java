package com.user.service.userservice.domain.ports;

import java.util.Optional;

import com.user.service.userservice.domain.model.User;

public interface UserRepository {
	
	public User addUser(User user);
	
	public Optional<User> getUser(String userName);

}
