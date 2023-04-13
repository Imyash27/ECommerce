package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.CustomerModel;
import com.util.DBUtil;

public class CustomerDao 
{
	Connection cn=null;
	int x=0;
	
	public int cutomerregister(CustomerModel rmodel)
	{
		cn=new DBUtil().getDatabaseConnection();
		String qry="insert into customer(firstname,lastname,gender,state,city,address,pincode,mobileno,emailid,username,password,image,status) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try
		{
			PreparedStatement st=cn.prepareStatement(qry);
			st.setString(1, rmodel.getFirstname());
			st.setString(2, rmodel.getLastname());
			st.setString(3, rmodel.getGender());
			st.setString(4, rmodel.getState());
			st.setString(5, rmodel.getCity());
			st.setString(6, rmodel.getAddress());
			st.setInt(7, rmodel.getPincode());
			st.setString(8, rmodel.getMobileno());
			st.setString(9, rmodel.getEmailid());
			st.setString(10, rmodel.getUsername());
			st.setString(11, rmodel.getPassword());
			st.setString(12, rmodel.getImage());
			st.setString(13, rmodel.getStatus());
			
			x=st.executeUpdate();
			cn.close();
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
		return x;
	}
	
	public CustomerModel customerLogin(CustomerModel lmodel)
	{
		CustomerModel model=null;
		cn=new DBUtil().getDatabaseConnection();
		
		String qry="select * from customer where emailid=? and password=?";
		
		try 
		{
			PreparedStatement st=cn.prepareStatement(qry);
			st.setString(1, lmodel.getEmailid());
			st.setString(2, lmodel.getPassword());
			
			ResultSet rs=st.executeQuery();
			if (rs.next()) 
			{
				model=new CustomerModel();
				model.setCustomerid(rs.getInt(1));
				model.setFirstname(rs.getString("firstname"));
				model.setLastname(rs.getString("lastname"));
				model.setGender(rs.getString("gender"));
				model.setState(rs.getString("state"));
				model.setCity(rs.getString("city"));
				model.setAddress(rs.getString("address"));
				model.setPincode(rs.getInt(8));
				model.setMobileno(rs.getString("mobileno"));
				model.setEmailid(rs.getString("emailid"));
				model.setUsername(rs.getString("username"));
				model.setPassword(rs.getString("password"));
				model.setImage(rs.getString("image"));
				model.setStatus(rs.getString("status"));						
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return model;
	}
}
