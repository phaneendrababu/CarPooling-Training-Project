package dao;
import java.sql.*;
import java.util.Date;

import bean.StoreHistoryBean;
import util.DBConnection;

public class StoreHistoryDao 
{
	public int history(StoreHistoryBean sb)
	{
		String id = sb.getId();
		String p_id = sb.getP_id();
		String p_name = sb.getP_name();
		String p_mobile = sb.getP_mobile();
		String p_mail = sb.getP_mail();
		String p_available_seats = sb.getP_available_seats();
		String p_booked_seats = sb.getP_booked_seats();
		PreparedStatement ps=null;
		int pid=Integer.parseInt(p_id);
		int s=Integer.parseInt(p_available_seats);
		int ss=Integer.parseInt(p_booked_seats);
		int eid=0;
		String name=null;
		String mobile=null;
		String mail=null;
		int cur_seats=0;
		Date date= new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		try
		{
			Connection con=DBConnection.createConnection();
			ps=con.prepareStatement("SELECT * FROM V_USER WHERE EMP_ID=?");
			
			eid=Integer.parseInt(id);
			ps.setInt(1, eid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				name=rs.getString(2);
				mobile=rs.getString(6);
				mail=rs.getString(4);
				/*sendEmail.send("phani.indra03@gmail.com","phani@1998", p_mail, "New Booking Request",name+" booked "+p_booked_seats+" seats on "+ ts);*/
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			Connection con=DBConnection.createConnection();
			ps=con.prepareStatement("INSERT INTO V_HISTORY VALUES(?,?,?,?,?,?,?,?,?,?)");
			
			ps.setInt(1, pid);
			ps.setString(2, p_name);
			ps.setString(3, p_mobile);
			ps.setString(4, p_mail);
			ps.setInt(5, eid);
			ps.setString(6,name);
			ps.setString(7, mobile);
			ps.setString(8, mail);
			ps.setInt(9,ss);
			ps.setTimestamp(10, ts);
			
			int i=ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			Connection con=DBConnection.createConnection();
			ps=con.prepareStatement("UPDATE V_PROVIDER SET AVAILABLE_SEATS=? WHERE EMP_ID=?");
		
			int ns=s-ss;
			ps.setInt(1,ns);
			ps.setInt(2,pid);
			
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