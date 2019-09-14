package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;
import bean.LoginBean;
import dao.LoginDao;


public class LoginServlet extends HttpServlet 
{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id=request.getParameter("emp_id");
		String password=request.getParameter("password");
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		LoginBean l=new LoginBean();
		l.setId(id);
		l.setPassword(password);
		HttpSession session=request.getSession();  
		LoginDao loginDao= new LoginDao();
		String validate=loginDao.authenticateUser(l);
		if(validate.equals("SUCCESS"))
		{
			
			session.setAttribute("id",id);
			request.getRequestDispatcher("/user_login.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("error.html").forward(request, response);;
		}
	}
}
