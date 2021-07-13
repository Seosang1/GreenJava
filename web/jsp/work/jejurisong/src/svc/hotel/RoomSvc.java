package svc.hotel;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;
import vo.*;

import dao.hotel.*;

public class RoomSvc {

	public int getCount(String where) {
		int rcnt = 0;
		Connection conn = getConnection();
		RoomDao roomDao = RoomDao.getInstance();

		roomDao.setConnection(conn);

		rcnt = roomDao.getCount(where);

		close(conn);

		return rcnt;

	}

	public ArrayList<RoomInfo> getList(String where, String orderBy, int cpage, int psize) {

		ArrayList<RoomInfo> list = new ArrayList<RoomInfo>();
		Connection conn = getConnection();
		RoomDao roomDao = RoomDao.getInstance();
		roomDao.setConnection(conn);
		list = roomDao.getList(where, orderBy, cpage, psize);
		close(conn);

		return list;
	}

	public RoomInfo getSelectOne(String code) {

		RoomInfo info = null;
		Connection conn = getConnection();
		RoomDao roomDao = RoomDao.getInstance();
		roomDao.setConnection(conn);
		info = roomDao.getSelectOne(code);
		close(conn);

		return info;
	}

	public ArrayList<RoomInfo> getList(String where1, String where2, String orderBy) {

		ArrayList<RoomInfo> list = new ArrayList<RoomInfo>();
		Connection conn = getConnection();
		RoomDao roomDao = RoomDao.getInstance();
		roomDao.setConnection(conn);
		list = roomDao.getList(where1, where2, orderBy);
		close(conn);

		return list;
	}

	/**
	 * 호텔 코드 생성
	 * 
	 * @return
	 */
	public String getCode() {
		Connection conn = getConnection();
		RoomDao adminDao = RoomDao.getInstance();
		adminDao.setConnection(conn);

		String hotel_code = adminDao.getCode();

		close(conn);

		return hotel_code;
	}

	/**
	 * 호텔정보 저장
	 * 
	 * @param roomInfo
	 * @return
	 */
	public int insert(RoomInfo roomInfo) {
		int result = 0;
		Connection conn = getConnection();
		RoomDao adminDao = RoomDao.getInstance();
		adminDao.setConnection(conn);

		result = adminDao.insert(roomInfo);

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
		RoomDao adminDao = RoomDao.getInstance();
		adminDao.setConnection(conn);

		ret = adminDao.delete(whereInDel, hotelRegId);

		if (ret.get("result").equals("success"))
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return ret;
	}

	public int update(RoomInfo roomInfo) {

		int result = 0;
		Connection conn = getConnection();
		RoomDao adminDao = RoomDao.getInstance();
		adminDao.setConnection(conn);

		result = adminDao.update(roomInfo);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;
	}

}
