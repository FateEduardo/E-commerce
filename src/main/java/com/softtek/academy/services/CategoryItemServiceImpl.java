package com.softtek.academy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.domain.CategoryItem;
import com.softtek.academy.domain.CategoryKey;
import com.softtek.academy.repository.CategoryItemRepository;

@Service
public class CategoryItemServiceImpl implements CategoryItemService{
	
	@Autowired
	CategoryItemRepository categoryItemRepository;

	
	@Override
	public List<CategoryItem> findCategoryItemByItem(Long id) {
		// TODO Auto-generated method stub
		return categoryItemRepository.findCategoryItemByItem(id);
	}


	@Override
	public boolean deleteCategoryItem(Long id) {
		// TODO Auto-generated method stub
		categoryItemRepository.deleteCategoryItem(id);
		return true;
	}




}
