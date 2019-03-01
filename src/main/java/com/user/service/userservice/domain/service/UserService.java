package com.user.service.userservice.domain.service;

import com.user.service.userservice.domain.exception.UserException;
import com.user.service.userservice.domain.model.User;
import com.user.service.userservice.domain.ports.UserRepository;

public class UserService {
	
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User addUser(User user) {
		return userRepository.addUser(user);
	}
	
	public User getUser(User user) {
		
		User userN = userRepository.getUser(user.getUsername()).orElseThrow(() -> new UserException("El usuario no existe"));
		if(user.getPassword().equals(userN.getPassword())) {
			return userN;
		}else {
			throw new UserException("La contraseña es incorrecta");
		}
		
	}

}
