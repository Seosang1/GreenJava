package admin.action.hotel;

import javax.servlet.http.*;
import java.util.*;
import admin.svc.*;
import vo.*;

public class HotelFormAdminAct implements action.Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");

	    ActionForward forward = new ActionForward();
	    forward.setPath("/admin/hotel/hotel_form.jsp");

	    return forward;
	}
	      
}
