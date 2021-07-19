package ctrl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import action.*; 
import action.hotel.*;
import vo.*;

@WebServlet("*.hotel")
public class HotelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestUri.substring(contextPath.length());
		
		System.out.println("requestUri : " + requestUri);
		System.out.println("command : " + command);

		ActionForward forward = null;
		Action action = null;
 
		
		switch (command) {
			case "/hotel_list.hotel": // ȣ�ڸ���Ʈ(����)
				action = new HotelListAction(); 
				break;

			case "/hotel_view.hotel": // ȣ�� �󼼺���
				action = new HotelViewAction(); 
				break;
		}

		try {
			forward = action.execute(request, response);
			// �� ��û�� ���� Action�� implements�� Ŭ������ execute() �޼ҵ带 ����
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
				// RequestDispatcher �� ���� �̵���Ű�� �̵��� �������� URL�� ������ �ʰ�,
				// �̵��� �������� ���� ������ �ִ� request�� response ��ü�� �״�� �Ѱ���
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