package action;

import javax.servlet.http.*;
import java.util.*;
import svc.*;
import vo.*;

public class PdtListAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<ProductInfo> pdtList = new ArrayList<ProductInfo>();
		
		request.setCharacterEncoding("utf-8");
		int cpage = 1, psize = 12, bsize = 10, spage, epage, rcnt, pcnt;
		if (request.getParameter("cpage") != null)
			cpage = Integer.parseInt(request.getParameter("cpage"));

		// 검색조건(검색어, 대/소분류, 브랜드, 가격대) 쿼리스트링
		String keyword, bcata, scata, brand, sprice, eprice;
		keyword	= request.getParameter("keyword");	// 검색어
		bcata	= request.getParameter("bcata");	// 대분류
		scata	= request.getParameter("scata");	// 소분류
		brand	= request.getParameter("brand");	// 브랜드
		sprice	= request.getParameter("sprice");	// 가격대 중 시작 가격
		eprice	= request.getParameter("eprice");	// 가격대 중 종료 가격

		// 검색 조건에 따른 where절 생성
		String where = " where a.cs_id = c.cs_id and b.cb_id = c.cb_id and " + 
			"a.b_id = d.b_id and a.pi_isview = 'y' ";
		if (!isEmpty(keyword))	where += " and a.pi_name like '%" + keyword + "%' ";
		if (!isEmpty(bcata))	where += " and b.cb_id = '" + bcata + "' ";
		if (!isEmpty(scata))	where += " and c.cs_id = '" + scata + "' ";
		if (!isEmpty(brand))	where += " and d.b_id = '" + brand + "' ";
		if (!isEmpty(sprice))	where += " and a.pi_price >= '" + sprice + "' ";
		if (!isEmpty(eprice))	where += " and a.pi_price <= '" + eprice + "' ";

		// 정렬조건(판매량-내, 가격-오내, 등록-내(기본), 상품명-오, 리뷰-내) 쿼리스트링
		String ord = request.getParameter("ord");
		if (ord == null || ord.equals(""))	ord = "idd";	// 등록 역순으로 정렬이 기본값
		String orderBy = " order by a.pi_" + ord.substring(0, ord.length() - 1) + 
			(ord.charAt(ord.length() - 1) == 'a' ? " asc" : " desc");
		// 정렬조건에 따른 order by절 생성

		PdtListSvc pdtListSvc = new PdtListSvc();
		rcnt = pdtListSvc.getPdtCount(where);
		// 검색된 상품의 총 개수(페이지 개수를 구하기 위해 필요)

		ActionForward forward = new ActionForward();
		forward.setPath("/product/pdt_list.jsp");

		return forward;
	}

	private boolean isEmpty(String str) {	// 매개변수에 어떤 값이든 들어 있는지 여부를 검사하는 메소드
		boolean empty = true;
		if (str != null && !str.equals(""))	empty = false;
		return empty;
	}
}
