package action;

import javax.servlet.http.*;
import java.util.*;
import svc.*; 
import vo.*;

public class ProductAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<ProductInfo> pdtList = new ArrayList<ProductInfo>();

		request.setCharacterEncoding("utf-8");
		int cpage = 1, psize = 4, bsize = 10, spage, epage, rcnt, pcnt;
		if (request.getParameter("cpage") != null)
			cpage = Integer.parseInt(request.getParameter("cpage"));
		if (request.getParameter("psize") != null)
			psize = Integer.parseInt(request.getParameter("psize"));
  
		
		ProductService productService = new ProductService();
		String where = " ";
		// 현 페이지(cpage)에서 보여줄 검색된 상품목록을 받아옴
		rcnt = productService.getPdtCount(where);
		pdtList = productService.getPdtList(where, cpage, psize);
		
		pcnt = rcnt / psize;
		if (rcnt % psize > 0)	pcnt++;				// 전체 페이지 수
		spage = (cpage - 1) / bsize * bsize + 1;	// 블록의 시작 페이지 번호
		epage = spage + bsize - 1;
		if (epage > pcnt)		epage = pcnt;		// 블록의 종료 페이지 번호 
		
		PageInfo pageInfo = new PageInfo();	// 페이징에 필요한 정보들을 저장할 인스턴스
		// 페이징에 필요한 정보들
		pageInfo.setCpage(cpage);		// 현재 페이지 번호
		pageInfo.setRcnt(rcnt);			// 전체 게시글 개수
		pageInfo.setPcnt(pcnt);			// 전체 페이지 개수
		pageInfo.setSpage(spage);		// 블록 시작 페이지 번호 
		pageInfo.setEpage(epage);		// 블록 종료 페이지 번호
		pageInfo.setPsize(psize);		// 페이지 크기
		pageInfo.setBsize(bsize);		// 블록 크기   
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("pdtList", pdtList);

		ActionForward forward = new ActionForward();
		forward.setPath("/product/product_list.jsp");

		return forward;
	} 
}