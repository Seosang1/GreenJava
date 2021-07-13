package ctrl.admin;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import action.*;
import action.admin.hotel.*;
import vo.*;

@WebServlet("*.replya")
public class ReplyAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ReplyAdminController() {
        super();
    }
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        
        String requestUri    = request.getRequestURI();        
        String contextPath    = request.getContextPath();       
        String command       = requestUri.substring(contextPath.length());

        System.out.println("requestUri : " + requestUri); 
   		System.out.println("contextPath : " + contextPath); 
   		System.out.println("command : " + command);
        
        ActionForward forward = null;
        Action action = null; 
        
        switch (command) {
        	case "/admin/reply_list.replya" :	 	// 府胶飘
        		action =  new ReplyListAdminAct();
        		break;     
        	case "/admin/reply_del.replya" :		// 昏力贸府
        		action =  new ReplyDelAdminAct();
        		break;     
        }
        
        try {
           forward = action.execute(request, response);
        } catch (Exception e) {
           e.printStackTrace();
        }
        
        if (forward != null) {
              if (forward.isRedirect()) {
                 response.sendRedirect(forward.getPath());
              } else {
                 RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
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
