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

public class RegisterServlet extends HttpServlet{

	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		
		resp.setContentType("text/html"); 
		PrintWriter out=resp.getWriter(); 
		
		String n=req.getParameter("username");
		int a=Integer.parseInt(req.getParameter("age"));
		String p=req.getParameter("password");
		String add=req.getParameter("address");
		
		
		
		out.println("Success!");  
		out.println("welcome user: "+n);
		out.println("your age is  : "+a);
		out.println("please hide the passsword "+p);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","XDB","xuer37xdd5");
							
			Statement st=con.createStatement();
			con.setAutoCommit(false);
			
			RequestDispatcher rd;
			
			String query="insert into registers values (?,?,?,?)";
			PreparedStatement prs=con.prepareStatement(query);
			
			prs.setString(1,n);//name
			prs.setInt(2, a);//age
			prs.setString(3, p);//password
			prs.setString(4, add);//address
			prs.execute();  
			
			con.commit();
			con.close();	
			
					
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
