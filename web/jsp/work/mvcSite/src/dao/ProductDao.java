package dao;

import static db.JdbcUtil.*;
import java.util.*;
import javax.sql.*;
import java.sql.*;
import vo.*;

public class ProductDao {
	private static ProductDao productDao;
	private Connection conn;
	private ProductDao() {}

	public static ProductDao getInstance() {
		if (productDao == null)	productDao = new ProductDao();
		return productDao;
	}
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public int getPdtCount(String where) {
	// �˻��� ��ǰ�� �� ������ �����ϴ� �޼ҵ�
		Statement stmt = null;
		ResultSet rs = null;
		int rcnt = 0;

		try {
			String sql = "select count(*) from t_product_info a, t_cata_big b, t_cata_small c, t_brand d " + where;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next())	rcnt = rs.getInt(1);
		} catch(Exception e) {
			System.out.println("getPdtCount() �޼ҵ� ����");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt);
		}

		return rcnt;
	}
}
