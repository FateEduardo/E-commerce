package com.softtek.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softtek.academy.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
