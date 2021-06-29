package svc;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;
import vo.*;

public class PdtListSvc {
	public int getPdtCount(String where) {
	// ��Ͽ��� ������ ��ü �Խñ��� ������ �����ϴ� �޼ҵ�
		int rcnt = 0;	// ��ü �Խñ� ������ ������ ����
		Connection conn = getConnection();	// DB�� ����
		ProductDao productDao = ProductDao.getInstance();
		// ProductDao �� �ν��Ͻ��� getInstance()�޼ҵ带 ���� ����
		productDao.setConnection(conn);
		// ProductDao �� �ν��Ͻ� productDao�� Connection��ü�� ����
		rcnt = productDao.getPdtCount(where);
		// �Խñ��� ��ü ������ ���� getArticleCount() �޼ҵ� ȣ��
		close(conn);

		return rcnt;
	}
}
