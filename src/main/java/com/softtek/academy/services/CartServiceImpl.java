package com.softtek.academy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.softtek.academy.domain.Cart;
import com.softtek.academy.repository.CartRepository;

public class CartServiceImpl implements CartService{

	@Autowired
	CartRepository cartRepository;

	@Override
	public List<Cart> findAll() {
		// TODO Auto-generated method stub
		return cartRepository.findAll();
	}

}
