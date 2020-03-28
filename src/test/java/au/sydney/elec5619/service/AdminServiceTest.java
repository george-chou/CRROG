package au.sydney.elec5619.service;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AdminServiceTest {

	AdminService as = new AdminService();
	ArrayList<Object> al = new ArrayList<Object>();
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}


	@Test
	public void testAdminLogin() {
		Assert.assertEquals(as.adminLogin("admin"), true);
		Assert.assertEquals(as.adminLogin("others"), false);
	}

	@Test
	public void testCompanySearch() {

		Assert.assertEquals(as.companySearch(""), al);
	}

	@Test
	public void testUserSearch() {
		
		Assert.assertEquals(as.userSearch(""), al);
	}

	@Test
	public void testBan() {
		
		Assert.assertEquals(as.Ban("mzho6553", false, true), true);
		Assert.assertEquals(as.Ban("mzho6553", false, false), false);
		Assert.assertEquals(as.Ban("yifan", true, true), true);
		Assert.assertEquals(as.Ban("yifan", true, false), false);
	}

	@Test
	public void testAudit() {
		Assert.assertEquals(as.Audit("yifan"), true);
	}

	@Test
	public void testGetBannedCompany() {
		Assert.assertEquals(as.getBannedCompany(), al);
	}

	@Test
	public void testGetBannedUser() {
		Assert.assertEquals(as.getBannedUser(), al);
	}

	@Test
	public void testGetWaiting() {
		Assert.assertEquals(as.getWaiting(), al);
	}

}
