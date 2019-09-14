package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ProviderRegisterBean;
import dao.FetchproviderDao;

public class FetchProvider extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String origin = request.getParameter("origin");
		String destination = request.getParameter("destination");
		
		ProviderRegisterBean providerRegisterBean = new ProviderRegisterBean();
		providerRegisterBean.setOrigin(origin);
		providerRegisterBean.setDestination(destination);
		
		FetchproviderDao f= new FetchproviderDao();
		ArrayList<ProviderRegisterBean> fetchdata = f.Fetchdata(providerRegisterBean);
		request.setAttribute("fetchdata", fetchdata);
		System.out.println(fetchdata.size());
		if(fetchdata.size()>0)
		{
			request.getRequestDispatcher("fetchprovider.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("fetch_provider_error.html").forward(request, response);
		}
	}
}