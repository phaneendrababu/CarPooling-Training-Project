package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ProviderRegisterBean;
import dao.FetchproviderDao;

/**
 * Servlet implementation class BookConfirm
 */
public class BookConfirm extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String pid=request.getParameter("pid");
		ProviderRegisterBean providerRegisterBean = new ProviderRegisterBean();
		providerRegisterBean.setId(pid);
		
		FetchproviderDao f= new FetchproviderDao();
		ArrayList<ProviderRegisterBean> fetchproviderdata = f.Fetchproviderdata(providerRegisterBean);
		request.setAttribute("fetchproviderdata", fetchproviderdata);
		request.getRequestDispatcher("book_confirm.jsp").forward(request, response);	
	}
}
