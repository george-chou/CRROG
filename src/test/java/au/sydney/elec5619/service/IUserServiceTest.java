package au.sydney.elec5619.service;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
 
import au.sydney.elec5619.domain.User;

public class IUserServiceTest {

 
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testGetUInfo() {
		
		User user = new User();
		user.setEmail("");
		user.setGender(0);
		user.setBan(false);
		user.setTwittersw(false);
		user.setGooglesw(false);
		user.setLinkedinsw(false);
		user.setGithubsw(false);
		user.setYcomsw(false);
		user.setQqmusicsw(false);
		user.setStyle(0);
		user.setQqmusicsw(false);
		user.setGitsw(false);
		user.setVisitormap(false);
		user.setPgsw(false);
		user.setValid(false);
		
		IUserService us = new IUserService(user);
		
		System.out.println(user.toString() + "\n\n");
		System.out.println(us.getUInfo("").toString() + "\n\n");
		
		
		Assert.assertEquals(us.getUInfo("").toString(), user.toString());

		
		//fail("Not yet implemented");
	}

	@Test
	public void testGetUInfoString() {
		
		User user = new User();
		IUserService us = new IUserService(user);
		Assert.assertEquals(us.getUInfo(), user);
		
	}

	@Test
	public void testOpenCV() {
		
		IUserService us = new IUserService();
		Assert.assertEquals(us.openCV("mzho6553"), true);
		Assert.assertEquals(us.openCV(""), false);
	}

	@Test
	public void testCompleteUser() {
		
		User user = new User("mzho6553", "Abc123456@");
		IUserService us = new IUserService(user);
		Assert.assertEquals(us.completeUser("job", "Software engineer"), true);
		Assert.assertEquals(us.completeUser("", "Software"), false);
	}

	@Test
	public void testTryLogin() {
		
		User user = new User("mzho6553", "Abc123456@");
		IUserService us = new IUserService(user);
		Assert.assertEquals(us.tryLogin(), 0);
		
		user = new User("mzho6553", "Abc23456@");
		us = new IUserService(user);
		Assert.assertEquals(us.tryLogin(), -2);

		user = new User("@", "Abc23456@");
		us = new IUserService(user);
		Assert.assertEquals(us.tryLogin(), -1);

		user = new User("rmao0248", "Abc123456@");
		us = new IUserService(user);
		Assert.assertEquals(us.tryLogin(), -9);
		
		user = new User("ghua3127", "Abc123456@");
		us = new IUserService(user);
		Assert.assertEquals(us.tryLogin(), 1);

		
	}

	@Test
	public void testTrySignIn() {
		
		User user = new User("mzho6553", "Abc123456@");
		IUserService us = new IUserService(user);
		Assert.assertEquals(us.trySignIn(), -4);
		
		user = new User("@", "23456@");
		us = new IUserService(user);	
		Assert.assertEquals(us.trySignIn(), -1);
		
		user = new User("mzho6553", "23456@");
		us = new IUserService(user);	
		Assert.assertEquals(us.trySignIn(), -3);
		
		user = new User("zigzagbob2", "Ab23456@");
		us = new IUserService(user);	
		Assert.assertEquals(us.trySignIn(), 2);
		
	}

}
