package util;

import java.sql.*;

public class DBConnection 
{
	public static Connection createConnection()
	{
		Connection con=null;
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username ="training_project";
		String password ="root";
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url,username,password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
