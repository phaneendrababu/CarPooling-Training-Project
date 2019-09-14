package dao;
import java.sql.*;

import bean.ProviderLoginBean;
import util.DBConnection;
public class ProviderLoginDao 
{
	public String authenticateUser(ProviderLoginBean pp)
	{
		String id=pp.getId();
		String password=pp.getPassword();
		try
		{
			Connection con=DBConnection.createConnection();
			PreparedStatement ps=con.prepareStatement("SELECT emp_id,password FROM V_PROVIDER WHERE emp_id=? AND password=?");
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