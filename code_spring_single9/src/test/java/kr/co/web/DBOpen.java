package kr.co.web;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class DBOpen {

	private static final String DRIVER = "org.mariadb.jdbc.Driver";
	private static final String URL = "jdbc:mariadb://127.0.0.1:3306/shopingmall?useUnicode=true&characterEncoding=euck";
	private static final String USER = "root"; //db ���� id
	private static final String PW = "ssw824"; //db ���� password

	@Test
	public void testConnection() throws Exception{
		Class.forName(DRIVER);
		try(
			Connection con = DriverManager.getConnection(URL, USER, PW)){
			System.out.println(con +"��񿬰Ἲ��");

		}catch(Exception e){
			System.out.println("�������" + e);
			e.printStackTrace();
		}
	}
} 
