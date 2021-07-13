package action.admin.hotel;

import javax.servlet.http.*;
import java.util.*; 
import svc.hotel.*; 
import vo.*;

public class ReserveListAdminAct implements action.Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		
		// 필요 인스턴스 선언
		ArrayList<ReserveInfo> list = new ArrayList<ReserveInfo>();
		Common common = new Common();	// 공통코드
		
		// 페이징 처리 
		int cpage = 1, psize = 10, bsize = 10, spage, epage, rcnt, pcnt;
		if (request.getParameter("cpage") != null)
			cpage = Integer.parseInt(request.getParameter("cpage"));
		if (request.getParameter("psize") != null)
			psize = Integer.parseInt(request.getParameter("psize"));
		
		// 검색조건 쿼리스트링
		String hotel_name, room_type, rv_code, rv_sdate, rv_edate, mem_id, rv_name, rv_state, where = ""; 
		HashMap<String, String> schargs = new HashMap<String, String>();

		hotel_name	= request.getParameter("txt_hotel_name");
		room_type	= request.getParameter("sl_room_type");
		rv_code		= request.getParameter("txt_rv_code");
		rv_sdate	= request.getParameter("txt_rv_sdate");
		rv_edate	= request.getParameter("txt_rv_edate");
		mem_id		= request.getParameter("txt_mem_id");
		rv_name		= request.getParameter("txt_rv_name");
		rv_state	= request.getParameter("sl_rv_state");

		// System.out.println("**page["+cpage+"] bsize[" + bsize + "] hotel_name["+hotel_name+"] room_type["+room_type+"]");

		/*System.out.println("hotel_name : " + hotel_name);
		System.out.println("room_type : " + room_type);
		System.out.println("rv_code : " + rv_code);
		System.out.println("rv_sdate : " + rv_sdate);
		System.out.println("rv_edate : " + rv_edate);
		System.out.println("rv_code : " + rv_code);
		System.out.println("mem_id : " + mem_id);
		System.out.println("rv_name : " + rv_name);*/
		
		// 검색 조건에 따른 where절 생성 
		if (!common.isEmpty(hotel_name)) {
			where += " and hotel_name like '%" + hotel_name + "%'";  
			schargs.put("hotel_name", hotel_name);
		} 
		if (!common.isEmpty(room_type)) {
			where += " and room_type = '" + room_type + "'";  
			schargs.put("room_type", room_type); 
		}  
		if (!common.isEmpty(rv_code)) {
			where += " and rv_code like '%" + rv_code + "%'";  
			schargs.put("rv_code", rv_code); 
		}  
		if (!common.isEmpty(rv_sdate)) {
			where += " and rv_sdate >= '" + rv_sdate + "'";  
			schargs.put("rv_sdate", rv_sdate); 
		}  
		if (!common.isEmpty(rv_edate)) {
			where += " and rv_edate <= '" + rv_edate + "'";  
			schargs.put("rv_edate", rv_edate); 
		}  
		if (!common.isEmpty(mem_id)) {
			where += " and mem_id like '%" + mem_id + "%'";  
			schargs.put("mem_id", mem_id); 
		}  
		if (!common.isEmpty(rv_name)) {
			where += " and rv_name like '%" + rv_name + "%'";  
			schargs.put("rv_name", mem_id); 
		}  
		if (!common.isEmpty(rv_state)) {
			where += " and rv_state = '" + rv_state + "'";  
			schargs.put("rv_state", rv_state); 
		}  
		if (!common.isEmpty(where)) {
			where = " where " + where.substring(4);
		} 
		   
		// order by 기본 셋팅
		String orderBy = " order by rv_idx desc ";
		
		System.out.println("where : " + where);
		System.out.println("orderby : " + orderBy);
		  
		ReserveSvc listAdminSvc = new ReserveSvc();
		rcnt = listAdminSvc.getCount(where);						// 총 개수(페이지 개수를 구하기 위해 필요)
		list = listAdminSvc.getList(where, orderBy, cpage, psize);	// 현 페이지(cpage)에서 보여줄 검색된 목록을 받아옴
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
		request.setAttribute("schargs", schargs);
		request.setAttribute("list", list);
		request.setAttribute("menuPage", "reserve");
		
	    ActionForward forward = new ActionForward();
	    forward.setPath("/admin/hotel/reserve_list.jsp"); 

	    return forward;
	}
	      
}
