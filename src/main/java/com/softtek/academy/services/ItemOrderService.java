package com.softtek.academy.services;

import java.util.List;

import com.softtek.academy.domain.ItemOrderEntity;

public interface ItemOrderService {

	List<ItemOrderEntity>findAll();
	ItemOrderEntity findOne(Long id);
	boolean save(ItemOrderEntity order);
	boolean delete(ItemOrderEntity order);
	boolean isValid(ItemOrderEntity order);
	ItemOrderEntity findOneItemOrderByItem(Long id);
	List<ItemOrderEntity> findItemOrderByUser(String username);
	Long count();
}
