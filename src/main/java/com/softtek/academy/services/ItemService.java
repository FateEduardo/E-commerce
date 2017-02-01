package com.softtek.academy.services;

import java.util.List;

import com.softtek.academy.domain.Item;

public interface ItemService {
	List<Item>findAll();
	Item findOne(Long id);
	boolean save(Item item);
	boolean isValid(Item item);
	boolean delete(Item item);

}
