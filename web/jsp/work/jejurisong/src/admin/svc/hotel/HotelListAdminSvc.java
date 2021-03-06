package admin.svc.hotel;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;
import vo.*;

import admin.dao.hotel.*;

public class HotelListAdminSvc { 
	
	public int getCount(String where) { 
		int rcnt = 0; 
		Connection conn = getConnection(); 
		HotelAdminDao hotelAdminDao = HotelAdminDao.getInstance();

		hotelAdminDao.setConnection(conn);

		rcnt = hotelAdminDao.getHotelCount(where);

		close(conn);

		return rcnt;
		
	}
	
	public ArrayList<HotelInfo> getList(String where, String orderBy, int cpage, int psize) {

		ArrayList<HotelInfo> list = new ArrayList<HotelInfo>();
		Connection conn = getConnection();
		HotelAdminDao hotelAdminDao = HotelAdminDao.getInstance();
		hotelAdminDao.setConnection(conn);
		list = hotelAdminDao.getHotelList(where, orderBy, cpage, psize);
		close(conn);
		
		return list;
	}

	public HotelInfo getSelectOne(String hotel_code) {

	      HotelInfo info = null;
	      Connection conn = getConnection();
	      HotelAdminDao hotelAdminDao = HotelAdminDao.getInstance();
	      hotelAdminDao.setConnection(conn); 
	      info = hotelAdminDao.getInfo(hotel_code); 

	      return info;
	}
	
}
