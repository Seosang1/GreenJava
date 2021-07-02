package ctrl;
 
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*; 

import action.*;
import action.food.*;
import vo.*; 

@WebServlet("*.food")
public class FoodController extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    public FoodController() {
        super(); 
    }

   	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		// 사용자의 요청이 get이든 post든 모두 처리하는 메소드
   		request.setCharacterEncoding("utf-8");
   		
   		// ***** 해당 요청을 구분하기 위해 url을 잘라냄 *****
   		String requestUri 	= request.getRequestURI();
   		System.out.println("requestUri : " + requestUri);
   		
   		String contextPath 	= request.getContextPath();
   		System.out.println("contextPath : " + contextPath);
   		
   		String command 		= requestUri.substring(contextPath.length());
   		System.out.println("command : " + command);
   	
   		ActionForward forward = null;	
   		Action action = null;			
   	
   		// 사용자의 요청에 따라 각기 다른 action을 작업
   		switch (command) {
		case "/food_list.food":		// 음식점 리스트 
			action = new FoodListAction(); 
			break;  
		}
   		 
   		try {
   			forward = action.execute(request, response);
   			//각 요청에 따른 Action을 implements한 클래스의  execute() 메소드를 실행
   		} catch(Exception e) {
   			e.printStackTrace();
   		}
   		
   		if (forward != null) {
   			if (forward.isRedirect()) {
   				response.sendRedirect(forward.getPath());
   			} else {
   				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
   				dispatcher.forward(request, response);
   				// RequestDispatcher 를 통해 이동시키면 이동한 페이지의 URL이 변하지 않고, 
   				// 이동한 페이지로 현재 가지고 있는 request와 response 객체를 그대로 넘겨줌 
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
 
