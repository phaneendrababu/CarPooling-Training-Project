package dao;

import java.sql.*;

import bean.ProviderRegisterBean;
import util.DBConnection;

public class ProviderRegisterDao 
{
	public int checkProvider(ProviderRegisterBean p)
	{
		String id=p.getId();
		try
		{
			Connection con = DBConnection.createConnection();
			PreparedStatement ps1=con.prepareStatement("SELECT * FROM V_PROVIDER WHERE EMP_ID=?");
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
	public int insertData(ProviderRegisterBean p)
	{
		String id=p.getId();
		String name=p.getName();
		String gender=p.getGender();
		String mobile=p.getMobile();
		String origin=p.getOrigin();
		String destination=p.getDestination();
		String start_time=p.getStart_time();
		String return_time=p.getReturn_time();
		String seats=p.getSeats();
		String email=p.getEmail();
		String password=p.getPassword();
		int ss=0;
		int eid=0;
		try
		{
			Connection con=DBConnection.createConnection();
			PreparedStatement ps=con.prepareStatement("INSERT INTO V_PROVIDER VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			eid=Integer.parseInt(id);
			ss=Integer.parseInt(seats);
			ps.setInt(1,eid);
			ps.setInt(9, ss);
			ps.setString(2, name);
			ps.setString(3, gender);
			ps.setString(4, mobile);
			ps.setString(5, origin);
			ps.setString(6,destination);
			ps.setString(7, start_time);
			ps.setString(8, return_time);
			ps.setString(10, email);
			ps.setString(11,password);
			ps.setInt(12, ss);
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
