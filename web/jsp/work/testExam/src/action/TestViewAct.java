package action;

import javax.servlet.http.*;
import java.util.*;
import svc.*;
import vo.*;

public class TestViewAct implements Action {
// Ư�� �Խñ��� �� �� ��������ִ� Ŭ����
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		// �۹�ȣ�� �ʼ��̹Ƿ� �ٷ� ���������� ��ȯ�Ͽ� �޾ƿ�

		TestViewSvc testViewSvc = new TestViewSvc();
		TestInfo article = testViewSvc.getArticle(idx);
		// Ư�� �Խñ��� �����͵��� NoticeInfo �� �ν��Ͻ� article�� ����
		
		request.setAttribute("article", article);
		// �̵��� �������� request ��ü�� �Խñ� ��ü�� ��� �Ѱ���(dispatch������� �̵��ϹǷ� request ��밡��)
		
		ActionForward forward = new ActionForward();
		forward.setPath("/test_view.jsp");
		// forward�ν��Ͻ��� redirect��������� ���� true�� �������� �ʾ����Ƿ� dispatch������� �̵���
		
		return forward;
	}
}