package com.softtek.academy.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.domain.ItemOrderEntity;
import com.softtek.academy.repository.ItemOrderRepository;

@Service
public class ItemOrderServiceImpl implements ItemOrderService{
	@Autowired
	ItemOrderRepository itemOrderRepository;
	@Override
	public List<ItemOrderEntity> findAll() {
		// TODO Auto-generated method stub
		return itemOrderRepository.findAll();
	}
	@Override
	public ItemOrderEntity findOne(final Long id) {
		// TODO Auto-generated method stub
		return itemOrderRepository.findOne(id);
	}
	@Override
	public boolean save(final ItemOrderEntity order) {
		// TODO Auto-generated method stub
		if(isValid(order)){
			itemOrderRepository.save(order);
			return false;
		}
		return true;
	}
	@Override
	public boolean delete(final ItemOrderEntity order) {
		// TODO Auto-generated method stub
		
		try{
			itemOrderRepository.delete(order);
			return true;
		}catch (EntityNotFoundException e) {
			// TODO: handle exception
			return false;
		}
	
	}
	@Override
	public boolean isValid(final ItemOrderEntity order) {
		// TODO Auto-generated method stub
		if(order.getCart()!=null){
			return false;
		}
		if(order.getItem()!=null){
			return false;
		}
		return true;
	}
	@Override
	public ItemOrderEntity findOneItemOrderByItem(final Long id) {
		// TODO Auto-generated method stub
		return itemOrderRepository.findOneItemOrderByItem(id);
	}
	@Override
	public List<ItemOrderEntity> findItemOrderByUser(final String username ) {
		// TODO Auto-generated method stub
		return itemOrderRepository.findItemOrderByUser(username);
	}
	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return itemOrderRepository.count();
	}

}
