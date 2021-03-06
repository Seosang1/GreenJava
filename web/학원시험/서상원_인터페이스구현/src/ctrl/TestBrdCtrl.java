package ctrl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import action.*;
import vo.*;

@WebServlet("*.brd")
public class TestBrdCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public TestBrdCtrl() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
 
    	String requestUri = request.getRequestURI();
    	System.out.println(requestUri);

    	String contextPath = request.getContextPath(); 
    	String command = requestUri.substring(contextPath.length()); 
    	System.out.println(contextPath);
    	System.out.println(command);

    	ActionForward forward = null; 
    	Action action = null; 
 
    	switch (command) {
    		case "/test_list.brd" : 	 
    			action = new TestListAct(); 
    			break;
    		case "/test_view.brd" : 	 
    			action = new TestViewAct();
    			break;
    		case "/test_proc.brd" : 	 
    			action = new TestProcAct();
    			break;
    		case "/test_form.brd" : 	 
    			action = new TestFormAct();
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
