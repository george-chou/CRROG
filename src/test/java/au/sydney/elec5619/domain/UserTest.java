package au.sydney.elec5619.domain;

import java.net.URL;
import java.sql.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class UserTest {
	
	User user = new User();
	URL url;
	JSONArray award;
	JSONObject a1;

	@Before
	public void setUp() throws Exception {
		
		url = new URL("https://www.google.com");		
		award = new JSONArray();
		a1 = new JSONObject();
		a1.put("title", "awardtitle");
		award.add(a1);
		
		user.setAbout("Hello");
		user.setAward(award);
		user.setBan(false);
		user.setBirth(new Date(10000));
		user.setCity("Sydney");
		user.setCollected(a1);
		user.setConference(award);
		user.setCountry("Australia");
		user.setEdu(award);
		user.setEmail("mzho6553");
		user.setFirstname("George");
		user.setLastname("Chou");
		user.setFolios(award);
		user.setGender(1);
		user.setGithubname("george-chou");
		user.setGithubsw(true);
		user.setGithuburl(url);
		user.setGitsw(true);
		user.setGooglesw(true);
		user.setGoogleurl(url);
		user.setHired(a1);
		user.setHomepage(url);
		user.setJob("Software engineer");
		user.setLanguage(award);
		user.setLinkedinsw(true);
		user.setLinkedinurl(url);
		user.setPassword("123456");
		user.setPgsw(true);
		user.setPhoto("photo");
		user.setPp(award);
		user.setProgramming(a1);
		user.setQqmusicsw(true);
		user.setSonglist("1234567890");
		user.setStyle(0);
		user.setTwittersw(true);
		user.setTwitterurl(url);
		user.setValid(true);
		user.setVisitormap(false);
		user.setWebs(award);
		user.setWorkexp(award);
		user.setYcomsw(true);
		user.setYcomurl(url);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetWorkexp() {
		Assert.assertEquals(user.getWorkexp(), award);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetAward() {
		Assert.assertEquals(user.getAward(), award);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetStyle() {
		Assert.assertEquals(user.getStyle(), 0);
		//fail("Not yet implemented");
	}

	@Test
	public void testIsTwittersw() {
		Assert.assertEquals(user.isTwittersw(), true);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetTwitterurl() {
		Assert.assertEquals(user.getTwitterurl(), url);
		//fail("Not yet implemented");
	}

	@Test
	public void testIsGooglesw() {
		Assert.assertEquals(user.isGooglesw(), true);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetGoogleurl() {
		Assert.assertEquals(user.getGoogleurl(), url);
		//fail("Not yet implemented");
	}

	@Test
	public void testIsLinkedinsw() {
		Assert.assertEquals(user.isLinkedinsw(), true);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetLinkedinurl() {
		Assert.assertEquals(user.getLinkedinurl(), url);
		//fail("Not yet implemented");
	}

	@Test
	public void testIsGithubsw() {
		Assert.assertEquals(user.isGithubsw(), true);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetGithuburl() {
		Assert.assertEquals(user.getGithuburl(), url);
		//fail("Not yet implemented");
	}

	@Test
	public void testIsYcomsw() {
		Assert.assertEquals(user.isYcomsw(), true);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetYcomurl() {
		Assert.assertEquals(user.getYcomurl(), url);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetWebs() {
		Assert.assertEquals(user.getWebs(), award);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetConference() {
		Assert.assertEquals(user.getConference(), award);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetPp() {
		Assert.assertEquals(user.getPp(), award);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetFolios() {
		Assert.assertEquals(user.getFolios(), award);
		//fail("Not yet implemented");
	}

	@Test
	public void testIsQqmusicsw() {
		Assert.assertEquals(user.isQqmusicsw(), true);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetSonglist() {
		Assert.assertEquals(user.getSonglist(), "1234567890");
		//fail("Not yet implemented");
	}

	@Test
	public void testGetGithubname() {
		Assert.assertEquals(user.getGithubname(), "george-chou");
		//fail("Not yet implemented");
	}

	@Test
	public void testIsGitsw() {
		Assert.assertEquals(user.isGithubsw(), true);
		//fail("Not yet implemented");
	}

	@Test
	public void testIsVisitormap() {
		Assert.assertEquals(user.isVisitormap(), false);
		//fail("Not yet implemented");
	}

	@Test
	public void testIsPgsw() {
		Assert.assertEquals(user.isPgsw(), true);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetProgramming() {
		Assert.assertEquals(user.getProgramming(), a1);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetCollected() {
		Assert.assertEquals(user.getCollected(), a1);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetHired() {
		Assert.assertEquals(user.getHired(), a1);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetEmail() {
		Assert.assertEquals(user.getEmail(), "mzho6553");
		//fail("Not yet implemented");
	}

	@Test
	public void testGetPassword() {
		Assert.assertEquals(user.getPassword(), "123456");
		//fail("Not yet implemented");
	}

	@Test
	public void testGetFirstname() {
		Assert.assertEquals(user.getFirstname(), "George");
		//fail("Not yet implemented");
	}

	@Test
	public void testGetLastname() {
		Assert.assertEquals(user.getLastname(), "Chou");
		//fail("Not yet implemented");
	}

	@Test
	public void testGetPhoto() {
		Assert.assertEquals(user.getPhoto(), "photo");
		//fail("Not yet implemented");
	}

	@Test
	public void testGetAbout() {
		Assert.assertEquals(user.getAbout(), "Hello");
		//fail("Not yet implemented");
	}

	@Test
	public void testGetHomepage() {
		Assert.assertEquals(user.getHomepage(), url);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetBirth() {
		Assert.assertEquals(user.getBirth(), new Date(10000));
		//fail("Not yet implemented");
	}

	@Test
	public void testGetEdu() {
		Assert.assertEquals(user.getEdu(), award);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetLanguage() {
		Assert.assertEquals(user.getLanguage(), award);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetJob() {
		Assert.assertEquals(user.getJob(), "Software engineer");
		//fail("Not yet implemented");
	}

	@Test
	public void testGetCountry() {
		Assert.assertEquals(user.getCountry(), "Australia");
		//fail("Not yet implemented");
	}

	@Test
	public void testGetCity() {
		Assert.assertEquals(user.getCity(), "Sydney");
		//fail("Not yet implemented");
	}

	@Test
	public void testIsBan() {
		Assert.assertEquals(user.isBan(), false);
		//fail("Not yet implemented");
	}

	@Test
	public void testIsValid() {
		Assert.assertEquals(user.isValid(), true);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetGender() {
		Assert.assertEquals(user.getGender(), 1);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetMark() {
		Assert.assertEquals(user.getMark(), 0);
		//fail("Not yet implemented");
	}

	@Test
	public void testCompleted() {
		Assert.assertEquals(user.completed(), true);
		//fail("Not yet implemented");
	}

}
