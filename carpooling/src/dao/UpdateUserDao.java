package dao;
import java.sql.*;
import bean.RegisterBean;
import util.DBConnection;

public class UpdateUserDao 
{
	public int updateUserData(RegisterBean r)
	{
		String id=r.getId();
		String name=r.getName();
		String gender=r.getGender();
		String email=r.getEmail();
		String mobile=r.getMobile();
		String password=r.getPassword();
		PreparedStatement ps=null;
		try
		{
			Connection con=DBConnection.createConnection();
			ps=con.prepareStatement("UPDATE V_USER SET FULL_NAME=?,GENDER=?,EMAIL=?,PASSWORD=?,MOBILE=? WHERE EMP_ID=?");
			int eid=Integer.parseInt(id);
			ps.setInt(6,eid);
			ps.setString(1, name);
			ps.setString(2, gender);
			ps.setString(3, email);
			ps.setString(4,password);
			ps.setString(5, mobile);
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
