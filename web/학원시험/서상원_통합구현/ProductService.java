package svc;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;
import vo.*;

public class ProductService {
	
	
	public int getPdtCount(String where) {
	// ��Ͽ��� ������ ��ü �Խñ��� ������ �����ϴ� �޼ҵ�
		int rcnt = 0;	// ��ü �Խñ� ������ ������ ����
		Connection conn = getConnection();	// DB�� ����
		ProductDao productDao = ProductDao.getInstance();
		// NoticeDao �� �ν��Ͻ��� getInstance()�޼ҵ带 ���� ����
		productDao.setConnection(conn);
		// NoticeDao �� �ν��Ͻ� noticeDao�� Connection��ü�� ����
		rcnt = productDao.getPdtCount(where);
		// �Խñ��� ��ü ������ ���� getArticleCount() �޼ҵ� ȣ��
		close(conn);

		return rcnt;
		
	}
	
	public ArrayList<ProductInfo> getPdtList(String where, int cpage, int psize) {
		// �˻��� ��ǰ ����� ArrayList<ProductInfo> �� �ν��Ͻ��� �����ϴ� �޼ҵ�
		ArrayList<ProductInfo> pdtList = new ArrayList<ProductInfo>();
		Connection conn = getConnection();
		ProductDao productDao = ProductDao.getInstance();
		productDao.setConnection(conn);
		pdtList = productDao.getPdtList(where, cpage, psize);
		close(conn);
		
		return pdtList;
	}
	
}