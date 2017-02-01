package com.softtek.academy.services;

import java.util.List;

import com.softtek.academy.domain.Category;

public interface CategoryService {
	List<Category> findAll();
	Category findOne(Long id);
}
