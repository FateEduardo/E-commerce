package com.softtek.academy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.domain.CategoryEntity;
import com.softtek.academy.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryRepository categoryRepository;
	@Override
	public List<CategoryEntity> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}
	@Override
	public CategoryEntity findOne(Long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findOne(id);
	}
	@Override
	public List<CategoryEntity> findCategoryByItemId(Long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findCategoryByItemId(id);
	}

}
