package svc.hotel;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;
import vo.*;

import dao.hotel.*;

public class ReserveSvc {

	public int getCount(String where) {
		int rcnt = 0;
		Connection conn = getConnection();
		ReserveDao dao = ReserveDao.getInstance();

		dao.setConnection(conn);

		rcnt = dao.getCount(where);

		close(conn);

		return rcnt;

	}

	public ArrayList<ReserveInfo> getList(String where, String orderBy, int cpage, int psize) {

		ArrayList<ReserveInfo> list = new ArrayList<ReserveInfo>();
		Connection conn = getConnection();
		ReserveDao dao = ReserveDao.getInstance();
		dao.setConnection(conn);
		list = dao.getList(where, orderBy, cpage, psize);
		close(conn);

		return list;
	}

	public ReserveInfo getSelectOne(String code) {

		ReserveInfo info = null;
		Connection conn = getConnection();
		ReserveDao dao = ReserveDao.getInstance();
		dao.setConnection(conn);
		info = dao.getSelectOne(code);
		close(conn);

		return info;
	}

	/**
	 * 호텔 코드 생성
	 * 
	 * @return
	 */
	public String getCode() {
		Connection conn = getConnection();
		ReserveDao dao = ReserveDao.getInstance();
		dao.setConnection(conn);

		String code = dao.getCode();

		close(conn);

		return code;
	}

	/**
	 * 호텔정보 저장
	 * 
	 * @param reserveInfo
	 * @return
	 */
	public int insert(ReserveInfo reserveInfo) {
		int result = 0;
		Connection conn = getConnection();
		ReserveDao dao = ReserveDao.getInstance();
		dao.setConnection(conn);

		result = dao.insert(reserveInfo);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;
	}

	public HashMap<String, String> delete(String whereInDel, String hotelRegId) {

		HashMap<String, String> ret = new HashMap<String, String>();

		Connection conn = getConnection();
		ReserveDao dao = ReserveDao.getInstance();
		dao.setConnection(conn);

		ret = dao.delete(whereInDel, hotelRegId);

		if (ret.get("result").equals("success"))
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return ret;
	}

}
