package au.sydney.elec5619.service;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import au.sydney.elec5619.domain.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class IUserService extends ClientService {

	private User user;
	
	private static final String[] UserColumn = 
		{
				"first",
				"last",
				"job",
				"gender",
				"country",
				"city",
				"homepage",
				"photo",
				"about",
				"birth",
				"edu",
				"language",
				"workexp",
				"award",
				"style",
				"ban",
				"twittersw",
				"twitterurl",
				"googlesw",
				"googleurl",
				"linkedinsw",
				"linkedinurl",
				"githubsw",
				"githuburl",
				"ycomsw",
				"ycomurl",
				"webs",
				"conference",
				"pp",
				"folios",
				"qqmusicsw",
				"songlist",
				"githubname",
				"gitsw",
				"visitormap",
				"pgsw",
				"programming",
				"collected",
				"hired",
				"showcv"
		};

	public IUserService(User user) 
	{
		super();
		this.user = user;
	}

	public IUserService() {}

	private boolean getUserinfo()
	{
		boolean isValid = false;
		String email = user.getEmail();
		String pass = user.getPassword();
		
		Connection conn = getConn();
        PreparedStatement preparedStatement = null;
        try
        {
        	String insertTableSQL = setColumn(UserColumn) + " from user where email=? and md5=?";       
        	preparedStatement = conn.prepareStatement(insertTableSQL);
        	preparedStatement.setString(1, email); 
        	preparedStatement.setString(2, getMD5(pass));

        	// execute insert SQL statement
        	ResultSet rs = preparedStatement.executeQuery();
        	if(rs.next())
        	{
        		this.user.setFirstname(rs.getString(1));
        		this.user.setLastname(rs.getString(2));
        		this.user.setJob(rs.getString(3)); 
        		this.user.setGender(rs.getInt(4));
        		this.user.setCountry(rs.getString(5));
        		this.user.setCity(rs.getString(6));
        		this.user.setHomepage(rs.getURL(7));
        		this.user.setPhoto(rs.getString(8));
        		this.user.setAbout(rs.getString(9)); 
        		this.user.setBirth(rs.getDate(10));
        		this.user.setEdu(JSONArray.fromObject(rs.getObject(11)));
        		this.user.setLanguage(JSONArray.fromObject(rs.getObject(12)));
        		this.user.setWorkexp(JSONArray.fromObject(rs.getObject(13)));
        		this.user.setAward(JSONArray.fromObject(rs.getObject(14)));
        		this.user.setStyle(rs.getInt(15));
        		this.user.setBan(rs.getBoolean(16));
        		this.user.setTwittersw(rs.getBoolean(17));
        		this.user.setTwitterurl(rs.getURL(18));
        		this.user.setGooglesw(rs.getBoolean(19));
        		this.user.setGoogleurl(rs.getURL(20));
        		this.user.setLinkedinsw(rs.getBoolean(21));
        		this.user.setLinkedinurl(rs.getURL(22));
        		this.user.setGithubsw(rs.getBoolean(23));
        		this.user.setGithuburl(rs.getURL(24));
        		this.user.setYcomsw(rs.getBoolean(25));
        		this.user.setYcomurl(rs.getURL(26));
        		this.user.setWebs(JSONArray.fromObject(rs.getObject(27)));
        		this.user.setConference(JSONArray.fromObject(rs.getObject(28)));
        		this.user.setPp(JSONArray.fromObject(rs.getObject(29)));
        		this.user.setFolios(JSONArray.fromObject(rs.getObject(30)));
        		this.user.setQqmusicsw(rs.getBoolean(31));
        		this.user.setSonglist(rs.getString(32));
        		this.user.setGithubname(rs.getString(33));
        		this.user.setGitsw(rs.getBoolean(34));
        		this.user.setVisitormap(rs.getBoolean(35));
        		this.user.setPgsw(rs.getBoolean(36));
        		this.user.setProgramming(JSONObject.fromObject(rs.getObject(37)));
        		this.user.setCollected(JSONObject.fromObject(rs.getObject(38)));
        		this.user.setHired(JSONObject.fromObject(rs.getObject(39)));
        		this.user.setValid(rs.getBoolean(40));        	   
        		
        		isValid = true;
        		System.out.println("pass correct!");
        	}
        	else
        	{
        		isValid = false;
        		System.out.println("pass incorrect!");
        	}
           
        	preparedStatement.close();
        	conn.close();

        }
        catch(SQLException se)
        {
           //Handle errors for JDBC
           se.printStackTrace();
        }
        catch(Exception e)
        {
           //Handle errors for Class.forName
           e.printStackTrace();
        }
        finally
        {
           try
           {
        	   if(preparedStatement != null) preparedStatement.close();
           }
           catch(SQLException se2)
           {
        	   se2.printStackTrace();
           }
           
           try
           {
        	   if(conn != null) conn.close();
           }
           catch(SQLException se)
           {
        	   se.printStackTrace();
           }
        }
        
        return isValid;
	}

	public User getUInfo()
	{
		getUserinfo();
		return user;
	}
	
	public User getUInfo(String email)
	{
		User temp = new User();	
		temp.setEmail(email);
		Connection conn = getConn();
        PreparedStatement preparedStatement = null;
        try
        {
        	String insertTableSQL = setColumn(UserColumn) + " from user where email=?";       
        	preparedStatement = conn.prepareStatement(insertTableSQL);
        	preparedStatement.setString(1, email);

        	ResultSet rs = preparedStatement.executeQuery();
        	if(rs.next())
        	{
        		temp.setFirstname(rs.getString(1));
        		temp.setLastname(rs.getString(2));
        		temp.setJob(rs.getString(3)); 
        		temp.setGender(rs.getInt(4));
        		temp.setCountry(rs.getString(5));
        		temp.setCity(rs.getString(6));
        		temp.setHomepage(rs.getURL(7));
        		temp.setPhoto(rs.getString(8));
        		temp.setAbout(rs.getString(9)); 
        		temp.setBirth(rs.getDate(10));
        		temp.setEdu(JSONArray.fromObject(rs.getObject(11)));
        		temp.setLanguage(JSONArray.fromObject(rs.getObject(12)));
        		temp.setWorkexp(JSONArray.fromObject(rs.getObject(13)));
        		temp.setAward(JSONArray.fromObject(rs.getObject(14)));
        		temp.setStyle(rs.getInt(15));
        		temp.setBan(rs.getBoolean(16));
        		temp.setTwittersw(rs.getBoolean(17));
        		temp.setTwitterurl(rs.getURL(18));
        		temp.setGooglesw(rs.getBoolean(19));
        		temp.setGoogleurl(rs.getURL(20));
        		temp.setLinkedinsw(rs.getBoolean(21));
        		temp.setLinkedinurl(rs.getURL(22));
        		temp.setGithubsw(rs.getBoolean(23));
        		temp.setGithuburl(rs.getURL(24));
        		temp.setYcomsw(rs.getBoolean(25));
        		temp.setYcomurl(rs.getURL(26));
        		temp.setWebs(JSONArray.fromObject(rs.getObject(27)));
        		temp.setConference(JSONArray.fromObject(rs.getObject(28)));
        		temp.setPp(JSONArray.fromObject(rs.getObject(29)));
        		temp.setFolios(JSONArray.fromObject(rs.getObject(30)));
        		temp.setQqmusicsw(rs.getBoolean(31));
        		temp.setSonglist(rs.getString(32));
        		temp.setGithubname(rs.getString(33));
        		temp.setGitsw(rs.getBoolean(34));
        		temp.setVisitormap(rs.getBoolean(35));
        		temp.setPgsw(rs.getBoolean(36));
        		temp.setProgramming(JSONObject.fromObject(rs.getObject(37)));
        		temp.setCollected(JSONObject.fromObject(rs.getObject(38)));
        		temp.setHired(JSONObject.fromObject(rs.getObject(39)));
        		temp.setValid(rs.getBoolean(40));
        	}
        	
        	preparedStatement.close();
        	conn.close();

        }
        catch(SQLException se)
        {
           //Handle errors for JDBC
           se.printStackTrace();
        }
        catch(Exception e)
        {
           //Handle errors for Class.forName
           e.printStackTrace();
        }
        finally
        {
           try
           {
        	   if(preparedStatement != null) preparedStatement.close();
           }
           catch(SQLException se2)
           {
        	   se2.printStackTrace();
           }
           
           try
           {
        	   if(conn != null) conn.close();
           }
           catch(SQLException se)
           {
        	   se.printStackTrace();
           }
        }        
        return temp;
	}
	
	public boolean openCV(String email)
	{
		boolean success = false;		
		Connection conn = getConn();
        PreparedStatement preparedStatement = null;
        try
        {
        	String insertTableSQL = "select showcv, ban from user where email=? and ban=false";       
        	preparedStatement = conn.prepareStatement(insertTableSQL);
        	preparedStatement.setString(1, email);
        	ResultSet rs = preparedStatement.executeQuery();
        	if(rs.next()) success = rs.getBoolean(1);   	
        	preparedStatement.close();
        	conn.close();
        }
        catch(SQLException se)
        {
           //Handle errors for JDBC
           se.printStackTrace();
        }
        catch(Exception e)
        {
           //Handle errors for Class.forName
           e.printStackTrace();
        }
        finally
        {
           try
           {
        	   if(preparedStatement != null) preparedStatement.close();
           }
           catch(SQLException se2)
           {
        	   se2.printStackTrace();
           }
           
           try
           {
        	   if(conn != null) conn.close();
           }
           catch(SQLException se)
           {
        	   se.printStackTrace();
           }
        }
        
        return success;
	}
	
	public boolean completeUser(String item, String updValue)
	{
		boolean success = false;
		String email = user.getEmail();		
		Connection conn = getConn();
        PreparedStatement preparedStatement = null;
        try
        {
        	String insertTableSQL = "update user set " + item + "=? where email=?";       
        	preparedStatement = conn.prepareStatement(insertTableSQL);
        	preparedStatement.setString(1, updValue);
        	preparedStatement.setString(2, email);
        	success = preparedStatement.executeUpdate() == 1; 
        	preparedStatement.close();
        	conn.close();
        }
        catch(SQLException se)
        {
           //Handle errors for JDBC
           se.printStackTrace();
        }
        catch(Exception e)
        {
           //Handle errors for Class.forName
           e.printStackTrace();
        }
        finally
        {
           try
           {
        	   if(preparedStatement != null) preparedStatement.close();
           }
           catch(SQLException se2)
           {
        	   se2.printStackTrace();
           }
           
           try
           {
        	   if(conn != null) conn.close();
           }
           catch(SQLException se)
           {
        	   se.printStackTrace();
           }
        }
        
        return success;
	}

	public int tryLogin()
	{
		if(!validUsername(this.user.getEmail())) return INVALID_EMAIL; 

		if(getUserinfo())
		{
			if(this.user.isBan())
			{
				return ACCOUNT_BANNED;
			}
			
			if(this.user.completed())
			{
				return LOGIN_SUCCESS;
			}
			else
			{
				return NEED_COMPLETE;
			}
		}
		else
		{
			return INCORRECT_PASS;
		}
		
	}


	public int trySignIn()
	{
		if(!validUsername(this.user.getEmail())) return INVALID_EMAIL;
		if(!validPass(this.user.getPassword())) return INVALID_PASS;
		
		if(insertClient("user", this.user.getEmail(), this.user.getPassword()))
		{
			return SIGNIN_SUCCESS;
		}
		else
		{
			return USER_EXIST;
		}

	}
	
}
