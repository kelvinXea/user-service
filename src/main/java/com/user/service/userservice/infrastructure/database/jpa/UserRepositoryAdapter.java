package com.user.service.userservice.infrastructure.database.jpa;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.user.service.userservice.domain.model.User;
import com.user.service.userservice.domain.ports.UserRepository;
import com.user.service.userservice.infrastructure.database.jpa.entity.UserEntity;

@Component
public class UserRepositoryAdapter implements UserRepository {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserSpringData userSpringData;

	@Override
	public User addUser(User user) {
		UserEntity userE = modelMapper.map(user, UserEntity.class);
		UserEntity userEn = userSpringData.save(userE);
		return modelMapper.map(userEn, User.class);
	}

	@Override
	public Optional<User> getUser(String userName) {
		Optional<UserEntity> userE = userSpringData.findById(userName);
		return userE.isPresent() ? Optional.of(modelMapper.map(userE.get(), User.class)) : Optional.empty();
	}

}
