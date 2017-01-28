package com.softtek.academy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.domain.CategoryItem;
import com.softtek.academy.repository.CategoryItemRepository;

@Service
public class CategoryItemServiceImpl implements CategoryItemService{
	
	@Autowired
	CategoryItemRepository categoryRepository;

	@Override
	public List<CategoryItem> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

}
