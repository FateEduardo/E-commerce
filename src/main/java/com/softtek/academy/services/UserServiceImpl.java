package com.softtek.academy.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

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
	public List<String> listStatus(){
		List<String>status=new ArrayList<String>();
		status.add("S");
		status.add("N");
		return status;
		
	}
	@Override
	public User findOne(String username) {
		// TODO Auto-generated method stub
		User user;
		try{
			 user=userRepository.findOne(username);
		}catch(EntityNotFoundException ex){
			return null;
		}
		
		return user;
	}

	@Override
	public boolean save(User user) {
		// TODO Auto-generated method stub
		if(isValid(user)){
		
				userRepository.save(user);
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

	@Override
	public boolean delete(User user) {
		// TODO Auto-generated method stub
		try{
			userRepository.delete(user);
		}catch(Exception ex){
			return false;
		}
		return true;
	}

}
