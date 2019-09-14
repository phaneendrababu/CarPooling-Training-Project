package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.RegisterBean;
import dao.RegisterDao;

public class RegisterServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id=request.getParameter("emp_id");
		String name=request.getParameter("full_name");
		String gender=request.getParameter("gender");
		String mobile=request.getParameter("mobile_no");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		RegisterBean r= new RegisterBean();
		r.setId(id);
		r.setName(name);
		r.setGender(gender);
		r.setMobile(mobile);
		r.setEmail(email);
		r.setPassword(password);
		
		RegisterDao register=new RegisterDao();
		int i=register.checkUser(r);
		int validate=0;
		if(i==1)
		{
			System.out.println(i);
			request.getRequestDispatcher("user_exists.html").forward(request, response);
		}
		else
		{
			validate=register.insertData(r);
			if(validate==1)
			{
				request.getRequestDispatcher("register_success.html").forward(request, response);
			}
		}
		
	}
}
