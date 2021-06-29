package dao;

import static db.JdbcUtil.*;
import java.sql.*;
import vo.*;

public class LoginDao {
// �α��� ���� ������ �����Ͽ� �����Ű�� Ŭ����
	private static LoginDao loginDao;
	// �ν��Ͻ� ����� �ƴ� Ŭ���� ����� loginDao �ν��Ͻ��� ���������ν� ���� ���� �ƴ� �ϳ��� �����ϰ� ��
	private Connection conn;
	// Ŭ���� ��ü���� Connection �ν��Ͻ� conn�� ����� �� �ְ� ��
	private LoginDao() {}
	// �ܺο��� ���������� �ν��Ͻ��� �����ϴ� ��(new Ű���� ���)�� ���� ���� private���� �⺻ �����ڸ� ����

	public static LoginDao getInstance() {
	// �ν��Ͻ��� �������ִ� �޼ҵ�� �ϳ��� �ν��Ͻ��� ������Ŵ(singleton ���)
	// DB�۾��� ���� �ϴ� Ŭ���� Ư���� ���� ���� �ν��Ͻ��� �����Ǹ� �׸�ŭ 
	// ���� ���� DB����(Connection)�� ����Ƿ� ��ü���� �ӵ� ������ ����� �־� �̱��� ����� ���
		if (loginDao == null) {
		// ����� ����� LoginDao �� �ν��Ͻ� loginDao�� null�̸�(�ν��Ͻ��� �������� �ʾ�����)
			loginDao = new LoginDao();
			// ������ loginDao �ν��Ͻ��� �����Ƿ� ���Ӱ� �ϳ� ������
		}
		return loginDao;
	}
	public void setConnection(Connection conn) {
	// LoginSvc Ŭ�������� ���� Connection��ü�� �޾� ����� conn�� ����
	// �ܺο��� Connection ��ü�� �޴� ������ DB�۾��� ���� ���� ��� 
	// Connection ��ü�� ���� �� �����ϴ� ���� ���� ���� ����� �����Ͽ� ���
		this.conn = conn;
	}
	public MemberInfo getLoginMember(String uid, String pwd) {
	// ����ڰ� �Է��� ���̵�� ��й�ȣ�� �̿��Ͽ� �α��� �� �ʿ��� ����������� �����Ͽ� MemberInfo ������ �����ϴ� �޼ҵ�
		MemberInfo loginMember = null;	// �α��� �� ����������� ������ �ν��Ͻ�
		Statement stmt = null;
		ResultSet rs = null;
		try {
		// DB���� �۾������� ��κ��� �޼ҵ尡 'throws SQLException'�� ����Ǿ� �ֱ� ������ ����ó���� �ؾ� �� 
			stmt = conn.createStatement();
			String sql = "select a.*, b.ma_idx, b.ma_zip, b.ma_addr1, b.ma_addr2 " + 
				"from t_member_info a, t_member_addr b where a.mi_id = b.mi_id and " + 
				"a.mi_id = '" + uid + "' and a.mi_pwd = '" + pwd + "' and " + 
				"a.mi_isactive = 'y' and b.ma_basic = 'y'";
			rs = stmt.executeQuery(sql);

			if (rs.next()) {	// �α��� ������
				loginMember = new MemberInfo();	// �α��� �����ÿ��� �����Ǵ� �ν��Ͻ�
				// �α��� ���нÿ��� loginMember�� ��� �ִ� ����(null)�� ���ϵǰ� ��

				loginMember.setMi_id(uid);
				loginMember.setMi_pwd(pwd);
				loginMember.setMi_name(rs.getString("mi_name"));
				loginMember.setMi_birth(rs.getString("mi_birth"));
				loginMember.setMi_gender(rs.getString("mi_gender"));
				loginMember.setMi_phone(rs.getString("mi_phone"));
				loginMember.setMi_email(rs.getString("mi_email"));
				loginMember.setMi_issns(rs.getString("mi_issns"));
				loginMember.setMi_ismail(rs.getString("mi_ismail"));
				loginMember.setMi_rebank(rs.getString("mi_rebank"));
				loginMember.setMi_account(rs.getString("mi_account"));
				loginMember.setMi_recommend(rs.getString("mi_recommend"));
				loginMember.setMi_date(rs.getString("mi_date"));
				loginMember.setMi_isactive(rs.getString("mi_isactive"));
				loginMember.setMi_lastlogin(rs.getString("mi_lastlogin"));
				loginMember.setMa_zip(rs.getString("ma_zip"));
				loginMember.setMa_addr1(rs.getString("ma_addr1"));
				loginMember.setMa_addr2(rs.getString("ma_addr2"));
				loginMember.setMi_point(rs.getInt("mi_point"));
				loginMember.setMa_idx(rs.getInt("ma_idx"));
				// MemberInfo Ŭ������ �ν��Ͻ� loginMember�� ȸ��������� �⺻�ּҸ� ����
			}

		} catch(Exception e) {
			System.out.println("getLoginMember() �޼ҵ� ����");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt);
		}

		return loginMember;
	}
}