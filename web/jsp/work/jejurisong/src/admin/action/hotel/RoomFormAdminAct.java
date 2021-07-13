package admin.action.hotel;

import javax.servlet.http.*;
import java.util.*;
import admin.svc.*;
import vo.*;

public class RoomFormAdminAct implements action.Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		
		System.out.println("aa");

	    ActionForward forward = new ActionForward();
	    forward.setPath("/admin/hotel/room_form.jsp");

	    return forward;
	}
	      
}
