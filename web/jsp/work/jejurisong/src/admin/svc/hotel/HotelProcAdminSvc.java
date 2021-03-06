package admin.svc.hotel;

import static db.JdbcUtil.*;
import java.util.*;

import admin.dao.hotel.*;

import java.sql.*;
import dao.*;
import vo.*;

public class HotelProcAdminSvc {

	/**
	 * 호텔 코드 생성 
	 * @return
	 */
	public String getHotelCode() {
		Connection conn = getConnection();
		HotelAdminDao hotelAdminDao = HotelAdminDao.getInstance();
		hotelAdminDao.setConnection(conn);

		String hotel_code = hotelAdminDao.getHotelCode(); 
		
		close(conn);

		return hotel_code;
	}
	
	/**
	 * 호텔정보 저장
	 * @param hotelInfo
	 * @return
	 */
	public int insert(HotelInfo hotelInfo) {
		int result = 0;
		Connection conn = getConnection();
		HotelAdminDao hotelAdminDao = HotelAdminDao.getInstance();
		hotelAdminDao.setConnection(conn);

		result = hotelAdminDao.insert(hotelInfo);

		if (result > 0) commit(conn); 
		else rollback(conn);  
		
		close(conn);

		return result;
	}


	public HashMap<String, String> delete(String whereInDel, String hotelRegId) {

		System.out.println("------HotelDelAdminSVC-----");
		
		HashMap<String, String> ret = new HashMap<String, String>();

		Connection conn = getConnection();
		HotelAdminDao hotelAdminDao = HotelAdminDao.getInstance();
		hotelAdminDao.setConnection(conn);

		ret = hotelAdminDao.delete(whereInDel, hotelRegId);

		if (ret.get("result").equals("success")) commit(conn);  
		else rollback(conn);  
		
		close(conn);

		return ret;
	}

	public int update(HotelInfo hotelInfo) {

		int result = 0;
		Connection conn = getConnection();
		HotelAdminDao hotelAdminDao = HotelAdminDao.getInstance();
		hotelAdminDao.setConnection(conn);
		 
		result = hotelAdminDao.update(hotelInfo);	 

		if (result > 0) commit(conn); 
		else rollback(conn);  
		
		close(conn);

		return result;
	}

}
