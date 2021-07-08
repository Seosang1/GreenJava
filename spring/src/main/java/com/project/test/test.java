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
	//드라이버 :// ip : 포트번호 / 데이터베이스 이름 
	String url = "jdbc:mariadb://192.168.0.7:3306/shopingmall";
	String sql = "SELECT * FROM atworks_user";
	String pwd = "wongi0595"; 
	
	try {  
		Class.forName(driver); 
	} catch (ClassNotFoundException e) { 
		System.out.println("드라이버 로드 실패"); 
		e.printStackTrace(); 
	} 
	
	try { 
		conn = DriverManager.getConnection(url, "root", pwd); 
		if (conn != null) { 
			System.out.println("DB접속 성공"); 
		} 
	} catch (SQLException e) { 
		System.out.println("DB접속 실패"); 
		e.printStackTrace(); } 
	} public static void main(String[] args) { 
		test dbconn = new test(); 
		dbconn.DBconn(); 
	} 
}