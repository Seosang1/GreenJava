package dao.hotel;

import static db.JdbcUtil.*;
import java.util.*;
import javax.sql.*;
import java.sql.*;
import vo.*;

public class RoomDao {
	private static RoomDao roomDao;
	private Connection conn;

	private RoomDao() { }

	public static RoomDao getInstance() {
		if (roomDao == null)
			roomDao = new RoomDao();
		return roomDao;
	}

	public void setConnection(Connection conn) {
		System.out.println("[RoomDao]");		
		this.conn = conn;
	}
 
	public int getCount(String where) {
		
		Statement stmt = null;
		ResultSet rs = null;
		int rcnt = 0;

		try {
			String sql = " select count(*) from t_room_info room left join t_hotel_info hotel on room.hotel_code = hotel.hotel_code " + where;
			System.out.println("* getCount : " + sql);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next())
				rcnt = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("* getCount() Error");
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
			String sql = "select room.*, hotel.hotel_name, rv.rv_cnt from t_room_info room left join t_hotel_info hotel on room.hotel_code = hotel.hotel_code "
					+ " left join (select room_code, count(rv_code) rv_cnt from t_reserve_info where rv_state != 'b'  group by room_code) rv  on room.room_code = rv.room_code" 
					+ where + orderBy ;
			//	-1 이 아니면 페이징 처리 (-1 : 숙박상세보기에서 보여지는 방 리스트 )
			if (psize >= 0) {
				sql += " limit " + snum + ", " + psize;	
			}
					
			System.out.println("* getList : " + sql);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				info = new RoomInfo();

				info.setRoom_idx(rs.getInt("room_idx"));
				info.setRoom_code(rs.getString("room_code")); 
				info.setHotel_code(rs.getString("hotel_code"));
				info.setRoom_type(rs.getString("room_type"));				
				info.setRoom_cnt(rs.getInt("room_cnt"));
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
				
				info.setRv_cnt(rs.getInt("rv_cnt"));

				String del_yn = "n";
				String del_id = "";
				String del_date = "";
				if(rs.getString("room_del_yn") != null) {
					del_yn = rs.getString("room_del_yn");
					del_id = rs.getString("room_del_id");
					del_date = rs.getString("room_del_date");
				}
				
				info.setRoom_del_yn(del_yn); 
				info.setRoom_del_id(del_id);
				info.setRoom_del_date(del_date);
				

				info.setHotel_name(rs.getString("hotel_name"));
				
				list.add(info); 
			}
		} catch (Exception e) {
			System.out.println("* getList() Fail");
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}

		return list;
	}


	public ArrayList<RoomInfo> getList(String where1, String where2, String orderBy) {
		
		ArrayList<RoomInfo> list = new ArrayList<RoomInfo>();
		Statement stmt = null;
		ResultSet rs = null;
		RoomInfo info = null;
		
		try { 
			String sql = "select * from t_room_info "
						+ where1   
						+ " and room_code not in (SELECT room_code FROM t_reserve_info "
						+ where2
						+ " GROUP BY room_code) " 
						+ orderBy ;
								
			System.out.println("* getList : " + sql);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				info = new RoomInfo();

				info.setRoom_idx(rs.getInt("room_idx"));
				info.setRoom_code(rs.getString("room_code")); 
				info.setHotel_code(rs.getString("hotel_code"));
				info.setRoom_type(rs.getString("room_type"));				
				info.setRoom_cnt(rs.getInt("room_cnt"));
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
				
				String del_yn = "n";
				String del_id = "";
				String del_date = "";
				if(rs.getString("room_del_yn") != null) {
					del_yn = rs.getString("room_del_yn");
					del_id = rs.getString("room_del_id");
					del_date = rs.getString("room_del_date");
				}
				
				info.setRoom_del_yn(del_yn); 
				info.setRoom_del_id(del_id);
				info.setRoom_del_date(del_date); 
				
				list.add(info); 
			}
		} catch (Exception e) {
			System.out.println("* getList() Fail");
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
			System.out.println("*  : getCode : " + sql);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next())
				code = rs.getString(1);
		} catch (Exception e) {
			System.out.println("* getCode() Fail");
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
					" (room_code, hotel_code, room_type, room_cnt, room_eq, room_svc, " +
					" room_min, room_max, room_price, room_discount, room_dis_price, " +
					" room_open_yn, room_reg_id, room_img) " +
					" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, roomInfo.getRoom_code()); 
			pstmt.setString(2, roomInfo.getHotel_code());
			pstmt.setString(3, roomInfo.getRoom_type());
			pstmt.setInt(4, roomInfo.getRoom_cnt());
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

			System.out.println("*  insert : " + pstmt);
			
			result = pstmt.executeUpdate(); 
			
		} catch(Exception e) {
			System.out.println("* insert() Fail");
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
			
			String sql = "select count(*) from t_reserve_info where room_code in (" + whereInDel + ") and rv_state != 'B' ";
			System.out.println("*  * Has Room Check : " + sql);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next())
				rcnt = rs.getInt(1);
			
			// 방 정보가 없다면 삭제(업데이트) 처리
			// 업데이트 할 때 운영정보도 종료처리 
			if ( rcnt == 0 ) {
				sql  = " update t_room_info set " +
						" room_del_yn ='y', " +
						" room_open_yn ='n', " +
						" room_del_date = now(), " + 
						" room_del_id = '" + regId + "'" + 
						" where room_code in (" + whereInDel + ") ";
				System.out.println("*  Delete  : " + sql);
				stmt = conn.createStatement();
				result = stmt.executeUpdate(sql);
				
				if (result > 0) {
					ret.put("result", "success");
					ret.put("msg", "삭제처리가 완료되었습니다.");
				} else {
					ret.put("result", "fail"); 
					ret.put("msg", "삭제처리가 실패되었습니다. 다시 시도해주세요.");
				} 
			} else {
				ret.put("result", "fail"); 
				ret.put("msg", "예약된 숙박 정보가 있습니다.\\n예약중인 방 정보가 있으면 삭제할 수 없습니다.");
			} 
			
		} catch(Exception e) {
			System.out.println("* delete Delete Error");
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}

		return ret ;
	}

	public RoomInfo getSelectOne(String code) {
				RoomInfo info = null;
				Statement stmt = null;
				ResultSet rs = null;

				try {
					String sql = "select room.*, hotel.hotel_name from t_room_info room left join t_hotel_info hotel "
							+ " on room.hotel_code = hotel.hotel_code "
							+ " where  room_code = '" + code + "' ";
					System.out.println("* getinfo : " + sql);
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					if (rs.next()) {
						info = new RoomInfo();

						info.setRoom_idx(rs.getInt("room_idx"));
						info.setRoom_code(rs.getString("room_code")); 
						info.setHotel_code(rs.getString("hotel_code"));
						info.setRoom_type(rs.getString("room_type"));				
						info.setRoom_cnt(rs.getInt("room_cnt"));
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
						info.setRoom_img(rs.getString("room_img")); 
						
						String del_yn = "n";
						String del_id = "";
						String del_date = "";
						if(rs.getString("room_del_yn") != null) {
							del_yn = rs.getString("room_del_yn");
							del_id = rs.getString("room_del_id");
							del_date = rs.getString("room_del_date");
						}
						
						info.setRoom_del_yn(del_yn); 
						info.setRoom_del_id(del_id);
						info.setRoom_del_date(del_date);
						
						info.setHotel_name(rs.getString("hotel_name"));
					}
				} catch (Exception e) {
					System.out.println("* getinfo() 메소드 오류");
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
					" room_cnt = '" + info.getRoom_cnt() + "', " +
					" room_eq = '" + info.getRoom_eq() + "', " +
					" room_svc = '" + info.getRoom_svc() + "', " +
					" room_min = '" + info.getRoom_min() + "', " +
					" room_max = '" + info.getRoom_max() + "', " +
					" room_price = '" + info.getRoom_price() + "', " +
					" room_discount = '" + info.getRoom_discount() + "', " +
					" room_dis_price = '" + info.getRoom_dis_price() + "', " ;
					if (!info.getRoom_img().equals("")) {
						sql += " room_img = '" + info.getRoom_img() + "', " ;
					}
					sql += " room_open_yn = '" + info.getRoom_open_yn() + "' " +
					" where room_code = '" + info.getRoom_code() + "'";
			System.out.println("*  update : " + sql);
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			
		} catch(Exception e) {
			System.out.println("* update() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(stmt);
		}

		return result;
	}

}
