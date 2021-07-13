package dao;

import static db.JdbcUtil.*;
import javax.sql.*;
import java.sql.*;
import java.util.*;
import vo.*;

public class MemberDao {
// �쉶�썝 愿��젴 DB�옉�뾽�쓣 �떎�젣濡� 泥섎━�븯�뒗 硫붿냼�뱶�뱾�쓣 �떞�� �겢�옒�뒪
	private static MemberDao memberDao;
	private Connection conn;
	private MemberDao() {}

	public static MemberDao getInstance() {
		if (memberDao == null)	memberDao = new MemberDao();
		return memberDao;
	}
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int memberJoin(MemberInfo memberInfo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String sql = "insert into t_member_info (mi_id, mi_pwd, mi_name, " + 
				"mi_birth, mi_gender, mi_phone, mi_email, mi_issns, mi_ismail) " +
				"values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
				
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberInfo.getMi_id());
			pstmt.setString(2, memberInfo.getMi_pwd());
			pstmt.setString(3, memberInfo.getMi_name());
			pstmt.setString(4, memberInfo.getMi_birth());
			pstmt.setString(5, memberInfo.getMi_gender());
			pstmt.setString(6, memberInfo.getMi_phone());
			pstmt.setString(7, memberInfo.getMi_email());
			pstmt.setString(8, memberInfo.getMi_issns());
			pstmt.setString(9, memberInfo.getMi_ismail());
			System.out.println(pstmt);
			
			result = pstmt.executeUpdate();
			if (result > 0) {
				sql = "insert into t_member_addr (mi_id, ma_zip, ma_addr1, ma_addr2) " + 
					"values (?, ?, ? , ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memberInfo.getMi_id());
				pstmt.setString(2, memberInfo.getMa_zip());
				pstmt.setString(3, memberInfo.getMa_addr1());
				pstmt.setString(4, memberInfo.getMa_addr2());
				System.out.println(pstmt);
				result += pstmt.executeUpdate();
				
			}
		} catch(Exception e) {
			System.out.println("memberJoin() 硫붿냼�뱶 �삤瑜�");
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
	
	public int memberUpdate(MemberInfo memberInfo) {
	// �쉶�썝 �젙蹂대�� �닔�젙�븯�뒗 硫붿냼�뱶
		int result = 0;
		Statement stmt = null;

		try {
			String sql = "update t_member_info set ";
			if (!memberInfo.getMi_pwd().equals("")) {	// 鍮꾨�踰덊샇�룄 蹂�寃쎌떆
				sql += "mi_pwd = '" + memberInfo.getMi_pwd() + "', ";
			}
			sql += "mi_phone = '"	+ memberInfo.getMi_phone()	+ "', ";
			sql += "mi_email = '"	+ memberInfo.getMi_email()	+ "', ";
			sql += "mi_issns = '"	+ memberInfo.getMi_issns()	+ "', ";
			sql += "mi_ismail = '"	+ memberInfo.getMi_ismail()	+ "' ";
			sql += "where mi_id = '"+ memberInfo.getMi_id() 	+ "' ";
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);

		} catch(Exception e) {
			System.out.println("memberUpdate() 硫붿냼�뱶 �삤瑜�");
			e.printStackTrace();
		} finally {
			close(stmt);
		}

		return result + 2;
	}

	public int memberDelete(String miid) {
	// �쉶�썝�쓣 �깉�눜�떆�궎�뒗 硫붿냼�뱶
		int result = 0;
		Statement stmt = null;

		try {
			String sql = "update t_member_info set mi_isactive = 'n' " + 
				" where mi_id = '" + miid + "' ";
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);

		} catch(Exception e) {
			System.out.println("硫ㅻ쾭 �떎�삤() 硫붿냼�뱶 �삤瑜�");
			e.printStackTrace();
		} finally {
			close(stmt);
		}

		return result;
	}
}
