package action.flight;
 
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import svc.*;
import vo.*; 

public class FlightListAction implements action.Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
 
		ActionForward forward = new ActionForward();
		forward.setRedirect(true); // dispatch가 아닌 sendRedirect 방식으로 이동
		forward.setPath("flight/flight_list.jsp");

		return forward;
	}
}
