package action.food;

import javax.servlet.http.*; 
import java.util.*;
import java.io.*; 
import svc.food.*;
import vo.*; 

public class FoodViewAction implements action.Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<FoodInfo> foodList = new ArrayList<FoodInfo>();

		request.setCharacterEncoding("utf-8"); 
		String id = request.getParameter("id");	// ��ǰID
		int cpage = Integer.parseInt(request.getParameter("cpage")); // ���� ������ ��ȣ
		int psize = Integer.parseInt(request.getParameter("psize")); // ������ũ��&��Ϻ�����

		// �˻�����(�˻���, ��/�Һз�, �귣��, ���ݴ�) �� �������� ������Ʈ��
		String keyword, ord;
		keyword	= request.getParameter("keyword");	// �˻��� 
		ord 	= request.getParameter("ord");		// ��������

		FoodViewSvc foodViewSvc = new FoodViewSvc();
		FoodInfo foodInfo = foodViewSvc.getFoodInfo(id);

		request.setAttribute("foodInfo", foodInfo);
			
		ActionForward forward = new ActionForward();
		forward.setPath("food/food_view.jsp");
 
		return forward; 
			
		} 

}