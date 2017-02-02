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


	@Override
	public boolean delete(CategoryKey key) {
		// TODO Auto-generated method stub
		categoryItemRepository.delete(key);
		return true;
	}


	@Override
	public List<CategoryItem> findAll() {
		// TODO Auto-generated method stub
		return categoryItemRepository.findAll();
	}


	@Override
	public boolean save(CategoryItem categoryItem) {
		// TODO Auto-generated method stub
		if(isValid(categoryItem)){
			categoryItemRepository.save(categoryItem);
			return true;
		}
		return false;
	}


	@Override
	public boolean isValid(CategoryItem categoryItem) {
		// TODO Auto-generated method stub
		if(categoryItem.getId()==null){
			return false;
		}
		if(categoryItem.getId().getId()==null){
			if(categoryItem.getId().getId().getId()==null){
				return false;
			}
		}
		if(categoryItem.getId().getItem()==null){
			if(categoryItem.getId().getItem().getId()==null){
				return false;
			}
		}
		return true;
	}




}
