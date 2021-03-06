package svc;


import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;
import vo.*;

public class NoticeViewSvc {
// κ²μκΈ? λ³΄κΈ°? λΉμ¦??€ λ‘μ§? μ²λ¦¬?? ?΄??€
	public NoticeInfo getArticle(int idx) {
	// λ°μ?¨ idx? ?΄?Ή?? κ²μκΈ?? ?°?΄?°?€? NoticeInfo ? ?Έ?€?΄?€λ‘? λ¦¬ν΄?? λ©μ?
		NoticeInfo noticeInfo = null;
		Connection conn = getConnection();
		NoticeDao noticeDao = NoticeDao.getInstance();
		noticeDao.setConnection(conn);
		
		int result = noticeDao.readCountUp(idx);	// μ‘°ν? μ¦κ?
		if (result > 0)	commit(conn);	// update? ? μ½λκ°? ??Όλ©? commit ??΄
		else			rollback(conn);	// update? ? μ½λκ°? ??Όλ©? rollback ??΄
		// μ‘°ν? μ¦κ?? κ²μ? ?΄?? ?° ??₯? λ―ΈμΉμ§? ??Όλ―?λ‘? rollback ??΄? κ³μ ??? ?΄?΄κ°?

		noticeInfo = noticeDao.getArticle(idx);
		// ?¬?©?κ°? ? ?? κ²μκΈ?? ? λ³΄λ?? λ°μ?? article? ???₯

		return noticeInfo;
	}
}
