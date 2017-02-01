package com.softtek.academy.services;

import java.util.List;

import com.softtek.academy.domain.CategoryItem;
import com.softtek.academy.domain.CategoryKey;

public interface CategoryItemService {
	List<CategoryItem> findCategoryItemByItem(Long id);
	boolean deleteCategoryItem(Long id);
	
}
