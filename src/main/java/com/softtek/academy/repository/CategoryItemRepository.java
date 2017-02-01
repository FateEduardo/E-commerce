package com.softtek.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softtek.academy.domain.CategoryItem;
import com.softtek.academy.domain.CategoryKey;


@Repository
public interface CategoryItemRepository extends JpaRepository<CategoryItem, CategoryKey> {

	
}
