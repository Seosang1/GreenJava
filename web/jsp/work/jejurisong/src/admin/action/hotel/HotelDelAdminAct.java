package admin.action.hotel;

import javax.servlet.http.*;
  
import java.io.PrintWriter;
import java.util.*;
import admin.svc.*;
import admin.svc.hotel.*;
import vo.*;

public class HotelDelAdminAct implements action.Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("------HotelDelAdminAct-----");
		
		request.setCharacterEncoding("utf-8");

				
		/** Form Parameter VO setting **/  
		if (request.getParameter("arrCheck") == null || request.getParameter("arrCheck").equals("")) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('�������� ������ �����Ͽ����ϴ�.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		
		// ���� ������ �ڵ� in ���� ���� ó���ϴ� �κ� 
		String[] arrDelCode = request.getParameter("arrCheck").split(",");
		String whereInDel = "";
		for (int i = 0; i < arrDelCode.length; i++) {
			whereInDel += ", '" + arrDelCode[i] + "'";
		} 
		whereInDel = whereInDel.substring(1);
       
		/** Admin id getter **/
		String hotelRegId = "sa";
		System.out.println("������ ���̵� : " + hotelRegId); 
		
		 
		/** ����&��� ����� �������� �κ� **/ 
		HotelProcAdminSvc hotelProcAdminSvc = new HotelProcAdminSvc(); 

		HashMap<String, String> ret = hotelProcAdminSvc.delete(whereInDel, hotelRegId);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('" + ret.get("msg") + "');");
		out.println("history.back();");
		out.println("</script>");

		System.out.println("result : " + ret.get("result"));
		System.out.println("msg : " + ret.get("msg"));
		
		// ���н� ������ �̵� ���� 
		if (ret.get("result").equals("fail")) out.close();
		
		/** ������ �̵� **/
		ActionForward forward = new ActionForward();  
		forward.setRedirect(true);	// redirect ������� �̵��ϵ��� ����
	    forward.setPath("/jejurisong/admin/hotel_list.hotela");

	    return forward;
	}
	      
}
