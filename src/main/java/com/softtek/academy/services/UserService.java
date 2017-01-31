package com.softtek.academy.services;

import java.util.List;

import com.softtek.academy.domain.User;

public interface UserService {
	
	List<User> findAll();
	User findOne(String username);
	boolean save(User user);
	boolean isValid(User user);
}
