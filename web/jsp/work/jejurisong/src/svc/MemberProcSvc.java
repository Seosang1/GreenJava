package svc;


import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;
import vo.*;

public class MemberProcSvc {
	public int memberProc(MemberInfo memberInfo, String wtype) {
	// ?? κ°?? λ°? ?? ? ??΄ DB?°κ²? λ°? μΏΌλ¦¬ ?€? λ©μ?λ₯? ?ΈμΆν? λ©μ?
		int result = 0;
		Connection conn = getConnection();
		MemberDao memberDao = MemberDao.getInstance();
		memberDao.setConnection(conn);
		if (wtype.equals("in")) {
			result = memberDao.memberJoin(memberInfo);
		} else if (wtype.equals("up")) {
			result = memberDao.memberUpdate(memberInfo);
		}

		if (result > 0)	commit(conn);	// μΆκ?? ? μ½λ(κ°??? ??)κ°? ??Όλ©? μΏΌλ¦¬λ₯? ? ?©??΄
		else				rollback(conn);	// μΆκ?? ? μ½λκ°? ??Όλ©?(?? κ°?? ?€?¨) ????λ‘? ?λ¦?
		close(conn);

		return result;
	}
	
	public int memberDelete(String miid) {
	// ?? ??΄λ₯? ??΄ DB?°κ²? λ°? μΏΌλ¦¬ ?€? λ©μ?λ₯? ?ΈμΆν? λ©μ?
		int result = 0;
		Connection conn = getConnection();
		MemberDao memberDao = MemberDao.getInstance();
		memberDao.setConnection(conn);
		result = memberDao.memberDelete(miid);

		if (result == 1)	commit(conn);	// λ³?κ²½λ ? μ½λ(?? ??΄ ?±κ³?)κ°? ??Όλ©? μΏΌλ¦¬λ₯? ? ?©??΄
		else				rollback(conn);	// λ³?κ²½λ ? μ½λ(?? ??΄ ?€?¨)κ°? ??Όλ©? ????λ‘? ?λ¦?
		close(conn);

		return result;
	}
}
