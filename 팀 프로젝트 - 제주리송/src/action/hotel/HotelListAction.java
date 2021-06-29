package action.hotel;

import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import svc.*;
import vo.*; 

public class HotelListAction implements action.Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ArrayList<HotelInfo> hotelList = new ArrayList<HotelInfo>();

		request.setCharacterEncoding("utf-8");
		int cpage = 1, psize = 12, bsize = 10, spage, epage, rcnt, pcnt;
		if (request.getParameter("cpage") != null)
			cpage = Integer.parseInt(request.getParameter("cpage"));
		if (request.getParameter("psize") != null)
			psize = Integer.parseInt(request.getParameter("psize"));

		
		// �˻�����(�˻���, ��/�Һз�, �귣��, ���ݴ�) ������Ʈ��
		String area, type, checkin, checkout, name, cnt, order;
		
		area		= request.getParameter("sl_area");		// ���� 
		checkin		= request.getParameter("txt_checkin");	// üũ�γ�¥
		checkout	= request.getParameter("txt_checkout");	// üũ�ƿ���¥ 
		type		= request.getParameter("sl_type");		// ��������
		name		= request.getParameter("txt_name");		// ���Ҹ�
		cnt 		= request.getParameter("txt_cnt");		// �ο���	
		order		= request.getParameter("sl_order");		// ��������
 
		
		// �˻� ���ǿ� ���� where�� ����
//		String where = " where a.cs_id = c.cs_id and b.cb_id = c.cb_id and " + 
//			"a.b_id = d.b_id and a.pi_isview = 'y' ";
//		if (!isEmpty(keyword))	where += " and a.pi_name like '%" + keyword + "%' ";
//		else	 keyword = "";
//		if (!isEmpty(bcata))	where += " and b.cb_id = '" + bcata + "' ";
//		else	 bcata = "";
//		if (!isEmpty(scata))	where += " and c.cs_id = '" + scata + "' ";
//		else	 scata = "";
//		if (!isEmpty(brand))	where += " and d.b_id = '" + brand + "' ";
//		else	 brand = "";
//		if (!isEmpty(sprice))	where += " and a.pi_price >= '" + sprice + "' ";
//		else	 sprice = "";
//		if (!isEmpty(eprice))	where += " and a.pi_price <= '" + eprice + "' ";
//		else	 eprice = "";
//
//		// ��������(�Ǹŷ�-��, ����-����, ���-��(�⺻), ��ǰ��-��, ����-��) ������Ʈ��
//		String ord = request.getParameter("ord");
//		if (ord == null || ord.equals(""))	ord = "idd";	// ��� �������� ������ �⺻��
//		String orderBy = " order by a.pi_" + ord.substring(0, ord.length() - 1) + 
//			(ord.charAt(ord.length() - 1) == 'a' ? " asc" : " desc");
//		// �������ǿ� ���� order by�� ����

		/*HotelListSvc hotelListSvc = new HotelListSvc();
		rcnt = hotelListSvc.getCount(where);	// �˻��� ��ǰ�� �� ����(������ ������ ���ϱ� ���� �ʿ�)
		hotelList = hotelListSvc.getList(where, orderBy, cpage, psize);
		
		pcnt = rcnt / psize;
		if (rcnt % psize > 0)	pcnt++;				// ��ü ������ ��
		spage = (cpage - 1) / bsize * bsize + 1;	// ����� ���� ������ ��ȣ
		epage = spage + bsize - 1;
		if (epage > pcnt)		epage = pcnt;		// ����� ���� ������ ��ȣ

		// ����¡�� �ʿ��� �������� ������ �ν��Ͻ�
		HotelInfo pageInfo = new HotelInfo();
		
		pageInfo.setCpage(cpage);		// ���� ������ ��ȣ
		pageInfo.setRcnt(rcnt);			// ��ü �Խñ� ����
		pageInfo.setPcnt(pcnt);			// ��ü ������ ����
		pageInfo.setSpage(spage);		// ��� ���� ������ ��ȣ
		pageInfo.setEpage(epage);		// ��� ���� ������ ��ȣ
		pageInfo.setPsize(psize);		// ������ ũ��
		pageInfo.setBsize(bsize);		// ��� ũ��
*/
		// �˻����� ������
//		pageInfo.setHotel_area(area);	  
//		pageInfo.setHotel_checkin(area);	  
//		pageInfo.setHotel_checkout(area);	 
//		pageInfo.setHotel_type(area); 
//		pageInfo.setHotel_name(area); 
//		pageInfo.setHotel_cnt(area);	 
//		
//		pageInfo.setOrd(ord);			// ��������

		
		
		//
//		ArrayList<CataBigInfo> cataBigList = pdtListSvc.getCataBigList();	// ��з� ���
//		ArrayList<CataSmallInfo> cataSmallList = pdtListSvc.getCataSmallList();	// �Һз� ���
//		ArrayList<BrandInfo> brandList = pdtListSvc.getBrandList();		// �귣�� ���
//
//		request.setAttribute("pageInfo", pageInfo);
//		request.setAttribute("pdtList", pdtList);
//		request.setAttribute("cataBigList", cataBigList);
//		request.setAttribute("cataSmallList", cataSmallList);
//		request.setAttribute("brandList", brandList);
		
		
		ActionForward forward = new ActionForward(); 
		forward.setPath("hotel/hotel_list.jsp");

		return forward;
	}

}
