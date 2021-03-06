package admin.dao.hotel;

import static db.JdbcUtil.*;
import java.util.*;
import javax.sql.*;
import java.sql.*;
import vo.*;

public class RoomAdminDao {
	private static RoomAdminDao roomAdminDao;
	private Connection conn;

	private RoomAdminDao() { }

	public static RoomAdminDao getInstance() {
		if (roomAdminDao == null)
			roomAdminDao = new RoomAdminDao();
		return roomAdminDao;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}
 
	public int getCount(String where) {
		
		Statement stmt = null;
		ResultSet rs = null;
		int rcnt = 0;

		try {
			String sql = "select count(*) from t_room_info " + where;
			System.out.println("[A] getCount : " + sql);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next())
				rcnt = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("[A] getCount() Error");
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}

		return rcnt;
	}
 
	public ArrayList<RoomInfo> getList(String where, String orderBy, int cpage, int psize) {
		
		ArrayList<RoomInfo> list = new ArrayList<RoomInfo>();
		Statement stmt = null;
		ResultSet rs = null;
		RoomInfo info = null;
		int snum = (cpage - 1) * psize;

		try {
			 
			String sql = "select * from t_room_info " 
					+ where + orderBy + " limit " + snum + ", " + psize;
			System.out.println("[A] getList : " + sql);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				info = new RoomInfo();

				info.setRoom_idx(rs.getInt("room_idx"));
				info.setRoom_code(rs.getString("room_code")); 
				info.setHotel_code(rs.getString("hotel_code"));
				info.setRoom_type(rs.getString("room_type"));				
				info.setRoom_number(rs.getString("room_number"));
				info.setRoom_eq(rs.getString("room_eq"));
				info.setRoom_svc(rs.getString("room_svc"));
				info.setRoom_min(rs.getInt("room_min"));
				info.setRoom_max(rs.getInt("room_max"));
				info.setRoom_price(rs.getInt("room_price"));
				info.setRoom_discount(rs.getInt("room_discount"));
				info.setRoom_dis_price(rs.getInt("room_dis_price"));
				info.setRoom_score(rs.getDouble("room_score"));
				info.setRoom_open_yn(rs.getString("room_open_yn")); 
				info.setRoom_reg_id(rs.getString("room_reg_id"));
				info.setRoom_img(rs.getString("room_img")); 
				
				list.add(info); 
			}
		} catch (Exception e) {
			System.out.println("[A] getList() Fail");
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}

		return list;
	}

	public String getCode() {

		Statement stmt = null;
		ResultSet rs = null;
		String code = "";

		try {
			String sql = "select max(room_code) from t_room_info order by room_idx desc limit 1";
			System.out.println("[A] getCode : " + sql);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next())
				code = rs.getString(1);
		} catch (Exception e) {
			System.out.println("[A] get getCode() Fail");
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}

		if (code == null || code.equals("") || code.equals("null")) {
			code = "R0001";
		} else {
			code = "R" + String.format("%04d", (Integer.parseInt(code.substring(1)) + 1));
		}

		return code;
	}
	
	public int insert(RoomInfo roomInfo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String code = "";
		
		try {
			String sql = "INSERT INTO t_room_info " +   
					" (room_code, hotel_code, room_type, room_number, room_eq, room_svc, " +
					" room_min, room_max, room_price, room_discount, room_dis_price, " +
					" room_open_yn, room_reg_id, room_img) " +
					" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, roomInfo.getRoom_code()); 
			pstmt.setString(2, roomInfo.getHotel_code());
			pstmt.setString(3, roomInfo.getRoom_type());
			pstmt.setString(4, roomInfo.getRoom_number());
			pstmt.setString(5, roomInfo.getRoom_eq());
			pstmt.setString(6, roomInfo.getRoom_svc());
			pstmt.setInt(7, roomInfo.getRoom_min());
			pstmt.setInt(8, roomInfo.getRoom_max());
			pstmt.setInt(9, roomInfo.getRoom_price());
			pstmt.setInt(10, roomInfo.getRoom_discount());
			pstmt.setInt(11, roomInfo.getRoom_dis_price()); 
			pstmt.setString(12, roomInfo.getRoom_open_yn());
			pstmt.setString(13, roomInfo.getRoom_reg_id());
			pstmt.setString(14, roomInfo.getRoom_img()); 

			System.out.println("[A] insert : " + pstmt);
			
			result = pstmt.executeUpdate(); 
			
		} catch(Exception e) {
			System.out.println("insert() Fail");
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public HashMap<String, String> delete(String whereInDel, String regId) { 
		
		HashMap<String, String> ret = new HashMap<String, String>();

		Statement stmt = null;
		ResultSet rs = null;
		
		int rcnt = 0;
		int result = 0;  
		
		try {
			
			String sql = "select count(*) from t_reserve_info where room_code in (" + whereInDel + ") ";
			System.out.println(" * Has Room Check : " + sql);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next())
				rcnt = rs.getInt(1);
			
			// ?? ?????? ?????? ????(????????) ????
			// ???????? ?? ?? ?????????? ???????? 
			if ( rcnt == 0 ) {
				sql  = " update t_room_info set " +
						" room_del_yn ='y', " +
						" room_open_yn ='n', " +
						" room_del_date = now(), " + 
						" roomdel_id = '" + regId + "'" + 
						" where room_code in (" + whereInDel + ") ";
				System.out.println("[A] Delete  : " + sql);
				stmt = conn.createStatement();
				result = stmt.executeUpdate(sql);
				
				if (result > 0) {
					ret.put("result", "success");
					ret.put("msg", "?????????? ??????????????.");
				} else {
					ret.put("result", "fail"); 
					ret.put("msg", "?????????? ??????????????. ???? ????????????.");
				} 
			} else {
				ret.put("result", "fail"); 
				ret.put("msg", "?????? ???? ?????? ????????.\\n???????? ?? ?????? ?????? ?????? ?? ????????.");
			} 
			
		} catch(Exception e) {
			System.out.println("delete Delete Error");
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}

		return ret ;
	}

	public RoomInfo getInfo(String code) {
				RoomInfo info = null;
				Statement stmt = null;
				ResultSet rs = null;

				try {
					String sql = "select * from t_room_info where  code = '" + code + "' ";
					System.out.println("getinfo >>" + sql);
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					if (rs.next()) {
						info = new RoomInfo();

						info.setRoom_idx(rs.getInt("room_idx"));
						info.setRoom_code(rs.getString("room_code")); 
						info.setHotel_code(rs.getString("hotel_code"));
						info.setRoom_type(rs.getString("room_type"));				
						info.setRoom_number(rs.getString("room_number"));
						info.setRoom_eq(rs.getString("room_eq"));
						info.setRoom_svc(rs.getString("room_svc"));
						info.setRoom_min(rs.getInt("room_min"));
						info.setRoom_max(rs.getInt("room_max"));
						info.setRoom_price(rs.getInt("room_price"));
						info.setRoom_discount(rs.getInt("room_discount"));
						info.setRoom_dis_price(rs.getInt("room_dis_price"));
						info.setRoom_score(rs.getDouble("room_score"));
						info.setRoom_open_yn(rs.getString("room_open_yn")); 
						info.setRoom_reg_id(rs.getString("room_reg_id"));
						info.setRoom_reg_date(rs.getString("room_reg_date"));
						info.setRoom_del_yn(rs.getString("room_del_yn")); 
						info.setRoom_del_id(rs.getString("room_del_id"));
						info.setRoom_del_date(rs.getString("room_del_date"));
						info.setRoom_img(rs.getString("room_img")); 
						
					}
				} catch (Exception e) {
					System.out.println("getinfo() ?????? ????");
					e.printStackTrace();
				} finally {
					close(rs);
					close(stmt);
				}

				return info;
	}

	public int update(RoomInfo info) {

		int result = 0;
		Statement stmt = null;
		
		try {
			String sql  = "update t_room_info set " +
					" hotel_code = '" + info.getHotel_code() + "', " +
					" room_type = '" + info.getRoom_type() + "', " +
					" room_number = '" + info.getRoom_number() + "', " +
					" room_eq = '" + info.getRoom_eq() + "', " +
					" room_svc = '" + info.getRoom_svc() + "', " +
					" room_min = '" + info.getRoom_min() + "', " +
					" room_max = '" + info.getRoom_max() + "', " +
					" room_price = '" + info.getRoom_price() + "', " +
					" room_discount = '" + info.getRoom_discount() + "', " +
					" room_dis_price = '" + info.getRoom_dis_price() + "', " +
					" room_score = '" + info.getRoom_score() + "', " +
					" room_img1 = '" + info.getRoom_img() + "', " +
					" room_open_yn = '" + info.getRoom_open_yn() + "' " +
					" where room_code = '" + info.getRoom_code() + "'";
			System.out.println("[A] update : " + sql);
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			
		} catch(Exception e) {
			System.out.println("update() ?????? ????");
			e.printStackTrace();
		} finally {
			close(stmt);
		}

		return result;
	}

}
