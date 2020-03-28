package au.sydney.elec5619.domain;
import java.net.URL;
import java.sql.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class User {
	
	private String email;
	private String password;
	private String firstname;
	private String lastname;
	private String job;
	private int gender;
	private String country;
	private String city;
	private URL homepage;
	private String photo;
	private String about;
	private Date birth;
	private JSONArray edu;
	private JSONArray language;
	private JSONArray workexp;
	private JSONArray award;
	private int style;
	private boolean ban;
	private boolean twittersw;
	private URL twitterurl;
	private boolean googlesw;
	private URL googleurl;
	private boolean linkedinsw;
	private URL linkedinurl;
	private boolean githubsw;
	private URL githuburl;
	private boolean ycomsw;
	private URL ycomurl;
	private JSONArray webs;
	private JSONArray conference;
	private JSONArray pp;
	private JSONArray folios;
	private boolean qqmusicsw;
	private String songlist;
	private String githubname;
	private boolean gitsw;
	private boolean visitormap;
	private boolean pgsw;
	private JSONObject programming;
	private JSONObject collected;
	private JSONObject hired;
	
	private boolean valid;

	public User() {
		
	}
	
	public JSONArray getWorkexp() {
		return workexp;
	}

	public void setWorkexp(JSONArray workexp) {
		this.workexp = workexp;
	}

	public JSONArray getAward() {
		return award;
	}

	public void setAward(JSONArray award) {
		this.award = award;
	}

	public int getStyle() {
		return style;
	}

	public void setStyle(int style) {
		this.style = style;
	}

	public boolean isTwittersw() {
		return twittersw;
	}

	public void setTwittersw(boolean twittersw) {
		this.twittersw = twittersw;
	}

	public URL getTwitterurl() {
		return twitterurl;
	}

	public void setTwitterurl(URL twitterurl) {
		this.twitterurl = twitterurl;
	}

	public boolean isGooglesw() {
		return googlesw;
	}

	public void setGooglesw(boolean googlesw) {
		this.googlesw = googlesw;
	}

	public URL getGoogleurl() {
		return googleurl;
	}

	public void setGoogleurl(URL googleurl) {
		this.googleurl = googleurl;
	}

	public boolean isLinkedinsw() {
		return linkedinsw;
	}

	public void setLinkedinsw(boolean linkedinsw) {
		this.linkedinsw = linkedinsw;
	}

	public URL getLinkedinurl() {
		return linkedinurl;
	}

	public void setLinkedinurl(URL linkedinurl) {
		this.linkedinurl = linkedinurl;
	}

	public boolean isGithubsw() {
		return githubsw;
	}

	public void setGithubsw(boolean githubsw) {
		this.githubsw = githubsw;
	}

	public URL getGithuburl() {
		return githuburl;
	}

	public void setGithuburl(URL githuburl) {
		this.githuburl = githuburl;
	}

	public boolean isYcomsw() {
		return ycomsw;
	}

	public void setYcomsw(boolean ycomsw) {
		this.ycomsw = ycomsw;
	}

	public URL getYcomurl() {
		return ycomurl;
	}

	public void setYcomurl(URL ycomurl) {
		this.ycomurl = ycomurl;
	}

	public JSONArray getWebs() {
		return webs;
	}

	public void setWebs(JSONArray webs) {
		this.webs = webs;
	}

	public JSONArray getConference() {
		return conference;
	}

	public void setConference(JSONArray conference) {
		this.conference = conference;
	}

	public JSONArray getPp() {
		return pp;
	}

	public void setPp(JSONArray pp) {
		this.pp = pp;
	}

	public JSONArray getFolios() {
		return folios;
	}

	public void setFolios(JSONArray folios) {
		this.folios = folios;
	}

	public boolean isQqmusicsw() {
		return qqmusicsw;
	}

	public void setQqmusicsw(boolean qqmusicsw) {
		this.qqmusicsw = qqmusicsw;
	}

	public String getSonglist() {
		return songlist;
	}

	public void setSonglist(String songlist) {
		this.songlist = songlist;
	}

	public String getGithubname() {
		return githubname;
	}

	public void setGithubname(String githubname) {
		this.githubname = githubname;
	}

	public boolean isGitsw() {
		return gitsw;
	}

	public void setGitsw(boolean gitsw) {
		this.gitsw = gitsw;
	}

	public boolean isVisitormap() {
		return visitormap;
	}

	public void setVisitormap(boolean visitormap) {
		this.visitormap = visitormap;
	}

	public boolean isPgsw() {
		return pgsw;
	}

	public void setPgsw(boolean pgsw) {
		this.pgsw = pgsw;
	}

	public JSONObject getProgramming() {
		return programming;
	}

	public void setProgramming(JSONObject programming) {
		this.programming = programming;
	}

	public JSONObject getCollected() {
		return collected;
	}

	public void setCollected(JSONObject collected) {
		this.collected = collected;
	}

	public JSONObject getHired() {
		return hired;
	}

	public void setHired(JSONObject hired) {
		this.hired = hired;
	}

	public void setLanguage(JSONArray language) {
		this.language = language;
	}

	public User(String username, String password) 
	{
		this.email = username;
		this.password = password;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public URL getHomepage() {
		return homepage;
	}

	public void setHomepage(URL homepage) {
		this.homepage = homepage;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}


	public JSONArray getEdu() {
		return edu;
	}

	public void setEdu(JSONArray edu) {
		this.edu = edu;
	}

	public JSONArray getLanguage() {
		return language;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isBan() {
		return ban;
	}

	public void setBan(boolean ban) {
		this.ban = ban;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

 
	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getMark()
	{
		return 0;
	}
	
	public boolean completed()
	{
		boolean NameComplete = (this.firstname != null) && (this.lastname != null);
		boolean HomePgComplete = (this.homepage != null);
		boolean PhotoComplete = (this.photo != null);
		boolean AboutComplete = (this.about != null);
		boolean BirthComplete = (this.birth != null);
		boolean EduComplete = (this.edu != null);
		boolean LangComplete = (this.language != null);
		
		return NameComplete && HomePgComplete && PhotoComplete && AboutComplete && BirthComplete && EduComplete && LangComplete;
	}
	
	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", job=" + job + ", gender=" + gender + ", country=" + country + ", city=" + city + ", homepage="
				+ homepage + ", photo=" + photo + ", about=" + about + ", birth=" + birth + ", edu=" + edu
				+ ", language=" + language + ", workexp=" + workexp + ", award=" + award + ", style=" + style + ", ban="
				+ ban + ", twittersw=" + twittersw + ", twitterurl=" + twitterurl + ", googlesw=" + googlesw
				+ ", googleurl=" + googleurl + ", linkedinsw=" + linkedinsw + ", linkedinurl=" + linkedinurl
				+ ", githubsw=" + githubsw + ", githuburl=" + githuburl + ", ycomsw=" + ycomsw + ", ycomurl=" + ycomurl
				+ ", webs=" + webs + ", conference=" + conference + ", pp=" + pp + ", folios=" + folios + ", qqmusicsw="
				+ qqmusicsw + ", songlist=" + songlist + ", githubname=" + githubname + ", gitsw=" + gitsw
				+ ", visitormap=" + visitormap + ", pgsw=" + pgsw + ", programming=" + programming + ", collected="
				+ collected + ", hired=" + hired + ", valid=" + valid + "]";
	}
}
