package au.sydney.elec5619.service;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import au.sydney.elec5619.domain.Company;

public class EnterpriseServiceTest { 	

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testGetCoInfo() {

		Company company = new Company();
		EnterpriseService es = new EnterpriseService(company);
		Assert.assertEquals(es.getCoInfo(), company);
		//fail("Not yet implemented");
	}

	@Test
	public void testTryLogin() {
		
		Company company = new Company("yifan", "Yifan12345@");
		EnterpriseService es = new EnterpriseService(company);	
		Assert.assertEquals(es.tryLogin(), 0);
		
		company = new Company("yifan", "Abc12345@");
		es = new EnterpriseService(company);	
		Assert.assertEquals(es.tryLogin(), -2);

		company = new Company("@", "Abc12345@");
		es = new EnterpriseService(company);	
		Assert.assertEquals(es.tryLogin(), -1);

		company = new Company("wangyifan", "Yifan12345@");
		es = new EnterpriseService(company);	
		Assert.assertEquals(es.tryLogin(), -9);
		
		company = new Company("sadiq", "Yifan12345@");
		es = new EnterpriseService(company);	
		Assert.assertEquals(es.tryLogin(), 1);

		company = new Company("dongyuan", "Yifan12345@");
		es = new EnterpriseService(company);	
		Assert.assertEquals(es.tryLogin(), -10);
		
	}

	@Test
	public void testTrySignIn() {
		
		Company company = new Company("yifan", "Yifan12345@");
		EnterpriseService es = new EnterpriseService(company);	
		Assert.assertEquals(es.trySignIn(), -4);
		
		company = new Company("@", "Yifan12345@");
		es = new EnterpriseService(company);	
		Assert.assertEquals(es.trySignIn(), -1);
		
		company = new Company("yifan", "123456");
		es = new EnterpriseService(company);	
		Assert.assertEquals(es.trySignIn(), -3);
		
		company = new Company("zigzag", "Yifan12345@");
		es = new EnterpriseService(company);	
		Assert.assertEquals(es.trySignIn(), 2);
	}

	@Test
	public void testSearchUser() {

		Company company = new Company();
		EnterpriseService es = new EnterpriseService(company);	
		ArrayList<Object> al = new ArrayList<Object>();
		Assert.assertEquals(es.searchUser("mzho"), al);
		
	}

	@Test
	public void testGetMarked() {
		
		Company company = new Company("dongyuan", "Yifan12345@");
		EnterpriseService es = new EnterpriseService(company);	
		ArrayList<Object> al = new ArrayList<Object>();
		Assert.assertEquals(es.getMarked(true), al);
		Assert.assertEquals(es.getMarked(false), al);
	}

	@Test
	public void testSetMark() {
		
		Company company = new Company();
		EnterpriseService es = new EnterpriseService(company);
		Assert.assertEquals(es.setMark("mzho6553", true, true), true);
		Assert.assertEquals(es.setMark("mzho6553", false, true), true);
		Assert.assertEquals(es.setMark("mzho6553", true, false), true);
		Assert.assertEquals(es.setMark("mzho6553", false, false), true);
		
	}

	@Test
	public void testCompleteCompany() {
		
		Company company = new Company("dongyuan", "Yifan12345@");
		EnterpriseService es = new EnterpriseService(company);
		Assert.assertEquals(es.completeCompany("companytype", "IT"), true);
		
	}

}
