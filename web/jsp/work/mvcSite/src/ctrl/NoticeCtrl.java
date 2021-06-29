package ctrl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import action.*;
import vo.*;

@WebServlet("*.ntc")
// url�� ���� ������ 4���ڰ� '.ntc'�� url�� ��� ���ν��� �޾� ��(��������-notice ���� ����� ��� ó��)
public class NoticeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public NoticeCtrl() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// ������� ��û�� get�̵� post�� ��� ó���ϴ� �޼ҵ�
    	request.setCharacterEncoding("utf-8");

    	// �ش� ��û�� �����ϱ� ���� url�� �߶�
    	String requestUri = request.getRequestURI();
    	// URI(�����ΰ� ������Ʈ���� �� �ּ� ���ڿ�) : /mvcSite/brd_list.ntc
    	String contextPath = request.getContextPath();
    	// URI���� ���ϸ� �κ��� ������ ���ڿ� : /mvcSite
    	String command = requestUri.substring(contextPath.length());
    	// requestUri���� contextPath�� �� ���ڿ� : /brd_list.ntc

    	ActionForward forward = null;
    	// ó�� �� �̵��� view�� �ش��ϴ� ��ũ�� �̵������ ��� ���� �ν��Ͻ�
    	Action action = null;
    	// ��� ���� ó���� �� ������ �޼ҵ�� �۾��ϱ� ���� ����� �ν��Ͻ�
    	// �������̽��̹Ƿ� �ν��Ͻ��� ������ ���� ����

    	// ������� ��û�� ���� ���� �ٸ� action�� ����
    	switch (command) {
    		case "/brd_list.ntc" : 	// �������� ��� ��û
    			action = new NoticeListAction();
    			// Action�� implements�ϴ� NoticeListActionŬ������ �̿��Ͽ� �ν��Ͻ� ����
    			break;
    		case "/brd_view.ntc" : 	// �������� ���� ��û
    			action = new NoticeViewAction();
    			break;
    		case "/brd_proc.ntc" : 	// �������� ó�� ��û
    			// action = new NoticeProcAction();
    			break;
    	}

    	try {
    		forward = action.execute(request, response);
    		// �� ��û�� ���� Action�� implements�� Ŭ������ execute()�޼ҵ带 ����
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
    			// RequestDispatcher�� ���� �̵���Ű�� �̵��� �������� URL�� ������ �ʰ�, 
    			// �̵��� �������� ���� ������ �ִ� request �� response ��ü�� �״�� �Ѱ���
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