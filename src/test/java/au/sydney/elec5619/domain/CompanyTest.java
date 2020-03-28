package au.sydney.elec5619.domain;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CompanyTest {
	
	private Company company;
	
	@Before
	public void setUp() throws Exception {
		
		company = new Company();
		company.setBan(false);
		company.setAudit(true);
		company.setCompanycode("123456");
		company.setCompanyname("Google");
		company.setCompanytype("IT");
		company.setEmail("mzho6553");
		company.setEstablishdate(new Date(10000));
		company.setHomepage(new URL("https://www.google.com"));
		company.setLicence("license");
		company.setLocation("Sydney");
		company.setPassword("123456");
		company.setPhone("123456789");
		company.setScale(2);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetPhone() {
		Assert.assertEquals(company.getPhone(), "123456789");
		//fail("Not yet implemented");
	}

	@Test
	public void testIsAudit() {
		Assert.assertEquals(company.isAudit(), true);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetEmail() {
		Assert.assertEquals(company.getEmail(), "mzho6553");
		//fail("Not yet implemented");
	}

	@Test
	public void testGetPassword() {
		Assert.assertEquals(company.getPassword(), "123456");
		//fail("Not yet implemented");
	}

	@Test
	public void testGetCompanyname() {
		Assert.assertEquals(company.getCompanyname(), "Google");
		//fail("Not yet implemented");
	}

	@Test
	public void testGetCompanycode() {
		Assert.assertEquals(company.getCompanycode(), "123456");
		//fail("Not yet implemented");
	}

	@Test
	public void testGetLicence() {
		Assert.assertEquals(company.getLicence(), "license");
		//fail("Not yet implemented");
	}

	@Test
	public void testGetHomepage() {
		try {
			Assert.assertEquals(company.getHomepage(), new URL("https://www.google.com"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//fail("Not yet implemented");
	}

	@Test
	public void testGetEstablishdate() {
		Assert.assertEquals(company.getEstablishdate(), new Date(10000));
		//fail("Not yet implemented");
	}

	@Test
	public void testGetCompanytype() {
		Assert.assertEquals(company.getCompanytype(), "IT");
		//fail("Not yet implemented");
	}

	@Test
	public void testGetLocation() {
		Assert.assertEquals(company.getLocation(), "Sydney");
		//fail("Not yet implemented");
	}

	@Test
	public void testGetScale() {
		Assert.assertEquals(company.getScale(), 2);
		//fail("Not yet implemented");
	}

	@Test
	public void testIsBan() {
		Assert.assertEquals(company.isBan(), false);
		//fail("Not yet implemented");
	}

	@Test
	public void testCompleted() {
		Assert.assertEquals(company.completed(), true);
		//fail("Not yet implemented");
	}

}
