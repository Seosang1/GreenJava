package action.admin.hotel;

import javax.servlet.http.*;
import java.util.*;

import svc.hotel.*; 
import vo.*;

/**
 * 수정 폼으로 이동
 * 폼 위에 데이터 뿌려지는 형태로 페이징, 검색조건, 코드값을 이용한 데이터 1건 의 데이터만 있음
 * @author sorakim
 *
 */
public class HotelUpFormAdminAct implements action.Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		HotelInfo info = new HotelInfo();
		Common common = new Common();
		
		request.setCharacterEncoding("utf-8");
 
		String hotel_code = request.getParameter("hotel_code");
		int cpage = 1, psize = 10, bsize = 10, spage, epage, rcnt, pcnt;
		if (request.getParameter("cpage") != null)
			cpage = Integer.parseInt(request.getParameter("cpage"));
		if (request.getParameter("psize") != null)
			psize = Integer.parseInt(request.getParameter("psize"));
		
		// 검색조건(지역, 숙소유형, 오픈여부, 숙박명) 쿼리스트링
		String area, type, open_yn, name, where = ""; 
		HashMap<String, String> schargs = new HashMap<String, String>();
		
		area	= request.getParameter("sl_area") ;		// 지역 
		type	= request.getParameter("sl_type");		// 숙소유형
		open_yn	= request.getParameter("sl_open_yn");	// 오픈여부
		name	= request.getParameter("txt_name");		// 숙박명

		System.out.println("cpage["+cpage+"] bsize[" + bsize + "] area["+area+"] type["+type+"] open_yn["+open_yn+"] name["+name+"]");
		
		// 검색 조건에 따른 where절 생성 
		if (!common.isEmpty(area)) { 
			schargs.put("area", area);
		} 
		if (!common.isEmpty(type)) { 
			schargs.put("type", type); 
		} 
		if (!common.isEmpty(open_yn)) { 
			schargs.put("open_yn", open_yn);
		} 
		if (!common.isEmpty(name)) { 
			schargs.put("name", name);
		} 
		     
		// ----- 숙박 정보 1건 가져오는 부분 ----- 
		HotelSvc hotelListAdminSvc = new HotelSvc();
		info = hotelListAdminSvc.getSelectOne(hotel_code);


		// ----- 숙박에 해당하는 방 리스트 ----- 
		where = " where room.hotel_code = '" + hotel_code + "'";
		String orderBy = " order by room_idx desc ";
		RoomSvc listAdminSvc = new RoomSvc();
		ArrayList<RoomInfo> roomList = listAdminSvc.getList(where, orderBy, 1, -1);	// 현 페이지(cpage)에서 보여줄 검색된 목록을 받아옴

		// ----- 숙박에 해당하는 후기 리스트 ----- 
		where = " where reply.hotel_code = '" + hotel_code + "'";
		orderBy = " order by room_re_idx desc ";
		ReplySvc replylistAdminSvc = new ReplySvc();
		ArrayList<ReplyInfo> replyList = replylistAdminSvc.getList(where, orderBy, 1, -1);	// 현 페이지(cpage)에서 보여줄 검색된 목록을 받아옴
 
		
		request.setAttribute("info", info); 
		request.setAttribute("roomList", roomList); 
		request.setAttribute("replyList", replyList); 
		request.setAttribute("menuPage", "hotel");
		
	    ActionForward forward = new ActionForward();
	    forward.setPath("/admin/hotel/hotel_up_form.jsp"); 

	    return forward;
	}
	      
}
