package com.softtek.academy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.softtek.academy.domain.CategoryItemEntity;
import com.softtek.academy.domain.CategoryKey;


@Repository
public interface CategoryItemRepository extends JpaRepository<CategoryItemEntity, CategoryKey> {

	@Query(name = "findCategoryItemByItemId", nativeQuery = true)
	List<CategoryItemEntity> findCategoryItemByItem(@Param("item")Long id);
	
	

}
