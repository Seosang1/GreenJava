package svc.hotel;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;
import vo.*;

import dao.hotel.*;

public class HotelSvc {

	public int getCount(String where) {
		int rcnt = 0;
		Connection conn = getConnection();
		HotelDao hotelDao = HotelDao.getInstance();

		hotelDao.setConnection(conn);

		rcnt = hotelDao.getHotelCount(where);

		close(conn);

		return rcnt;

	}

	public ArrayList<HotelInfo> getList(String where, String orderBy, int cpage, int psize) {

		ArrayList<HotelInfo> list = new ArrayList<HotelInfo>();
		Connection conn = getConnection();
		HotelDao hotelDao = HotelDao.getInstance();
		hotelDao.setConnection(conn);
		list = hotelDao.getHotelList(where, orderBy, cpage, psize);
		close(conn);

		return list;
	}

	public HotelInfo getSelectOne(String hotel_code) {

		HotelInfo info = null;
		Connection conn = getConnection();
		HotelDao hotelDao = HotelDao.getInstance();
		hotelDao.setConnection(conn);
		info = hotelDao.getSelectOne(hotel_code);
		close(conn);

		return info;
	}

	public ArrayList<HotelInfo> getListMain(String where, String orderBy) {

		ArrayList<HotelInfo> list = new ArrayList<HotelInfo>();
		Connection conn = getConnection();
		HotelDao hotelDao = HotelDao.getInstance();
		hotelDao.setConnection(conn);
		list = hotelDao.getListMain(where, orderBy);
		close(conn);

		return list;
	}

	/**
	 * 호텔 코드 생성
	 * 
	 * @return
	 */
	public String getHotelCode() {
		Connection conn = getConnection();
		HotelDao hotelAdminDao = HotelDao.getInstance();
		hotelAdminDao.setConnection(conn);

		String hotel_code = hotelAdminDao.getHotelCode();

		close(conn);

		return hotel_code;
	}

	/**
	 * 호텔정보 저장
	 * 
	 * @param hotelInfo
	 * @return
	 */
	public int insert(HotelInfo hotelInfo) {
		int result = 0;
		Connection conn = getConnection();
		HotelDao hotelAdminDao = HotelDao.getInstance();
		hotelAdminDao.setConnection(conn);

		result = hotelAdminDao.insert(hotelInfo);

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
		HotelDao hotelAdminDao = HotelDao.getInstance();
		hotelAdminDao.setConnection(conn);

		ret = hotelAdminDao.delete(whereInDel, hotelRegId);

		if (ret.get("result").equals("success"))
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return ret;
	}

	public int update(HotelInfo hotelInfo) {

		int result = 0;
		Connection conn = getConnection();
		HotelDao hotelAdminDao = HotelDao.getInstance();
		hotelAdminDao.setConnection(conn);

		result = hotelAdminDao.update(hotelInfo);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;
	}
}
