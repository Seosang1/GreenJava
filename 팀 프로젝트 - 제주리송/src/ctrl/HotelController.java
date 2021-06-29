package ctrl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import action.*;
import action.flight.FlightListAction;
import action.hotel.*;
import vo.*;

@WebServlet("*.hotel")
public class HotelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자의 요청이 get이든 post든 모두 처리하는 메소드
		request.setCharacterEncoding("utf-8");

		// ***** 해당 요청을 구분하기 위해 url을 잘라냄 *****
		String requestUri = request.getRequestURI();
		System.out.println("requestUri : " + requestUri);

		String contextPath = request.getContextPath();
		System.out.println("contextPath : " + contextPath);

		String command = requestUri.substring(contextPath.length());
		System.out.println("command : " + command);

		ActionForward forward = null;
		Action action = null;
 
		
		switch (command) {
			case "/hotel_list.hotel": // 호텔리스트(메인)
				action = new HotelListAction(); 
				break;

			case "/hotel_view.hotel": // 호텔 상세보기
				action = new HotelViewAction(); 
				break;
		}

		try {
			forward = action.execute(request, response);
			// 각 요청에 따른 Action을 implements한 클래스의 execute() 메소드를 실행
		} catch (Exception e) {
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
