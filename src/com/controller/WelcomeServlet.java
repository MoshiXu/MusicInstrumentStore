package com.controller;

import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WelcomeServlet extends HttpServlet {

	private String message;
	
	public void init() throws ServletException {
	      // Do required initialization
	      message = "Hehe";
	   }
	
	public void destroy() {
	      // do nothing.
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html"); 
		PrintWriter out=resp.getWriter();
		
		String name=req.getParameter("name");
		
		/*
		HttpSession session=req.getSession(false);
		session.getAttribute("name");
		*/
		out.println("welcome "+name);
		
		 
	    out.println("<h1>" + message + "</h1>");
	
	}

	  
}
