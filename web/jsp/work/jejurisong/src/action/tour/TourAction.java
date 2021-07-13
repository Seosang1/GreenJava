package action.tour;

import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import svc.*;
import vo.*;  

public class TourAction implements action.Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true); // dispatch�� �ƴ� sendRedirect ������� �̵�
		forward.setPath("tour/.jsp");
	
		return forward;
	}
}

