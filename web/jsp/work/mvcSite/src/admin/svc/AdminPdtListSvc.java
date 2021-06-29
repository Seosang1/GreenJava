package admin.svc;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminPdtListSvc {
	public ArrayList<CataBigInfo> getCataBigList() {
		ArrayList<CataBigInfo> cataBigList = null;
		Connection conn = getConnection();
		AdminPdtDao adminPdtDao = AdminPdtDao.getInstance();
		adminPdtDao.setConnection(conn);
		cataBigList = adminPdtDao.getCataBigList();
		close(conn);

		return cataBigList;
	}

	public ArrayList<CataSmallInfo> getCataSmallList() {
		ArrayList<CataSmallInfo> cataSmallList = null;
		Connection conn = getConnection();
		AdminPdtDao adminPdtDao = AdminPdtDao.getInstance();
		adminPdtDao.setConnection(conn);
		cataSmallList = adminPdtDao.getCataSmallList();
		close(conn);

		return cataSmallList;
	}

	public ArrayList<BrandInfo> getBrandList() {
		ArrayList<BrandInfo> brandList = null;
		Connection conn = getConnection();
		AdminPdtDao adminPdtDao = AdminPdtDao.getInstance();
		adminPdtDao.setConnection(conn);
		brandList = adminPdtDao.getBrandList();
		close(conn);

		return brandList;
	}

	public int getPdtCount(String where) {
		int rcnt = 0;
		Connection conn = getConnection();
		AdminPdtDao adminPdtDao = AdminPdtDao.getInstance();
		adminPdtDao.setConnection(conn);
		rcnt = adminPdtDao.getPdtCount(where);
		close(conn);

		return rcnt;
	}

	public ArrayList<ProductInfo> getPdtList(String where, String orderBy, int cpage, int psize) {
	// 검색된 상품 목록을 ArrayList<ProductInfo> 형 인스턴스로 리턴하는 메소드
		ArrayList<ProductInfo> pdtList = new ArrayList<ProductInfo>();
		Connection conn = getConnection();
		AdminPdtDao adminPdtDao = AdminPdtDao.getInstance();
		adminPdtDao.setConnection(conn);
		pdtList = adminPdtDao.getPdtList(where, orderBy, cpage, psize);
		close(conn);

		return pdtList;
	}
}
