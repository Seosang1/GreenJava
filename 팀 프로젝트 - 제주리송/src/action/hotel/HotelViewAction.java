package action.hotel;

import javax.servlet.http.*;
import java.util.*;
import svc.*;
import vo.*;

public class HotelViewAction implements action.Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
 
//		String schtype = request.getParameter("schtype");
//		String keyword = request.getParameter("keyword");

//		NoticeViewSvc noticeViewSvc = new NoticeViewSvc();
//		NoticeInfo article = noticeViewSvc.getArticle(idx);

//		request.setAttribute("article", article);

		ActionForward forward = new ActionForward();
		forward.setPath("/hotel/hotel_view.jsp"); 
		
		return forward;
	}
} 
