package dao;

import static db.JdbcUtil.*;
import java.sql.*;
import vo.*;

public class LoginDao {
// 濡쒓렇�씤 愿��젴 荑쇰━瑜� �깮�꽦�븯�뿬 �떎�뻾�떆�궎�뒗 �겢�옒�뒪
	private static LoginDao loginDao;
	// �씤�뒪�꽩�뒪 硫ㅻ쾭媛� �븘�땶 �겢�옒�뒪 硫ㅻ쾭濡� loginDao �씤�뒪�꽩�뒪瑜� �꽑�뼵�븿�쑝濡쒖뜥 �뿬�윭 媛쒓� �븘�땶 �븯�굹留� 議댁옱�븯寃� �맖
	private Connection conn;
	// �겢�옒�뒪 �쟾泥댁뿉�꽌 Connection �씤�뒪�꽩�뒪 conn�쓣 �궗�슜�븷 �닔 �엳寃� �맖
	private LoginDao() {}
	// �쇅遺��뿉�꽌 吏곸젒�쟻�쑝濡� �씤�뒪�꽩�뒪瑜� �깮�꽦�븯�뒗 寃�(new �궎�썙�뱶 �궗�슜)�쓣 留됯린 �쐞�빐 private�쑝濡� 湲곕낯 �깮�꽦�옄瑜� �꽑�뼵

	public static LoginDao getInstance() {
	// �씤�뒪�꽩�뒪瑜� �깮�꽦�빐二쇰뒗 硫붿냼�뱶濡� �븯�굹�쓽 �씤�뒪�꽩�뒪留� �깮�꽦�떆�궡(singleton 諛⑹떇)
	// DB�옉�뾽�쓣 留롮씠 �븯�뒗 �겢�옒�뒪 �듅�꽦�긽 �뿬�윭 媛쒖쓽 �씤�뒪�꽩�뒪媛� �깮�꽦�릺硫� 洹몃쭔�겮 
	// 留롮� �닔�쓽 DB�뿰寃�(Connection)�씠 �깮湲곕�濡� �쟾泥댁쟻�씤 �냽�룄 ���븯�쓽 �슦�젮媛� �엳�뼱 �떛湲��넠 諛⑹떇�쓣 �궗�슜
		if (loginDao == null) {
		// 硫ㅻ쾭濡� �꽑�뼵�맂 LoginDao �삎 �씤�뒪�꽩�뒪 loginDao媛� null�씠硫�(�씤�뒪�꽩�뒪媛� �깮�꽦�릺吏� �븡�븯�쑝硫�)
			loginDao = new LoginDao();
			// �깮�꽦�맂 loginDao �씤�뒪�꽩�뒪媛� �뾾�쑝誘�濡� �깉濡�寃� �븯�굹 �깮�꽦�븿
		}
		return loginDao;
	}
	public void setConnection(Connection conn) {
	// LoginSvc �겢�옒�뒪�뿉�꽌 蹂대궦 Connection媛앹껜瑜� 諛쏆븘 硫ㅻ쾭�씤 conn�뿉 ���옣
	// �쇅遺��뿉�꽌 Connection 媛앹껜瑜� 諛쏅뒗 �씠�쑀�뒗 DB�옉�뾽�씠 �뿬�윭 踰덉씪 寃쎌슦 
	// Connection 媛앹껜瑜� �뿬�윭 踰� �깮�꽦�븯�뒗 寃껋쓣 留됯린 �쐞�빐 硫ㅻ쾭濡� 吏��젙�븯�뿬 �궗�슜
		this.conn = conn;
	}
	public MemberInfo getLoginMember(String uid, String pwd) {
	// �궗�슜�옄媛� �엯�젰�븳 �븘�씠�뵒�� 鍮꾨�踰덊샇瑜� �씠�슜�븯�뿬 濡쒓렇�씤 �썑 �븘�슂�븳 �궗�슜�옄�젙蹂대�� 異붿텧�븯�뿬 MemberInfo �삎�쑝濡� 由ы꽩�븯�뒗 硫붿냼�뱶
		MemberInfo loginMember = null;	// 濡쒓렇�씤 �썑 �궗�슜�옄�젙蹂대�� ���옣�븷 �씤�뒪�꽩�뒪
		Statement stmt = null;
		ResultSet rs = null;
		try {
		// DB愿��젴 �옉�뾽�뿉�꽌�뒗 ��遺�遺꾩쓽 硫붿냼�뱶媛� 'throws SQLException'濡� �꽑�뼵�릺�뼱 �엳湲� �븣臾몄뿉 �삁�쇅泥섎━瑜� �빐�빞 �븿 
			stmt = conn.createStatement();
			String sql = "select a.*, b.ma_idx, b.ma_zip, b.ma_addr1, b.ma_addr2 " + 
				"from t_member_info a, t_member_addr b where a.mi_id = b.mi_id and " + 
				"a.mi_id = '" + uid + "' and a.mi_pwd = '" + pwd + "' "  ;
			//System.out.print("getLoginMember : " + sql);
			rs = stmt.executeQuery(sql);

			if (rs.next()) {	// 濡쒓렇�씤 �꽦怨듭떆
				loginMember = new MemberInfo();	// 濡쒓렇�씤 �꽦怨듭떆�뿉留� �깮�꽦�릺�뒗 �씤�뒪�꽩�뒪
				// 濡쒓렇�씤 �떎�뙣�떆�뿉�뒗 loginMember媛� 鍮꾩뼱 �엳�뒗 �긽�깭(null)濡� 由ы꽩�릺寃� �븿

				loginMember.setMi_id(uid);
				loginMember.setMi_pwd(pwd);
				loginMember.setMi_name(rs.getString("mi_name"));
				loginMember.setMi_birth(rs.getString("mi_birth"));
				loginMember.setMi_gender(rs.getString("mi_gender"));
				loginMember.setMi_phone(rs.getString("mi_phone"));
				loginMember.setMi_email(rs.getString("mi_email"));
				loginMember.setMi_issns(rs.getString("mi_issns"));
				loginMember.setMi_ismail(rs.getString("mi_ismail"));
				loginMember.setMa_zip(rs.getString("ma_zip"));
				loginMember.setMa_addr1(rs.getString("ma_addr1"));
				loginMember.setMa_addr2(rs.getString("ma_addr2"));
				loginMember.setMa_idx(rs.getInt("ma_idx"));
				// MemberInfo �겢�옒�뒪�쓽 �씤�뒪�꽩�뒪 loginMember�뿉 �쉶�썝�젙蹂대뱾怨� 湲곕낯二쇱냼瑜� ���옣
			}

		} catch(Exception e) {
			System.out.println("getLoginMember() 硫붿냼�뱶 �삤瑜�");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt);
		}

		return loginMember;
	}
}
