package ctrl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;	// request, response, session ���� ��ü�� ����ϱ� ����
import svc.*;
import vo.*;

@WebServlet("/login")
public class LoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginCtrl() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// post������� �����͸� ������ ��� �����ϴ� �������� �޼ҵ�
		request.setCharacterEncoding("utf-8");
		// ������� ��û���� ���� �����͵��� ���ڵ� ����� �����ڵ�� ����
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		// ����ڰ� ���� ������ ����ִ� ��Ʈ��(uid, pwd)���� ���� ���� uid, pwd�� ����

		String url = request.getParameter("url");
		// �α��� �Ŀ� �̵��� �ּҷ� ���� ��쿡�� �� ���ڿ��� ����
		if (url.equals(""))	url = "index.jsp";
		// �α��� �Ŀ� �̵��� �ּҷ� ���� ��쿡�� index ȭ������ �̵��ϵ��� �ּҸ� ����
		
		LoginSvc loginSvc = new LoginSvc();
		// �α��ο� �ʿ��� �۾��� ���� �α��� ����� �޼ҵ带 ���� Ŭ������ �ν��Ͻ� ����
		MemberInfo loginMember = loginSvc.getLoginMember(uid, pwd);
		// ����ڿ��� �Է¹��� ���̵�� ��й�ȣ�� �μ��� �Ͽ� loginSvc �ν��Ͻ���
		// getLoginMember() �޼ҵ带 �����ϰ� �� ����� MemberInfo�� �ν��Ͻ� loginMember�� ����
		// �޾ƿ� loginMember �ν��Ͻ����� �α����� ȸ���� �������� ��� ����
		// ��, �α��� ���н� loginMember �ν��Ͻ����� null���� ����ְ� ��
		
		HttpSession session = request.getSession();
		// JSP�� �ٸ��� ���� ��ü�� ����Ϸ��� ���� HttpSession �ν��Ͻ��� �����ؾ� ��
		
		response.setContentType("text/html; charset=utf-8");
		// �����ϴ� �������� Ÿ���� text�� html�� ���� - ���ڵ��� �����ڵ�� ����
		PrintWriter out = response.getWriter();

		if (loginMember != null) {	// �α��� ������
			session.setAttribute("loginMember", loginMember);
			// �α��� ���¸� �����ϰ�, �ٸ� ������������ �α��� ������ ����� �� �ֵ��� ���ǿ� ����
/*			out.println("<script>");
			out.println("location.href = 'index.jsp';");
			out.println("</script>");*/
			response.sendRedirect(url);
		} else {	// �α��� ���н�
			out.println("<script>");
			out.println("alert('�α��ο� �����߽��ϴ�.');");
			out.println("history.back();");
			out.println("</script>");
		}
	}
}