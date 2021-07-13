package svc.hotel;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;
import vo.*;

import dao.hotel.*;

public class ReplySvc {

	public int getCount(String where) {
		int rcnt = 0;
		Connection conn = getConnection();
		ReplyDao adminDao = ReplyDao.getInstance();

		adminDao.setConnection(conn);

		rcnt = adminDao.getCount(where);

		close(conn);

		return rcnt;

	}

	public ArrayList<ReplyInfo> getList(String where, String orderBy, int cpage, int psize) {

		ArrayList<ReplyInfo> list = new ArrayList<ReplyInfo>();
		Connection conn = getConnection();
		ReplyDao adminDao = ReplyDao.getInstance();
		adminDao.setConnection(conn);
		list = adminDao.getList(where, orderBy, cpage, psize);
		close(conn);

		return list;
	}

	public ReplyInfo getSelectOne(String code) {

		ReplyInfo info = null;
		Connection conn = getConnection();
		ReplyDao adminDao = ReplyDao.getInstance();
		adminDao.setConnection(conn);
		info = adminDao.getSelectOne(code);
		close(conn);

		return info;
	}

	/**
	 * 정보 저장
	 * 
	 * @param replyInfo
	 * @return
	 */
	public int insert(ReplyInfo replyInfo) {
		int result = 0;
		Connection conn = getConnection();
		ReplyDao adminDao = ReplyDao.getInstance();
		adminDao.setConnection(conn);

		result = adminDao.insert(replyInfo);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;
	}

	public int delete(String whereInDel, String del_id) {

		Connection conn = getConnection();
		ReplyDao adminDao = ReplyDao.getInstance();
		adminDao.setConnection(conn);

		int result = adminDao.delete(whereInDel, del_id);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;
	}

}
