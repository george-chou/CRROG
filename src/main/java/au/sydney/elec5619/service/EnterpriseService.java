package au.sydney.elec5619.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import au.sydney.elec5619.domain.Company;

public class EnterpriseService extends ClientService {

	private Company company;
	
	private static final String[] EnterpriseColumn = 
		{
				"companyname", 
				"companycode", 
				"license", 
				"homepage", 
				"establishdate", 
				"companytype", 
				"location", 
				"scale",
				"phone",
				"audit",
				"ban"
		};
	
	public EnterpriseService(Company company) 
	{
		super();
		this.company = company;
	}
	
	public EnterpriseService() {}

	private boolean getCoinfo()
	{
		boolean isVaild = false;
		String email = company.getEmail();
		String pass = company.getPassword();
		
		Connection conn = getConn();
        PreparedStatement preparedStatement = null;
        try
        {
        	String insertTableSQL = setColumn(EnterpriseColumn) + " from enterprise where email=? and md5=?";       
        	preparedStatement = conn.prepareStatement(insertTableSQL);
        	preparedStatement.setString(1, email); 
        	preparedStatement.setString(2, getMD5(pass));

        	// execute insert SQL statement
        	ResultSet rs = preparedStatement.executeQuery();
        	if(rs.next())
        	{
        		this.company.setCompanyname(rs.getString(1));
        		this.company.setCompanycode(rs.getString(2));
        		this.company.setLicence(rs.getString(3));
        		this.company.setHomepage(rs.getURL(4));      	   
        		this.company.setEstablishdate(rs.getDate(5));
        		this.company.setCompanytype(rs.getString(6));
        		this.company.setLocation(rs.getString(7));
        		this.company.setScale(rs.getInt(8));
        		this.company.setPhone(rs.getString(9));
        		this.company.setAudit(rs.getBoolean(10));
        		this.company.setBan(rs.getBoolean(11));        	   
        		
        		isVaild = true;
        		System.out.println("pass correct!");
        	}
        	else
        	{
        		isVaild = false;
        		System.out.println("pass incorrect!");
        	}
           
        	preparedStatement.close();
        	conn.close();

        }
        catch(SQLException se)
        {
           //Handle errors for JDBC
           se.printStackTrace();
           System.out.println(se.toString());
        }
        catch(Exception e)
        {
           //Handle errors for Class.forName
           e.printStackTrace();
           System.out.println(e.toString());
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
        	   System.out.println(se2.toString());
           }
           
           try
           {
        	   if(conn != null) conn.close();
           }
           catch(SQLException se)
           {
        	   se.printStackTrace();
        	   System.out.println(se.toString());
           }
        }
        
        return isVaild;
	}
	


	public Company getCoInfo()
	{
		getCoinfo();
		return company;
	}


	public int tryLogin()
	{
		if(!validUsername(this.company.getEmail())) return INVALID_EMAIL; 

		if(getCoinfo())
		{
			
			if(this.company.isBan())
			{
				return ACCOUNT_BANNED;
			}
			
			if(this.company.completed())
			{
				if(!this.company.isAudit()) return NEED_AUDIT;
				
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
		if(!validUsername(this.company.getEmail())) return INVALID_EMAIL;
		if(!validPass(this.company.getPassword())) return INVALID_PASS;
		
		if(insertClient("enterprise", this.company.getEmail(), this.company.getPassword()))
		{
			return SIGNIN_SUCCESS;
		}
		else
		{
			return USER_EXIST;
		}

	}
	
	private boolean existInJSON(String id, JSONObject json)
	{
		return (json.get(id) != null);
	}
	
	private JSONObject toJSON(String s) throws ParseException
	{
		return (JSONObject) new JSONParser().parse(s);
	}
	
	public ArrayList<Object> searchUser(String keyword)
	{
		
		String companyId = this.company.getEmail();
		ArrayList<Object> searchList = new ArrayList<Object>(); 
		Connection conn = getConn();
        PreparedStatement preparedStatement = null;
        try
        {
        	String insertTableSQL = "select job, first, last, homepage, collected, hired, email from user where (first like ? or last like ? or job like ?) and ban=false and showcv=true";    
        	preparedStatement = conn.prepareStatement(insertTableSQL);
        	preparedStatement.setString(1, keyword);
        	preparedStatement.setString(2, keyword);
        	preparedStatement.setString(3, keyword);
        	// execute insert SQL statement
        	ResultSet rs = preparedStatement.executeQuery();
        	while(rs.next())
        	{
        		if(rs.getURL(4) == null || rs.getObject(5) == null || rs.getObject(6) == null) continue;
        		
        		Map<String, Object> temp = new HashMap<String, Object>();
        		temp.put("job", rs.getString(1));
        		temp.put("name", rs.getString(2) + " " + rs.getString(3));
        		temp.put("homepage", rs.getURL(4).toString());
        		temp.put("collected", existInJSON(companyId, toJSON(rs.getObject(5).toString())));
        		temp.put("hired", existInJSON(companyId, toJSON(rs.getObject(6).toString())));
        		temp.put("email", rs.getString(7));
        		
        		searchList.add(temp);
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
        return searchList;
	}
	
	public ArrayList<Object> getMarked(boolean isCollect)
	{
		String companyId = this.company.getEmail();
		String isCollected = isCollect ? "collected" : "hired";		
		ArrayList<Object> searchList = new ArrayList<Object>(); 
		Connection conn = getConn();
        PreparedStatement preparedStatement = null;
        try
        {
        	String insertTableSQL = "select job, first, last, homepage, collected, hired, email from user where json_contains_path(" + isCollected + ", 'all', ?) and ban=false and showcv=true";    
        	preparedStatement = conn.prepareStatement(insertTableSQL);
        	preparedStatement.setString(1, "$." + companyId);
        	// execute insert SQL statement
        	ResultSet rs = preparedStatement.executeQuery();
        	while(rs.next())
        	{
        		if(rs.getURL(4) == null || rs.getObject(5) == null || rs.getObject(6) == null) continue;
        		
        		Map<String, Object> temp = new HashMap<String, Object>();
        		temp.put("job", rs.getString(1));
        		temp.put("name", rs.getString(2) + " " + rs.getString(3));
        		temp.put("homepage", rs.getURL(4).toString());
        		temp.put("collected", existInJSON(companyId, toJSON(rs.getObject(5).toString())));
        		temp.put("hired", existInJSON(companyId, toJSON(rs.getObject(6).toString())));
        		temp.put("email", rs.getString(7));
        		
        		searchList.add(temp);
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
        return searchList;
	}


	@SuppressWarnings("unchecked")
	public boolean setMark(String username, boolean switchon, boolean isfollow)
	{
		boolean marked = switchon;
		String companyId = this.company.getEmail();
		Connection conn = getConn();
        PreparedStatement preparedStatement = null;
        PreparedStatement ps = null;
        
        try
        {
        	String isCollect = isfollow ? "collected" : "hired";
        	String insertTableSQL = "select " + isCollect + " from user where email=? and ban=false and showcv=true";    
        	preparedStatement = conn.prepareStatement(insertTableSQL);
        	preparedStatement.setString(1, username);        	
        	ResultSet rs = preparedStatement.executeQuery();
        	
        	if(rs.next())
        	{
        		JSONObject json = toJSON(rs.getObject(1).toString());
        		boolean isMarked = existInJSON(companyId, json);

        		if((!switchon) && (!isMarked))
        		{
        			SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        			json.put(companyId, ft.format(new Date()).toString());
        			String insertTableSQL2 = "update user set " + isCollect + "='" + json.toString() + "' where email=?";  
        			ps = conn.prepareStatement(insertTableSQL2);
                	ps.setString(1, username);
                	if(ps.executeUpdate() == 1) marked = true; 
                	ps.close();
        		}
        		else if(switchon && isMarked)
        		{
        			json.remove(companyId);
        			String insertTableSQL2 = "update user set " + isCollect + "='" + json.toString() + "' where email=?";  
        			ps = conn.prepareStatement(insertTableSQL2);
                	ps.setString(1, username);
                	if(ps.executeUpdate() == 1) marked = false; 
                	ps.close();
        		}
        		
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
        return marked;
	}
	
	public boolean completeCompany(String item, String updValue)
	{
		boolean success = false;
		String email = company.getEmail();		
		Connection conn = getConn();
        PreparedStatement preparedStatement = null;
        try
        {
        	String insertTableSQL = "update enterprise set " + item + "=? where email=?";       
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
	

}

