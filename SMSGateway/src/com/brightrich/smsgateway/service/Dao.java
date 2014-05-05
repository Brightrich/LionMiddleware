package com.brightrich.smsgateway.service;

import java.sql.Connection;
import java.sql.DriverManager;


public class Dao {

	public static Connection createConnection() throws Exception{
		String url = "jdbc:mysql://localhost/smsg";
		String user = "root";
		String pass = "root";
		Connection conn = null;
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		conn = DriverManager.getConnection(url, user, pass);
		return conn;
		}
	
}
