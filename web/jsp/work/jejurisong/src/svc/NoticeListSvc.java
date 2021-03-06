package svc;


import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;
import vo.*;

public class NoticeListSvc {
// κ²μκΈ? λͺ©λ‘ λ³΄κΈ°? λΉμ¦??€ λ‘μ§? μ²λ¦¬?? ?΄??€(? μ²? κ²μκΈ? κ°μ?? ?Ή?  ??΄μ§?? λͺ©λ‘? μΆμΆ)
	public int getArticleCount(String where) {
	// λͺ©λ‘?? λ³΄μ¬μ€? ? μ²? κ²μκΈ?? κ°μλ₯? λ¦¬ν΄?? λ©μ?
		int rcnt = 0;	// ? μ²? κ²μκΈ? κ°μλ₯? ???₯?  λ³??
		Connection conn = getConnection();	// DB? ?°κ²?
		NoticeDao noticeDao = NoticeDao.getInstance();
		// NoticeDao ? ?Έ?€?΄?€λ₯? getInstance()λ©μ?λ₯? ?΅?΄ ??±
		noticeDao.setConnection(conn);
		// NoticeDao ? ?Έ?€?΄?€ noticeDao? Connectionκ°μ²΄λ₯? μ§?? 
		rcnt = noticeDao.getArticleCount(where);
		// κ²μκΈ?? ? μ²? κ°μλ₯? κ΅¬ν  getArticleCount() λ©μ? ?ΈμΆ?
		close(conn);

		return rcnt;
	}

	public ArrayList<NoticeInfo> getArticleList(String where, int cpage, int psize) {
	// λ§€κ°λ³?? : μ‘°κ±΄? , ??¬ ??΄μ§? λ²νΈ, ??΄μ§? ?¬κΈ°λ‘ κ°?? Έ?¬ ? μ½λ κ°μλ‘? ?¬?©
		ArrayList<NoticeInfo> articleList = null;
		// κ²μκΈ? λͺ©λ‘? ?΄? ArrayList ?Έ?€?΄?€ ? ?Έ
		Connection conn = getConnection();
		NoticeDao noticeDao = NoticeDao.getInstance();
		noticeDao.setConnection(conn);
		articleList = noticeDao.getArticleList(where, cpage, psize);
		close(conn);

		return articleList;
	}
}
