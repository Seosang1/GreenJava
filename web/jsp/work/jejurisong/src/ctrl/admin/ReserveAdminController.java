package ctrl.admin;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import action.*;
import action.admin.hotel.*;
import vo.*;

@WebServlet("*.reservea")
public class ReserveAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReserveAdminController() {
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
        	case "/admin/reserve_list.reservea" :	 	// 리스트
        		action =  new ReserveListAdminAct();
        		break;    
        	case "/admin/reserve_del.reservea" :		// 삭제처리
        		action =  new ReserveDelAdminAct();
        		break;    
        	case "/admin/reserve_view.reservea" :		// 상세보기 
        		action =  new ReserveUpFormAdminAct();
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
