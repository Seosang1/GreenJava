package action.hotel;

import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import svc.*;
import svc.hotel.HotelSvc;
import svc.hotel.ReplySvc;
import svc.hotel.ReserveSvc;
import svc.hotel.RoomSvc;
import vo.*; 

public class ReserveFormAction implements action.Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Common comm = new Common();
		HashMap<String, String> schargs = new HashMap<String, String>();
		
		// view 에서 방코드 넘어옴
		String room_code, sdate, edate, cnt, where = "";


		room_code	= request.getParameter("room_code") ;  
		sdate		= request.getParameter("sdate") ;  
		edate		= request.getParameter("edate") ;  
		cnt			= request.getParameter("cnt") ;  
		
		// 검색 조건에 따른 where절 생성  
		if (!comm.isEmpty(room_code)) {   
			where  += " and room_code = '" + room_code + "' ";   
			schargs.put("room_code", room_code);
		}
		if (!comm.isEmpty(sdate)) {  
			schargs.put("sdate", sdate);
		} 
		if (!comm.isEmpty(edate)) {  
			schargs.put("edate",edate);
		} 
		if (!comm.isEmpty(cnt)) {  
			schargs.put("cnt",cnt);
		} 
		if (!comm.isEmpty(where)) {
			where = " where " + where.substring(4);
		}  
		
		/** 방 정보 가져오기 **/
		RoomSvc roomListSvc = new RoomSvc(); 
		RoomInfo roomInfo = roomListSvc.getSelectOne(room_code); 
		 
		request.setAttribute("schargs", 	schargs);
		request.setAttribute("roomInfo", 	roomInfo);
		request.setAttribute("mem_id", 	"sora");  
		
		ActionForward forward = new ActionForward(); 
		forward.setPath("hotel/reserve_form.jsp");

		return forward;
	}

}
