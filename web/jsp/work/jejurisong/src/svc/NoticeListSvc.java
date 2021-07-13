package svc;


import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;
import vo.*;

public class NoticeListSvc {
// ê²Œì‹œê¸? ëª©ë¡ ë³´ê¸°?˜ ë¹„ì¦ˆ?‹ˆ?Š¤ ë¡œì§?„ ì²˜ë¦¬?•˜?Š” ?´?˜?Š¤(? „ì²? ê²Œì‹œê¸? ê°œìˆ˜?? ?Š¹? • ?˜?´ì§??˜ ëª©ë¡?„ ì¶”ì¶œ)
	public int getArticleCount(String where) {
	// ëª©ë¡?—?„œ ë³´ì—¬ì¤? ? „ì²? ê²Œì‹œê¸??˜ ê°œìˆ˜ë¥? ë¦¬í„´?•˜?Š” ë©”ì†Œ?“œ
		int rcnt = 0;	// ? „ì²? ê²Œì‹œê¸? ê°œìˆ˜ë¥? ???¥?•  ë³??ˆ˜
		Connection conn = getConnection();	// DB?— ?—°ê²?
		NoticeDao noticeDao = NoticeDao.getInstance();
		// NoticeDao ?˜• ?¸?Š¤?„´?Š¤ë¥? getInstance()ë©”ì†Œ?“œë¥? ?†µ?•´ ?ƒ?„±
		noticeDao.setConnection(conn);
		// NoticeDao ?˜• ?¸?Š¤?„´?Š¤ noticeDao?— Connectionê°ì²´ë¥? ì§?? •
		rcnt = noticeDao.getArticleCount(where);
		// ê²Œì‹œê¸??˜ ? „ì²? ê°œìˆ˜ë¥? êµ¬í•  getArticleCount() ë©”ì†Œ?“œ ?˜¸ì¶?
		close(conn);

		return rcnt;
	}

	public ArrayList<NoticeInfo> getArticleList(String where, int cpage, int psize) {
	// ë§¤ê°œë³??ˆ˜ : ì¡°ê±´? ˆ, ?˜„?¬ ?˜?´ì§? ë²ˆí˜¸, ?˜?´ì§? ?¬ê¸°ë¡œ ê°?? ¸?˜¬ ? ˆì½”ë“œ ê°œìˆ˜ë¡? ?‚¬?š©
		ArrayList<NoticeInfo> articleList = null;
		// ê²Œì‹œê¸? ëª©ë¡?„ ?‹´?„ ArrayList ?¸?Š¤?„´?Š¤ ?„ ?–¸
		Connection conn = getConnection();
		NoticeDao noticeDao = NoticeDao.getInstance();
		noticeDao.setConnection(conn);
		articleList = noticeDao.getArticleList(where, cpage, psize);
		close(conn);

		return articleList;
	}
}
