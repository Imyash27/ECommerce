package com.controller;

import java.io.IOException;

import com.dao.AdminDao;
import com.dao.CustomerDao;
import com.model.AdminModel;
import com.model.CategoryModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public AdminController() 
    {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action=request.getParameter("action");
		if (action.equalsIgnoreCase("adminlogin")) 
		{
			AdminModel amodel=new AdminModel();
			amodel.setEmailid(request.getParameter("emailid"));
			amodel.setPassword(request.getParameter("password"));
			
			AdminModel model=new AdminDao().AdminLogin(amodel);
			if(model != null)
			{
				HttpSession session= request.getSession(true);
				session.setAttribute("model", model);
				session.setAttribute("username", model.getFirstname());
				session.setAttribute("id", model.getId());
				
				//request.getRequestDispatcher("admin/dashboard.jsp").forward(request, response);
				response.sendRedirect("admin/dashboard.jsp");
			}
			else
			{
				//request.setAttribute("login","Invalid Emailid Or Password");
				//request.getRequestDispatcher("admin/index.jsp").forward(request, response);
				response.sendRedirect("admin/index.jsp");
				
			}
			
		} 
		else if(action.equalsIgnoreCase("addcategory"))
		{
			CategoryModel rmodel=new CategoryModel();
			
			rmodel.setCatname(request.getParameter("categoryname"));
			rmodel.setCatimage(null);
			int x=new AdminDao().addCategory(rmodel);
			
			if(x>0)
			{
				
				response.sendRedirect("admin/addcategory.jsp");
				
			}	
			else
			{
				/*request.setAttribute("msg","Registration Error");
				request.getRequestDispatcher("registration.jsp").forward(request, response);*/
				response.sendRedirect("admin/dashboard.jsp");
				
			}
		}
		
	}

}
