package com.softtek.academy.services;

import java.util.List;

import com.softtek.academy.domain.CategoryEntity;

public interface CategoryService {
	List<CategoryEntity> findAll();
	CategoryEntity findOne(Long id);
	List<CategoryEntity>findCategoryByItemId(Long id);
}
