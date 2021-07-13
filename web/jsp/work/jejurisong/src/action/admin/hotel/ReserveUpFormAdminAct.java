package action.admin.hotel;

import javax.servlet.http.*;
import java.util.*;

import svc.hotel.*; 
import vo.*; 


public class ReserveUpFormAdminAct implements action.Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ReserveInfo info = new ReserveInfo();
		Common common = new Common();
		
		request.setCharacterEncoding("utf-8");
 
		String room_code = request.getParameter("room_code");
		int cpage = 1, psize = 10, bsize = 10, spage, epage, rcnt, pcnt;
		if (request.getParameter("cpage") != null)
			cpage = Integer.parseInt(request.getParameter("cpage"));
		if (request.getParameter("psize") != null)
			psize = Integer.parseInt(request.getParameter("psize"));

		// 검색조건 쿼리스트링
		String rv_code, where = ""; 
		HashMap<String, String> schargs = new HashMap<String, String>();

		rv_code		= request.getParameter("rv_code");

		// System.out.println("**page["+cpage+"] bsize[" + bsize + "] hotel_name["+hotel_name+"] room_type["+room_type+"]");
		
		// 검색 조건에 따른 where절 생성  
		if (!common.isEmpty(rv_code)) {
			where += " and rv_code like '%" + rv_code + "%'";  
			schargs.put("rv_code", rv_code); 
		}   
		if (!common.isEmpty(where)) {
			where = " where " + where.substring(4);
		}  
		 
		// ----- 숙박 정보 1건 가져오는 부분 ----- 
		ReserveSvc adminSvc = new ReserveSvc(); 
		info = adminSvc.getSelectOne(rv_code);
		    
		request.setAttribute("info", info);  
		request.setAttribute("menuPage", "reserve");
		
	    ActionForward forward = new ActionForward();
	    forward.setPath("/admin/hotel/reserve_view.jsp"); 

	    return forward;
	}
	      
}
