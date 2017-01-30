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
import com.softtek.academy.domain.User;
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
	@DatabaseSetup(value="/dataset/scenario1User.xml", type=DatabaseOperation.CLEAN_INSERT)
	public void testUserServiceListUserNotNull() {
		List<User>users=userService.findAll();
		System.out.println(users);
		Assert.assertNotNull(users);
	}
	
	@Test
	@DatabaseSetup(value="/dataset/scenario1User.xml", type=DatabaseOperation.CLEAN_INSERT)
	public void testFindOneUserAsUsername(){
		User user=userService.findOne("admin");
		System.out.println(user);
		Assert.assertTrue(user.getName().equals("admin"));
	}

}
