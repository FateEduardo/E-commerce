package com.softtek.academy.test.integration.services;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.softtek.academy.domain.Category;
import com.softtek.academy.services.CategoryService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(inheritLocations = true)
@DatabaseSetup(value={"/dataset/category.xml"}, type=DatabaseOperation.CLEAN_INSERT)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
	TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
public class CategoryServiceImplTest {

	@Autowired
	CategoryService categoryService;

	@Test
	@DatabaseSetup(value="/dataset/category.xml", type=DatabaseOperation.CLEAN_INSERT)
	public void testCategoryList() {
		List<Category> categories=categoryService.findAll();
		Assert.assertNotNull(categories);
	}
	
	@Test
	@DatabaseSetup(value="/dataset/category.xml", type=DatabaseOperation.CLEAN_INSERT)
	public void testCategoryFindOneById(){
		Category category=categoryService.findOne(1l);
		Assert.assertTrue(category.getDescription().equals("shoes"));
	}

}
