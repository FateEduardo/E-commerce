package com.softtek.academy.test.integration.services;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.softtek.academy.domain.UserRole;
import com.softtek.academy.services.UserRoleService;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(inheritLocations = true)
@DatabaseSetup(value={"/dataset/user.xml"}, type=DatabaseOperation.CLEAN_INSERT)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
	TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
public class UserRoleServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	UserRoleService userRoleService;

	@Test
	@DatabaseSetup(value="/dataset/scenario1User.xml", type=DatabaseOperation.CLEAN_INSERT)
	public void testRoleListNotNull() {
		List<UserRole>roles=userRoleService.findAll();
		System.out.println(roles);
		Assert.assertNotNull(roles);
	}

}
