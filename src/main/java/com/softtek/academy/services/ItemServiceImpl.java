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
	@Override
	public Item findOne(Long id) {
		// TODO Auto-generated method stub
		return itemRepository.findOne(id);
	}
	@Override
	public boolean save(Item item) {
		// TODO Auto-generated method stub
		if(isValid(item)){
			itemRepository.save(item);
		}
		return true;
	}
	@Override
	public boolean isValid(Item item) {
		if(item.getId()==null){
			return false;
		}
		if(item.getDescription()==null || item.getDescription().isEmpty()){
			return false;
		}
		if(item.getFeatures()==null||item.getFeatures().isEmpty()){
			return false;
		}
		if(item.getActive()==null){
			return false;
		}
		if(item.getPrice()==null){
			return false;
		}
		if(item.getStock()==null){
			return false;
		}
		return true;
	}


}
