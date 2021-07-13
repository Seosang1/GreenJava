package ctrl.admin;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import svc.user.*;
import vo.*;

@WebServlet("/admin/adminLogin")
public class LoginAminCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginAminCtrl() {
		super();
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        
        String requestUri    = request.getRequestURI();        
        String contextPath    = request.getContextPath();       
        String command       = requestUri.substring(contextPath.length());

        System.out.println("requestUri : " + requestUri); 
   		System.out.println("contextPath : " + contextPath); 
   		System.out.println("command : " + command);
   		
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");  

		AdminLoginSvc adminLoginSvc = new AdminLoginSvc();
		AdminInfo adminInfo = adminLoginSvc.getLoginAdmin(uid, pwd);
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(60*60); // 60 x 60초 = 60분 = 1시

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if (adminInfo != null) {
			session.setAttribute("adminInfo", adminInfo);
			response.sendRedirect("hotel_list.hotela");
		} else {
			out.println("<script>");
			out.println("alert('로그인에 실패했습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
	}

}