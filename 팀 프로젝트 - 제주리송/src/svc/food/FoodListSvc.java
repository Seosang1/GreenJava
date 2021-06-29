package svc.food; 

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.food.*;
import vo.FoodInfo;
import vo.*;

public class FoodListSvc {   

		public int getFoodCount(String where) {
		// 목록에서 보여줄 전체 게시글의 개수를 리턴하는 메소드
			int rcnt = 0;	// 전체 게시글 개수를 저장할 변수
			Connection conn = getConnection();	// DB에 연결
			FoodDao foodDao = FoodDao.getInstance();
			// ProductDao 형 인스턴스를 getInstance()메소드를 통해 생성
			foodDao.setConnection(conn);
			// ProductDao 형 인스턴스 productDao에 Connection객체를 지정
			rcnt = foodDao.getFoodCount(where);
			// 게시글의 전체 개수를 구할 getArticleCount() 메소드 호출
			close(conn);

			return rcnt;
		}

		public ArrayList<FoodInfo> getFoodList(String where, String orderBy, int cpage, int psize) {
		// 검색된 상품 목록을 ArrayList<ProductInfo> 형 인스턴스로 리턴하는 메소드
			ArrayList<FoodInfo> foodList = new ArrayList<FoodInfo>();
			Connection conn = getConnection();
			FoodDao foodDao = FoodDao.getInstance();
			foodDao.setConnection(conn);
			foodList = foodDao.getFoodList(where, orderBy, cpage, psize);
			close(conn);

			return foodList;
		} 
}
