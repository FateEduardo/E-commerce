package com.softtek.academy.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.domain.ItemEntity;
import com.softtek.academy.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	ItemRepository itemRepository;
	@Override
	public List<ItemEntity> findAll() {
		// TODO Auto-generated method stub
		return itemRepository.findAll();
	}
	@Override
	public ItemEntity findOne(Long id) {
		// TODO Auto-generated method stub
		ItemEntity item;
		try{
			item= itemRepository.findOne(id);
		}catch (EntityNotFoundException e) {
			// TODO: handle exception
			item=null;
		}
		return item;
	}
	@Override
	public boolean save(ItemEntity item) {
		// TODO Auto-generated method stub
		if(isValid(item)){
			itemRepository.save(item);
		}
		return true;
	}
	@Override
	public boolean isValid(ItemEntity item) {

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
	@Override
	public boolean delete(ItemEntity item) {
		// TODO Auto-generated method stub
		try{
			itemRepository.delete(item);
		}catch (EntityNotFoundException e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}
	@Override
	public List<ItemEntity> findItemByCategory(String description) {
		// TODO Auto-generated method stub
		return itemRepository.findItemByCategory(description);
		
	}


}
