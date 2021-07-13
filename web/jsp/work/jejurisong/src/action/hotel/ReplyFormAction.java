package action.hotel;

import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import svc.*;
import vo.*; 

public class ReplyFormAction implements action.Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("hotel/hotel_list.jsp");

		return forward;
	}

}
