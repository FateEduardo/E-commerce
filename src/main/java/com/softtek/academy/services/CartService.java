package com.softtek.academy.services;

import java.util.List;

import com.softtek.academy.domain.CartEntity;

public interface CartService {
	List<CartEntity> findAll();
	CartEntity findOne(Long id);
	boolean save(CartEntity cart);
	boolean delete(CartEntity cart);
	boolean isValid(CartEntity cart);
	CartEntity findCartByUser(String username);
}
