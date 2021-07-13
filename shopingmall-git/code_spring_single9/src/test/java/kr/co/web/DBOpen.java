package kr.co.web;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class DBOpen {

	private static final String DRIVER = "org.mariadb.jdbc.Driver";
	private static final String URL = "jdbc:mariadb://127.0.0.1:3306/shopingmall?useUnicode=true&characterEncoding=euck";
	private static final String USER = "root"; //db 접속 id
	private static final String PW = "ssw824"; //db 접속 password

	@Test
	public void testConnection() throws Exception{
		Class.forName(DRIVER);
		try(
			Connection con = DriverManager.getConnection(URL, USER, PW)){
			System.out.println(con +"디비연결성공");

		}catch(Exception e){
			System.out.println("연결실패" + e);
			e.printStackTrace();
		}
	}
} 
