package admin.action.food;

import javax.servlet.http.*;

import svc.user.*;

import java.util.*;

import vo.*;

public class FoodFormAdminAct implements action.Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");

		request.setAttribute("menuPage", "food"); 

	    ActionForward forward = new ActionForward();
	    forward.setPath("/admin/food/food_form.jsp");

	    return forward;
	}
	      
}
