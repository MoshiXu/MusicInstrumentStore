package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.ConnectionClass;
import com.DAO.RegisterDAO;
import com.DAO.RegisterDAOImpl;
import com.model.RegisterBean;

public class RegisterServlet extends HttpServlet{


	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		
		resp.setContentType("text/html"); 
		PrintWriter out=resp.getWriter(); 
		
		String n=req.getParameter("username");
		int a=Integer.parseInt(req.getParameter("age"));
		String p=req.getParameter("password");
		String add=req.getParameter("address");
		
		RegisterBean newUser=new RegisterBean();
		newUser.setUserName(n);
		newUser.setAge(a);
		newUser.setPassword(p);
		newUser.setAddress(add);
		
		System.out.println(newUser.toString());
		
		
		RegisterDAOImpl registerDAO=new RegisterDAOImpl();
		registerDAO.addProduct(newUser);
		
		out.println("Success!");  
		out.println("welcome user: "+n);
		out.println("your age is  : "+a);
		out.println("please hide the passsword "+p);
		
		
		
		
		
	}
}
