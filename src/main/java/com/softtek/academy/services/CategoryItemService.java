package com.softtek.academy.services;

import java.util.List;

import com.softtek.academy.domain.CategoryItemEntity;
import com.softtek.academy.domain.CategoryKey;

public interface CategoryItemService {
	List<CategoryItemEntity> findCategoryItemByItem(Long id);
	boolean delete(CategoryKey key);
	List<CategoryItemEntity>findAll();
	boolean save(CategoryItemEntity categoryItem);
	boolean isValid(CategoryItemEntity categoryItem);
}
