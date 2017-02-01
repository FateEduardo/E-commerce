package com.softtek.academy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.domain.UserRole;
import com.softtek.academy.repository.UserRoleRepository;

 @Service
public class UserRoleServiceImpl implements UserRoleService{

	@Autowired
	UserRoleRepository userRoleRepository;
	
	@Override
	public List<UserRole> findAll() {
		// TODO Auto-generated method stub
		return userRoleRepository.findAll();
	}

	@Override
	public UserRole findOne(String id) {
		// TODO Auto-generated method stub
		return userRoleRepository.findOne(id);
	}
	

}
