package com.softtek.academy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.domain.Category;
import com.softtek.academy.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryRepository categoryRepository;
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}
	@Override
	public Category findOne(Long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findOne(id);
	}
	@Override
	public List<Category> findCategoryByItemId(Long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findCategoryByItemId(id);
	}

}
