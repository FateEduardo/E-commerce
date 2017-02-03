package com.softtek.academy.services;

import java.util.List;

import com.softtek.academy.domain.UserRoleEntity;
	
public interface UserRoleService {
	List<UserRoleEntity> findAll();
	UserRoleEntity findOne(String id);
}
