package com.project.test;
import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class test {
	String driver = "org.mariadb.jdbc.Driver"; 
	Connection conn; public void DBconn() { 
	//����̹� :// ip : ��Ʈ��ȣ / �����ͺ��̽� �̸� 
	String url = "jdbc:mariadb://192.168.0.7:3306/shopingmall";
	String sql = "SELECT * FROM atworks_user";
	String pwd = "wongi0595"; 
	
	try {  
		Class.forName(driver); 
	} catch (ClassNotFoundException e) { 
		System.out.println("����̹� �ε� ����"); 
		e.printStackTrace(); 
	} 
	
	try { 
		conn = DriverManager.getConnection(url, "root", pwd); 
		if (conn != null) { 
			System.out.println("DB���� ����"); 
		} 
	} catch (SQLException e) { 
		System.out.println("DB���� ����"); 
		e.printStackTrace(); } 
	} public static void main(String[] args) { 
		test dbconn = new test(); 
		dbconn.DBconn(); 
	} 
}