package com.softtek.academy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.domain.Item;
import com.softtek.academy.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	ItemRepository itemRepository;
	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		return itemRepository.findAll();
	}

}
