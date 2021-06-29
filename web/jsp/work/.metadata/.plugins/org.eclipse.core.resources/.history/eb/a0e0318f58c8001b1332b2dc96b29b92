package svc;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;
import vo.*;

public class TestProcSvc {

	public int testProc(TestInfo testInfo) {
		int result = 0;
		Connection conn = getConnection();
		TestBrdDao testBrdDao = TestBrdDao.getInstance();
		testBrdDao.setConnection(conn);
		

		result = testBrdDao.insert(testInfo);			
		
		if (result == 1)	commit(conn); 
		else				rollback(conn);	 
		close(conn);

		return result;
	} 
}