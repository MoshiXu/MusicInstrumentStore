package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

import com.model.LoginBean;
import com.model.RegisterBean;

public class ConnectionClass implements DAO{

	public static final String URL="oracle.jdbc.driver.OracleDriver";
	public static final	String DRIVER="jdbc:oracle:thin:@localhost:1521:orcl";
	public static final	String USERNAME="XDB";
	public static final String PASSWORD="xuer37xdd5";
						
	public static Connection con=null;
						
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

	//register
	@Override
	public void addProduct(RegisterBean u) {
		String query="insert into registers values (?,?,?,?)";
		
	}

	@Override
	public void deleteProduct(RegisterBean u) {
		
	}

	@Override
	public void fetchProdcut() {
		
	}

	@Override
	public void updateProduct(RegisterBean u) {
		
	}

	@Override
	public void validateProduct(RegisterBean u) {
		String query="select * from regisers where name='"+LoginBean.getName()+"' and password='" + LoginBean.getPassword();

		
	}
}
