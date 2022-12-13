package com.lhk.DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	private String jdbcURL="jdbc:mysql://localhost:3306/ban_giay_dep?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
	private String jdbcUsername="root";
	private String jdbcPassword="Anos@123";
	private String jdbcDriver="com.mysql.cj.jdbc.Driver";
	
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(jdbcDriver);
			con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
}
