package com.softtek.academy.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.domain.CartEntity;
import com.softtek.academy.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartRepository cartRepository;

	@Override
	public List<CartEntity> findAll() {
		// TODO Auto-generated method stub
		return cartRepository.findAll();
	}

	@Override
	public CartEntity findOne(Long id) {
		// TODO Auto-generated method stub
		return cartRepository.findOne(id);
	}

	@Override
	public boolean save(CartEntity cart) {
		// TODO Auto-generated method stub
		if(isValid(cart)){
			System.out.println("llego");
			cartRepository.save(cart);
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(CartEntity cart) {
		// TODO Auto-generated method stub
		try{
			cartRepository.delete(cart);
		}catch (EntityNotFoundException e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	@Override
	public boolean isValid(CartEntity cart) {
		// TODO Auto-generated method stub
	
				return true;
	}

	@Override
	public CartEntity findCartByUser(String username) {
		// TODO Auto-generated method stub
		return cartRepository.findCartByUser(username);
	}

}
