package action;

import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import svc.*;
import vo.*;

public class TestFormAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
 
		ActionForward forward = new ActionForward();
		forward.setRedirect(true); 
		forward.setPath("test_form.jsp");

		return forward;
	}
}