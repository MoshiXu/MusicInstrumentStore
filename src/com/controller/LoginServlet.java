package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.ConnectionClass;
import com.model.LoginBean;

public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Connection con=null;
		resp.setContentType("text/html"); 
		PrintWriter out=resp.getWriter(); 
		
		String name=req.getParameter("username");
		String password=req.getParameter("password");
		
		ResultSet rs;
		RequestDispatcher rd;
		
		
		
		
		
		LoginBean login=new LoginBean();
		login.setName(name);
		login.setPassword(password);
		
		//LoginDao loginDao=new LoginDao();
		
		//String userValidate=loginDao.authenticateUser(loginBean);
		
		//get detail from Model class
		String nm=login.getName();
		
		//add detail into hashmap
		HashMap<String,String> map=new HashMap<>();
		map.put("username", nm);
		map.put("address",nm);
				
		//create session add attribute in session
		HttpSession session=req.getSession();
		session.setAttribute("userDetails", login);
				
		//call database layer
		//String query="insert into register users values (?,?)";
		
		
		
		try {		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","XDB","xuer37xdd5");
							
			Statement st=con.createStatement();
			
			String query="select * from registers where name='"+name+"'and password='"+password+"' ";
			rs=st.executeQuery(query);
					
			if(rs.next()) {
				System.out.println("Correct");
				rd=req.getRequestDispatcher("welcome");
				rd.forward(req, resp);
			}else {
				System.out.println("Wrong");
				rd=req.getRequestDispatcher("/login.html");
				rd.include(req,resp);
				out.println("Invalid");
			}	
					
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
				
/*
		try {
			PreparedStatement pstmt=con.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}
			
		if(name.equals("moshi")&&password.equals("moshi")) {
			RequestDispatcher rd=req.getRequestDispatcher("welcome.jsp");
			rd.forward(req, resp);
		}else {
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}
*/		
		
	}

}
