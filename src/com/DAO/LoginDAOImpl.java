package com.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.LoginBean;

public class LoginDAOImpl implements LoginDAO{

	@Override
	public String validate(LoginBean loginBean) {
		String userName=loginBean.getName();
		String password=loginBean.getPassword();
		
		Connection con=null;
		Statement statement=null;
		ResultSet resultSet=null;
		String nameDB="";
		String passwordDB="";
		
		try {
			con=ConnectionClass.getConnection();
			statement=con.createStatement();
			String query="select name,password from registers";
			resultSet=statement.executeQuery(query);
			
			while(resultSet.next()) {
				nameDB=resultSet.getString("name");
				passwordDB=resultSet.getString("password");
				
				if(userName.equals(nameDB)&& password.equals(passwordDB)) {
					return "YES";
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return "NO";
	}

}
