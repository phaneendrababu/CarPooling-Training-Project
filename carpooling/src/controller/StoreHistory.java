package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.StoreHistoryBean;
import dao.StoreHistoryDao;

/**
 * Servlet implementation class StoreHistory
 */
public class StoreHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id = request.getParameter("id");
		String p_id = request.getParameter("p_id");
		String p_name = request.getParameter("p_name");
		String p_mobile = request.getParameter("p_mobile");
		String p_mail = request.getParameter("p_mail");
		String p_available_seats = request.getParameter("p_available_seats");
		String p_booked_seats = request.getParameter("p_booked_seats");
		
		StoreHistoryBean storeHistoryBean = new StoreHistoryBean();
		storeHistoryBean.setId(id);
		storeHistoryBean.setP_id(p_id);
		storeHistoryBean.setP_name(p_name);
		storeHistoryBean.setP_mobile(p_mobile);
		storeHistoryBean.setP_mail(p_mail);
		storeHistoryBean.setP_available_seats(p_available_seats);
		storeHistoryBean.setP_booked_seats(p_booked_seats);
		
		StoreHistoryDao sb=new StoreHistoryDao();
		int validate =sb.history(storeHistoryBean);
		
		if(validate==1)
		{
			request.getRequestDispatcher("book_success.html").forward(request, response);
		}
	}

}
