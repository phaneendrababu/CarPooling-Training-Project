package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ProviderRegisterBean;
import dao.ProviderRegisterDao;
import dao.UpdateProviderDao;

public class UpdateProviderServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id=request.getParameter("emp_id");
		String name=request.getParameter("full_name");
		String gender=request.getParameter("gender");
		String mobile=request.getParameter("mobile_no");
		String origin=request.getParameter("origin");
		String destination=request.getParameter("destination");
		String start_time=request.getParameter("start_time");
		String return_time=request.getParameter("return_time");
		String seats=request.getParameter("seats");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		ProviderRegisterBean p= new ProviderRegisterBean();
		p.setId(id);
		p.setName(name);
		p.setGender(gender);
		p.setMobile(mobile);
		p.setOrigin(origin);
		p.setDestination(destination);
		p.setStart_time(start_time);
		p.setReturn_time(return_time);
		p.setSeats(seats);
		p.setEmail(email);
		p.setPassword(password);
		p.setAvailable_seats(seats);
		
		
		UpdateProviderDao up=new UpdateProviderDao();
		int validate=up.updateProviderData(p);
		if(validate==1)
		{
			System.out.println("abc");
			request.getRequestDispatcher("provider_update_success.html").forward(request, response);
		}
		else
		{
			
		}
	}
}
