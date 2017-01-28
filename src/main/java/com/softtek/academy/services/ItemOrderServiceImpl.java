package com.softtek.academy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.domain.ItemOrder;
import com.softtek.academy.repository.ItemOrderRepository;

@Service
public class ItemOrderServiceImpl implements ItemOrderService{
	@Autowired
	ItemOrderRepository itemOrderRepository;
	@Override
	public List<ItemOrder> findAll() {
		// TODO Auto-generated method stub
		return itemOrderRepository.findAll();
	}

}
