package action.food;

import javax.servlet.http.*; 
import java.util.*;
import java.io.*;
import svc.food.*;
import vo.*;
import java.util.HashMap;   

public class FoodListAction implements action.Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<FoodInfo> foodList = new ArrayList<FoodInfo>();

		request.setCharacterEncoding("utf-8");
		int cpage = 1, psize = 9, bsize = 10, spage, epage, rcnt, pcnt;
		if (request.getParameter("cpage") != null)
			cpage = Integer.parseInt(request.getParameter("cpage"));
		
		String isview	= request.getParameter("isview");	// �Խÿ���(y, n) 
		String keyword	= request.getParameter("keyword");	// �˻���  	
		String area = request.getParameter("area"); 		// �������� 
		String where = "";	// �˻�� ���� ��쿡�� ���� ��
		if (request.getParameter("psize") != null)
			psize = Integer.parseInt(request.getParameter("psize"));  
		
		
		// ������ ���� üũ�ڽ� ���� �޾ƿ� �������� �˻��Ǵ� ������Ʈ��  
		String[] chk = request.getParameterValues("chk"); 
		String fdType = "";  
		// �˻� ���ǿ� ���� where�� ����  
		if (chk != null) {
			for (int i = 0; i < chk.length; i++) {
				fdType += ",'" + chk[i] + "'";
			}
				where += "where food_isview = 'y' and food_type in ( " + fdType.substring(1) + ")";
			} else {
				where += "where food_isview = 'y'";  
		} 
		
		if (keyword != null) {	// �˻�� ���� ��쿡�� where�� ���� 
			where += "and food_name like '%" + keyword.trim() + "%' ";
			//System.out.println("key : " + keyword);
		} else { 
			keyword = "";
		} 
		
  

		// ��������(���-��(�⺻), ����-��, ��-��, ����-��) ������Ʈ��
		String ord = request.getParameter("ord");
		System.out.println(">>>ord : " + ord);
		if (ord == null || ord.equals(""))	ord = "coded";	// ��� �������� ������ �⺻��
		String orderBy = " order by food_" + ord.substring(0, ord.length() - 1) + 
			(ord.charAt(ord.length() - 1) == 'a' ? " asc" : " desc");
		System.out.println("���Ĺ� : " + orderBy);
		// �������ǿ� ���� order by�� ����  
		
		// �Ķ���ͷ� ���� ���� �߰� url����
		String pmOrder = "";
		String pmArea = ""; 
		 
		if (!isEmpty(ord)) {			// ����
			pmOrder = "&ord="+ord;
			
			if (!isEmpty(area))	{  	// ����
				pmArea += "&area="+area;
				where += " and food_area = '" + area + "' ";
			}  
		}
		
		
		System.out.println("pmArea : " + pmArea + "- pmOrder : " + pmOrder);
		 

		FoodListSvc foodListSvc = new FoodListSvc();
		// �� ������(cpage)���� ������ �˻��� ��ǰ����� �޾ƿ�
		rcnt = foodListSvc.getFoodCount(where);
		foodList = foodListSvc.getFoodList(where, orderBy, cpage, psize);
		
		pcnt = rcnt / psize;
		if (rcnt % psize > 0)	pcnt++;				// ��ü ������ ��
		spage = (cpage - 1) / bsize * bsize + 1;	// ������ ���� ������ ��ȣ
		epage = spage + bsize - 1;
		if (epage > pcnt)		epage = pcnt;		// ������ ���� ������ ��ȣ 
		
		PageInfo pageInfo = new PageInfo();	// ����¡�� �ʿ��� �������� ������ �ν��Ͻ�
		// ����¡�� �ʿ��� ������
		pageInfo.setCpage(cpage);		// ���� ������ ��ȣ
		pageInfo.setRcnt(rcnt);			// ��ü �Խñ� ����
		pageInfo.setPcnt(pcnt);			// ��ü ������ ����
		pageInfo.setSpage(spage);		// ���� ���� ������ ��ȣ 
		pageInfo.setEpage(epage);		// ���� ���� ������ ��ȣ
		pageInfo.setPsize(psize);		// ������ ũ��
		pageInfo.setBsize(bsize);		// ���� ũ�� 
 
		// �˻����� ������
		pageInfo.setKeyword(keyword);	// �˻��� (��ȣ��) 
		pageInfo.setOrd(ord);			// ��������
		pageInfo.setArea(area);
		


		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("foodList", foodList);
		request.setAttribute("pmOrder", pmOrder);
		request.setAttribute("pmArea", pmArea);
		//request.setAttribute("args", args);
		
		   
		ActionForward forward = new ActionForward();
		forward.setPath("food/food_list.jsp");
  

		return forward;
		}  


	private boolean isEmpty(String str) {	// �Ű������� � ���̵� ��� �ִ��� ���θ� �˻��ϴ� �޼ҵ�
		boolean empty = true;
		if (str != null && !str.equals(""))	empty = false;
		return empty;
		} 
 
} 
  


		
 