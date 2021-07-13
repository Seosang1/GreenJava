package dao.hotel;

import static db.JdbcUtil.*;
import java.util.*;
import javax.sql.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import vo.*;

public class ReserveDao {
	private static ReserveDao ReserveDao;
	private Connection conn;

	private ReserveDao() {}

	public static ReserveDao getInstance() {
		if (ReserveDao == null)
			ReserveDao = new ReserveDao();
		return ReserveDao;
	}

	public void setConnection(Connection conn) {
		System.out.println("[ReserveDao]");
		this.conn = conn;
	}

	public int getCount(String where) {

		Statement stmt = null;
		ResultSet rs = null;
		int rcnt = 0;

		try {
			String sql = " select count(*) from t_reserve_info rv "
					+ " left join t_hotel_info hotel on rv.hotel_code = hotel.hotel_code "
					+ " left join t_room_info room on rv.room_code = room.room_code " + where;
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

	public String getCode() {

		Statement stmt = null;
		ResultSet rs = null;
		String code = "";

		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd");
		Calendar c1 = Calendar.getInstance();
		String strToday = sdf.format(c1.getTime());


		try {
			String sql = "select max(rv_code) from t_reserve_info order "
					+ " where rv_code like '"+strToday+"%' "
					+ " by rv_idx desc limit 1 ";
			System.out.println("* getCode : " + sql);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next())
				code = rs.getString(1);
		} catch (Exception e) {
			System.out.println("* get getCode() Fail");
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		

		if (code == null || code.equals("") || code.equals("null")) {
			code = strToday + "001";
		} else {
			code = strToday + String.format("%03d", (Integer.parseInt(code.substring(8)) + 1));
		}

		System.out.println("* return getCode() " + code);
		return code;
	}

	public int insert(ReserveInfo ReserveInfo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String code = "";

		try {
			String sql = " insert into t_reserve_info "
					+ " ( rv_code, hotel_code, room_code, mem_id, rv_sdate, rv_edate, "
					+ "   rv_cnt, rv_price, rv_discount, rv_dis_price, "
					+ "   rv_name, rv_email, rv_phone, rv_content) "
					+ " value (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ReserveInfo.getRv_code());
			pstmt.setString(2, ReserveInfo.getHotel_code());
			pstmt.setString(3, ReserveInfo.getRoom_code());
			pstmt.setString(4, ReserveInfo.getMem_id());
			pstmt.setString(5, ReserveInfo.getRv_sdate());
			pstmt.setString(6, ReserveInfo.getRv_edate());
			pstmt.setInt(7, ReserveInfo.getRv_cnt());
			pstmt.setInt(8, ReserveInfo.getRv_price());
			pstmt.setInt(9, ReserveInfo.getRv_discount());
			pstmt.setInt(10, ReserveInfo.getRv_dis_price());
			pstmt.setString(11, ReserveInfo.getRv_name());
			pstmt.setString(12, ReserveInfo.getRv_email());
			pstmt.setString(13, ReserveInfo.getRv_phone());
			pstmt.setString(14, ReserveInfo.getRv_content());

			System.out.println("* insert : " + pstmt);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
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

			// 여행종료날짜가 오늘 날짜보다 작은 애들 (은 여행 종료 처리 되었다고 판단)
			String sql = "select count(*) from t_reserve_info where rv_code in (" + whereInDel
					+ ") and rv_edate > CURDATE() ";
			System.out.println("*  * Has Room Check : " + sql);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next())
				rcnt = rs.getInt(1);

			if (rcnt > 0) {
				sql = " update t_reserve_info set " + " rv_state ='b', " + " rv_cancel_date = now(), " + " ai_id = '"
						+ regId + "'" + " where rv_code in (" + whereInDel + ") ";
				System.out.println("* Delete  : " + sql);
				stmt = conn.createStatement();
				result = stmt.executeUpdate(sql);

				if (result > 0) {
					ret.put("result", "success");
					ret.put("msg", "취소처리가 완료되었습니다.");
				} else {
					ret.put("result", "fail");
					ret.put("msg", "취소처리가 실패되었습니다. 다시 시도해주세요.");
				}
			} else {
				ret.put("result", "fail");
				ret.put("msg", "취소할 예약 정보가 없습니다.\\n여행종료된 예약정보는 삭제할 수 없습니다.");
			}

		} catch (Exception e) {
			System.out.println("* delete Delete Error");

			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}

		return ret;
	}

	public ArrayList<ReserveInfo> getList(String where, String orderBy, int cpage, int psize) {

		ArrayList<ReserveInfo> list = new ArrayList<ReserveInfo>();
		Statement stmt = null;
		ResultSet rs = null;
		ReserveInfo info = null;
		int snum = (cpage - 1) * psize;

		try {

			String sql = " select rv.*, hotel.hotel_name, room.room_type, room.room_cnt from t_reserve_info rv "
					+ "left join t_hotel_info hotel on rv.hotel_code = hotel.hotel_code "
					+ "left join t_room_info room on rv.room_code = room.room_code " + where + orderBy;
			// -1 이 아니면 페이징 처리 (-1 : 숙박상세보기에서 보여지는 방 리스트 )
			if (psize >= 0) {
				sql += " limit " + snum + ", " + psize;
			}

			System.out.println("* getList : " + sql);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				info = new ReserveInfo();

				info.setRv_idx(rs.getInt("rv_idx"));
				info.setRv_code(rs.getString("rv_code"));
				info.setHotel_code(rs.getString("hotel_code"));
				info.setRoom_code(rs.getString("room_code"));
				info.setMem_id(rs.getString("mem_id"));
				info.setRv_sdate(rs.getString("rv_sdate"));
				info.setRv_edate(rs.getString("rv_edate"));
				info.setRv_cnt(rs.getInt("rv_cnt"));
				info.setRv_price(rs.getInt("rv_price"));
				info.setRv_discount(rs.getInt("rv_discount"));
				info.setRv_dis_price(rs.getInt("rv_dis_price"));
				info.setRv_name(rs.getString("rv_name"));
				info.setRv_email(rs.getString("rv_email"));
				info.setRv_phone(rs.getString("rv_phone"));
				info.setRv_content(rs.getString("rv_content"));
				info.setRv_payment(rs.getString("rv_payment"));
				info.setRv_agree(rs.getString("rv_agree"));
				info.setRv_date(rs.getString("rv_date"));
				info.setRv_state(rs.getString("rv_state"));
				info.setRv_cancel_date(rs.getString("rv_cancel_date"));
				info.setAi_id(rs.getString("ai_id"));
				info.setHotel_name(rs.getString("hotel_name"));
				info.setRoom_type(rs.getString("room_type"));
				info.setRoom_cnt(rs.getInt("room_cnt"));

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

	public ReserveInfo getSelectOne(String code) {
		ReserveInfo info = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			String sql = " select rv.*, hotel.hotel_name, room.room_type, room.room_cnt from t_reserve_info rv "
					+ "left join t_hotel_info hotel on rv.hotel_code = hotel.hotel_code "
					+ "left join t_room_info room on rv.room_code = room.room_code " + " where  rv_code = '" + code
					+ "' ";
			System.out.println("* getinfo >>" + sql);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				info = new ReserveInfo();

				info.setRv_idx(rs.getInt("rv_idx"));
				info.setRv_code(rs.getString("rv_code"));
				info.setHotel_code(rs.getString("hotel_code"));
				info.setRoom_code(rs.getString("room_code"));
				info.setMem_id(rs.getString("mem_id"));
				info.setRv_sdate(rs.getString("rv_sdate"));
				info.setRv_edate(rs.getString("rv_edate"));
				info.setRv_cnt(rs.getInt("rv_cnt"));
				info.setRv_price(rs.getInt("rv_price"));
				info.setRv_discount(rs.getInt("rv_discount"));
				info.setRv_dis_price(rs.getInt("rv_dis_price"));
				info.setRv_name(rs.getString("rv_name"));
				info.setRv_email(rs.getString("rv_email"));
				info.setRv_phone(rs.getString("rv_phone"));
				info.setRv_content(rs.getString("rv_content"));
				info.setRv_payment(rs.getString("rv_payment"));
				info.setRv_agree(rs.getString("rv_agree"));
				info.setRv_date(rs.getString("rv_date"));
				info.setRv_state(rs.getString("rv_state"));
				info.setRv_cancel_date(rs.getString("rv_cancel_date"));
				info.setAi_id(rs.getString("ai_id"));

				info.setHotel_name(rs.getString("hotel_name"));
				info.setRoom_type(rs.getString("room_type"));
				info.setRoom_cnt(rs.getInt("room_cnt"));

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

}
