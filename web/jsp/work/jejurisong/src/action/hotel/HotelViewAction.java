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
		
		// list ���� ȣ���ڵ� �Ѿ��
		// ==> ?hotel_code=A0003&area=E&sdate=2021-06-09&name=�غ�ġ&type=RST&edate=2021-07-07
		// �˻�����(����, ��������, üũ��, üũ�ƿ�, ���Ҹ�) ������Ʈ��
		// �ٽ� ��ȸ�� ���� üũ��, üũ�ƿ� ��˻�, �ο��� �˻� ����
		String hotel_code, area, type, sdate, edate, name;
		String cnt;
		String room_where1 = "";		// �� ��ȸ �� where
		String room_where2 = " and rv_state != 'b' ";		// �� ��ȸ �� where
		String reply_where ="";		// �ı� ��ȸ �� where


		hotel_code	= request.getParameter("hotel_code") ;

		sdate = request.getParameter("sdate");
		edate = request.getParameter("edate");
		area = request.getParameter("area");
		name = request.getParameter("name");
		type = request.getParameter("type");
		
		// �ٽ� ��ȸ�Ҷ��� �� ����
		cnt	 = (request.getParameter("txt_cnt") == null) ? "2" : request.getParameter("txt_cnt") ;

		schargs.put("cnt",cnt);
		// �˻� ���ǿ� ���� where�� ���� 
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
		
		
		
		/** ȣ�� ���� �������� **/
		HotelSvc hotelListSvc = new HotelSvc(); 
		HotelInfo hotelInfo = hotelListSvc.getSelectOne(hotel_code); 
		
		/** �� ����Ʈ �������� **/
		String orderBy = " order by room_dis_price desc ";	// �� ���� ������ ����
		RoomSvc roomListSvc = new RoomSvc(); 
		ArrayList<RoomInfo> roomList = roomListSvc.getList(room_where1, room_where2, orderBy); 
		

		/** �ı� ����Ʈ �������� **/ 
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
