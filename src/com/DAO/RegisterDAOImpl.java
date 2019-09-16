package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;

import com.model.RegisterBean;

public class RegisterDAOImpl implements RegisterDAO{

	
	//constructor
	public RegisterDAOImpl() {
		
	}
	
	//insert into db
	public void addProduct(RegisterBean u) {
		
		
		PreparedStatement prs=null;
		
		try {
			String query="insert into registers (name,age,password,address) values (?,?,?,?)";
			ConnectionClass.con=ConnectionClass.getConnection();
			ConnectionClass.con.setAutoCommit(false);
			prs=ConnectionClass.con.prepareStatement(query);
		
			prs.setString(1, u.getUserName());
			prs.setInt(2, u.getAge());
			prs.setString(3, u.getPassword());
			prs.setString(4, u.getAddress());	
			prs.execute();
			
			ConnectionClass.con.commit();
			ConnectionClass.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}


	
