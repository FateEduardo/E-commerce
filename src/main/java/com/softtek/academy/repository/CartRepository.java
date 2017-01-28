package com.softtek.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softtek.academy.domain.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{

}