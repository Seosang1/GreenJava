package action;

import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import svc.*;
import vo.*;

public class CartUpProcAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String kind = request.getParameter("kind");	// ����(cnt) or �ɼ�(opt) ����
		String op = request.getParameter("op");		// �����̸� ������, �ɼ��̸� �ɼǰ�
		int idx = Integer.parseInt(request.getParameter("idx")); // īƮ �ε�����ȣ(PK)
		String piid = request.getParameter("piid");	// ��ǰID�� �ɼ� ����� �ʿ�

		HttpSession session = request.getSession();
		MemberInfo loginMember = (MemberInfo)session.getAttribute("loginMember");

		CartUpProcSvc cartUpProcSvc = new CartUpProcSvc();
		int result = cartUpProcSvc.cartUpdate(kind, op, idx, loginMember.getMi_id(), piid);

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(result);
		out.close();

		return null;
	}
}