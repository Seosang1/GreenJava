package admin.svc.hotel;

import static db.JdbcUtil.*;
import java.util.*;

import admin.dao.hotel.*;

import java.sql.*;
import dao.*;
import vo.*;

public class RoomProcAdminSvc {

	/**
	 * ȣ�� �ڵ� ���� 
	 * @return
	 */
	public String getCode() {
		Connection conn = getConnection();
		RoomAdminDao adminDao = RoomAdminDao.getInstance();
		adminDao.setConnection(conn);

		String hotel_code = adminDao.getCode(); 
		
		close(conn);

		return hotel_code;
	}
	
	/**
	 * ȣ������ ����
	 * @param roomInfo
	 * @return
	 */
	public int insert(RoomInfo roomInfo) {
		int result = 0;
		Connection conn = getConnection();
		RoomAdminDao adminDao = RoomAdminDao.getInstance();
		adminDao.setConnection(conn);

		result = adminDao.insert(roomInfo);

		if (result > 0) commit(conn); 
		else rollback(conn);  
		
		close(conn);

		return result;
	}


	public HashMap<String, String> delete(String whereInDel, String hotelRegId) {

		System.out.println("------HotelDelAdminSVC-----");
		
		HashMap<String, String> ret = new HashMap<String, String>();

		Connection conn = getConnection();
		RoomAdminDao adminDao = RoomAdminDao.getInstance();
		adminDao.setConnection(conn);

		ret = adminDao.delete(whereInDel, hotelRegId);

		if (ret.get("result").equals("success")) commit(conn);  
		else rollback(conn);  
		
		close(conn);

		return ret;
	}

	public int update(RoomInfo roomInfo) {

		int result = 0;
		Connection conn = getConnection();
		RoomAdminDao adminDao = RoomAdminDao.getInstance();
		adminDao.setConnection(conn);
		 
		result = adminDao.update(roomInfo);	 

		if (result > 0) commit(conn); 
		else rollback(conn);  
		
		close(conn);

		return result;
	}

}