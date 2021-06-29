

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/loginProc")
public class LoginProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    public LoginProc() {
        super(); 
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String idGet = request.getParameter("idGet");
		String pwGet = request.getParameter("pwGet"); 
		// ������ �̸��� ��Ʈ�� ���� ������ ����
		
		response.setContentType("text/html; charset=utf-8");
		// ����ڿ��� �����ϴ� ������ ������ ����(�±׸� ����� �� �ִ� html������ ���ڵ��� �����ڵ�� ����)
		PrintWriter out = response.getWriter();
		// ������� ��û�� ���� ������ �� �� �ְ� ���ִ� ��ü�� ����(�̿��̸� jsp�� ���� out���� ����)
		
		out.println("���̵� : " + idGet + "<br />");
		out.println("��й�ȣ : " + pwGet + "<br />");
		

		// ����ڿ��� ������
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uname = request.getParameter("uname");	// ������̸�
		String uid = request.getParameter("uid");		// ���̵�
		String e1 = request.getParameter("e1");			// �̸��� ���̵� �κ�
		String e2 = request.getParameter("e2");			// �̸��� ������ �κ�
	
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();	// ����ڿ��� ������ �غ�
	
		if (uid == null) {	// ���̵� ã���̸�
			out.println("<h3> ���̵� ã�� </h3>");
			out.println("�̸� : " + uname + "<br />");
			out.println("�̸��� : " + e1 + "@" + e2 + "<br />");
		} else {	// ��й�ȣ ã���̸�
			out.println("<h3> ��й�ȣ ã�� </h3>");
			out.println("�̸� : " + uname + "<br />");
			out.println("���̵� : " + uid + "<br />");
			out.println("�̸��� : " + e1 + "@" + e2 + "<br />");
		} 
	} 
}
