package action.admin.hotel;

import javax.servlet.http.*;
  
import java.io.PrintWriter;
import java.util.*;

import svc.hotel.*;
import svc.user.*;
import vo.*;

public class ReplyDelAdminAct implements action.Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("------RoomDelAdminAct-----");
		
		request.setCharacterEncoding("utf-8");
				
		/** Form Parameter VO setting **/  
		// ���� ������ �ڵ� in ���� ���� ó���ϴ� �κ� 
		String[] arrDelCode = request.getParameter("arrCheck").split(",");
		String whereInDel = "";
		for (int i = 0; i < arrDelCode.length; i++) {
			whereInDel += ", '" + arrDelCode[i] + "'";
		} 
		whereInDel = whereInDel.substring(1);
        
		
		/** Admin id getter **/
		String adminId = "sa";
		System.out.println("������ ���̵� : " + adminId); 
		
		 
		/** ����&��� ����� �������� �κ� **/ 
		ReplySvc procAdminSvc = new ReplySvc(); 
		
		System.out.println("whereInDel : " + whereInDel);

		int result = procAdminSvc.delete(whereInDel, adminId);
		
		if (result == 0) { 
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('����ó���� �����Ͽ����ϴ�.');");
			out.println("history.back();");
			out.println("</script>");	
			out.close();
		}
 
		/** ������ �̵� **/
		ActionForward forward = new ActionForward();  
		forward.setRedirect(true);	// redirect ������� �̵��ϵ��� ����
	    forward.setPath("/jejurisong/admin/reply_list.replya");

	    return forward;
	}
	      
}
