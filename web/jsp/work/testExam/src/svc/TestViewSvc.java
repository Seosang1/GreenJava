package svc;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;
import vo.*;

public class TestViewSvc { 
	public TestInfo getArticle(int idx) { 
		TestInfo article = null;
		Connection conn = getConnection();
		TestBrdDao testBrdDao = TestBrdDao.getInstance();
		testBrdDao.setConnection(conn);
		
		int result = testBrdDao.readCountUp(idx);	 
		if (result > 0)	commit(conn);	 
		else			rollback(conn);	  
		article = testBrdDao.getArticle(idx); 

		return article;
	}
}
