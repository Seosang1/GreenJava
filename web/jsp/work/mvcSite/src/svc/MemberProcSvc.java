package svc;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;
import vo.*;

public class MemberProcSvc {
	public int memberProc(MemberInfo memberInfo, String wtype) {
	// ȸ�� ���� �� ������ ���� DB���� �� ���� ���� �޼ҵ带 ȣ���ϴ� �޼ҵ�
		int result = 0;
		Connection conn = getConnection();
		MemberDao memberDao = MemberDao.getInstance();
		memberDao.setConnection(conn);
		if (wtype.equals("in")) {
			result = memberDao.memberJoin(memberInfo);
		} else if (wtype.equals("up")) {
			result = memberDao.memberUpdate(memberInfo);
		}

		if (result == 3)	commit(conn);	// �߰��� ���ڵ�(���Ե� ȸ��)�� ������ ������ �����Ŵ
		else				rollback(conn);	// �߰��� ���ڵ尡 ������(ȸ�� ���� ����) ������� ����
		close(conn);

		return result;
	}
	
	public int memberDelete(String miid) {
	// ȸ�� Ż�� ���� DB���� �� ���� ���� �޼ҵ带 ȣ���ϴ� �޼ҵ�
		int result = 0;
		Connection conn = getConnection();
		MemberDao memberDao = MemberDao.getInstance();
		memberDao.setConnection(conn);
		result = memberDao.memberDelete(miid);

		if (result == 1)	commit(conn);	// ����� ���ڵ�(ȸ�� Ż�� ����)�� ������ ������ �����Ŵ
		else				rollback(conn);	// ����� ���ڵ�(ȸ�� Ż�� ����)�� ������ ������� ����
		close(conn);

		return result;
	}
}
