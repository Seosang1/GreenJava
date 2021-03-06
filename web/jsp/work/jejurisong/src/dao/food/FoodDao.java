package dao.food;

import static db.JdbcUtil.*;
import java.util.*;
import javax.sql.*;
import java.sql.*;

import vo.*;

public class FoodDao {
	private static FoodDao foodDao;
	private Connection conn;

		private FoodDao() {
		}

		public static FoodDao getInstance() {
			if (foodDao == null)
				foodDao = new FoodDao();
			return foodDao;
		}

		public void setConnection(Connection conn) {
			this.conn = conn;
		}
 

		public int getFoodCount(String where) {
			// 검색된 상품의 총 개수를 리턴하는 메소드
			Statement stmt = null;
			ResultSet rs = null;
			int rcnt = 0;
	
			try {
				String sql = "select count(*) from t_food_info " + where;
				System.out.println("getFoodCount : " + sql);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				if (rs.next())
					rcnt = rs.getInt(1);
			} catch (Exception e) {
				System.out.println("getFoodCount() 메소드 오류");
				e.printStackTrace();
			} finally {
				close(rs);
				close(stmt);
			}
	
			return rcnt;
		}

	public ArrayList<FoodInfo> getFoodList(String where, String orderBy, int cpage, int psize) {
		// 검색된 상품 목록을 ArrayList<FoodInfo> 형 인스턴스로 리턴하는 메소드
		ArrayList<FoodInfo> foodList = new ArrayList<FoodInfo>();
		// 상품목록을 저장할 ArrayList로 오직 ProductInfo형 인스턴스만 저장됨
		Statement stmt = null;
		ResultSet rs = null;
		FoodInfo foodInfo = null;
		// foodList에 담을 데이터인 ProductInfo형 인스턴스 선언
		int snum = (cpage - 1) * psize;
		// 쿼리의 limit 명령에서 데이터를 가져올 시작 인덱스 번호

		try {
			String sql = "select * from t_food_info " + where + orderBy + " limit "
					+ snum + ", " + psize;
			System.out.println("getFoodList : " + sql);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				// rs에 보여줄 상품이 있을 경우
				foodInfo = new FoodInfo();
				// foodList에 저장할 한 상품 정보를 담을 인스턴스 생성

				foodInfo.setFood_name(rs.getString("food_name")); 
				foodInfo.setFood_idx(rs.getInt("food_idx"));
				foodInfo.setFood_code(rs.getString("food_code")); 
				foodInfo.setFood_addr(rs.getString("food_addr"));
				foodInfo.setFood_zip(rs.getString("food_zip"));
				foodInfo.setFood_tel(rs.getString("food_tel"));
				foodInfo.setFood_type(rs.getString("food_type"));
				foodInfo.setFood_area(rs.getString("food_area")); 
				foodInfo.setFood_like(rs.getInt("food_like"));
				foodInfo.setFood_open(rs.getString("food_open"));
				foodInfo.setFood_close(rs.getString("food_close"));
				foodInfo.setFood_img1(rs.getString("food_img1"));	
				foodInfo.setFood_img2(rs.getString("food_img2"));
				foodInfo.setFood_img3(rs.getString("food_img3")); 
				foodInfo.setFood_desc(rs.getString("food_desc"));
				foodInfo.setFood_review_cnt(rs.getInt("food_review_cnt"));
				foodInfo.setFood_park_yn(rs.getString("food_park_yn"));
				foodInfo.setFood_open_yn(rs.getString("food_open_yn"));
				foodInfo.setFood_detail(rs.getString("food_detail"));
				foodInfo.setFood_isview(rs.getString("food_isview"));
				foodInfo.setFood_score(rs.getFloat("food_score"));
				foodInfo.setFood_reg_id(rs.getString("food_reg_id"));
				foodInfo.setFood_reg_date(rs.getString("food_reg_date"));
				foodInfo.setFood_isadd(rs.getString("food_isadd"));
				foodInfo.setFood_del_yn(rs.getString("food_del_yn"));
				foodInfo.setFood_del_id(rs.getString("food_del_id"));
				foodInfo.setFood_del_date(rs.getString("food_del_date"));
				foodList.add(foodInfo);
				// 한 게시글의 정보를 담은 noticeInfo 인스턴스를 articleList에 저장
			}
		} catch (Exception e) {
			System.out.println("getFoodList() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}

		return foodList;
	}  
	public FoodInfo getFoodInfo(String id) {
		// 지정한 id에 해당하는 특정 상품 정보를 productInfo형 인스턴스로 리턴하는 메소드
		FoodInfo foodInfo = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from t_food_info where " +
				"food_code = '" + id + "' and (food_open_yn = 'y' or food_isview = 'y' or food_del_yn = 'n');";
			System.out.println("getFoodInfo >>" + sql);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				foodInfo = new FoodInfo(); 
				foodInfo.setFood_name(rs.getString("food_name"));
				foodInfo.setFood_idx(rs.getInt("food_idx")); 
				foodInfo.setFood_code(rs.getString("food_code"));
				foodInfo.setFood_addr(rs.getString("food_addr"));
				foodInfo.setFood_zip(rs.getString("food_zip"));
				foodInfo.setFood_tel(rs.getString("food_tel"));
				foodInfo.setFood_type(rs.getString("food_type"));
				foodInfo.setFood_area(rs.getString("food_area"));
				foodInfo.setFood_like(rs.getInt("food_like"));
				foodInfo.setFood_open(rs.getString("food_open"));
				foodInfo.setFood_close(rs.getString("food_close"));  
				foodInfo.setFood_img1(rs.getString("food_img1"));
				foodInfo.setFood_img2(rs.getString("food_img2"));
				foodInfo.setFood_img3(rs.getString("food_img3"));
				foodInfo.setFood_desc(rs.getString("food_desc"));
				foodInfo.setFood_review_cnt(rs.getInt("food_review_cnt"));
				foodInfo.setFood_park_yn(rs.getString("food_park_yn"));
				foodInfo.setFood_open_yn(rs.getString("food_open_yn"));
				foodInfo.setFood_detail(rs.getString("food_detail"));  
				foodInfo.setFood_isview(rs.getString("food_isview"));   
 
				foodInfo.setFood_score(rs.getFloat("food_score")); 
				// 받아온 레코드들로 상품 정보를 저장

			}
		} catch (Exception e) {
			System.out.println("getFoodInfo() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}

		return foodInfo; 
	}
}