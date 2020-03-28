package au.sydney.elec5619.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

	protected static final String DB_URL = "jdbc:mysql://localhost:3306/springapp?serverTimezone=GMT";
	protected static final String USER = "root";
	protected static final String PASS = "resumegenerator";
	
	protected static final int RESET_SUCCESS = 3;
	protected static final int SIGNIN_SUCCESS = 2;
	protected static final int NEED_COMPLETE = 1;
	protected static final int LOGIN_SUCCESS = 0;
	protected static final int INVALID_EMAIL = -1;
	protected static final int INCORRECT_PASS = -2;
	protected static final int INVALID_PASS = -3;
	protected static final int USER_EXIST = -4;	
	protected static final int RESET_FAILED = -5;
	protected static final int USER_NOTEXIST = -6;
	protected static final int OLD_EQUALNEW = -7;
	protected static final int UNKNOWN_ERR = -8;
	protected static final int ACCOUNT_BANNED = -9;
	protected static final int NEED_AUDIT = -10;
	
	public ClientService() {}

	protected static String getMD5(String sourceStr) throws NoSuchAlgorithmException 
	{
        if(sourceStr==null || "".equals(sourceStr.trim())) return null;
        byte[] source=sourceStr.getBytes();
        String s = null;
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try
        {
        	MessageDigest md = MessageDigest.getInstance( "MD5" );
            md.update(source);
            byte tmp[] = md.digest();
            char str[] = new char[16 * 2];
            int k = 0;
            for (int i = 0; i < 16; i++) 
            {
                byte byte0 = tmp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            s = new String(str);
        }
        catch(NoSuchAlgorithmException e)
        {
        	throw e;
        }
        return s;
	}
	

	private boolean checkEmailFormat(String content)
	{
		String REGEX = "^[a-z0-9]+$";
	    Pattern p = Pattern.compile(REGEX);    
	    Matcher matcher = p.matcher(content);

	    return matcher.matches();
	}
	
	protected static Connection getConn() 
	{
        Connection conn = null;        
        try 
        {
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);           
        } 
        catch (ClassNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        
        return conn;
    }
	
	protected String setColumn(String[] EnterpriseColumn)
	{
		int Length = EnterpriseColumn.length;
		String insertSQL = "select ";
		
		for(int i = 0 ; i < Length ; i++)
		{
			insertSQL = insertSQL + EnterpriseColumn[i];
			if(i < Length - 1) insertSQL = insertSQL + ", ";
		}
		
		return insertSQL;
	}

	protected boolean validPass(String p)
	{
		String reg = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}";
		return Pattern.matches(reg, p);
	}
	
	protected boolean validUsername(String u)
	{
		return checkEmailFormat(u);
	}
	
	protected boolean insertClient(String type, String user, String pass)
	{
		boolean insertSuccess = false;
		Connection conn = getConn();
        PreparedStatement preparedStatement = null;
        PreparedStatement ps = null;
        try
        {        	
        	String insertTableSQL = "select * from " + type + " where email=?";
        	preparedStatement = conn.prepareStatement(insertTableSQL);
        	preparedStatement.setString(1, user);
        	ResultSet rs = preparedStatement.executeQuery();
        	if(!rs.next())
        	{
        		insertTableSQL = "INSERT INTO " + type + " (email, md5) VALUES (?, ?)";
            	ps = conn.prepareStatement(insertTableSQL);
            	ps.setString(1, user);
            	ps.setString(2, getMD5(pass));           	
            	insertSuccess = (ps.executeUpdate() > 0);          	
            	ps.close();
        	}        	
        	//Clean-up environment
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
        
		return insertSuccess;
	}
	
	
	public int resetPass(String email, String newpass, boolean isUser)
	{
		if(!validUsername(email)) return INVALID_EMAIL;
		if(!validPass(newpass)) return INVALID_PASS;
		
		int result = UNKNOWN_ERR;
		String clientype = isUser ? "user" : "enterprise";
		
		Connection conn = getConn();
        PreparedStatement preparedStatement = null;
        PreparedStatement ps = null;
        
        try
        {
        	String insertTableSQL1 = "select md5 from " + clientype + " where email=?";
        	ps = conn.prepareStatement(insertTableSQL1);
        	ps.setString(1, email);
        	ResultSet rs = ps.executeQuery();
        	if(rs.next())
        	{
        		
        		if(rs.getString(1) == getMD5(newpass))
        		{
        			result = OLD_EQUALNEW;
        		}
        		else
        		{
            		String insertTableSQL2 = "update " + clientype + " set md5='" + getMD5(newpass) + "' where email=?";       
                	preparedStatement = conn.prepareStatement(insertTableSQL2);
                	preparedStatement.setString(1, email);
                	int reset = preparedStatement.executeUpdate();             	
                	result = (reset == 1) ? RESET_SUCCESS : RESET_FAILED;
                	preparedStatement.close();
        		}

        	}
        	else
        	{ 
        		result = USER_NOTEXIST;
        	}
        	
        	ps.close();
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
        
        return result;
	}
	

}
