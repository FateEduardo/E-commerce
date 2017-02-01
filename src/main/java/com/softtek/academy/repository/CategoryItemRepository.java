package com.softtek.academy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.softtek.academy.domain.CategoryItem;
import com.softtek.academy.domain.CategoryKey;
import com.softtek.academy.domain.Item;


@Repository
public interface CategoryItemRepository extends JpaRepository<CategoryItem, CategoryKey> {

	@Query(name = "findCategoryItemByItemId", nativeQuery = true)
	List<CategoryItem> findCategoryItemByItem(@Param("item")Long id);
	
	@Query(name="deleteCategoryItem",nativeQuery=true)
	boolean deleteCategoryItem(@Param("id")Long id);

}
