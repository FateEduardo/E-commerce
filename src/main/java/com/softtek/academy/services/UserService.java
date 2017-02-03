package com.softtek.academy.services;

import java.util.List;

import com.softtek.academy.domain.UserEntity;

public interface UserService {
	
	List<UserEntity> findAll();
	UserEntity findOne(String username);
	boolean save(UserEntity user);
	boolean isValid(UserEntity user);
	boolean delete(UserEntity user);
	List<String>listStatus();
}
