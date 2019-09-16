package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.LoginBean;
import com.model.RegisterBean;

public class ConnectionClass{

	public static final String URL="oracle.jdbc.driver.OracleDriver";
	public static final	String DRIVER="jdbc:oracle:thin:@localhost:1521:orcl";
	public static final	String USERNAME="XDB";
	public static final String PASSWORD="xuer37xdd5";
						
	public static Connection con=null;
			
	
	
	//get connected to DB
	public static Connection getConnection() {	
		if(con!=null) {
			return con;
		}
		try {
			Class.forName(DRIVER);
			con=DriverManager.getConnection(URL);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
