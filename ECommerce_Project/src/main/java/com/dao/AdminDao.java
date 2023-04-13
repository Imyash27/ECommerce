package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.AdminModel;
import com.model.CategoryModel;
import com.model.AdminModel;
import com.util.DBUtil;

public class AdminDao
{
	
	Connection cn=null;
	int x=0;
	
	public AdminModel AdminLogin(AdminModel lmodel)
	{
		AdminModel model=null;
		cn=new DBUtil().getDatabaseConnection();
		
		String qry="select * from admin where emailid=? and password=?";
		
		try 
		{
			PreparedStatement st=cn.prepareStatement(qry);
			st.setString(1, lmodel.getEmailid());
			st.setString(2, lmodel.getPassword());
			
			ResultSet rs=st.executeQuery();
			if (rs.next()) 
			{
				model=new AdminModel();
				model.setId(rs.getInt(1));
				model.setFirstname(rs.getString("firstname"));
				model.setLastname(rs.getString("lastname"));
				model.setEmailid(rs.getString("emailid"));	
				model.setPassword(rs.getString("password"));
										
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return model;
	}
	
	public int addCategory(CategoryModel rmodel)
	{
		cn=new DBUtil().getDatabaseConnection();
		String qry="insert into cat(catname,catimage) values (?,?)";
		
		try
		{
			PreparedStatement st=cn.prepareStatement(qry);
			st.setString(1, rmodel.getCatname());
			st.setString(2, rmodel.getCatimage());	
			
			x=st.executeUpdate();
			cn.close();
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
		return x;
	}

}
