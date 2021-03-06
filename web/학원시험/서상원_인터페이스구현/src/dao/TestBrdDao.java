package dao;

import static db.JdbcUtil.*;
import javax.sql.*;
import java.sql.*;
import java.util.*;
import vo.*;

public class TestBrdDao { 
	private static TestBrdDao testBrdDao; 
	private Connection conn;
	private TestBrdDao() {} 

	public static TestBrdDao getInstance() {
		if (testBrdDao == null)	testBrdDao = new TestBrdDao(); 
		return testBrdDao;
	}
	public void setConnection(Connection conn) { 
		this.conn = conn; 
	}

	public int getArticleCount(String where) { 
		Statement stmt = null; 
		ResultSet rs = null;	 
		int rcnt = 0;	 

		try {
			String sql = "select count(*) from t_board" + where; 
			System.out.println(sql);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next())	rcnt = rs.getInt(1); 
			
		} catch(Exception e) {
			System.out.println("getArticleCount() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt);
		}

		return rcnt;
	}
	
	public ArrayList<TestInfo> getArticleList(String where, int cpage, int psize) {
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<TestInfo> articleList = new ArrayList<TestInfo>(); 
		TestInfo testInfo = null; 
		int snum = (cpage - 1) * psize; 

		try {
			String sql = "select * from t_board " + where + 
				" order by bn_idx desc limit " + snum + ", " + psize;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) { 
				testInfo = new TestInfo(); 

				testInfo.setBn_idx(rs.getInt("bn_idx"));
				testInfo.setBn_title(rs.getString("bn_title"));
				testInfo.setBn_pwd(rs.getString("bn_pwd"));
				testInfo.setBn_content(rs.getString("bn_content"));
				testInfo.setBn_read(rs.getInt("bn_read")); 
				testInfo.setBn_date(rs.getString("bn_date"));  
				
				articleList.add(testInfo); 
			}
		} catch(Exception e) {
			System.out.println("getArticleList() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt);
		}

		return articleList;
	}

	public int readCountUp(int idx) { 
		Statement stmt = null;
		int result = 0;
		
		try {
			String sql = "update t_board set bn_read = bn_read + 1 " +
				" where bn_idx = " + idx;
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch(Exception e) {
			System.out.println("readCountUp() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		
		return result;
	}

	public TestInfo getArticle(int idx) { 
		Statement stmt = null;
		ResultSet rs = null;
		TestInfo article = null; 

		try {
			String sql = "select * from t_board where bn_idx = " + idx;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) { 
				article = new TestInfo();

				article.setBn_idx(idx);
				article.setBn_writer(rs.getString("bn_writer"));
				article.setBn_pwd(rs.getString("bn_pwd"));
				article.setBn_title(rs.getString("bn_title"));
				article.setBn_content(rs.getString("bn_content"));
				article.setBn_read(rs.getInt("bn_read")); 
				article.setBn_date(rs.getString("bn_date"));  
			}
		} catch(Exception e) {
			System.out.println("getArticle() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt);
		}

		return article;
	}
	
	public int insert(TestInfo testInfo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = " insert into t_board (bn_writer, bn_pwd, bn_title, bn_content) values (?, ?, ?, ?);";
		try { 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, testInfo.getBn_writer());
			pstmt.setString(2, testInfo.getBn_pwd()); 
			pstmt.setString(3, testInfo.getBn_title());
			pstmt.setString(4, testInfo.getBn_content());
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("insert() 메소드 오류"); 
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println(sql);
		return result;
	}
} 
