package databaseconnection;
import java.sql.*;

public class databasecon 
{
	static Connection co;
	public static Connection getconnection()
	{
 		
 			
		try
		{
			Class.forName("com.mysql.jdbc.Driver");	
			co = DriverManager.getConnection("jdbc:mysql://localhost:3306/securedata","root","root");
		}
		catch(Exception e)
		{
			System.out.println("Database Error"+e);
		}
		return co;
	}
	
}
