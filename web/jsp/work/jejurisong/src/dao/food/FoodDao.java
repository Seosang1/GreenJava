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
			// �˻��� ��ǰ�� �� ������ �����ϴ� �޼ҵ�
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
				System.out.println("getFoodCount() �޼ҵ� ����");
				e.printStackTrace();
			} finally {
				close(rs);
				close(stmt);
			}
	
			return rcnt;
		}

	public ArrayList<FoodInfo> getFoodList(String where, String orderBy, int cpage, int psize) {
		// �˻��� ��ǰ ����� ArrayList<FoodInfo> �� �ν��Ͻ��� �����ϴ� �޼ҵ�
		ArrayList<FoodInfo> foodList = new ArrayList<FoodInfo>();
		// ��ǰ����� ������ ArrayList�� ���� ProductInfo�� �ν��Ͻ��� �����
		Statement stmt = null;
		ResultSet rs = null;
		FoodInfo foodInfo = null;
		// foodList�� ���� �������� ProductInfo�� �ν��Ͻ� ����
		int snum = (cpage - 1) * psize;
		// ������ limit ���ɿ��� �����͸� ������ ���� �ε��� ��ȣ

		try {
			String sql = "select * from t_food_info " + where + orderBy + " limit "
					+ snum + ", " + psize;
			System.out.println("getFoodList : " + sql);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				// rs�� ������ ��ǰ�� ���� ���
				foodInfo = new FoodInfo();
				// foodList�� ������ �� ��ǰ ������ ���� �ν��Ͻ� ����

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
				// �� �Խñ��� ������ ���� noticeInfo �ν��Ͻ��� articleList�� ����
			}
		} catch (Exception e) {
			System.out.println("getFoodList() �޼ҵ� ����");
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}

		return foodList;
	}  
	public FoodInfo getFoodInfo(String id) {
		// ������ id�� �ش��ϴ� Ư�� ��ǰ ������ productInfo�� �ν��Ͻ��� �����ϴ� �޼ҵ�
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
				// �޾ƿ� ���ڵ��� ��ǰ ������ ����

			}
		} catch (Exception e) {
			System.out.println("getFoodInfo() �޼ҵ� ����");
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}

		return foodInfo; 
	}
}