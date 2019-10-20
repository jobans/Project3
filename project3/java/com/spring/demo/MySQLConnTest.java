package com.spring.demo;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;



public class MySQLConnTest {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/sol802?useSSL=false";
	private static final String USER = "scott";
	private static final String PASSWORD = "tiger";
	
	@Test
	public void testConn() throws Exception{
		
		Class.forName(DRIVER);
		
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		
		System.out.println("conn : " + conn);
		
		
	}// testConn end
	
}
