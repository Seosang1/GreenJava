package action.tour;

import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import svc.*;
import vo.*;  

public class TourAction implements action.Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true); // dispatch가 아닌 sendRedirect 방식으로 이동
		forward.setPath("tour/.jsp");
	
		return forward;
	}
}

