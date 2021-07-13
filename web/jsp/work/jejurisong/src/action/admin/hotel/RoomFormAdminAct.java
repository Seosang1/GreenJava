package action.admin.hotel;

import javax.servlet.http.*;

import svc.user.*;

import java.util.*;

import vo.*;

public class RoomFormAdminAct implements action.Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8"); 

		request.setAttribute("menuPage", "room");
		
	    ActionForward forward = new ActionForward();
	    forward.setPath("/admin/hotel/room_form.jsp");

	    return forward;
	}
	      
}
