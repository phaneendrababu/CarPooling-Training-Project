package dao;
import java.sql.*;

import bean.ProviderRegisterBean;
import util.DBConnection;

public class UpdateProviderDao 
{
	public int updateProviderData(ProviderRegisterBean p)
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
		PreparedStatement ps=null;
		try
		{
			Connection con=DBConnection.createConnection();
			ps=con.prepareStatement("UPDATE V_PROVIDER SET NAME=?,GENDER=?,MOBILE=?,ORIGIN=?,DESTINATION=?,START_TIME=?,RETURN_TIME=?,SEATS=?,EMAIL=?,PASSWORD=?,AVAILABLE_SEATS=? WHERE EMP_ID=?");
			ss=Integer.parseInt(seats);
			eid=Integer.parseInt(id);
			ps.setInt(12,eid);
			ps.setString(1, name);
			ps.setString(2, gender);
			ps.setString(3,mobile);
			ps.setString(4,origin);
			ps.setString(5, destination);
			ps.setString(6, start_time);
			ps.setString(7, return_time);
			ps.setInt(8, ss);
			ps.setString(9, email);
			ps.setString(10,password);
			ps.setInt(11, ss);
			int s=ps.executeUpdate();
			ps.close();
			if(s==1)
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
