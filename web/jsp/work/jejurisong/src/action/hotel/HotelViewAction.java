package action.hotel;

import javax.servlet.http.*;

import java.text.SimpleDateFormat;
import java.util.*;
import svc.*;
import svc.hotel.*;
import vo.*;

public class HotelViewAction implements action.Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		Common comm = new Common();
		HashMap<String, String> schargs = new HashMap<String, String>();
		
		// list 에서 호텔코드 넘어옴
		// ==> ?hotel_code=A0003&area=E&sdate=2021-06-09&name=해비치&type=RST&edate=2021-07-07
		// 검색조건(지역, 숙소유형, 체크인, 체크아웃, 숙소명) 쿼리스트링
		// 다시 조회할 때는 체크인, 체크아웃 재검색, 인원수 검색 가능
		String hotel_code, area, type, sdate, edate, name;
		String cnt;
		String room_where1 = "";		// 방 조회 시 where
		String room_where2 = " and rv_state != 'b' ";		// 방 조회 시 where
		String reply_where ="";		// 후기 조회 시 where


		hotel_code	= request.getParameter("hotel_code") ;

		sdate = request.getParameter("sdate");
		edate = request.getParameter("edate");
		area = request.getParameter("area");
		name = request.getParameter("name");
		type = request.getParameter("type");
		
		// 다시 조회할때나 값 들어옴
		cnt	 = (request.getParameter("txt_cnt") == null) ? "2" : request.getParameter("txt_cnt") ;

		schargs.put("cnt",cnt);
		// 검색 조건에 따른 where절 생성 
		if (!comm.isEmpty(hotel_code)) {   
			room_where1 += " and hotel_code = '"+hotel_code+"'";
			room_where2 += " and hotel_code = '"+hotel_code+"'";
			reply_where += " and room.hotel_code = '"+hotel_code+"'";
			schargs.put("hotel_code", hotel_code);
		} 
		if (!comm.isEmpty(cnt)) {  
			room_where1 += " and room_max >= '"+cnt+"'";
			schargs.put("cnt",cnt);
		}    
		if (!comm.isEmpty(sdate) || !comm.isEmpty(edate)) { 
			room_where2 += " and (rv_sdate >= '"+sdate+"' AND rv_sdate <= '"+edate+"') or (rv_edate >= '"+sdate+"' AND rv_edate < '"+edate+"')";
			schargs.put("sdate", sdate);
			schargs.put("edate",edate);
		} 		
		if (!comm.isEmpty(room_where1)) {
			room_where1 = " where" + room_where1.substring(4); 
		}
		
		if (!comm.isEmpty(room_where2)) {
			room_where2 = " where" + room_where2.substring(4); 
		}
		
		if (!comm.isEmpty(reply_where)) {
			reply_where = " where" + reply_where.substring(4); 
		}
		
		
		
		/** 호텔 정보 가져오기 **/
		HotelSvc hotelListSvc = new HotelSvc(); 
		HotelInfo hotelInfo = hotelListSvc.getSelectOne(hotel_code); 
		
		/** 방 리스트 가져오기 **/
		String orderBy = " order by room_dis_price desc ";	// 싼 가격 순으로 정렬
		RoomSvc roomListSvc = new RoomSvc(); 
		ArrayList<RoomInfo> roomList = roomListSvc.getList(room_where1, room_where2, orderBy); 
		

		/** 후기 리스트 가져오기 **/ 
		ReplySvc replyListSvc = new ReplySvc(); 
		ArrayList<ReplyInfo> replyList = replyListSvc.getList(reply_where, orderBy, 0, -1); 
		
		request.setAttribute("schargs", 	schargs);
		request.setAttribute("hotelInfo", 	hotelInfo);  
		request.setAttribute("roomList", 	roomList);  
		request.setAttribute("replyList", 	replyList);  

		ActionForward forward = new ActionForward();
		forward.setPath("/hotel/hotel_view.jsp"); 
		
		return forward;
	}
} 
