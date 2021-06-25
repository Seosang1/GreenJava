package dao;

import static db.JdbcUtil.*;
import java.util.*;
import javax.sql.*;
import java.sql.*;
import vo.*;

public class ProductDao {
	private static ProductDao productDao;
	private Connection conn;

	private ProductDao() {
	}

	public static ProductDao getInstance() {
		if (productDao == null)
			productDao = new ProductDao();
		return productDao;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}


	public int getPdtCount(String where) {
		Statement stmt = null;
		ResultSet rs = null;
		int rcnt = 0;

		try {
			String sql = "select count(*) from TBL_PRODUCT " + where; 	
			System.out.println("getPdtCount : " + sql);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next())
				rcnt = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("getPdtCount() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}

		return rcnt;
	}

	public ArrayList<ProductInfo> getPdtList(String where, int cpage, int psize) {
		ArrayList<ProductInfo> pdtList = new ArrayList<ProductInfo>();
		Statement stmt = null;
		ResultSet rs = null;
		ProductInfo productInfo = null;
		int snum = (cpage - 1) * psize;

		try {
			String sql = "select * from TBL_PRODUCT " + where + " order by p_idx desc limit "
					+ snum + ", " + psize;
			System.out.println("getPdtList : " + sql); 
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				productInfo = new ProductInfo(); 
				 
				productInfo.setP_idx(rs.getInt("p_idx"));	
				productInfo.setP_id(rs.getString("p_id"));
				productInfo.setP_name(rs.getString("p_name"));
				productInfo.setP_img(rs.getString("p_img"));
				productInfo.setP_price(rs.getInt("p_price"));

				pdtList.add(productInfo);

			}
		} catch (Exception e) {
			System.out.println("getPdtList() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}

		return pdtList;
	}
 
}