package com.softtek.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.softtek.academy.domain.CartEntity;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long>{

	@Query(value="SELECT c FROM CartEntity c INNER JOIN c.user u WHERE u.username = :username")
	CartEntity findCartByUser(@Param("username")String username);
}
