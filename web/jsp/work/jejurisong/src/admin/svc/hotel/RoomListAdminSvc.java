package admin.svc.hotel;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;
import vo.*;

import admin.dao.hotel.*;

public class RoomListAdminSvc { 
	
	public int getCount(String where) { 
		int rcnt = 0; 
		Connection conn = getConnection(); 
		RoomAdminDao roomAdminDao = RoomAdminDao.getInstance();

		roomAdminDao.setConnection(conn);

		rcnt = roomAdminDao.getCount(where);

		close(conn);

		return rcnt;
		
	}
	
	public ArrayList<RoomInfo> getList(String where, String orderBy, int cpage, int psize) {

		ArrayList<RoomInfo> list = new ArrayList<RoomInfo>();
		Connection conn = getConnection();
		RoomAdminDao roomAdminDao = RoomAdminDao.getInstance();
		roomAdminDao.setConnection(conn);
		list = roomAdminDao.getList(where, orderBy, cpage, psize);
		close(conn);
		
		return list;
	}

	public RoomInfo getSelectOne(String code) {

		RoomInfo info = null;
	    Connection conn = getConnection();
	    RoomAdminDao roomAdminDao = RoomAdminDao.getInstance();
	    roomAdminDao.setConnection(conn); 
	    info = roomAdminDao.getInfo(code); 

	    return info;
	}
	
}
