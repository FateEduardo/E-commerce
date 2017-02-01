package com.softtek.academy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.softtek.academy.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	@Query(name = "findCategoryByItemId", nativeQuery = true)
	List<Category>findCategoryByItemId(@Param("id")Long id);
}
