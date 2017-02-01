package com.softtek.academy.services;

import java.util.List;

import com.softtek.academy.domain.UserRole;
	
public interface UserRoleService {
	List<UserRole> findAll();
	UserRole findOne(String id);
}
