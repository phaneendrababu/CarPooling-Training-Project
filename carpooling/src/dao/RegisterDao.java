package dao;

import java.sql.*;

import bean.RegisterBean;
import util.DBConnection;

public class RegisterDao 
{
	public int checkUser(RegisterBean r)
	{
		String id=r.getId();
		try
		{
			Connection con = DBConnection.createConnection();
			PreparedStatement ps1=con.prepareStatement("SELECT * FROM V_USER WHERE EMP_ID=?");
			int eid=Integer.parseInt(id);
			ps1.setInt(1, eid);
			ResultSet rs1= ps1.executeQuery();
			while(rs1.next())
			{
				return 1;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	public int insertData(RegisterBean r)
	{
		String id=r.getId();
		String name=r.getName();
		String gender=r.getGender();
		String mobile=r.getMobile();
		String email=r.getEmail();
		String password=r.getPassword();
		try
		{
			Connection con=DBConnection.createConnection();
			PreparedStatement ps=con.prepareStatement("INSERT INTO V_USER VALUES(?,?,?,?,?,?)");
			int eid=Integer.parseInt(id);
			ps.setInt(1,eid);
			ps.setString(2, name);
			ps.setString(3, gender);
			ps.setString(4, email);
			ps.setString(5,password);
			ps.setString(6, mobile);
			int i=ps.executeUpdate();
				
			if(i==1)
			{ 
					
					return 1;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
}
