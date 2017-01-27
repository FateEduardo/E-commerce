package com.softtek.academy.services;

import java.util.List;

import com.softtek.academy.domain.Cart;

public interface CartService {
	List<Cart> findAll();
}
