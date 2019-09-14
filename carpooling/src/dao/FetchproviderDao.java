package dao;
import java.sql.*;
import java.util.ArrayList;

import bean.ProviderRegisterBean;
import util.DBConnection;
public class FetchproviderDao 
{
	public ArrayList<ProviderRegisterBean> Fetchdata(ProviderRegisterBean p)
	{
		String origin=p.getOrigin();
		String destination=p.getDestination();
		ArrayList<ProviderRegisterBean> arrayList = new ArrayList<ProviderRegisterBean>();
		try
		{
			Connection con=DBConnection.createConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM V_PROVIDER WHERE origin=? AND destination=? and AVAILABLE_SEATS>0");
			ps.setString(1,origin);
			ps.setString(2,destination);  
			ResultSet rs=ps.executeQuery();
				
			while(rs.next())
			{ 
					ProviderRegisterBean providerRegisterBean = new ProviderRegisterBean();
					providerRegisterBean.setId(rs.getString(1));
					providerRegisterBean.setName(rs.getString(2));
					providerRegisterBean.setStart_time(rs.getString(7));
					providerRegisterBean.setReturn_time(rs.getString(8));
					providerRegisterBean.setAvailable_seats(rs.getString(12));
					providerRegisterBean.setMobile(rs.getString(4));
					providerRegisterBean.setEmail(rs.getString(10));
					arrayList.add(providerRegisterBean);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return arrayList;
	}
	public ArrayList<ProviderRegisterBean> Fetchproviderdata(ProviderRegisterBean p)
	{
		String id=p.getId();
		int pid=Integer.parseInt(id);
		ArrayList<ProviderRegisterBean> arrayList = new ArrayList<ProviderRegisterBean>();
		try
		{
			Connection con=DBConnection.createConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM V_PROVIDER WHERE emp_id=?");
			ps.setInt(1,pid); 
			ResultSet rs=ps.executeQuery();
				
			while(rs.next())
			{ 
					ProviderRegisterBean providerRegisterBean = new ProviderRegisterBean();
					providerRegisterBean.setId(rs.getString(1));
					providerRegisterBean.setName(rs.getString(2));
					providerRegisterBean.setMobile(rs.getString(4));
					providerRegisterBean.setEmail(rs.getString(10));
					providerRegisterBean.setAvailable_seats(rs.getString(12));
					arrayList.add(providerRegisterBean);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return arrayList;
	}
}
