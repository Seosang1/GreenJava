package action.hotel;

import javax.servlet.http.*;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

import svc.*;
import svc.hotel.*;
import vo.*; 

public class HotelListAction implements action.Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		
		ArrayList<HotelInfo> hotelList = new ArrayList<HotelInfo>();
		Common comm = new Common();
		
		int cpage = 1, rcnt; 
		
		// 검색조건(지역, 숙소유형, 오픈여부, 숙박명) 쿼리스트링
		String area, type, open_yn, name, sdate, edate, where = "", whereOn = ""; 
		HashMap<String, String> schargs = new HashMap<String, String>();

		// 출발일자~도착일자가 없을 경우 오늘날짜~내일 셋팅
		if (request.getParameter("txt_sdate") == null) {
			// 날짜 셋팅
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			Calendar c1 = Calendar.getInstance(); 
			String nowDate = sdf.format(c1.getTime());
			sdate = nowDate;
			 
			c1.add(Calendar.DATE, 1);
			edate = sdf.format(c1.getTime()); 
			
		} else {
			sdate = request.getParameter("txt_sdate");
			edate = request.getParameter("txt_edate");
		}
		  
		area	= request.getParameter("sl_area") ;		// 지역 
		type	= request.getParameter("sl_type");		// 숙소유형 
		name	= request.getParameter("txt_name");		// 숙박명  
		
		// 검색 조건에 따른 where절 생성 
		if (!comm.isEmpty(area)) {
			where += " and hotel_area = '" + area + "'";  
			schargs.put("area", area);
		} 
		if (!comm.isEmpty(type)) {
			where += " and hotel_type = '" + type + "'";  
			schargs.put("type", type); 
		} 
		if (!comm.isEmpty(name)) {
			where += " and hotel_name like '%" + name + "%'";   
			schargs.put("name", name);
		} 
		if (!comm.isEmpty(sdate)) { 
			schargs.put("sdate", sdate);
		} 
		if (!comm.isEmpty(edate)) { 
			schargs.put("edate",edate);
		} 
		 
		
		where += " and hotel_open_yn = 'y'";   
		
		if (!comm.isEmpty(where)) {
			where = " where " + where.substring(4);
		} 
		   
		// order by 기본 셋팅
		String orderBy = " order by hotel_idx desc ";
		 
		HotelSvc hotelListSvc = new HotelSvc();
		rcnt = hotelListSvc.getCount(where);	// 검색된 상품의 총 개수(페이지 개수를 구하기 위해 필요)
		hotelList = hotelListSvc.getListMain(where, orderBy); 
		PageInfo pageInfo = new PageInfo();	// 페이징에 필요한 정보들을 저장할 인스턴스
		// 페이징에 필요한 정보들
		pageInfo.setCpage(cpage);		// 현재 페이지 번호 
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("schargs", schargs);
		request.setAttribute("list", hotelList);  
		
		ActionForward forward = new ActionForward(); 
		forward.setPath("hotel/hotel_list.jsp");

		return forward;
	}

}
