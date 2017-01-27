package com.softtek.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softtek.academy.domain.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

}
