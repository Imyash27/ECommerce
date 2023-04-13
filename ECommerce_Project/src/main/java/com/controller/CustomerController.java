package com.controller;

import java.io.IOException;

import com.dao.CustomerDao;
import com.model.CustomerModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public CustomerController() 
    {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action=request.getParameter("action");
		if (action.equalsIgnoreCase("login")) 
		{
			CustomerModel lmodel=new CustomerModel();
			lmodel.setEmailid(request.getParameter("emailid"));
			lmodel.setPassword(request.getParameter("password"));
			
			CustomerModel model=new CustomerDao().customerLogin(lmodel);
			if(model != null)
			{
				HttpSession session= request.getSession(true);
				session.setAttribute("model", model);
				session.setAttribute("username", model.getUsername());
				session.setAttribute("cid", model.getCustomerid());
				
				request.getRequestDispatcher("cust-dash.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("login","Invalid Emailid Or Password");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}
			
		}
		else if(action.equalsIgnoreCase("register"))
		{
			CustomerModel rmodel=new CustomerModel();
			
			rmodel.setFirstname(request.getParameter("firstname"));
			rmodel.setLastname(request.getParameter("lastname"));
			rmodel.setGender(request.getParameter("gender"));
			rmodel.setState(request.getParameter("state"));
			rmodel.setCity(request.getParameter("city"));
			rmodel.setAddress(request.getParameter("address"));
			rmodel.setPincode(Integer.parseInt(request.getParameter("pincode")));
			rmodel.setMobileno(request.getParameter("mobileno"));
			rmodel.setEmailid(request.getParameter("emailid"));
			rmodel.setUsername(request.getParameter("username"));
			rmodel.setPassword(request.getParameter("password"));
			rmodel.setImage(null);
			rmodel.setStatus("Active");
			
			int x=new CustomerDao().cutomerregister(rmodel);
			
			if(x>0)
			{
				request.setAttribute("msg","Registration Success");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}	
			else
			{
				request.setAttribute("msg","Registration Error");
				request.getRequestDispatcher("registration.jsp").forward(request, response);
				
			}
		}
	}

}
