package ctrl.admin;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import action.*;
import admin.action.food.*;
import vo.*;

@WebServlet("*.fooda")
public class FoodAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FoodAdminController() {
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
        	case "/admin/food_list.fooda" :	 	// 음식점 리스트
        		action =  new FoodListAdminAct();
        		break;    
        	case "/admin/food_form.fooda" :		// 음식점 등록 폼
        		action =  new FoodFormAdminAct();
        		break;  
        	case "/admin/food_proc.fooda" :		// 음식점 등록 처리
        		action =  new FoodProcAdminAct();
        		break;    
        	case "/admin/food_del.fooda" :		// 음식점 삭제 처리
        		action =  new FoodDelAdminAct();
        		break;    
        	case "/admin/food_view.fooda" :		// 음식점 상세보기(수정폼) 
        		action =  new FoodUpFormAdminAct();
        		break;
        	case "/admin/food_up_proc.fooda" :	// 음식점 수정 처리
        		action =  new FoodUpProcAdminAct();
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
