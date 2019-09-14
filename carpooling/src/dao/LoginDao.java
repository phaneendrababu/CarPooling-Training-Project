package dao;
import java.sql.*;

import bean.LoginBean;
import util.DBConnection;
public class LoginDao 
{
	public String authenticateUser(LoginBean l)
	{
		String id=l.getId();
		String password=l.getPassword();
		try
		{
			Connection con=DBConnection.createConnection();
			PreparedStatement ps=con.prepareStatement("SELECT emp_id,password FROM V_USER WHERE emp_id=? AND password=?");
			int eid=Integer.parseInt(id);
			ps.setInt(1,eid);
			ps.setString(2,password);  
			ResultSet rs=ps.executeQuery();
				
			if(rs.next())
			{ 
					
					return "SUCCESS";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "NOT VALID CREDENTIALS";
	}
}
