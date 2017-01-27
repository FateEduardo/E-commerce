package com.softtek.academy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.softtek.academy.domain.UserRole;
import com.softtek.academy.repository.UserRoleRepository;

public class UserRoleServiceImpl implements UserRoleService{

	@Autowired
	UserRoleRepository userRoleRepository;
	
	@Override
	public List<UserRole> findAll() {
		// TODO Auto-generated method stub
		return userRoleRepository.findAll();
	}

}
