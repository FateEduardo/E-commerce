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
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.softtek.academy.domain.UserEntity;
import com.softtek.academy.domain.UserRoleEntity;
import com.softtek.academy.services.UserService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(inheritLocations = true)
@DatabaseSetup(value={"/dataset/user.xml"}, type=DatabaseOperation.CLEAN_INSERT)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
	TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
public class UserServiceImplTest  {
	
	
	@Autowired
	UserService userService;

	@Test
	@DatabaseSetup(value="/dataset/user.xml", type=DatabaseOperation.CLEAN_INSERT)
	public void testUserServiceListUserNotNull() {
		List<UserEntity>users=userService.findAll();
		Assert.assertNotNull(users);

	}
	
	@Test
	@DatabaseSetup(value="/dataset/user.xml", type=DatabaseOperation.CLEAN_INSERT)
	public void testFindOneUserAsUsername(){
		UserEntity user=userService.findOne("admin");
	
		Assert.assertTrue(user.getName().equals("admin"));
	}
	
	@Test
	@ExpectedDatabase("/dataset/scenario1User.xml")
	public void testUserSave(){
		UserEntity user =new UserEntity();
		user.setName("eduardo");
		user.setPassword("eduardo");
		user.setStatus(true);
		user.setUsername("eduardo");
		UserRoleEntity userRole=new UserRoleEntity();
		userRole.setDescription("Registered User");
		userRole.setId("ROLE_USR");
		user.setRole(userRole);
		userService.save(user);
		
	}
	@Test
	@ExpectedDatabase("/dataset/scenario2User.xml")
	public void testUserUpdate(){
		UserEntity user =userService.findOne("dani");
		user.setName("eduardo");
		userService.save(user);
	}
	@Test
	@ExpectedDatabase("/dataset/scenario3User.xml")
	public void testUserDelete(){
		UserEntity user =userService.findOne("dani");
		userService.delete(user);
	}
	
	

}
