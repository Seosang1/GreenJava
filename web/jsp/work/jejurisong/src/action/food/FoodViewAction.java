package action.food;

import javax.servlet.http.*; 
import java.util.*;
import java.io.*; 
import svc.food.*;
import vo.*; 

public class FoodViewAction implements action.Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<FoodInfo> foodList = new ArrayList<FoodInfo>();

		request.setCharacterEncoding("utf-8"); 
		String id = request.getParameter("id");	// 상품ID
		int cpage = Integer.parseInt(request.getParameter("cpage")); // 현재 페이지 번호
		int psize = Integer.parseInt(request.getParameter("psize")); // 페이지크기&목록보기방식

		// 검색조건(검색어, 대/소분류, 브랜드, 가격대) 및 정렬조건 쿼리스트링
		String keyword, ord;
		keyword	= request.getParameter("keyword");	// 검색어 
		ord 	= request.getParameter("ord");		// 정렬조건

		FoodViewSvc foodViewSvc = new FoodViewSvc();
		FoodInfo foodInfo = foodViewSvc.getFoodInfo(id);

		request.setAttribute("foodInfo", foodInfo);
			
		ActionForward forward = new ActionForward();
		forward.setPath("food/food_view.jsp");
 
		return forward; 
			
		} 

}
