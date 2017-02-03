package com.softtek.academy.services;

import java.util.List;

import com.softtek.academy.domain.ItemEntity;

public interface ItemService {
	List<ItemEntity>findAll();
	ItemEntity findOne(Long id);
	boolean save(ItemEntity item);
	boolean isValid(ItemEntity item);
	boolean delete(ItemEntity item);
	List<ItemEntity>findItemByCategory(String description);

}
