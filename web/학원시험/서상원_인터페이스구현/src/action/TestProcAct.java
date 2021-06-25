  
package action;

import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import svc.*;
import vo.*;

public class TestProcAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		

		System.out.println(request.getParameter("bn_pwd"));
		System.out.println(request.getParameter("bn_writer"));
		System.out.println(request.getParameter("bn_title"));
		System.out.println(request.getParameter("bn_content"));
		int result = 0;
		TestInfo testInfo = new TestInfo();
		testInfo.setBn_writer(request.getParameter("bn_writer").trim());
		testInfo.setBn_pwd(request.getParameter("bn_pwd").trim());
		testInfo.setBn_title(request.getParameter("bn_title").trim());
		testInfo.setBn_content(request.getParameter("bn_content").trim());

		TestProcSvc testProcSvc = new TestProcSvc();

		result = testProcSvc.testProc(testInfo); 

		ActionForward forward = new ActionForward();
		forward.setRedirect(true);  
		forward.setPath("test_list.brd");

		return forward;
	}
}