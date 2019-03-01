package com.user.service.userservice.infrastructure.database.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.service.userservice.infrastructure.database.jpa.entity.UserEntity;

@Repository
public interface UserSpringData extends CrudRepository<UserEntity, String> {

}
