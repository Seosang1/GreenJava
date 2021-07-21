package kr.co.web;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class DBOpen {

	private static final String DRIVER = "org.mariadb.jdbc.Driver";
	private static final String URL = "jdbc:mariadb://192.168.0.7:3306/shopingmall?useUnicode=true&characterEncoding=euck";
	private static final String USER = "root"; //db 立加 id
	private static final String PW = "wongi0595"; //db 立加 password

	@Test
	public void testConnection() throws Exception{
		Class.forName(DRIVER);
		try(
				Connection con = DriverManager.getConnection(URL, USER, PW)){
			System.out.println(con +"success");

		}catch(Exception e){
			System.out.println("楷搬角菩" + e);
			e.printStackTrace();
		}
	}
}
