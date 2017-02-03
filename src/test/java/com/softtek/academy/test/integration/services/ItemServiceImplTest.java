package com.softtek.academy.test.integration.services;

import java.util.List;

import org.junit.Ignore;
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
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.softtek.academy.domain.ItemEntity;
import com.softtek.academy.services.ItemService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(inheritLocations = true)
@DatabaseSetup(value={"/dataset/item.xml"}, type=DatabaseOperation.CLEAN_INSERT)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
	TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
public class ItemServiceImplTest {
	@Autowired
	ItemService itemService;
	@Ignore
	@Test
	@DatabaseSetup(value="/dataset/item.xml", type=DatabaseOperation.CLEAN_INSERT)
	public void testItemListNotNull() {
		List<ItemEntity> items=itemService.findAll();
		Assert.assertNotNull(items);
	}
	@Ignore
	@Test
	@DatabaseSetup(value="/dataset/item.xml", type=DatabaseOperation.CLEAN_INSERT)
	public void testItemFindOneById() {
		ItemEntity item=itemService.findOne(1L);
		Assert.assertTrue(item.getFeatures().equals("white"));
		
	}
	@Ignore
	@Test
	@DatabaseSetup(value="/dataset/item.xml", type=DatabaseOperation.CLEAN_INSERT)
	public void testItemFindOneByIdNotFound() {
		ItemEntity item=itemService.findOne(5L);
		Assert.assertTrue(item==null);
		
	}
	
	@Test
	@ExpectedDatabase("/dataset/scenario2Item.xml")
	public void testItemSave(){
		ItemEntity item=new ItemEntity();
		item.setDescription("medium");
		item.setFeatures("blue");
		item.setActive(true);
		item.setPrice(1.0);
		item.setStock(4);
		itemService.save(item);
		List<ItemEntity>items=itemService.findAll();
		System.err.println(items);
	}
	@Ignore
	@Test
	@ExpectedDatabase("/dataset/scenario2Item.xml")
	public void testItemDelete(){
		ItemEntity item=itemService.findOne(1L);
		itemService.delete(item);
		System.out.println(itemService.findAll());
	}
//	@Test
//	@DatabaseSetup(value="/dataset/scenario3Item.xml", type=DatabaseOperation.INSERT)
//	@DatabaseSetup(value="/dataset/scenario3Item.xml", type=DatabaseOperation.DELETE)
//	public void testItemFindItemByCategory(){
//		List<Item>items=itemService.findItemByCategory(1l);
//		Assert.assertNotNull(items);
//	}

}
