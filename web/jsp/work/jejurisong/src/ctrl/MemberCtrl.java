package ctrl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import action.*;
import vo.*;

@WebServlet("*.mem")
public class MemberCtrl extends HttpServlet {
// �쉶�썝愿��젴 �옉�뾽(媛��엯, �젙蹂댁닔�젙, �깉�눜)�쓣 泥섎━�븯�뒗 而⑦듃濡ㅻ윭
	private static final long serialVersionUID = 1L;
    public MemberCtrl() {
        super();
    }

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");

    	String requestUri = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String command = requestUri.substring(contextPath.length());

    	ActionForward forward = null;
    	Action action = null;

    	switch (command) {
    		case "/member/proc.mem" : 	// �쉶�썝 愿��젴 泥섎━�옉�뾽(媛��엯, �닔�젙, �깉�눜) �슂泥�
    			action = new MemberProcAct();
    			break;
    		case "/member/mypage.mem" :	// �쉶�썝 �젙蹂� �닔�젙 �뤌 �슂泥�
    			action = new MemberUpdateAct();
    			break;
    	}

    	try {
    		forward = action.execute(request, response);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	if (forward != null) {
    		if (forward.isRedirect()) {
    			response.sendRedirect(forward.getPath());
    		} else {
    			RequestDispatcher dispatcher = 
    				request.getRequestDispatcher(forward.getPath());
    			dispatcher.forward(request, response);
    		}
    	}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}
