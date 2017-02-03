package com.softtek.academy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.softtek.academy.domain.ItemOrderEntity;


@Repository
public interface ItemOrderRepository extends JpaRepository<ItemOrderEntity, Long> {

	@Query(value="SELECT io  FROM ItemOrderEntity io INNER JOIN io.item_id item WHERE item.id =:id")
	ItemOrderEntity findOneItemOrderByItem(@Param("id")Long id);
	@Query(value="SELECT io  FROM ItemOrderEntity io INNER JOIN io.cart cart INNER JOIN cart.user user  WHERE user.username =:username")
	List<ItemOrderEntity> findItemOrderByUser(@Param("username")String username);
	
}
