package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ProviderLoginBean;
import dao.ProviderLoginDao;



public class ProviderLoginServlet extends HttpServlet 
{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id=request.getParameter("provider_id");
		String password=request.getParameter("password");
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		ProviderLoginBean p=new ProviderLoginBean();
		p.setId(id);
		p.setPassword(password);
		HttpSession session=request.getSession();  
		ProviderLoginDao loginDao= new ProviderLoginDao();
		String validate=loginDao.authenticateUser(p);
		if(validate.equals("SUCCESS"))
		{
			System.out.print("abc");
			session.setAttribute("id",id);
			request.getRequestDispatcher("/provider_login.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("provider_error.html").forward(request, response);;
		}
	}

}
