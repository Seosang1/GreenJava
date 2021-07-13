package svc;


import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;
import vo.*;

public class NoticeListSvc {
// 게시�? 목록 보기?�� 비즈?��?�� 로직?�� 처리?��?�� ?��?��?��(?���? 게시�? 개수?? ?��?�� ?��?���??�� 목록?�� 추출)
	public int getArticleCount(String where) {
	// 목록?��?�� 보여�? ?���? 게시�??�� 개수�? 리턴?��?�� 메소?��
		int rcnt = 0;	// ?���? 게시�? 개수�? ???��?�� �??��
		Connection conn = getConnection();	// DB?�� ?���?
		NoticeDao noticeDao = NoticeDao.getInstance();
		// NoticeDao ?�� ?��?��?��?���? getInstance()메소?���? ?��?�� ?��?��
		noticeDao.setConnection(conn);
		// NoticeDao ?�� ?��?��?��?�� noticeDao?�� Connection객체�? �??��
		rcnt = noticeDao.getArticleCount(where);
		// 게시�??�� ?���? 개수�? 구할 getArticleCount() 메소?�� ?���?
		close(conn);

		return rcnt;
	}

	public ArrayList<NoticeInfo> getArticleList(String where, int cpage, int psize) {
	// 매개�??�� : 조건?��, ?��?�� ?��?���? 번호, ?��?���? ?��기로 �??��?�� ?��코드 개수�? ?��?��
		ArrayList<NoticeInfo> articleList = null;
		// 게시�? 목록?�� ?��?�� ArrayList ?��?��?��?�� ?��?��
		Connection conn = getConnection();
		NoticeDao noticeDao = NoticeDao.getInstance();
		noticeDao.setConnection(conn);
		articleList = noticeDao.getArticleList(where, cpage, psize);
		close(conn);

		return articleList;
	}
}
