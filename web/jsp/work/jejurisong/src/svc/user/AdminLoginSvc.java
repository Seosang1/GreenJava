package svc.user;

import static db.JdbcUtil.*;
import java.sql.*;

import dao.*;
import dao.user.*;
import vo.*;

public class AdminLoginSvc {
	public AdminInfo getLoginAdmin(String uid, String pwd) {
		UserAdminDao adminLoginDao = UserAdminDao.getInstance();
		Connection conn = getConnection();
		adminLoginDao.setConnection(conn);

		AdminInfo adminInfo = adminLoginDao.getLoginAdmin(uid, pwd);
		close(conn);

		return adminInfo;
	}
}