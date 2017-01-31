package com.softtek.academy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.domain.User;
import com.softtek.academy.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findOne(String username) {
		// TODO Auto-generated method stub
		User user=userRepository.findOne(username);
		return user;
	}

	@Override
	public boolean save(User user) {
		// TODO Auto-generated method stub
		if(isValid(user)){
			return true;
		}
		return false;
	}

	@Override
	public boolean isValid(User user) {
		// TODO Auto-generated method stub
		if(user.getUsername()==null || user.getUsername().isEmpty()){
			return false;
		}
		if(user.getName()==null||user.getName().isEmpty()){
			return false;
		}
		if(user.getPassword()==null||user.getPassword().isEmpty()){
			return false;
		}
		if(user.getStatus()==null){
			return false;
		}
		if(user.getRole()==null){
			if(user.getRole().getDescription()==null||user.getRole().getDescription().isEmpty()){
				return false;
			}
			if(user.getRole().getId()==null||user.getRole().getId().isEmpty()){
				return false;
			}
		}
		return true;
	}

}
