package dao.hotel;

import static db.JdbcUtil.*;
import java.util.*;
import javax.sql.*;
import java.sql.*;
import vo.*;

public class ReplyDao {
	private static ReplyDao ReplyDao;
	private Connection conn;

	private ReplyDao() {}

	public static ReplyDao getInstance() {
		if (ReplyDao == null)
			ReplyDao = new ReplyDao();
		return ReplyDao;
	}

	public void setConnection(Connection conn) {
		System.out.println("[ReplyDao]");
		this.conn = conn;
	}

	public int getCount(String where) {

		Statement stmt = null;
		ResultSet rs = null;
		int rcnt = 0;

		try {
			String sql = " select count(*) from t_room_reply reply "
					+ " left join t_reserve_info rv on reply.rv_code = rv.rv_code "
					+ " left join t_hotel_info hotel on reply.hotel_code = hotel.hotel_code "
					+ " left join t_room_info room on reply.room_code = room.room_code " + where;
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

	public ArrayList<ReplyInfo> getList(String where, String orderBy, int cpage, int psize) {

		ArrayList<ReplyInfo> list = new ArrayList<ReplyInfo>();
		Statement stmt = null;
		ResultSet rs = null;
		ReplyInfo info = null;
		int snum = (cpage - 1) * psize;

		try {

			String sql = " select reply.*, hotel.hotel_name, room.room_type from t_room_reply reply "
					+ " left join t_reserve_info rv on reply.rv_code = rv.rv_code "
					+ " left join t_hotel_info hotel on reply.hotel_code = hotel.hotel_code "
					+ " left join t_room_info room on reply.room_code = room.room_code " + where + orderBy;
			// -1 이 아니면 페이징 처리 (-1 : 숙박상세보기에서 보여지는 방 리스트 )
			if (psize >= 0) {
				sql += " limit " + snum + ", " + psize;
			}

			System.out.println("* getList : " + sql);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				info = new ReplyInfo();

				info.setRoom_re_idx(rs.getInt("room_re_idx"));
				info.setRv_code(rs.getString("rv_code"));
				info.setHotel_code(rs.getString("hotel_code"));
				info.setRoom_code(rs.getString("room_code"));
				info.setMem_id(rs.getString("mem_id"));
				info.setRoom_re_content(rs.getString("room_re_content"));
				info.setRoom_re_score(rs.getDouble("room_re_score"));
				info.setRoom_re_date(rs.getString("room_re_date"));
				info.setRoom_re_del_yn(rs.getString("room_re_del_yn"));
				info.setRoom_re_del(rs.getString("room_re_del"));
				info.setRoom_re_del_id(rs.getString("room_re_del_id"));

				info.setHotel_name(rs.getString("hotel_name"));
				info.setRoom_type(rs.getString("room_type")); 

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

	public ReplyInfo getSelectOne(String code) {
		ReplyInfo info = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			String sql = " select reply.*, hotel.hotel_name, room.room_type from t_room_reply reply "
					+ " left join t_reserve_info rv on reply.rv_code = rv.rv_code "
					+ " left join t_hotel_info hotel on reply.hotel_code = hotel.hotel_code "
					+ " left join t_room_info room on reply.room_code = room.room_code " + " where  room_re_idx = "
					+ code + " ";
			System.out.println("* getinfo >>" + sql);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				info = new ReplyInfo();

				info.setRoom_re_idx(rs.getInt("room_re_idx"));
				info.setRv_code(rs.getString("rv_code"));
				info.setHotel_code(rs.getString("hotel_code"));
				info.setRoom_code(rs.getString("room_code"));
				info.setMem_id(rs.getString("mem_id"));
				info.setRoom_re_content(rs.getString("room_re_content"));
				info.setRoom_re_score(rs.getDouble("room_re_score"));
				info.setRoom_re_date(rs.getString("room_re_date"));
				info.setRoom_re_del_yn(rs.getString("room_re_del_yn"));
				info.setRoom_re_del(rs.getString("room_re_del"));
				info.setRoom_re_del_id(rs.getString("room_re_del_id"));

				info.setHotel_name(rs.getString("hotel_name"));
				info.setRoom_type(rs.getString("room_type")); 
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

	public int insert(ReplyInfo ReplyInfo) {
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			String sql = "call sp_reply_insert(?, ?, ?, ?, ?, ?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ReplyInfo.getRv_code());
			pstmt.setString(2, ReplyInfo.getHotel_code());
			pstmt.setString(3, ReplyInfo.getRoom_code());
			pstmt.setString(4, ReplyInfo.getMem_id());
			pstmt.setString(5, ReplyInfo.getRoom_re_content());
			pstmt.setDouble(6, ReplyInfo.getRoom_re_score());

			System.out.println("*  insert : " + pstmt);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("* insert() Fail");
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int delete(String whereInDel, String del_id) {

		Statement stmt = null;
		ResultSet rs = null;

		int result = 0;
		int resultT = 0;

		try {

			String[] arrRvCode = whereInDel.split(",");

			for (int i = 0; i < arrRvCode.length; i++) {
				String sql = "select hotel_code, room_code from t_room_reply where rv_code = " + arrRvCode[i];
				System.out.println("* del-hotel/room : " + sql);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					String hotel_code = rs.getString(1);
					String room_code = rs.getString(2);

					sql = "call sp_reply_delete(" + arrRvCode[i] + ", '" + hotel_code + "', '" + room_code + "', '"+ del_id + "')";
					System.out.println("* call sp_reply_delete : " + sql);
					
					result = stmt.executeUpdate(sql);

					if (result > 0)
						resultT++;
				}
			}

			if (resultT != arrRvCode.length)
				result = 0;

		} catch (Exception e) {
			System.out.println("* delete Delete Error");

			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}

		return result;
	}

}
