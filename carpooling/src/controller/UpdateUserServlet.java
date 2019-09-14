package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.RegisterBean;
import dao.UpdateUserDao;

/**
 * Servlet implementation class UpdateUserServlet
 */
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String emp_id = request.getParameter("emp_id");
		String full_name = request.getParameter("full_name");
		String gender = request.getParameter("gender");
		String email=request.getParameter("email");
		String mobile = request.getParameter("mobile_no");
		String password = request.getParameter("password");
		
		RegisterBean rb=new RegisterBean();
		rb.setId(emp_id);
		rb.setName(full_name);
		rb.setGender(gender);
		rb.setEmail(email);
		rb.setMobile(mobile);
		rb.setPassword(password);
		
		UpdateUserDao ud=new UpdateUserDao();
		int validate=ud.updateUserData(rb);
		if(validate==1)
		{
			request.getRequestDispatcher("update_success.html").forward(request, response);
		}
	}
}
