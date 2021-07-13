package svc;


import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;
import vo.*;

public class MemberProcSvc {
	public int memberProc(MemberInfo memberInfo, String wtype) {
	// ?šŒ?› ê°??… ë°? ?ˆ˜? •?„ ?œ„?•´ DB?—°ê²? ë°? ì¿¼ë¦¬ ?‹¤?–‰ ë©”ì†Œ?“œë¥? ?˜¸ì¶œí•˜?Š” ë©”ì†Œ?“œ
		int result = 0;
		Connection conn = getConnection();
		MemberDao memberDao = MemberDao.getInstance();
		memberDao.setConnection(conn);
		if (wtype.equals("in")) {
			result = memberDao.memberJoin(memberInfo);
		} else if (wtype.equals("up")) {
			result = memberDao.memberUpdate(memberInfo);
		}

		if (result > 0)	commit(conn);	// ì¶”ê??œ ? ˆì½”ë“œ(ê°??…?œ ?šŒ?›)ê°? ?ˆ?œ¼ë©? ì¿¼ë¦¬ë¥? ? ?š©?‹œ?‚´
		else				rollback(conn);	// ì¶”ê??œ ? ˆì½”ë“œê°? ?—†?œ¼ë©?(?šŒ?› ê°??… ?‹¤?Œ¨) ?›?˜??ë¡? ?Œë¦?
		close(conn);

		return result;
	}
	
	public int memberDelete(String miid) {
	// ?šŒ?› ?ƒˆ?‡´ë¥? ?œ„?•´ DB?—°ê²? ë°? ì¿¼ë¦¬ ?‹¤?–‰ ë©”ì†Œ?“œë¥? ?˜¸ì¶œí•˜?Š” ë©”ì†Œ?“œ
		int result = 0;
		Connection conn = getConnection();
		MemberDao memberDao = MemberDao.getInstance();
		memberDao.setConnection(conn);
		result = memberDao.memberDelete(miid);

		if (result == 1)	commit(conn);	// ë³?ê²½ëœ ? ˆì½”ë“œ(?šŒ?› ?ƒˆ?‡´ ?„±ê³?)ê°? ?ˆ?œ¼ë©? ì¿¼ë¦¬ë¥? ? ?š©?‹œ?‚´
		else				rollback(conn);	// ë³?ê²½ëœ ? ˆì½”ë“œ(?šŒ?› ?ƒˆ?‡´ ?‹¤?Œ¨)ê°? ?—†?œ¼ë©? ?›?˜??ë¡? ?Œë¦?
		close(conn);

		return result;
	}
}
