package dao;

import static db.JdbcUtil.*;
import java.sql.*;
import java.util.*;
import vo.*;

public class OrderDao {
	private static OrderDao orderDao;
	private Connection conn;
	private OrderDao() {}

	public static OrderDao getInstance() {
		if (orderDao == null) {
			orderDao = new OrderDao();
		}
		return orderDao;
	}
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public ArrayList<CartInfo> getCartList(String miid) {
	// ��ٱ��Ͽ��� ������ Ư�� ȸ���� ��ٱ��� ����� �����ϴ� �޼ҵ�
		ArrayList<CartInfo> cartList = new ArrayList<CartInfo>();
		Statement stmt = null;
		ResultSet rs = null;
		CartInfo cart = null;

		try {
			String sql = "select a.*, b.pi_name, b.pi_img1, c.b_name, b.pi_option, " + 
			"b.pi_price, b.pi_stock, b.pi_discount from t_order_cart a, t_product_info b, t_brand c " + 
			"where a.pi_id = b.pi_id and b.b_id = c.b_id and b.pi_isview = 'y' and " + 
			"(b.pi_stock >= a.oc_cnt or b.pi_stock = -1) and a.mi_id = '" + miid + "'";
			System.out.println(sql);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				cart = new CartInfo();
				cart.setOc_idx(rs.getInt("oc_idx"));
				cart.setMi_id(rs.getString("mi_id"));
				cart.setOc_cnt(rs.getInt("oc_cnt"));
				cart.setOc_option(rs.getString("oc_option"));
				cart.setB_name(rs.getString("b_name"));
				cart.setPi_id(rs.getString("pi_id"));
				cart.setPi_name(rs.getString("pi_name"));
				cart.setPi_img1(rs.getString("pi_img1"));
				cart.setPi_option(rs.getString("pi_option"));
				cart.setPi_stock(rs.getInt("pi_stock"));
				int price = rs.getInt("pi_price");
				if (rs.getInt("pi_discount") > 0) {	// �������� ������
					float rate = (float)rs.getInt("pi_discount") / 100;	// ������
					price = Math.round(price - (price * rate));
					// �������� �ִ� ��ǰ�� ��� �������� ������ ������ ������
				}
				cart.setPi_price(price);

				cartList.add(cart);
			}
		} catch(Exception e) {
			System.out.println("getCartList() �޼ҵ� ����");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt);
		}

		return cartList;
	}

	public int cartInsert(CartInfo cart) {
	// ��ٱ��Ͽ� Ư�� ��ǰ�� ����ϴ� �޼ҵ�
		int result = 0;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql = "select a.oc_idx, a.oc_cnt, b.pi_stock " + 
			"from t_order_cart a, t_product_info b where a.pi_id = b.pi_id and " + 
			"a.mi_id = '" + cart.getMi_id() + "' and a.pi_id = '" + 
			cart.getPi_id() + "' and a.oc_option = '" + cart.getOc_option() + "'";
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
			// ���� �߰��Ϸ��� ��ǰ�� ������ ��ǰ�� �̹� ��ٱ��Ͽ� ���� ���
				sql = "update t_order_cart set oc_cnt = oc_cnt + " + cart.getOc_cnt() + 
				" where oc_idx = " + rs.getInt("oc_idx");
				if (rs.getInt("pi_stock") > 0)	// ����� ������(-1)�� �ƴϸ�
					sql += " and (oc_cnt + " + cart.getOc_cnt() + ") <= " + rs.getInt("pi_stock");
			} else {
				sql = "insert into t_order_cart (mi_id, pi_id, oc_option, oc_cnt) " + 
				"values ('" + cart.getMi_id() + "', '" + cart.getPi_id() + 
				"', '" + cart.getOc_option() + "', " + cart.getOc_cnt() + ")";
			}
			result = stmt.executeUpdate(sql);

		} catch(Exception e) {
			System.out.println("cartInsert() �޼ҵ� ����");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt);
		}

		return result;
	}

	public int cartUpdate(String kind, String op, int idx, String uid, String piid) {
	// ��ٱ��ϳ� ���� �� �ɼ� ���� �޼ҵ�
		Statement stmt = null;
		ResultSet rs = null;
		int result = 0;

		try {
			stmt = conn.createStatement();
			String sql = "";
			if (kind.equals("cnt")) {	// ���� ������ ���
				sql = "update t_order_cart set oc_cnt = oc_cnt " + op + " 1 " + 
					" where mi_id = '" + uid + "' and oc_idx = " + idx;
			} else {	// �ɼ� ������ ���
				sql = "select oc_idx, oc_cnt from t_order_cart where mi_id = '" + 
					uid + "' and pi_id = '" + piid + "' and oc_option = '" + op + "'";
				// ���� ȸ���� ��ٱ��� �ӿ� ������ ��ǰ�� ������ �ɼ��� �ִ��� �˻��� ����
				rs = stmt.executeQuery(sql);
				if (rs.next()) {	// ������ ��ǰ�� ������ �ɼ��� ������
					
				} else {	// ó�� ���õǴ� �ɼ��̸�
					sql = "update t_order_cart set oc_option = '" + 
						op + "' where oc_idx = " + idx;
				}
			}
			result = stmt.executeUpdate(sql);

		} catch(Exception e) {
			System.out.println("cartUpdate() �޼ҵ� ����");
			e.printStackTrace();
		} finally {
			if (kind.equals("opt"))	close(rs);	// �ɼǺ����� ��쿡�� rs�� �ݾ���
			close(stmt);
		}

		return result;
	}
}