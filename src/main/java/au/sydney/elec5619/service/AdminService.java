package au.sydney.elec5619.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AdminService extends ClientService {

	public AdminService() { }
	
	public boolean adminLogin(String pass)
	{
		return pass.equals("admin");
	}
	
	public ArrayList<Object> companySearch(String keyword)
	{
 		
		ArrayList<Object> searchList = new ArrayList<Object>(); 
		Connection conn = getConn();
        PreparedStatement preparedStatement = null;
        try
        {
        	String insertTableSQL = "select email, companyname, companycode, ban from enterprise where email like ? or companyname like ? or companycode like ?";    
        	preparedStatement = conn.prepareStatement(insertTableSQL);
        	preparedStatement.setString(1, keyword);
        	preparedStatement.setString(2, keyword);
        	preparedStatement.setString(3, keyword);
        	ResultSet rs = preparedStatement.executeQuery();
        	while(rs.next())
        	{
        		Map<String, Object> temp = new HashMap<String, Object>();
        		temp.put("email", rs.getString(1));
        		temp.put("company", rs.getString(2) + " " + rs.getString(3));
        		temp.put("ban", rs.getBoolean(4));

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
	
	public ArrayList<Object> userSearch(String keyword)
	{
 		
		ArrayList<Object> searchList = new ArrayList<Object>(); 
		Connection conn = getConn();
        PreparedStatement preparedStatement = null;
        try
        {
        	String insertTableSQL = "select email, first, last, ban from user where email like ? or first like ? or last like ?";    
        	preparedStatement = conn.prepareStatement(insertTableSQL);
        	preparedStatement.setString(1, keyword);
        	preparedStatement.setString(2, keyword);
        	preparedStatement.setString(3, keyword);
        	ResultSet rs = preparedStatement.executeQuery();
        	while(rs.next())
        	{
        		Map<String, Object> temp = new HashMap<String, Object>();
        		temp.put("email", rs.getString(1));
        		temp.put("name", rs.getString(2) + " " + rs.getString(3));
        		temp.put("ban", rs.getBoolean(4));
        		
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
	
	
	public boolean Ban(String email, boolean isCompany, boolean ban)
	{
		boolean success = !ban;	
		String clientype = isCompany ? "enterprise" : "user";
		Connection conn = getConn();
        PreparedStatement preparedStatement = null;
        try
        {
        	String insertTableSQL = "update " + clientype + " set ban=? where email=?";       
        	preparedStatement = conn.prepareStatement(insertTableSQL);
        	preparedStatement.setBoolean(1, ban);
        	preparedStatement.setString(2, email);
        	if(preparedStatement.executeUpdate() == 1) success = ban;
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
	
	public boolean Audit(String companyemail)
	{
		boolean success = false;	
		Connection conn = getConn();
        PreparedStatement preparedStatement = null;
        try
        {
        	String insertTableSQL = "update enterprise set audit=true where email=?";       
        	preparedStatement = conn.prepareStatement(insertTableSQL);
        	preparedStatement.setString(1, companyemail);
        	success = (preparedStatement.executeUpdate() == 1); 
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
	
	public ArrayList<Object> getBannedCompany()
	{
 		
		ArrayList<Object> searchList = new ArrayList<Object>(); 
		Connection conn = getConn();
        PreparedStatement preparedStatement = null;
        try
        {
        	String insertTableSQL = "select email, companyname, companycode from enterprise where ban=true";    
        	preparedStatement = conn.prepareStatement(insertTableSQL);
        	ResultSet rs = preparedStatement.executeQuery();
        	while(rs.next())
        	{
        		Map<String, Object> temp = new HashMap<String, Object>();
        		temp.put("email", rs.getString(1));
        		temp.put("company", rs.getString(2) + " " + rs.getString(3));

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
	
	public ArrayList<Object> getBannedUser()
	{
 		
		ArrayList<Object> searchList = new ArrayList<Object>(); 
		Connection conn = getConn();
        PreparedStatement preparedStatement = null;
        try
        {
        	String insertTableSQL = "select email, first, last from user where ban=true";    
        	preparedStatement = conn.prepareStatement(insertTableSQL);
        	ResultSet rs = preparedStatement.executeQuery();
        	while(rs.next())
        	{
        		Map<String, Object> temp = new HashMap<String, Object>();
        		temp.put("email", rs.getString(1));
        		temp.put("name", rs.getString(2) + " " + rs.getString(3));

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
	
	public ArrayList<Object> getWaiting()
	{
 		
		ArrayList<Object> searchList = new ArrayList<Object>(); 
		Connection conn = getConn();
        PreparedStatement preparedStatement = null;
        try
        {
        	String insertTableSQL = "select email, companyname, companycode from enterprise where audit=false";    
        	preparedStatement = conn.prepareStatement(insertTableSQL);
        	ResultSet rs = preparedStatement.executeQuery();
        	while(rs.next())
        	{
        		Map<String, Object> temp = new HashMap<String, Object>();
        		temp.put("email", rs.getString(1));
        		temp.put("company", rs.getString(2) + " " + rs.getString(3));

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
	

}
